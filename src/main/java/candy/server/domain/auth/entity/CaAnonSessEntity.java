package candy.server.domain.auth.entity;

import candy.server.domain.user.entity.CaAnonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaAnonSessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long anonsessId;
    @ManyToOne
    @JoinColumn(name = "anonId")
    private CaAnonEntity anonId;
    private String anonsessIp;
    private Timestamp anonsessTime;
    private int anonsessRefresh;
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
