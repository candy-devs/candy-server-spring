package candy.server.domains.article.entity;

import candy.server.domains.user.entity.CaUserEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_READ_USER", schema = "PUBLIC")
public class CaArticleReadUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "READ_ID")
    private long readId;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private CaUserEntity userId;
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;
    @Basic
    @Column(name = "READ_TIME")
    private Timestamp readTime;
    @Basic
    @Column(name = "READ_CLOCK")
    private int readClock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleReadUserEntity that = (CaArticleReadUserEntity) o;
        return readId == that.readId && userId == that.userId && articleId == that.articleId && readClock == that.readClock && Objects.equals(readTime, that.readTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readId, userId, articleId, readTime, readClock);
    }
}
