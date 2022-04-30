package candy.server.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CaAnonSessEntityPK implements Serializable {
    private int anonsessId;
    private int anonId;

    @Column(name = "ANONSESS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAnonsessId() {
        return anonsessId;
    }

    public void setAnonsessId(int anonsessId) {
        this.anonsessId = anonsessId;
    }

    @Column(name = "ANON_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAnonId() {
        return anonId;
    }

    public void setAnonId(int anonId) {
        this.anonId = anonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaAnonSessEntityPK that = (CaAnonSessEntityPK) o;
        return anonsessId == that.anonsessId && anonId == that.anonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anonsessId, anonId);
    }
}
