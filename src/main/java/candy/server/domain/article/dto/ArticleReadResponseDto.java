package candy.server.domain.article.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ArticleReadResponseDto {
    private String title;
    private String body;
    private String author;
    private Timestamp writeTime;
    private Timestamp lastModifiedTime;
    private int comment;
    private int notice;
    private int view;
    private int up;
    private int down;
    private int bookmark;
}