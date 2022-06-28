package candy.server.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class TagCreateRequestDto {
    private String tagName;
}