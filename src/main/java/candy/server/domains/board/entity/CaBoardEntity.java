package candy.server.domains.board.entity;

import candy.server.domains.article.entity.CaArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaBoardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long boardId;
    @Column(length = 50)
    private String boardKey;
    @Column(length = 50)
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
