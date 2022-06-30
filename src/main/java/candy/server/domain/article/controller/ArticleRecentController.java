package candy.server.domain.article.controller;

import candy.server.domain.article.dto.ArticleRecentResponseDto;
import candy.server.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/article/recent")
public class ArticleRecentController {

    private final ArticleService articleService;

    @GetMapping
    /* get recent articles regardless of boardKey */
    public ResponseEntity<ArticleRecentResponseDto> recent(@RequestParam int p) {
        ArticleRecentResponseDto response = articleService.articleRecent(p);

        return ResponseEntity.ok()
                .body(response);
    }
}
