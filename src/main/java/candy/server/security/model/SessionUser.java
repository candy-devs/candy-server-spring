package candy.server.security.model;

import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class SessionUser implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String picture;
    private final UserRoleEnum role;

    public static SessionUser fromEntity(CaUserEntity entity) {
        return SessionUser.builder()
                .id(entity.getUserId())
                .name(entity.getUserNickname())
                .email(entity.getUserEmail())
                .picture(entity.getUserImage())
                .role(entity.getUserRole())
                .build();
    }
}
