package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_BOARD", schema = "PUBLIC", catalog = "TEST")
public class CaBoardEntity {
    private int boardId;
    private Object boardKey;
    private Object boardName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BOARD_ID")
    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    @Basic
    @Column(name = "BOARD_KEY")
    public Object getBoardKey() {
        return boardKey;
    }

    public void setBoardKey(Object boardKey) {
        this.boardKey = boardKey;
    }

    @Basic
    @Column(name = "BOARD_NAME")
    public Object getBoardName() {
        return boardName;
    }

    public void setBoardName(Object boardName) {
        this.boardName = boardName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaBoardEntity that = (CaBoardEntity) o;
        return boardId == that.boardId && Objects.equals(boardKey, that.boardKey) && Objects.equals(boardName, that.boardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardId, boardKey, boardName);
    }
}
