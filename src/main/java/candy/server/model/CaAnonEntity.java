package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
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

    public long getAnonId() {
        return anonId;
    }

    public void setAnonId(long anonId) {
        this.anonId = anonId;
    }

    public Timestamp getAnonTime() {
        return anonTime;
    }

    public void setAnonTime(Timestamp anonTime) {
        this.anonTime = anonTime;
    }

    public Timestamp getAnonLastTime() {
        return anonLastTime;
    }

    public void setAnonLastTime(Timestamp anonLastTime) {
        this.anonLastTime = anonLastTime;
    }

    public String getAnonSess() {
        return anonSess;
    }

    public void setAnonSess(String anonSess) {
        this.anonSess = anonSess;
    }

    public String getAnonJwt() {
        return anonJwt;
    }

    public void setAnonJwt(String anonJwt) {
        this.anonJwt = anonJwt;
    }

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
