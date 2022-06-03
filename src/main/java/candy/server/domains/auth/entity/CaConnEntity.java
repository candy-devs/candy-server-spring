package candy.server.domains.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_CONN", schema = "PUBLIC", catalog = "TEST")
public class CaConnEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CONN_ID")
    private long connId;
    @Basic
    @Column(name = "CONN_IP")
    private String connIp;
    @Basic
    @Column(name = "CONN_TIME")
    private Timestamp connTime;
    @Basic
    @Column(name = "CONN_UA")
    private String connUa;

    public long getConnId() {
        return connId;
    }

    public void setConnId(long connId) {
        this.connId = connId;
    }

    public String getConnIp() {
        return connIp;
    }

    public void setConnIp(String connIp) {
        this.connIp = connIp;
    }

    public Timestamp getConnTime() {
        return connTime;
    }

    public void setConnTime(Timestamp connTime) {
        this.connTime = connTime;
    }

    public String getConnUa() {
        return connUa;
    }

    public void setConnUa(String connUa) {
        this.connUa = connUa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaConnEntity that = (CaConnEntity) o;
        return connId == that.connId && Objects.equals(connIp, that.connIp) && Objects.equals(connTime, that.connTime) && Objects.equals(connUa, that.connUa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connId, connIp, connTime, connUa);
    }
}
