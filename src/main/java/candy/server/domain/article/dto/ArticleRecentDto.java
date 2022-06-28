package candy.server.domain.article.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

public class ArticleRecentDto {

    @Data
    @Builder
    @AllArgsConstructor
    /* this must be equal to article header model */
    public static class ArticleRecentResponse {
        @Getter
        @Setter
        @AllArgsConstructor
        @Builder
        public static class PaginationItem {
            public long id;
            public String title, author, summary, board;
            public String thumbnail, authorImage;
            public Timestamp writeTime;
            public int up, down, view, comments, bookmark;
            public List<String> tags;
        }

        public List<PaginationItem> articles;
    }
}
