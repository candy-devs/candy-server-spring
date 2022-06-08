package candy.server.domains.article.entity;

import candy.server.domains.user.entity.CaUserEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class CaArticleReadUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long readId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;
    @ManyToOne
    @JoinColumn(name = "articleId")
    private CaArticleEntity articleId;
    private Timestamp readTime;
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
