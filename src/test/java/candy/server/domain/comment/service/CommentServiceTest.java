package candy.server.domain.comment.service;

import candy.server.domain.article.dto.ArticleWriteRequestDto;
import candy.server.domain.article.service.ArticleService;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.comment.dto.CommentWriteRequestDto;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.security.model.SessionUser;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CommentServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private JpaBoardRepository boardRepository;

    @BeforeEach
    void 테스트_게시판_생성() {
        boardRepository.save(CaBoardEntity.builder()
                .boardKey("test-board")
                .boardName("test-board")
                .build());

        articleService.articleWrite(
                null,
                ArticleWriteRequestDto.builder()
                        .nickname("test-nick")
                        .password("test-pw")
                        .boardKey("test-board")
                        .title("test-title")
                        .body("test-body")
                        .build()
        );
    }

    private SessionUser mockSessionUser() {
        return SessionUser.fromEntity(CaUserEntity.UserBuilder()
                .userIdid("test-id")
                .userNickname("test-nick")
                .userEmail("test-email")
                .userImage("test-image")
                .build());
    }

    @Test
    void 댓글쓰기() {
        var result = commentService.writeComment(mockSessionUser(),
                CommentWriteRequestDto.builder()
                        .articleId(0L).body("댓글 테스트").nickname("test-nick").build());

        Assertions.assertThat(result.getMessage().equals("댓글 작성 완료"));
    }
}
