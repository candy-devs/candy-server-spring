package candy.server.domains.article.dto;

import candy.server.domains.article.entity.CaArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ArticleReadRequest {
        private Long articleId;
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
}
