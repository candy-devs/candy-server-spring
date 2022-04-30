package candy.server.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CaBoardTagEntityPK implements Serializable {
    @Column(name = "TAG_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;
    @Column(name = "BOARD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        CaBoardTagEntityPK that = (CaBoardTagEntityPK) o;
        return tagId == that.tagId && boardId == that.boardId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, boardId);
    }
}
