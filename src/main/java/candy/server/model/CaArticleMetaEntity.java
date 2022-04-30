package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_META", schema = "PUBLIC", catalog = "TEST")
public class CaArticleMetaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AM_ID")
    private long amId;
    @Basic
    @Column(name = "ARTICLE_ID")
    private int articleId;
    @Basic
    @Column(name = "ARI_ID")
    private Integer ariId;
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
    @Column(name = "AM_EXT")
    private String amExt;
    @Basic
    @Column(name = "AM_IP")
    private String amIp;
    @Basic
    @Column(name = "AM_WRITE_TIME")
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

    public long getAmId() {
        return amId;
    }

    public void setAmId(long amId) {
        this.amId = amId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Integer getAriId() {
        return ariId;
    }

    public void setAriId(Integer ariId) {
        this.ariId = ariId;
    }

    public String getAmToken() {
        return amToken;
    }

    public void setAmToken(String amToken) {
        this.amToken = amToken;
    }

    public String getAmOFilename() {
        return amOFilename;
    }

    public void setAmOFilename(String amOFilename) {
        this.amOFilename = amOFilename;
    }

    public String getAmFilename() {
        return amFilename;
    }

    public void setAmFilename(String amFilename) {
        this.amFilename = amFilename;
    }

    public int getAmType() {
        return amType;
    }

    public void setAmType(int amType) {
        this.amType = amType;
    }

    public long getAmSize() {
        return amSize;
    }

    public void setAmSize(long amSize) {
        this.amSize = amSize;
    }

    public String getAmExt() {
        return amExt;
    }

    public void setAmExt(String amExt) {
        this.amExt = amExt;
    }

    public String getAmIp() {
        return amIp;
    }

    public void setAmIp(String amIp) {
        this.amIp = amIp;
    }

    public Timestamp getAmWriteTime() {
        return amWriteTime;
    }

    public void setAmWriteTime(Timestamp amWriteTime) {
        this.amWriteTime = amWriteTime;
    }

    public int getAmRef() {
        return amRef;
    }

    public void setAmRef(int amRef) {
        this.amRef = amRef;
    }

    public Integer getAmWidth() {
        return amWidth;
    }

    public void setAmWidth(Integer amWidth) {
        this.amWidth = amWidth;
    }

    public Integer getAmHeight() {
        return amHeight;
    }

    public void setAmHeight(Integer amHeight) {
        this.amHeight = amHeight;
    }

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
