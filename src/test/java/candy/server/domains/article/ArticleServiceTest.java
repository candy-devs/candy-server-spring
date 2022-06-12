package candy.server.domains.article;

import candy.server.domains.article.ArticleService;
import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private JpaBoardRepository boardRepository;

    @Before
    void 테스트_게시판_생성() {
        boardRepository.save(CaBoardEntity.builder()
                .boardKey("test-board")
                .boardName("test-board")
                .build());
    }

    @Test
    void 글쓰기_익명() throws Exception {
        var result =articleService.articleWrite(
                null,
                ArticleDto.ArticleWriteRequest.builder()
                        .nickname("test-nick")
                        .password("test-pw")
                        .boardKey("test-board")
                        .title("test-title")
                        .body("test-body")
                        .build());
        Assertions.assertThat(result).isGreaterThan(0L);
    }
}