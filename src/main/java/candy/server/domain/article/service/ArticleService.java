package candy.server.domain.article.service;

import candy.server.security.model.SessionUser;
import candy.server.domain.article.dto.ArticleDto;
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

    private boolean checkArticleWriteDto(ArticleDto.ArticleWriteRequest dto) {
        return dto.getTitle().length() <= 50;
    }

    private CaBoardEntity getBoardFromKey(String key) {
        return boardRepository.findByBoardKey(key).orElse(null);
    }

    private CaArticleEntity defaultEntityFromDto(ArticleDto.ArticleWriteRequest dto) {
        return CaArticleEntity.builder()
                .articleTitle(dto.getTitle())
                .articleBody(dto.getBody())
                .articleType(CaArticleTypeEnum.ANON)
                .articleIp(HttpReqRespUtils.getClientIpAddressIfServletRequestExist())
                .build();
    }

    private Long articleWriteAnonymous(ArticleDto.ArticleWriteRequest dto) {
        // 익명 글쓰기의 경우 request dto에 nickname과 pw가 포함되어야 함
        if (dto.getNickname() == null || dto.getPassword() == null)
            return -1L;
        if (!ScalarUtils.inside(dto.getNickname().length(), 2, 16) || !ScalarUtils.inside(dto.getPassword().length(), 4, 32))
            return -1L;

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return -1L;

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setArticleNickname(dto.getNickname());
        article.setArticlePassword(dto.getPassword());

        articleRepository.save(article);

        return article.getArticleId();
    }

    private Long articleWriteUser(SessionUser user, ArticleDto.ArticleWriteRequest dto) {
        CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null)
            return -1L;

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return -1L;

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setUserId(userEntity);

        articleRepository.save(article);

        return article.getArticleId();
    }

    private Long articleWriteUserAnonymous(SessionUser user, ArticleDto.ArticleWriteRequest dto) {
        // 로그인-익명 글쓰기의 경우 request dto에 nickname이 포함되어야 함
        if (dto.getNickname() == null)
            return -1L;
        if (!ScalarUtils.inside(dto.getNickname().length(), 2, 16))
            return -1L;

        CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null)
            return -1L;

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return -1L;

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);
        article.setArticleNickname(userEntity.getUserNickname());
        article.setUserId(userEntity);

        articleRepository.save(article);

        return article.getArticleId();
    }

    public Long articleWrite(SessionUser user, ArticleDto.ArticleWriteRequest dto) {
        // request dto 명세 확인
        if (!checkArticleWriteDto(dto) || dto.getBoardKey() == null)
            return -1L;

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
    public ArticleDto.ArticleReadResponse articleRead(SessionUser user, Long id)  {
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
        return ArticleDto.ArticleReadResponse.builder()
                .body(article.getArticleBody())
                .title(article.getArticleTitle())
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

    public ArticleDto.ArticleRecentResponse articleRecent(int p) {
        /* todo: this query must get result with board key, user nickname (if exists) */
        Page<CaArticleEntity> articles = articleRepository
                .findByArticleDelAndArticleHideOrderByArticleIdDesc(0,0,PageRequest.of(p, 10));

        List<ArticleDto.ArticleRecentResponse.PaginationItem> items = articles.stream().map(article ->
                ArticleDto.ArticleRecentResponse.PaginationItem.builder()
                        .id(article.getArticleId())
                        .title(article.getArticleTitlePretty())
                        .summary(article.getArticleBody())
                        .author(ArticleUtils.getAuthor(article))
                        .writeTime(article.getArticleWriteTime())
                        .up(article.getArticleUpvote())
                        .down(article.getArticleDownvote())
                        .view(article.getArticleView())
                        .bookmark(article.getArticleBookmarkCount())
                        .comments(article.getArticleCommentCount())
                        .build()
        ).collect(Collectors.toList());

        return ArticleDto.ArticleRecentResponse.builder()
                .articles(items)
                .build();
    }
}
