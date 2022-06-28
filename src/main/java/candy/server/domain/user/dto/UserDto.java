package candy.server.domain.user.dto;

import candy.server.security.model.SessionUser;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;

import java.sql.Timestamp;

public class UserDto {

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

