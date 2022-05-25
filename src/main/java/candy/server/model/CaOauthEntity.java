package candy.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_OAUTH", schema = "PUBLIC", catalog = "TEST")
public class CaOauthEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OAUTH_ID")
    private long oauthId;
    @Basic
    @Column(name = "OAUTH_TYPE")
    private CaOauthTypeEnum oauthType;
    @Basic
    @Column(name = "OAUTH_TIMED")
    private Timestamp oauthTimed;
    @Basic
    @Lob
    @Column(name = "OAUTH_META")
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
