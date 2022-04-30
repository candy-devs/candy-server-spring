package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ANON_JWT", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaAnonJwtEntityPK.class)
public class CaAnonJwtEntity {
    private int anonjwtId;
    private int anonId;
    private Object anonjwtIp;
    private Timestamp anonjwtTime;
    private int anonjwtRefresh;
    private Object anonjwtPreJwt;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONJWT_ID")
    public int getAnonjwtId() {
        return anonjwtId;
    }

    public void setAnonjwtId(int anonjwtId) {
        this.anonjwtId = anonjwtId;
    }

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
    @Column(name = "ANONJWT_IP")
    public Object getAnonjwtIp() {
        return anonjwtIp;
    }

    public void setAnonjwtIp(Object anonjwtIp) {
        this.anonjwtIp = anonjwtIp;
    }

    @Basic
    @Column(name = "ANONJWT_TIME")
    public Timestamp getAnonjwtTime() {
        return anonjwtTime;
    }

    public void setAnonjwtTime(Timestamp anonjwtTime) {
        this.anonjwtTime = anonjwtTime;
    }

    @Basic
    @Column(name = "ANONJWT_REFRESH")
    public int getAnonjwtRefresh() {
        return anonjwtRefresh;
    }

    public void setAnonjwtRefresh(int anonjwtRefresh) {
        this.anonjwtRefresh = anonjwtRefresh;
    }

    @Basic
    @Column(name = "ANONJWT_PRE_JWT")
    public Object getAnonjwtPreJwt() {
        return anonjwtPreJwt;
    }

    public void setAnonjwtPreJwt(Object anonjwtPreJwt) {
        this.anonjwtPreJwt = anonjwtPreJwt;
    }

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
