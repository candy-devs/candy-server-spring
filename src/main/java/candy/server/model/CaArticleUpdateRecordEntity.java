package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_UPDATE_RECORD", schema = "PUBLIC", catalog = "TEST")
public class CaArticleUpdateRecordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUR_ID")
    private long aurId;
    @Basic
    @Column(name = "ARTICLE_ID")
    private int articleId;
    @Basic
    @Column(name = "ANON_ID")
    private int anonId;
    @Basic
    @Column(name = "USER_ID")
    private int userId;
    @Basic
    @Column(name = "AUR_TIME")
    private Timestamp aurTime;
    @Basic
    @Column(name = "AUR_IP")
    private String aurIp;

    public long getAurId() {
        return aurId;
    }

    public void setAurId(long aurId) {
        this.aurId = aurId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAnonId() {
        return anonId;
    }

    public void setAnonId(int anonId) {
        this.anonId = anonId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getAurTime() {
        return aurTime;
    }

    public void setAurTime(Timestamp aurTime) {
        this.aurTime = aurTime;
    }

    public String getAurIp() {
        return aurIp;
    }

    public void setAurIp(String aurIp) {
        this.aurIp = aurIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleUpdateRecordEntity that = (CaArticleUpdateRecordEntity) o;
        return aurId == that.aurId && articleId == that.articleId && anonId == that.anonId && userId == that.userId && Objects.equals(aurTime, that.aurTime) && Objects.equals(aurIp, that.aurIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aurId, articleId, anonId, userId, aurTime, aurIp);
    }
}
