package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_READ_USER", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaArticleReadUserEntityPK.class)
public class CaArticleReadUserEntity {
    private Object readId;
    private int userId;
    private int articleId;
    private Timestamp readTime;
    private int readClock;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "READ_ID")
    public Object getReadId() {
        return readId;
    }

    public void setReadId(Object readId) {
        this.readId = readId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Basic
    @Column(name = "READ_TIME")
    public Timestamp getReadTime() {
        return readTime;
    }

    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

    @Basic
    @Column(name = "READ_CLOCK")
    public int getReadClock() {
        return readClock;
    }

    public void setReadClock(int readClock) {
        this.readClock = readClock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleReadUserEntity that = (CaArticleReadUserEntity) o;
        return userId == that.userId && articleId == that.articleId && readClock == that.readClock && Objects.equals(readId, that.readId) && Objects.equals(readTime, that.readTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readId, userId, articleId, readTime, readClock);
    }
}
