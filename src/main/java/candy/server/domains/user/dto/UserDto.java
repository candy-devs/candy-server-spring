package candy.server.domains.user.dto;

import candy.server.domains.user.entity.CaUserEntity;
import lombok.*;

import java.sql.Timestamp;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Login {
        private String id;
        private String pw;
    }

    @Getter
    public static class UserListsResponse {
        private final String id;
        private final String nickname;

        public UserListsResponse(CaUserEntity entity) {
            this.id = entity.getUserIdid();
            this.nickname = entity.getUserNickname();
        }
    }

    public record UserCreateData (

    ) {

    }
}

