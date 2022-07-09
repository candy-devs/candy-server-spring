package candy.server.domain.bookmark.controller;

import candy.server.domain.bookmark.dto.BookmarkArticleRequestDto;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController("/api/v1/bookmark")
@Slf4j
public class BookmarkController {
    private BookmarkService bookmarkService;

    @PostMapping("/article")
    @ResponseBody
    private Long article(@LoginUser SessionUser sessionUser,
                         @Valid @RequestBody BookmarkArticleRequestDto dto) {
        return bookmarkService.article(sessionUser, dto);
    }

    @PostMapping("/unarticle")
    @ResponseBody
    private Long unArticle(@LoginUser SessionUser sessionUser,
                           @Valid @RequestBody BookmarkArticleRequestDto dto) {
        return bookmarkService.unArticle(sessionUser, dto);
    }


}
