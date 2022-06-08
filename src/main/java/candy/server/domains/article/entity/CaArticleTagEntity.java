package candy.server.domains.article.entity;

import candy.server.domains.board.entity.CaTagEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@IdClass(CaArticleTagEntityPK.class)
public class CaArticleTagEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "tagId")
    private CaTagEntity tagId;
    @Id
    @ManyToOne
    @JoinColumn(name = "articleId")
    private CaArticleEntity articleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleTagEntity that = (CaArticleTagEntity) o;
        return tagId == that.tagId && articleId == that.articleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, articleId);
    }
}
