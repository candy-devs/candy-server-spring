package candy.server.domain.board.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPaginationResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaginationItem {
        private Long id;
        private String title;
        private String author;
        // body summary
        private String summary;
        private int up, down, view;
    }

    public List<PaginationItem> articles;
}
