package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_ABUSE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleAbuseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AA_ID")
    private long aaId;
    @Basic
    @Column(name = "ARTICLE_ID")
    private int articleId;
    @Basic
    @Column(name = "AA_BODY")
    private String aaBody;
    @Basic
    @Column(name = "AA_IP")
    private String aaIp;
    @Basic
    @Column(name = "FIELD")
    private String field;

    public long getAaId() {
        return aaId;
    }

    public void setAaId(long aaId) {
        this.aaId = aaId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getAaBody() {
        return aaBody;
    }

    public void setAaBody(String aaBody) {
        this.aaBody = aaBody;
    }

    public String getAaIp() {
        return aaIp;
    }

    public void setAaIp(String aaIp) {
        this.aaIp = aaIp;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleAbuseEntity that = (CaArticleAbuseEntity) o;
        return aaId == that.aaId && articleId == that.articleId && Objects.equals(aaBody, that.aaBody) && Objects.equals(aaIp, that.aaIp) && Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aaId, articleId, aaBody, aaIp, field);
    }
}
