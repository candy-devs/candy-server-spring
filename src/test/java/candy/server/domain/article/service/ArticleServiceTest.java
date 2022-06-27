package candy.server.domain.article.service;

import candy.server.domain.article.dto.ArticleDto;
import candy.server.domain.article.service.ArticleService;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.security.model.SessionUser;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private JpaBoardRepository boardRepository;

    @BeforeAll
    static void 테스트_게시판_생성(@Autowired JpaBoardRepository boardRepository) {
        boardRepository.save(CaBoardEntity.builder()
                .boardKey("test-board")
                .boardName("test-board")
                .build());
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
    void 글쓰기_익명() throws Exception {
        var result =articleService.articleWrite(
                mockSessionUser(),
                ArticleDto.ArticleWriteRequest.builder()
                        .nickname("test-nick")
                        .password("test-pw")
                        .boardKey("test-board")
                        .title("test-title")
                        .body("test-body")
                        .build());
        Assertions.assertThat(result).isGreaterThan(0L);
    }

    @Test
    void 글읽기_HAPPY() {
        var result = articleService.articleRead(mockSessionUser(), 1L);
        Assertions.assertThat(result.title).isNotNull();
    }

    @Test
    void 글읽기_SAD() {
        var result = articleService.articleRead(mockSessionUser(), 1234567L);
        Assertions.assertThat(result).isNull();
    }

    @Test
    void 최근글() {
        var result = articleService.articleRecent(0);
        Assertions.assertThat(result.articles.size()).isGreaterThanOrEqualTo(1);
    }
}