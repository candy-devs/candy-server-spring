package candy.server.domain.article.controller;

import candy.server.domain.article.dto.ArticleReadResponseDto;
import candy.server.domain.article.dto.ArticleWriteRequestDto;
import candy.server.domain.article.dto.ArticleWriteResponseDto;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.article.dto.ArticleDto;
import candy.server.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/article")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleWriteResponseDto> write(@LoginUser SessionUser user,
                                                         @RequestBody ArticleWriteRequestDto dto) {
        ArticleWriteResponseDto response = ArticleWriteResponseDto.builder()
                .articleId(articleService.articleWrite(user, dto))
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping
    public ResponseEntity<ArticleReadResponseDto> read(@LoginUser SessionUser user,
                                                               @RequestParam Long id) {
        ArticleReadResponseDto response = articleService.articleRead(user, id);

        return ResponseEntity.ok()
                .body(response);
    }

//    @GetMapping("/admin/article/read")
//    @Secured("hasRole('ROLE_ADMIN')")
//    public ArticleDto.ArticleWriteResponse adminArticleRead(@LoginUser SessionUser user,
//                                                            @RequestBody Long dto) {
//        return null;
//    }

}
