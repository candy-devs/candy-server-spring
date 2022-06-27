package candy.server.domain.article.entity;

import candy.server.domain.user.entity.CaAnonEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@DynamicInsert
public class CaArticleReadAnonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long readaId;
    @ManyToOne
    @JoinColumn(name = "articleId")
    private CaArticleEntity articleId;
    @ManyToOne
    @JoinColumn(name = "anonId")
    private CaAnonEntity anonId;
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp readaTime;
    private int readaClock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleReadAnonEntity that = (CaArticleReadAnonEntity) o;
        return readaId == that.readaId && articleId == that.articleId && readaClock == that.readaClock && Objects.equals(anonId, that.anonId) && Objects.equals(readaTime, that.readaTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readaId, articleId, anonId, readaTime, readaClock);
    }
}
