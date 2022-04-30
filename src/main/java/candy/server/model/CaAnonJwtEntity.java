package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ANON_JWT", schema = "PUBLIC", catalog = "TEST")
public class CaAnonJwtEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONJWT_ID")
    private long anonjwtId;
    @Basic
    @Column(name = "ANON_ID")
    private int anonId;
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

    public long getAnonjwtId() {
        return anonjwtId;
    }

    public void setAnonjwtId(long anonjwtId) {
        this.anonjwtId = anonjwtId;
    }

    public int getAnonId() {
        return anonId;
    }

    public void setAnonId(int anonId) {
        this.anonId = anonId;
    }

    public String getAnonjwtIp() {
        return anonjwtIp;
    }

    public void setAnonjwtIp(String anonjwtIp) {
        this.anonjwtIp = anonjwtIp;
    }

    public Timestamp getAnonjwtTime() {
        return anonjwtTime;
    }

    public void setAnonjwtTime(Timestamp anonjwtTime) {
        this.anonjwtTime = anonjwtTime;
    }

    public int getAnonjwtRefresh() {
        return anonjwtRefresh;
    }

    public void setAnonjwtRefresh(int anonjwtRefresh) {
        this.anonjwtRefresh = anonjwtRefresh;
    }

    public String getAnonjwtPreJwt() {
        return anonjwtPreJwt;
    }

    public void setAnonjwtPreJwt(String anonjwtPreJwt) {
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
