package candy.server.domain.article.service;

import candy.server.domain.article.dto.*;
import candy.server.security.model.SessionUser;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.article.entity.CaArticleTypeEnum;
import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.util.ArticleUtils;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.utils.HttpReqRespUtils;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.utils.ScalarUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ArticleService {

    private final JpaArticleRepository articleRepository;
    private final JpaBoardRepository boardRepository;
    private final JpaUserRepository userRepository;
    private final XSSFilterService xssFilterService;

    private boolean checkArticleWriteDto(ArticleWriteRequestDto dto) {
        boolean title = dto.getTitle().length() <= 50;
        boolean tags = dto.getTags() == null || Arrays.stream(dto.getTags())
                .filter(t -> t.length() > 12 || t.contains(" ") || t.contains(","))
                .findAny()
                .isEmpty();
        boolean body = dto.getBody().length() <= 65536;
        return title && tags && body;
    }

    private String makeArticleTitlePretty(String title) {
        if (title.length() < 20)
            return title;
        return title.substring(0, 20);
    }

    private CaBoardEntity getBoardFromKey(String key) {
        return boardRepository.findByBoardKey(key).orElse(null);
    }

    private CaArticleEntity defaultEntityFromDto(ArticleWriteRequestDto dto) {
        return CaArticleEntity.builder()
                .articleTitle(dto.getTitle())
                .articleTitlePretty(makeArticleTitlePretty(dto.getTitle()))
                .articleBody(xssFilterService.makeSafeDocument(dto.getBody()))
                .articleType(CaArticleTypeEnum.ANON)
                .articleIp(HttpReqRespUtils.getClientIpAddressIfServletRequestExist())
                .articleTags(dto.getTags() != null ? String.join(",",dto.getTags()) : null)
                .build();
    }

    private ArticleWriteResponseDto articleWriteAnonymous(ArticleWriteRequestDto dto) {
        // 익명 글쓰기의 경우 request dto에 nickname과 pw가 포함되어야 함
        if (dto.getNickname() == null || dto.getPassword() == null)
            return ArticleWriteResponseDto.builder()
                    .message("nickname or pw not found")
                    .articleId(-1L)
                    .build();
        if (!ScalarUtils.inside(dto.getNickname().length(), 2, 16) || !ScalarUtils.inside(dto.getPassword().length(), 4, 32))
            return ArticleWriteResponseDto.builder()
                    .message("nickname or pw format is incorrect.")
                    .articleId(-1L)
                    .build();

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return ArticleWriteResponseDto.builder()
                    .message("board not found")
                    .articleId(-1L)
                    .build();

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setArticleNickname(dto.getNickname());
        article.setArticlePassword(dto.getPassword());

        articleRepository.save(article);

        return ArticleWriteResponseDto.builder()
                .articleId(article.getArticleId())
                .build();
    }

    private ArticleWriteResponseDto articleWriteUser(SessionUser user, ArticleWriteRequestDto dto) {
        if (user.getId() == null)
            return ArticleWriteResponseDto.builder()
                    .message("session user not found")
                    .articleId(-1L)
                    .build();

        CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null)
            return ArticleWriteResponseDto.builder()
                    .message("user not found")
                    .articleId(-1L)
                    .build();

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return ArticleWriteResponseDto.builder()
                    .message("board not found")
                    .articleId(-1L)
                    .build();

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setUserId(userEntity);

        articleRepository.save(article);

        return ArticleWriteResponseDto.builder()
                .articleId(article.getArticleId())
                .build();
    }

    private ArticleWriteResponseDto articleWriteUserAnonymous(SessionUser user, ArticleWriteRequestDto dto) {
        // 로그인-익명 글쓰기의 경우 request dto에 nickname이 포함되어야 함
        if (dto.getNickname() == null)
            return ArticleWriteResponseDto.builder()
                    .message("nickname not found")
                    .articleId(-1L)
                    .build();
        if (!ScalarUtils.inside(dto.getNickname().length(), 2, 16))
            return ArticleWriteResponseDto.builder()
                    .message("nickname format is invalid")
                    .articleId(-1L)
                    .build();

        CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null)
            return ArticleWriteResponseDto.builder()
                    .message("user not found")
                    .articleId(-1L)
                    .build();

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return ArticleWriteResponseDto.builder()
                    .message("board not found")
                    .articleId(-1L)
                    .build();

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setArticleNickname(userEntity.getUserNickname());
        article.setUserId(userEntity);

        articleRepository.save(article);

        return ArticleWriteResponseDto.builder()
                .articleId(article.getArticleId())
                .build();
    }

    public ArticleWriteResponseDto articleWrite(SessionUser user, ArticleWriteRequestDto dto) {
        // request dto 명세 확인
        if (!checkArticleWriteDto(dto) || dto.getBoardKey() == null)
            return ArticleWriteResponseDto.builder()
                    .message("data is invalid")
                    .articleId(-1L)
                    .build();

        // 비로그인 상태 글쓰기
        if (user == null)
            return articleWriteAnonymous(dto);
        else if (dto.getNickname() == null)
            return articleWriteUser((SessionUser)user, dto);
        else
            return articleWriteUserAnonymous((SessionUser)user, dto);
    }

    /*
    * 글 속성에 따른 읽기 형태
    * 1. 익명 글 읽기
    * 2. 로그인 글 읽기
    * 3. 로그인/비익명 글 읽기
    *
    * 누가 이 글을 읽냐
    * 1. 어떤 사용자가 어떤 글을 읽었는지는 저장하지 않음
    *     => 너무 too much한 정보임, 대신 로컬에 저장함
    * 2.
    * */
    public ArticleReadResponseDto articleRead(SessionUser user, Long id)  {
        CaArticleEntity article = articleRepository.findById(id).orElse(null);

        if (article == null || article.getArticleDel() == 1)
            return null;

        if (article.getArticleHide() == 1) {
            if (article.getUserId() == null)
                return null;

            if (user == null)
                return null;

            CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

            if (userEntity == null || article.getUserId() != userEntity)
                return null;
        }

        /* 조회수 증가 */
        article.setArticleView(article.getArticleView() + 1);

        /* 성능이 크리티컬한 부분임, 캐싱 필요  */
        return ArticleReadResponseDto.builder()
                .body(article.getArticleBody())
                .title(article.getArticleTitle())
                .tags(article.getArticleTags() != null ? article.getArticleTags().split(",") : null)
                .author(ArticleUtils.getAuthor(article))
                .writeTime(article.getArticleWriteTime())
                .lastModifiedTime(article.getArticleLastUpdateTime())
                .comment(article.getArticleCommentCount())
                .notice(article.getArticleNotice())
                .view(article.getArticleView())
                .up(article.getArticleUpvote())
                .down(article.getArticleDownvote())
                .bookmark(article.getArticleBookmarkCount())
                .build();
    }

    public ArticleRecentResponseDto articleRecent(int p) {
        /* todo: this query must get result with board key, user nickname (if exists) */
        Page<CaArticleEntity> articles = articleRepository
                .findByArticleDelAndArticleHideOrderByArticleIdDesc(0,0,PageRequest.of(p, 10));

        List<ArticleRecentResponseDto.PaginationItem> items = articles.stream().map(article ->
                ArticleRecentResponseDto.PaginationItem.builder()
                        .id(article.getArticleId())
                        .title(article.getArticleTitlePretty())
                        .summary(article.getArticleBody())
                        .tags(article.getArticleTags() != null ? article.getArticleTags().split(",") : null)
                        .author(ArticleUtils.getAuthor(article))
                        .writeTime(article.getArticleWriteTime())
                        .up(article.getArticleUpvote())
                        .down(article.getArticleDownvote())
                        .view(article.getArticleView())
                        .bookmark(article.getArticleBookmarkCount())
                        .comments(article.getArticleCommentCount())
                        .board(article.getBoardId().getBoardName())
                        .build()
        ).collect(Collectors.toList());

        return ArticleRecentResponseDto.builder()
                .articles(items)
                .build();
    }


}
