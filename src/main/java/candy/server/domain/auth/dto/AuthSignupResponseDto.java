package candy.server.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthSignupResponseDto {
    private AuthSignupResponseDtoCode code;
    private String message;
}
