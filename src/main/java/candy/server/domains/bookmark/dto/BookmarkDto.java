package candy.server.domains.bookmark.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BookmarkDto {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ArticleRequest {
        public Long articleId;
    }
}
