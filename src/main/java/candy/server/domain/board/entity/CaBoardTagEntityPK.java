package candy.server.domain.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class CaBoardTagEntityPK implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "tagId")
    private CaTagEntity tagId;
    @Id
    @ManyToOne
    @JoinColumn(name = "boardId")
    private CaBoardEntity boardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaBoardTagEntityPK that = (CaBoardTagEntityPK) o;
        return tagId == that.tagId && boardId == that.boardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, boardId);
    }
}
