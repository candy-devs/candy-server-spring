package candy.server.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CaArticleTagEntityPK implements Serializable {
    private int tagId;
    private int articleId;

    @Column(name = "TAG_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Column(name = "ARTICLE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        CaArticleTagEntityPK that = (CaArticleTagEntityPK) o;
        return tagId == that.tagId && articleId == that.articleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, articleId);
    }
}
