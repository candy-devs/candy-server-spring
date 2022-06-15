package candy.server.domains.article;

import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.article.entity.CaArticleTypeEnum;
import candy.server.domains.article.repository.JpaArticleRepository;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.board.repository.JpaBoardRepository;
import candy.server.domains.common.utils.HttpReqRespUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ArticleService {

    private final JpaArticleRepository articleRepository;
    private final JpaBoardRepository boardRepository;

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

        CaBoardEntity board = getBoardFromKey(dto.getBoardKey());

        // 게시판 존재하지 않음
        if (board == null)
            return -1L;

        CaArticleEntity article = defaultEntityFromDto(dto);
        article.setBoardId(board);

        articleRepository.save(article);

        return -1L;
    }

    public Long articleWrite(HttpSession session, ArticleDto.ArticleWriteRequest dto) {
        // request dto 명세 확인
        if (!checkArticleWriteDto(dto) || dto.getBoardKey() == null)
            return -1L;

        // 비로그인 상태 글쓰기
        if (session == null)
            return articleWriteAnonymous(dto);

        var user = session.getAttribute("user");

        // 비로그인 상태 글쓰기
        if (user == null)
            return articleWriteAnonymous(dto);

        return -1L;
    }

    public ArticleDto.ArticleReadResponse articleRead(HttpSession session, ArticleDto.ArticleReadRequest dto)  {
        CaArticleEntity entity = articleRepository.findById(dto.getArticleId()).orElse(null);

        if (entity == null || entity.getArticleDel() == 1)
            return null;

        /* 성능이 크리티컬한 부분임, 캐싱 필요  */
        return ArticleDto.ArticleReadResponse.builder()
                .body(entity.getArticleBody())
                .title(entity.getArticleTitle())
                .writeTime(entity.getArticleWriteTime())
                .lastModifiedTime(entity.getArticleLastUpdateTime())
                .comment(entity.getArticleCommentCount())
                .notice(entity.getArticleNotice())
                .view(entity.getArticleView())
                .up(entity.getArticleUpvote())
                .down(entity.getArticleDownvote())
                .bookmark(entity.getArticleBookmarkCount())
                .build();
    }
}
