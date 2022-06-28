package candy.server.domain.board.controller;

import candy.server.domain.board.dto.BoardPaginationDto;
import candy.server.domain.board.service.BoardPaginationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/board")
@RestController
@Slf4j
public class BoardPaginationController {
    private final BoardPaginationService boardPaginationService;

    @GetMapping("/articles")
    public ResponseEntity<BoardPaginationDto.BoardPaginationResponse> articles(@RequestParam String id, @RequestParam int p) {
        BoardPaginationDto.BoardPaginationResponse response = boardPaginationService.articles(id, p);

        return ResponseEntity.ok()
                .body(response);
    }
}
