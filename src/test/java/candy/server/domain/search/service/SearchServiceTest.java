package candy.server.domain.search.service;

import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.article.service.ArticleService;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.search.dao.JpaSearchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SearchServiceTest {
    @Autowired
    private SearchService searchService;
    @Autowired
    private JpaBoardRepository boardRepository;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private JpaArticleRepository jpaArticleRepository;
    @Autowired
    private JpaSearchRepository searchRepository;
    @BeforeEach
    void 테스트_게시판_생성() {
        searchService.save("test","testest");
    }
    @Test
    void search_title(){
        System.out.println(jpaArticleRepository.findAll().get(0).getArticleTitle());
        var result = searchService.searchByTitle("test");
        System.out.println(result);
    }

    @Test
    void search_body(){
        System.out.println(jpaArticleRepository.findAll().get(0).getArticleTitle());
        var result = searchService.searchByBody("test");
        System.out.println(result);
    }
}
