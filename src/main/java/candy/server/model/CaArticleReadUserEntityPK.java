package candy.server.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CaArticleReadUserEntityPK implements Serializable {
    private Object readId;
    private int userId;
    private int articleId;

    @Column(name = "READ_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Object getReadId() {
        return readId;
    }

    public void setReadId(Object readId) {
        this.readId = readId;
    }

    @Column(name = "USER_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        CaArticleReadUserEntityPK that = (CaArticleReadUserEntityPK) o;
        return userId == that.userId && articleId == that.articleId && Objects.equals(readId, that.readId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readId, userId, articleId);
    }
}
