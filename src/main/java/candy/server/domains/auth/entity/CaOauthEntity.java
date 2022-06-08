package candy.server.domains.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaOauthEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long oauthId;
    private CaOauthTypeEnum oauthType;
    private Timestamp oauthTimed;
    @Lob
    private String oauthMeta;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String picture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaOauthEntity that = (CaOauthEntity) o;
        return oauthId == that.oauthId && oauthType == that.oauthType && Objects.equals(oauthTimed, that.oauthTimed) && Objects.equals(oauthMeta, that.oauthMeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthId, oauthType, oauthTimed, oauthMeta);
    }
}
