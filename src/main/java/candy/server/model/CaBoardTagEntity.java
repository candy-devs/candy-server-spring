package candy.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_BOARD_TAG", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaBoardTagEntityPK.class)
public class CaBoardTagEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private CaTagEntity tagId;
    @Id
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private CaBoardEntity boardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaBoardTagEntity that = (CaBoardTagEntity) o;
        return tagId == that.tagId && boardId == that.boardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, boardId);
    }
}
