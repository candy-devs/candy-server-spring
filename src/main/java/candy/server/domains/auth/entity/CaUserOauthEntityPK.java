package candy.server.domains.auth.entity;

import candy.server.domains.user.entity.CaUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Getter @Setter
public class CaUserOauthEntityPK implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "oauthId")
    private CaOauthEntity oauthId;
    @Id
    @ManyToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaUserOauthEntityPK that = (CaUserOauthEntityPK) o;
        return oauthId == that.oauthId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthId, userId);
    }
}
