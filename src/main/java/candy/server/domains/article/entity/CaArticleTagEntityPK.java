package candy.server.domains.article.entity;

import candy.server.domains.board.entity.CaTagEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class CaArticleTagEntityPK implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private CaTagEntity tagId;
    @Id
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleTagEntityPK that = (CaArticleTagEntityPK) o;
        return tagId == that.tagId && articleId == that.articleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, articleId);
    }
}
