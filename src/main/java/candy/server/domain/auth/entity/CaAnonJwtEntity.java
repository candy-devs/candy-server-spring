package candy.server.domain.auth.entity;

import candy.server.domain.user.entity.CaAnonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaAnonJwtEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long anonjwtId;
    @ManyToOne
    @JoinColumn(name = "anonId")
    private CaAnonEntity anonId;
    private String anonjwtIp;
    private Timestamp anonjwtTime;
    private int anonjwtRefresh;
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
