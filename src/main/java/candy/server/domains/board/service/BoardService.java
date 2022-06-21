package candy.server.domains.board.service;

import candy.server.domains.board.dao.JpaBoardRepository;
import candy.server.domains.board.dto.BoardDto;
import candy.server.domains.board.entity.CaBoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final JpaBoardRepository boardRepository;

    public Long createBoard(BoardDto.BoardCreateRequest dto) {
        if (boardRepository.findByBoardKeyOrBoardName(dto.boardKey, dto.boardName).isPresent())
            return -1L;

        CaBoardEntity board = CaBoardEntity.builder()
                .boardKey(dto.boardKey)
                .boardName(dto.boardName)
                .build();

        boardRepository.save(board);

        return board.getBoardId();
    }
}
