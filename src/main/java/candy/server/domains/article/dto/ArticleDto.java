package candy.server.domains.article.dto;

import candy.server.domains.article.entity.CaArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
