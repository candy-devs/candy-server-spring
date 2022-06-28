package candy.server.domain.board.service;

import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.board.dto.BoardCreateRequestDto;
import candy.server.domain.board.entity.CaBoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final JpaBoardRepository boardRepository;

    public Long createBoard(BoardCreateRequestDto dto) {
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
