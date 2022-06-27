package candy.server.domains.user.dto;

import candy.server.security.model.SessionUser;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.*;

import java.sql.Timestamp;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SignupRequest {
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
    public static class LoginRequest {
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

    @Getter
    public static class UserSimpInfoResponse {
        private final String name;
        private final String email;
        private final String picture;

        public UserSimpInfoResponse(SessionUser sessionUser) {
            this.name = sessionUser.getName();
            this.email = sessionUser.getEmail();
            this.picture = sessionUser.getPicture();
        }
    }
}

