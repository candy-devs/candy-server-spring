package candy.server.domains.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

public class TagDto {
    @Builder
    @AllArgsConstructor
    public static class TagCreateRequest {
        public String tagName;
    }
}
