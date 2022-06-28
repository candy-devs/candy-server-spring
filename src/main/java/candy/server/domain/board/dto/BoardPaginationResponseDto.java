package candy.server.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BoardPaginationResponseDto {
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
