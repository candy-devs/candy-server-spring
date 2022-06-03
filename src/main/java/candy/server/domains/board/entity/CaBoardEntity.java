package candy.server.domains.board.entity;

import candy.server.domains.article.entity.CaArticleEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CA_BOARD", schema = "PUBLIC")
public class CaBoardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BOARD_ID")
    private long boardId;
    @Basic
    @Column(name = "BOARD_KEY", length = 50)
    private String boardKey;
    @Basic
    @Column(name = "BOARD_NAME", length = 50)
    private String boardName;

    @OneToMany(mappedBy = "boardId")
    private List<CaArticleEntity> caArticleEntityList;

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
