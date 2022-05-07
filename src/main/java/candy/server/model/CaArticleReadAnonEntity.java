package candy.server.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ARTICLE_READ_ANON", schema = "PUBLIC", catalog = "TEST")
@DynamicInsert
public class CaArticleReadAnonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "READA_ID")
    private long readaId;
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;
    @ManyToOne
    @JoinColumn(name = "ANON_ID")
    private CaAnonEntity anonId;
    @Basic
    @Column(nullable = false, name = "READA_TIME")
    @CreationTimestamp
    private Timestamp readaTime;
    @Basic
    @Column(name = "READA_CLOCK")
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
