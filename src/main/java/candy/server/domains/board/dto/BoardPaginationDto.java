package candy.server.domains.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BoardPaginationDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class BoardPaginationResponse {
        @Getter
        @Setter
        @AllArgsConstructor
        @Builder
        public static class PaginationItem {
            public Long id;
            public String title;
            public String author;
            // body summary
            public String summary;
            public int up, down, view;
        }

        public List<PaginationItem> articles;
    }
}
