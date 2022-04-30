package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_OAUTH", schema = "PUBLIC", catalog = "TEST")
public class CaOauthEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OAUTH_ID")
    private long oauthId;
    @Basic
    @Column(name = "OAUTH_TYPE")
    private int oauthType;
    @Basic
    @Column(name = "OAUTH_TIMED")
    private Timestamp oauthTimed;
    @Basic
    @Column(name = "OAUTH_META")
    private String oauthMeta;

    public long getOauthId() {
        return oauthId;
    }

    public void setOauthId(long oauthId) {
        this.oauthId = oauthId;
    }

    public int getOauthType() {
        return oauthType;
    }

    public void setOauthType(int oauthType) {
        this.oauthType = oauthType;
    }

    public Timestamp getOauthTimed() {
        return oauthTimed;
    }

    public void setOauthTimed(Timestamp oauthTimed) {
        this.oauthTimed = oauthTimed;
    }

    public String getOauthMeta() {
        return oauthMeta;
    }

    public void setOauthMeta(String oauthMeta) {
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
