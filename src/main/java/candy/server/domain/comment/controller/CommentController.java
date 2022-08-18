package candy.server.domain.comment.controller;

import candy.server.domain.comment.dto.CommentWriteRequestDto;
import candy.server.domain.comment.dto.CommentWriteResponseDto;
import candy.server.domain.comment.service.CommentService;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentWriteResponseDto> write(@LoginUser SessionUser user, CommentWriteRequestDto commentWriteRequestDto){
        CommentWriteResponseDto response=  commentService.writeComment(user,commentWriteRequestDto);

        return ResponseEntity.ok().body(response);

    }
}
