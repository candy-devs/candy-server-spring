package candy.server.domains.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long tagId;
    private String tagName;
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
