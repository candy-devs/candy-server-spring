package candy.server.domains.article.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_ARTICLE_META", schema = "PUBLIC", catalog = "TEST")
public class CaArticleMetaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AM_ID")
    private long amId;
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private CaArticleEntity articleId;
    @OneToOne
    @JoinColumn(name = "ARI_ID")
    private CaArticleResizeImageEntity ariId;
    @Basic
    @Column(name = "AM_TOKEN")
    private String amToken;
    @Basic
    @Column(name = "AM_O_FILENAME")
    private String amOFilename;
    @Basic
    @Column(name = "AM_FILENAME")
    private String amFilename;
    @Basic
    @Column(name = "AM_TYPE")
    private int amType;
    @Basic
    @Column(name = "AM_SIZE")
    private long amSize;
    @Basic
    @Column(name = "AM_EXT", length = 10)
    private String amExt;
    @Basic
    @Column(name = "AM_IP")
    private String amIp;
    @Basic
    @Column(name = "AM_WRITE_TIME")
    @CreationTimestamp
    private Timestamp amWriteTime;
    @Basic
    @Column(name = "AM_REF")
    private int amRef;
    @Basic
    @Column(name = "AM_WIDTH")
    private Integer amWidth;
    @Basic
    @Column(name = "AM_HEIGHT")
    private Integer amHeight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleMetaEntity that = (CaArticleMetaEntity) o;
        return amId == that.amId && articleId == that.articleId && amType == that.amType && amSize == that.amSize && amRef == that.amRef && Objects.equals(ariId, that.ariId) && Objects.equals(amToken, that.amToken) && Objects.equals(amOFilename, that.amOFilename) && Objects.equals(amFilename, that.amFilename) && Objects.equals(amExt, that.amExt) && Objects.equals(amIp, that.amIp) && Objects.equals(amWriteTime, that.amWriteTime) && Objects.equals(amWidth, that.amWidth) && Objects.equals(amHeight, that.amHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amId, articleId, ariId, amToken, amOFilename, amFilename, amType, amSize, amExt, amIp, amWriteTime, amRef, amWidth, amHeight);
    }
}
