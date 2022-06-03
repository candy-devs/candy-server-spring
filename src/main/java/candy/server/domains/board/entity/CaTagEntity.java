package candy.server.domains.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_TAG", schema = "PUBLIC")
public class CaTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    private long tagId;
    @Basic
    @Column(name = "TAG_NAME", length = 50)
    private String tagName;
    @Basic
    @Column(name = "TAG_REF")
    private int tagRef;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaTagEntity that = (CaTagEntity) o;
        return tagId == that.tagId && tagRef == that.tagRef && Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagName, tagRef);
    }
}
