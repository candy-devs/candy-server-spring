package candy.server.domain.article.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
/* this must be equal to article header model */
public class ArticleRecentResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaginationItem {
        private long id;
        private String title, author, summary, board;
        private String thumbnail, authorImage;
        private Timestamp writeTime;
        private int up, down, view, comments, bookmark;
        private List<String> tags;
    }

    private List<PaginationItem> articles;
}