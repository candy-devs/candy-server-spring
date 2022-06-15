package candy.server.domains.article;

import candy.server.domains.article.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
                                                      @RequestBody ArticleDto.ArticleReadRequest dto) {
        return articleService.articleRead(session, dto);
    }

}
