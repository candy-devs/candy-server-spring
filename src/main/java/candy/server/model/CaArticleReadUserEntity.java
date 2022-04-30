package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_READ_USER", schema = "PUBLIC", catalog = "TEST")
public class CaArticleReadUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "READ_ID")
    private long readId;
    @Basic
    @Column(name = "USER_ID")
    private int userId;
    @Basic
    @Column(name = "ARTICLE_ID")
    private int articleId;
    @Basic
    @Column(name = "USER_ID2")
    private int userId2;
    @Basic
    @Column(name = "READ_TIME")
    private Timestamp readTime;
    @Basic
    @Column(name = "READ_CLOCK")
    private int readClock;

    public long getReadId() {
        return readId;
    }

    public void setReadId(long readId) {
        this.readId = readId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    public Timestamp getReadTime() {
        return readTime;
    }

    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

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
        return readId == that.readId && userId == that.userId && articleId == that.articleId && userId2 == that.userId2 && readClock == that.readClock && Objects.equals(readTime, that.readTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readId, userId, articleId, userId2, readTime, readClock);
    }
}
