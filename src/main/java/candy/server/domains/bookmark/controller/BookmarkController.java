package candy.server.domains.bookmark.controller;

import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domains.bookmark.dto.BookmarkDto;
import candy.server.domains.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@Slf4j
public class BookmarkController {
    private BookmarkService bookmarkService;

    @PostMapping("/bookmark/article")
    @ResponseBody
    private Long article(@LoginUser SessionUser sessionUser, @RequestBody BookmarkDto.ArticleRequest dto) {
        return bookmarkService.article(sessionUser, dto);
    }

    @PostMapping("/bookmark/unarticle")
    @ResponseBody
    private Long unArticle(@LoginUser SessionUser sessionUser, @RequestBody BookmarkDto.ArticleRequest dto) {
        return bookmarkService.unArticle(sessionUser, dto);
    }


}
