package candy.server.domain.article.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

public class ArticleDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ArticleWriteRequest {
        private String boardKey;
        private String title;
        private String body;
        // 익명 글쓰기에 한함
        private String nickname;
        private String password;
        private List<String> tags;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ArticleWriteResponse {
        public Long articleId;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ArticleReadResponse{
        public String title;
        public String body;
        public String author;
        public Timestamp writeTime;
        public Timestamp lastModifiedTime;
        private int comment;
        private int notice;
        private int view;
        private int up;
        private int down;
        private int bookmark;
    }


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
