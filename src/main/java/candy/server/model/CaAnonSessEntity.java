package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ANON_SESS", schema = "PUBLIC", catalog = "TEST")
public class CaAnonSessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONSESS_ID")
    private long anonsessId;
    @Basic
    @Column(name = "ANON_ID")
    private int anonId;
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

    public long getAnonsessId() {
        return anonsessId;
    }

    public void setAnonsessId(long anonsessId) {
        this.anonsessId = anonsessId;
    }

    public int getAnonId() {
        return anonId;
    }

    public void setAnonId(int anonId) {
        this.anonId = anonId;
    }

    public String getAnonsessIp() {
        return anonsessIp;
    }

    public void setAnonsessIp(String anonsessIp) {
        this.anonsessIp = anonsessIp;
    }

    public Timestamp getAnonsessTime() {
        return anonsessTime;
    }

    public void setAnonsessTime(Timestamp anonsessTime) {
        this.anonsessTime = anonsessTime;
    }

    public int getAnonsessRefresh() {
        return anonsessRefresh;
    }

    public void setAnonsessRefresh(int anonsessRefresh) {
        this.anonsessRefresh = anonsessRefresh;
    }

    public String getAnonsessPreSess() {
        return anonsessPreSess;
    }

    public void setAnonsessPreSess(String anonsessPreSess) {
        this.anonsessPreSess = anonsessPreSess;
    }

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
