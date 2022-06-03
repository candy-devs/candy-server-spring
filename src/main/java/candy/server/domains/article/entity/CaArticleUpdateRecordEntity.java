package candy.server.domains.article.entity;

import candy.server.domains.user.entity.CaAnonEntity;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ARTICLE_UPDATE_RECORD", schema = "PUBLIC", catalog = "TEST")
public class CaArticleUpdateRecordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUR_ID")
    private long aurId;
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;
    @ManyToOne
    @JoinColumn(name = "ANON_ID")
    private CaAnonEntity anonId;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private CaUserEntity userId;
    @Basic
    @Column(name = "AUR_TIME")
    private Timestamp aurTime;
    @Basic
    @Column(name = "AUR_IP", length = 64)
    private String aurIp;

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
