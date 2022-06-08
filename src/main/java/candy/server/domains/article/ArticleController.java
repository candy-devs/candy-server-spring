package candy.server.domains.article;

import candy.server.domains.article.dto.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ArticleController {

    @PostMapping("/article/write")
    @ResponseBody
    public String articleWrite(HttpSession session, @RequestBody ArticleDto.ArticleWriteRequest dto) {
        session.setAttribute("id", "sex");
        return "hello";
    }

    @GetMapping("/article/session")
    @ResponseBody
    public String getSession(HttpSession session) {
        System.out.println(session.getAttribute("id"));
        return session.getAttribute("id").toString();
    }
}
