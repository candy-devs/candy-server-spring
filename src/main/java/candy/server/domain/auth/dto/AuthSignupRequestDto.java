package candy.server.domain.auth.dto;

import candy.server.domain.user.entity.CaUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthSignupRequestDto {
    private String id;
    private String pw;
    private String nickname;

    public CaUserEntity toEntity() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return CaUserEntity.UserBuilder()
                .userIdid(this.getId())
                .userPw(this.getPw())
                .userNickname(this.getNickname())
                .userSignupTime(currentTime)
                .userLastLoginTime(currentTime)
                .userRest(0)
                .build();
    }
}