package candy.server.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentWriteRequestDto {

    @NotNull
    private String body;
    @NotNull
    private Long articleId;
    private String nickname;
    private String password;

}
