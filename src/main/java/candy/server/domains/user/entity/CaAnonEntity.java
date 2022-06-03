package candy.server.domains.user.entity;

import candy.server.domains.auth.entity.CaAnonJwtEntity;
import candy.server.domains.auth.entity.CaAnonSessEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ANON", schema = "PUBLIC", catalog = "TEST")
public class CaAnonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANON_ID")
    private long anonId;
    @Basic
    @Column(name = "ANON_TIME")
    private Timestamp anonTime;
    @Basic
    @Column(name = "ANON_LAST_TIME")
    private Timestamp anonLastTime;
    @Basic
    @Column(name = "ANON_SESS")
    private String anonSess;
    @Basic
    @Column(name = "ANON_JWT")
    private String anonJwt;
    @Basic
    @Column(name = "ANON_TYPE")
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
