package candy.server.domains.article.controller;

import candy.server.domains.article.dto.ArticleDto;
import candy.server.domains.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article/write")
    @ResponseBody
    public ArticleDto.ArticleWriteResponse articleWrite(HttpSession session,
                                                        @RequestBody ArticleDto.ArticleWriteRequest dto) {
        return ArticleDto.ArticleWriteResponse.builder()
                .articleId(articleService.articleWrite(session, dto))
                .build();
    }

    @GetMapping("/article/read")
    @ResponseBody
    public ArticleDto.ArticleReadResponse articleRead(HttpSession session,
                                                      @RequestParam Long id) {
        return articleService.articleRead(session, id);
    }

    @GetMapping("/admin/article/read")
    @Secured("hasRole('ROLE_ADMIN')")
    public ArticleDto.ArticleWriteResponse adminArticleRead(HttpSession session,
                                                       @RequestBody Long dto) {
        return null;
    }

}
