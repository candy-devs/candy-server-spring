package candy.server.domains.auth.entity;

import candy.server.domains.user.entity.CaAnonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ANON_JWT", schema = "PUBLIC", catalog = "TEST")
public class CaAnonJwtEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONJWT_ID")
    private long anonjwtId;
    @ManyToOne
    @JoinColumn(name = "ANON_ID")
    private CaAnonEntity anonId;
    @Basic
    @Column(name = "ANONJWT_IP")
    private String anonjwtIp;
    @Basic
    @Column(name = "ANONJWT_TIME")
    private Timestamp anonjwtTime;
    @Basic
    @Column(name = "ANONJWT_REFRESH")
    private int anonjwtRefresh;
    @Basic
    @Column(name = "ANONJWT_PRE_JWT")
    private String anonjwtPreJwt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaAnonJwtEntity that = (CaAnonJwtEntity) o;
        return anonjwtId == that.anonjwtId && anonId == that.anonId && anonjwtRefresh == that.anonjwtRefresh && Objects.equals(anonjwtIp, that.anonjwtIp) && Objects.equals(anonjwtTime, that.anonjwtTime) && Objects.equals(anonjwtPreJwt, that.anonjwtPreJwt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anonjwtId, anonId, anonjwtIp, anonjwtTime, anonjwtRefresh, anonjwtPreJwt);
    }
}
