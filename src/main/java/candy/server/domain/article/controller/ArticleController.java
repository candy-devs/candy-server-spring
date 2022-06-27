package candy.server.domain.article.controller;

import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.article.dto.ArticleDto;
import candy.server.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article/write")
    @ResponseBody
    public ArticleDto.ArticleWriteResponse articleWrite(@LoginUser SessionUser user,
                                                        @RequestBody ArticleDto.ArticleWriteRequest dto) {
        return ArticleDto.ArticleWriteResponse.builder()
                .articleId(articleService.articleWrite(user, dto))
                .build();
    }

    @GetMapping("/article/read")
    @ResponseBody
    public ArticleDto.ArticleReadResponse articleRead(@LoginUser SessionUser user,
                                                      @RequestParam Long id) {
        return articleService.articleRead(user, id);
    }

    @GetMapping("/admin/article/read")
    @Secured("hasRole('ROLE_ADMIN')")
    public ArticleDto.ArticleWriteResponse adminArticleRead(@LoginUser SessionUser user,
                                                            @RequestBody Long dto) {
        return null;
    }


    @GetMapping("/article/recent")
    @ResponseBody
    /* get recent articles regardless of boardKey */
    public ArticleDto.ArticleRecentResponse articleRecent(@RequestParam int p) {
        return articleService.articleRecent(p);
    }
}
