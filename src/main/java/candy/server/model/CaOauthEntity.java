package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_OAUTH", schema = "PUBLIC", catalog = "TEST")
public class CaOauthEntity {
    private int oauthId;
    private int oauthType;
    private Timestamp oauthTimed;
    private Object oauthMeta;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OAUTH_ID")
    public int getOauthId() {
        return oauthId;
    }

    public void setOauthId(int oauthId) {
        this.oauthId = oauthId;
    }

    @Basic
    @Column(name = "OAUTH_TYPE")
    public int getOauthType() {
        return oauthType;
    }

    public void setOauthType(int oauthType) {
        this.oauthType = oauthType;
    }

    @Basic
    @Column(name = "OAUTH_TIMED")
    public Timestamp getOauthTimed() {
        return oauthTimed;
    }

    public void setOauthTimed(Timestamp oauthTimed) {
        this.oauthTimed = oauthTimed;
    }

    @Basic
    @Column(name = "OAUTH_META")
    public Object getOauthMeta() {
        return oauthMeta;
    }

    public void setOauthMeta(Object oauthMeta) {
        this.oauthMeta = oauthMeta;
    }

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
