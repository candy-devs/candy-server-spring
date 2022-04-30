package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_ABUSE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleAbuseEntity {
    private int aaId;
    private int articleId;
    private Integer userId;
    private Integer anonId;
    private Object aaBody;
    private Object aaIp;
    private Object field;

    @Basic
    @Column(name = "AA_ID")
    public int getAaId() {
        return aaId;
    }

    public void setAaId(int aaId) {
        this.aaId = aaId;
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
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ANON_ID")
    public Integer getAnonId() {
        return anonId;
    }

    public void setAnonId(Integer anonId) {
        this.anonId = anonId;
    }

    @Basic
    @Column(name = "AA_BODY")
    public Object getAaBody() {
        return aaBody;
    }

    public void setAaBody(Object aaBody) {
        this.aaBody = aaBody;
    }

    @Basic
    @Column(name = "AA_IP")
    public Object getAaIp() {
        return aaIp;
    }

    public void setAaIp(Object aaIp) {
        this.aaIp = aaIp;
    }

    @Basic
    @Column(name = "FIELD")
    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleAbuseEntity that = (CaArticleAbuseEntity) o;
        return aaId == that.aaId && articleId == that.articleId && Objects.equals(userId, that.userId) && Objects.equals(anonId, that.anonId) && Objects.equals(aaBody, that.aaBody) && Objects.equals(aaIp, that.aaIp) && Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aaId, articleId, userId, anonId, aaBody, aaIp, field);
    }
}
