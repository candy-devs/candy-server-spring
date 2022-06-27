package candy.server.domain.user.entity;

import candy.server.domain.auth.entity.CaAnonJwtEntity;
import candy.server.domain.auth.entity.CaAnonSessEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaAnonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long anonId;
    private Timestamp anonTime;
    private Timestamp anonLastTime;
    private String anonSess;
    private String anonJwt;
    private int anonType;

    @OneToMany(mappedBy = "anonId")
    private List<CaAnonJwtEntity> caAnonJwtEntityList;
    @OneToMany(mappedBy = "anonId")
    private List<CaAnonSessEntity> caAnonSessEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaAnonEntity that = (CaAnonEntity) o;
        return anonId == that.anonId && anonType == that.anonType && Objects.equals(anonTime, that.anonTime) && Objects.equals(anonLastTime, that.anonLastTime) && Objects.equals(anonSess, that.anonSess) && Objects.equals(anonJwt, that.anonJwt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anonId, anonTime, anonLastTime, anonSess, anonJwt, anonType);
    }
}
