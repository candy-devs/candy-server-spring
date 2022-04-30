package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ANON_SESS", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaAnonSessEntityPK.class)
public class CaAnonSessEntity {
    private int anonsessId;
    private int anonId;
    private Object anonsessIp;
    private Timestamp anonsessTime;
    private int anonsessRefresh;
    private Object anonsessPreSess;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ANONSESS_ID")
    public int getAnonsessId() {
        return anonsessId;
    }

    public void setAnonsessId(int anonsessId) {
        this.anonsessId = anonsessId;
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
    @Column(name = "ANONSESS_IP")
    public Object getAnonsessIp() {
        return anonsessIp;
    }

    public void setAnonsessIp(Object anonsessIp) {
        this.anonsessIp = anonsessIp;
    }

    @Basic
    @Column(name = "ANONSESS_TIME")
    public Timestamp getAnonsessTime() {
        return anonsessTime;
    }

    public void setAnonsessTime(Timestamp anonsessTime) {
        this.anonsessTime = anonsessTime;
    }

    @Basic
    @Column(name = "ANONSESS_REFRESH")
    public int getAnonsessRefresh() {
        return anonsessRefresh;
    }

    public void setAnonsessRefresh(int anonsessRefresh) {
        this.anonsessRefresh = anonsessRefresh;
    }

    @Basic
    @Column(name = "ANONSESS_PRE_SESS")
    public Object getAnonsessPreSess() {
        return anonsessPreSess;
    }

    public void setAnonsessPreSess(Object anonsessPreSess) {
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
