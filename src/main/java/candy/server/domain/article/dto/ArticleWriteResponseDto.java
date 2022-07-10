package candy.server.domain.article.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleWriteResponseDto {
    private String message;
    private Long articleId;
}
