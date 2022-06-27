package candy.server.domain.bookmark.entity;

import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CaArticleBookmarkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private CaUserEntity userId;
    @ManyToOne
    @JoinColumn(name = "articleId", nullable = false)
    private CaArticleEntity articleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleBookmarkEntity that = (CaArticleBookmarkEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, articleId);
    }
}
