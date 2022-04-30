package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_BOARD_TAG", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaBoardTagEntityPK.class)
public class CaBoardTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    private int tagId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BOARD_ID")
    private int boardId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

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
