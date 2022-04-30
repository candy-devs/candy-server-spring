package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_READ_ANON", schema = "PUBLIC", catalog = "TEST")
public class CaArticleReadAnonEntity {
    private int readaId;
    private int articleId;
    private Integer anonId2;
    private Timestamp readaTime;
    private int readaClock;

    @Basic
    @Column(name = "READA_ID")
    public int getReadaId() {
        return readaId;
    }

    public void setReadaId(int readaId) {
        this.readaId = readaId;
    }

    @Basic
    @Column(name = "ARTICLE_ID")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "ANON_ID2")
    public Integer getAnonId2() {
        return anonId2;
    }

    public void setAnonId2(Integer anonId2) {
        this.anonId2 = anonId2;
    }

    @Basic
    @Column(name = "READA_TIME")
    public Timestamp getReadaTime() {
        return readaTime;
    }

    public void setReadaTime(Timestamp readaTime) {
        this.readaTime = readaTime;
    }

    @Basic
    @Column(name = "READA_CLOCK")
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
