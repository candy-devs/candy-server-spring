package candy.server.domain.user.dto;

import candy.server.security.model.SessionUser;
import lombok.*;
import org.hibernate.Session;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleInfoResponseDto {
    private String name;
    private String email;
    private String picture;
    private String role;

    public static UserSimpleInfoResponseDto fromSessionUser(SessionUser sessionUser) {
        return UserSimpleInfoResponseDto.builder()
                .name(sessionUser.getName())
                .email(sessionUser.getEmail())
                .picture(sessionUser.getPicture())
                .role(sessionUser.getRole().name())
                .build();
    }
}