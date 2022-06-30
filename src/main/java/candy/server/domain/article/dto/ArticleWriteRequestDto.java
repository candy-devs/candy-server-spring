package candy.server.domain.article.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleWriteRequestDto {
    @NotNull
    private String boardKey;
    @NotNull
    private String title;
    @NotNull
    private String body;
    // 익명 글쓰기에 한함
    private String nickname;
    private String password;
    private String[] tags;
}