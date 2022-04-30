package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_READ_ANON", schema = "PUBLIC", catalog = "TEST")
public class CaArticleReadAnonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "READA_ID")
    private long readaId;
    @Basic
    @Column(name = "ARTICLE_ID")
    private int articleId;
    @Basic
    @Column(name = "ANON_ID2")
    private Integer anonId2;
    @Basic
    @Column(name = "READA_TIME")
    private Timestamp readaTime;
    @Basic
    @Column(name = "READA_CLOCK")
    private int readaClock;

    public long getReadaId() {
        return readaId;
    }

    public void setReadaId(long readaId) {
        this.readaId = readaId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Integer getAnonId2() {
        return anonId2;
    }

    public void setAnonId2(Integer anonId2) {
        this.anonId2 = anonId2;
    }

    public Timestamp getReadaTime() {
        return readaTime;
    }

    public void setReadaTime(Timestamp readaTime) {
        this.readaTime = readaTime;
    }

    public int getReadaClock() {
        return readaClock;
    }

    public void setReadaClock(int readaClock) {
        this.readaClock = readaClock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleReadAnonEntity that = (CaArticleReadAnonEntity) o;
        return readaId == that.readaId && articleId == that.articleId && readaClock == that.readaClock && Objects.equals(anonId2, that.anonId2) && Objects.equals(readaTime, that.readaTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readaId, articleId, anonId2, readaTime, readaClock);
    }
}
