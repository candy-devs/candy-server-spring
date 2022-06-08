package candy.server.domains.auth.entity;

import candy.server.domains.user.entity.CaUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@IdClass(CaUserOauthEntityPK.class)
public class CaUserOauthEntity {
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
        CaUserOauthEntity that = (CaUserOauthEntity) o;
        return oauthId == that.oauthId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthId, userId);
    }
}
