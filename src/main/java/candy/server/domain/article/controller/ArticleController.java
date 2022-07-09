package candy.server.domain.article.controller;

import candy.server.domain.article.dto.ArticleReadResponseDto;
import candy.server.domain.article.dto.ArticleWriteRequestDto;
import candy.server.domain.article.dto.ArticleWriteResponseDto;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.article.dto.ArticleDto;
import candy.server.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/article")
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticleWriteResponseDto> writeJson(@LoginUser SessionUser user,
                                                             @Valid @RequestBody ArticleWriteRequestDto dto) {
        ArticleWriteResponseDto response = ArticleWriteResponseDto.builder()
                .articleId(articleService.articleWrite(user, dto))
                .build();

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<ArticleWriteResponseDto> writeForm(HttpServletResponse res,
                          @LoginUser SessionUser user,
                          @Valid ArticleWriteRequestDto dto) throws IOException {
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
