package candy.server.domain.board.controller;

import candy.server.domain.board.dto.BoardPaginationResponseDto;
import candy.server.domain.board.service.BoardPaginationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@RestController
@Slf4j
public class BoardPaginationController {

    private final BoardPaginationService boardPaginationService;

    @GetMapping("/articles")
    public ResponseEntity<BoardPaginationResponseDto> articles(@RequestParam String id, @RequestParam int p) {
        BoardPaginationResponseDto response = boardPaginationService.articles(id, p);

        return ResponseEntity.ok()
                .body(response);
    }
}
