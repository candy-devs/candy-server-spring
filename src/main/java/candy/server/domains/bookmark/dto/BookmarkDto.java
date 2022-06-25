package candy.server.domains.bookmark.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoomarkDto {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ArticleRequest {
        public Long articleId;
    }
}
