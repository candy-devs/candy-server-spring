package candy.server.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardDto {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardCreateRequest {
        public String boardKey;
        public String boardName;
    }
}
