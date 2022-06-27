package candy.server.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class TagDto {
    @Builder
    @AllArgsConstructor
    public static class TagCreateRequest {
        public String tagName;
    }
}
