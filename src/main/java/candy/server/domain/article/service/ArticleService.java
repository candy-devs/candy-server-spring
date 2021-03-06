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
        // ?????? ???????????? ?????? request dto??? nickname??? pw??? ??????????????? ???
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

        // ????????? ???????????? ??????
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

        // ????????? ???????????? ??????
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
        // ?????????-?????? ???????????? ?????? request dto??? nickname??? ??????????????? ???
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

        // ????????? ???????????? ??????
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
        // request dto ?????? ??????
        if (!checkArticleWriteDto(dto) || dto.getBoardKey() == null)
            return ArticleWriteResponseDto.builder()
                    .message("data is invalid")
                    .articleId(-1L)
                    .build();

        // ???????????? ?????? ?????????
        if (user == null)
            return articleWriteAnonymous(dto);
        else if (dto.getNickname() == null)
            return articleWriteUser((SessionUser)user, dto);
        else
            return articleWriteUserAnonymous((SessionUser)user, dto);
    }

    /*
    * ??? ????????? ?????? ?????? ??????
    * 1. ?????? ??? ??????
    * 2. ????????? ??? ??????
    * 3. ?????????/????????? ??? ??????
    *
    * ?????? ??? ?????? ??????
    * 1. ?????? ???????????? ?????? ?????? ??????????????? ???????????? ??????
    *     => ?????? too much??? ?????????, ?????? ????????? ?????????
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

        /* ????????? ?????? */
        article.setArticleView(article.getArticleView() + 1);

        /* ????????? ??????????????? ?????????, ?????? ??????  */
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
