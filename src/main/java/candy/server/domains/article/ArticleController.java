package candy.server.domains.article;

import candy.server.domains.article.dto.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ArticleController {

    @PostMapping("/article/write")
    @ResponseBody
    public String articleWrite(HttpSession session, @RequestBody ArticleDto.ArticleWriteRequest dto) {
        return "hello";
    }
}
