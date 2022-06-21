package candy.server.domains.board.controller;

import candy.server.domains.board.dto.BoardPaginationDto;
import candy.server.domains.board.service.BoardPaginationService;
import candy.server.domains.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@Slf4j
public class BoardPaginationController {
    private final BoardPaginationService boardPaginationService;

    @GetMapping("/board/articles")
    @ResponseBody
    public BoardPaginationDto.BoardPaginationResponse articles(@RequestParam String id, @RequestParam int p) {
        return boardPaginationService.articles(id, p);
    }
}
