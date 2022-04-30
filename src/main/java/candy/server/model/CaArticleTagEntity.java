package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_TAG", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaArticleTagEntityPK.class)
public class CaArticleTagEntity {
    private int tagId;
    private int articleId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARTICLE_ID")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

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
