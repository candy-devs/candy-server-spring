package candy.server.domains.article;

import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.article.service.ArticleService;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.board.dao.JpaBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
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

    @Test
    void 글쓰기_익명() throws Exception {
        var session = new MockHttpSession();
        var result =articleService.articleWrite(
                session,
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
        var session = new MockHttpSession();
        var result = articleService.articleRead(session, 1L);
        Assertions.assertThat(result.title).isNotNull();
    }

    @Test
    void 글읽기_SAD() {
        var session = new MockHttpSession();
        var result = articleService.articleRead(session, 1234567L);
        Assertions.assertThat(result).isNull();
    }

    @Test
    void 최근글() {
        var result = articleService.articleRecent(0);
        Assertions.assertThat(result.articles.size()).isGreaterThanOrEqualTo(1);
    }
}