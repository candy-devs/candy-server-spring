package candy.server.dto;

import candy.server.model.CaUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

public class UserDto {

    @Data
    @AllArgsConstructor
    @Builder
    public static class Signup {
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

}
