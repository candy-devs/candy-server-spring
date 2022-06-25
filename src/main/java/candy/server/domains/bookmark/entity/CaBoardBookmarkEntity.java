package candy.server.domains.bookmark.entity;

import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaBoardBookmarkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private CaUserEntity userId;
    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    private CaBoardEntity boardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaBoardBookmarkEntity that = (CaBoardBookmarkEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(boardId, that.boardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, boardId);
    }
}
