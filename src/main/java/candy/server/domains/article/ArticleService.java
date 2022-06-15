package candy.server.domains.article;

import candy.server.config.auth.SessionUser;
import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.article.entity.CaArticleTypeEnum;
import candy.server.domains.article.dao.JpaArticleRepository;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.board.dao.JpaBoardRepository;
import candy.server.domains.common.utils.HttpReqRespUtils;
import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.controller.JpaUserRepository;
import candy.server.utils.ScalarUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

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

    public Long articleWrite(HttpSession session, ArticleDto.ArticleWriteRequest dto) {
        // request dto 명세 확인
        if (!checkArticleWriteDto(dto) || dto.getBoardKey() == null)
            return -1L;

        var user = session.getAttribute("user");

        // 비로그인 상태 글쓰기
        if (user == null)
            return articleWriteAnonymous(dto);
        else if (dto.getNickname() == null)
            return articleWriteUser((SessionUser)user, dto);
        else
            return articleWriteUserAnonymous((SessionUser)user, dto);
    }

    public ArticleDto.ArticleReadResponse articleRead(HttpSession session, ArticleDto.ArticleReadRequest dto)  {
        CaArticleEntity articleEntity = articleRepository.findById(dto.getArticleId()).orElse(null);

        if (articleEntity == null || articleEntity.getArticleDel() == 1)
            return null;

        if (articleEntity.getArticleHide() == 1) {
            if (articleEntity.getUserId() == null)
                return null;

            var user = session.getAttribute("user");
            if (user == null)
                return null;

            SessionUser sessionUser = (SessionUser)user;
            CaUserEntity userEntity = userRepository.findById(sessionUser.getId()).orElse(null);

            if (userEntity == null || articleEntity.getUserId() != userEntity)
                return null;
        }

        /* 성능이 크리티컬한 부분임, 캐싱 필요  */
        return ArticleDto.ArticleReadResponse.builder()
                .body(articleEntity.getArticleBody())
                .title(articleEntity.getArticleTitle())
                .writeTime(articleEntity.getArticleWriteTime())
                .lastModifiedTime(articleEntity.getArticleLastUpdateTime())
                .comment(articleEntity.getArticleCommentCount())
                .notice(articleEntity.getArticleNotice())
                .view(articleEntity.getArticleView())
                .up(articleEntity.getArticleUpvote())
                .down(articleEntity.getArticleDownvote())
                .bookmark(articleEntity.getArticleBookmarkCount())
                .build();
    }
}
