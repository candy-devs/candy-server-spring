package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_UPDATE_RECORD", schema = "PUBLIC", catalog = "TEST")
public class CaArticleUpdateRecordEntity {
    private int aurId;
    private int articleId;
    private Integer anonId;
    private Timestamp aurTime;
    private Object aurIp;

    @Basic
    @Column(name = "AUR_ID")
    public int getAurId() {
        return aurId;
    }

    public void setAurId(int aurId) {
        this.aurId = aurId;
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
    @Column(name = "ANON_ID")
    public Integer getAnonId() {
        return anonId;
    }

    public void setAnonId(Integer anonId) {
        this.anonId = anonId;
    }

    @Basic
    @Column(name = "AUR_TIME")
    public Timestamp getAurTime() {
        return aurTime;
    }

    public void setAurTime(Timestamp aurTime) {
        this.aurTime = aurTime;
    }

    @Basic
    @Column(name = "AUR_IP")
    public Object getAurIp() {
        return aurIp;
    }

    public void setAurIp(Object aurIp) {
        this.aurIp = aurIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleUpdateRecordEntity that = (CaArticleUpdateRecordEntity) o;
        return aurId == that.aurId && articleId == that.articleId && Objects.equals(anonId, that.anonId) && Objects.equals(aurTime, that.aurTime) && Objects.equals(aurIp, that.aurIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aurId, articleId, anonId, aurTime, aurIp);
    }
}
