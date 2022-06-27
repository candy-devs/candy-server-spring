package candy.server.domain.board.controller;

import candy.server.domain.board.dto.BoardDto;
import candy.server.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/admin/board/create")
    @ResponseBody
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Long createBoard(@RequestBody BoardDto.BoardCreateRequest dto) {
        return boardService.createBoard(dto);
    }
}
