package candy.server.domain.board.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagCreateRequestDto {
    private String tagName;
}