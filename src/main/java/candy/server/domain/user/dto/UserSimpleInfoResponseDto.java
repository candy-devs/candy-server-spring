package candy.server.domain.user.dto;

import candy.server.security.model.SessionUser;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleInfoResponseDto {
    private String name;
    private String email;
    private String picture;

    public UserSimpleInfoResponseDto(SessionUser sessionUser) {
        this.name = sessionUser.getName();
        this.email = sessionUser.getEmail();
        this.picture = sessionUser.getPicture();
    }
}