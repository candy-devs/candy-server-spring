package candy.server.domain.board.controller;

import candy.server.domain.board.dto.BoardCreateRequestDto;
import candy.server.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/admin/board/create")
    public ResponseEntity<Long> createBoard(@RequestBody BoardCreateRequestDto dto) {
        Long response = boardService.createBoard(dto);

        return ResponseEntity.ok()
                .body(response);
    }
}
