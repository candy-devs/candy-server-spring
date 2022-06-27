package candy.server.security.model;

import candy.server.domains.user.entity.CaUserEntity;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String picture;

    private SessionUser(CaUserEntity user) {
        this.id = user.getUserId();
        this.name = user.getUserNickname();
        this.email = user.getUserEmail();
        this.picture = user.getUserImage();
    }

    public static SessionUser fromEntity(CaUserEntity entity) {
        return new SessionUser(entity);
    }
}
