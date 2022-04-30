package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_CONN", schema = "PUBLIC", catalog = "TEST")
public class CaConnEntity {
    private int connId;
    private Object connIp;
    private Timestamp connTime;
    private Object connUa;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CONN_ID")
    public int getConnId() {
        return connId;
    }

    public void setConnId(int connId) {
        this.connId = connId;
    }

    @Basic
    @Column(name = "CONN_IP")
    public Object getConnIp() {
        return connIp;
    }

    public void setConnIp(Object connIp) {
        this.connIp = connIp;
    }

    @Basic
    @Column(name = "CONN_TIME")
    public Timestamp getConnTime() {
        return connTime;
    }

    public void setConnTime(Timestamp connTime) {
        this.connTime = connTime;
    }

    @Basic
    @Column(name = "CONN_UA")
    public Object getConnUa() {
        return connUa;
    }

    public void setConnUa(Object connUa) {
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
