package candy.server.domain.board.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
