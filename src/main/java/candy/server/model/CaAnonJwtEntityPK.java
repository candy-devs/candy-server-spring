package candy.server.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CaAnonJwtEntityPK implements Serializable {
    private int anonjwtId;
    private int anonId;

    @Column(name = "ANONJWT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAnonjwtId() {
        return anonjwtId;
    }

    public void setAnonjwtId(int anonjwtId) {
        this.anonjwtId = anonjwtId;
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
        CaAnonJwtEntityPK that = (CaAnonJwtEntityPK) o;
        return anonjwtId == that.anonjwtId && anonId == that.anonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anonjwtId, anonId);
    }
}
