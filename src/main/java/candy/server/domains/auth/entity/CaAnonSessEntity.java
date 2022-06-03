package candy.server.domains.auth.entity;

import candy.server.domains.user.entity.CaAnonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ANON_SESS", schema = "PUBLIC", catalog = "TEST")
public class CaAnonSessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONSESS_ID")
    private long anonsessId;
    @ManyToOne
    @JoinColumn(name = "ANON_ID")
    private CaAnonEntity anonId;
    @Basic
    @Column(name = "ANONSESS_IP")
    private String anonsessIp;
    @Basic
    @Column(name = "ANONSESS_TIME")
    private Timestamp anonsessTime;
    @Basic
    @Column(name = "ANONSESS_REFRESH")
    private int anonsessRefresh;
    @Basic
    @Column(name = "ANONSESS_PRE_SESS")
    private String anonsessPreSess;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaAnonSessEntity that = (CaAnonSessEntity) o;
        return anonsessId == that.anonsessId && anonId == that.anonId && anonsessRefresh == that.anonsessRefresh && Objects.equals(anonsessIp, that.anonsessIp) && Objects.equals(anonsessTime, that.anonsessTime) && Objects.equals(anonsessPreSess, that.anonsessPreSess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anonsessId, anonId, anonsessIp, anonsessTime, anonsessRefresh, anonsessPreSess);
    }
}
