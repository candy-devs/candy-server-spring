package candy.server.domain.user.controller;

import candy.server.domain.article.dto.ArticleRecentResponseDto;
import candy.server.domain.article.service.ArticleService;
import candy.server.domain.user.dto.UserProfileArticleResponseDto;
import candy.server.domain.user.dto.UserProfileRequestDto;
import candy.server.domain.user.service.UserService;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user/profile")
@RestController
@Slf4j
public class UserProfileController {
    private final UserService userService;
    private final ArticleService articleService;

    @GetMapping("/article")
    /* get recent articles regardless of boardKey */
    public ResponseEntity<UserProfileArticleResponseDto> recent(@LoginUser SessionUser user, @RequestParam int p, @PathVariable("specific") String specific) {
        UserProfileArticleResponseDto response = userService.articleProfileUser(p,specific,user);

        return ResponseEntity.ok()
                .body(response);
    }
    @GetMapping
    public ResponseEntity<UserProfileRequestDto> getProfile(@PathVariable("specific") String specific) {
        UserProfileRequestDto response = userService.getuserProfileRequestDto(specific);

        return ResponseEntity.ok()
                .body(response);
    }
}
