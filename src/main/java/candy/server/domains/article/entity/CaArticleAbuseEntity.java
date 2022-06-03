package candy.server.domains.article.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ARTICLE_ABUSE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleAbuseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AA_ID")
    private long aaId;
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;
    @Basic
    @Lob
    @Column(name = "AA_BODY")
    private String aaBody;
    @Basic
    @Column(name = "AA_IP", length = 64)
    private String aaIp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleAbuseEntity that = (CaArticleAbuseEntity) o;
        return aaId == that.aaId && articleId == that.articleId && Objects.equals(aaBody, that.aaBody) && Objects.equals(aaIp, that.aaIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aaId, articleId, aaBody, aaIp);
    }
}
