package candy.server.domain.user.dto;

import candy.server.domain.article.dto.ArticleRecentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserProfileArticleResponseDto {
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
        private String[] tags;
    }

    private List<UserProfileArticleResponseDto.PaginationItem> articles;
}
