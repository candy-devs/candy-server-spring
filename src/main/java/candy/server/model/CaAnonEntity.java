package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ANON", schema = "PUBLIC", catalog = "TEST")
public class CaAnonEntity {
    private int anonId;
    private Timestamp anonTime;
    private Timestamp anonLastTime;
    private Object anonSess;
    private Object anonJwt;
    private int anonType;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANON_ID")
    public int getAnonId() {
        return anonId;
    }

    public void setAnonId(int anonId) {
        this.anonId = anonId;
    }

    @Basic
    @Column(name = "ANON_TIME")
    public Timestamp getAnonTime() {
        return anonTime;
    }

    public void setAnonTime(Timestamp anonTime) {
        this.anonTime = anonTime;
    }

    @Basic
    @Column(name = "ANON_LAST_TIME")
    public Timestamp getAnonLastTime() {
        return anonLastTime;
    }

    public void setAnonLastTime(Timestamp anonLastTime) {
        this.anonLastTime = anonLastTime;
    }

    @Basic
    @Column(name = "ANON_SESS")
    public Object getAnonSess() {
        return anonSess;
    }

    public void setAnonSess(Object anonSess) {
        this.anonSess = anonSess;
    }

    @Basic
    @Column(name = "ANON_JWT")
    public Object getAnonJwt() {
        return anonJwt;
    }

    public void setAnonJwt(Object anonJwt) {
        this.anonJwt = anonJwt;
    }

    @Basic
    @Column(name = "ANON_TYPE")
    public int getAnonType() {
        return anonType;
    }

    public void setAnonType(int anonType) {
        this.anonType = anonType;
    }

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
