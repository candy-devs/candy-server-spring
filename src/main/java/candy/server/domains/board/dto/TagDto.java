package candy.server.domains.board.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

public class TagDto {
    @Builder
    @RequiredArgsConstructor
    public static class TagCreateRequest {
        public String tagName;
    }
}
