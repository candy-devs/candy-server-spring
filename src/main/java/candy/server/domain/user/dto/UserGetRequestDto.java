package candy.server.domain.user.dto;

import candy.server.security.model.SessionUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetRequestDto {
    private String name;
    private String picture;
    private String role;
}
