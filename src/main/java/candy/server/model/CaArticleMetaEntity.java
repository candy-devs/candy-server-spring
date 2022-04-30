package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_META", schema = "PUBLIC", catalog = "TEST")
public class CaArticleMetaEntity {
    private int amId;
    private int articleId;
    private Integer ariId;
    private Integer userId;
    private Integer anonId;
    private Object amToken;
    private Object amOFilename;
    private Object amFilename;
    private int amType;
    private long amSize;
    private Object amExt;
    private Object amIp;
    private Timestamp amWriteTime;
    private int amRef;
    private Integer amWidth;
    private Integer amHeight;

    @Basic
    @Column(name = "AM_ID")
    public int getAmId() {
        return amId;
    }

    public void setAmId(int amId) {
        this.amId = amId;
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
    @Column(name = "ARI_ID")
    public Integer getAriId() {
        return ariId;
    }

    public void setAriId(Integer ariId) {
        this.ariId = ariId;
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
    @Column(name = "AM_TOKEN")
    public Object getAmToken() {
        return amToken;
    }

    public void setAmToken(Object amToken) {
        this.amToken = amToken;
    }

    @Basic
    @Column(name = "AM_O_FILENAME")
    public Object getAmOFilename() {
        return amOFilename;
    }

    public void setAmOFilename(Object amOFilename) {
        this.amOFilename = amOFilename;
    }

    @Basic
    @Column(name = "AM_FILENAME")
    public Object getAmFilename() {
        return amFilename;
    }

    public void setAmFilename(Object amFilename) {
        this.amFilename = amFilename;
    }

    @Basic
    @Column(name = "AM_TYPE")
    public int getAmType() {
        return amType;
    }

    public void setAmType(int amType) {
        this.amType = amType;
    }

    @Basic
    @Column(name = "AM_SIZE")
    public long getAmSize() {
        return amSize;
    }

    public void setAmSize(long amSize) {
        this.amSize = amSize;
    }

    @Basic
    @Column(name = "AM_EXT")
    public Object getAmExt() {
        return amExt;
    }

    public void setAmExt(Object amExt) {
        this.amExt = amExt;
    }

    @Basic
    @Column(name = "AM_IP")
    public Object getAmIp() {
        return amIp;
    }

    public void setAmIp(Object amIp) {
        this.amIp = amIp;
    }

    @Basic
    @Column(name = "AM_WRITE_TIME")
    public Timestamp getAmWriteTime() {
        return amWriteTime;
    }

    public void setAmWriteTime(Timestamp amWriteTime) {
        this.amWriteTime = amWriteTime;
    }

    @Basic
    @Column(name = "AM_REF")
    public int getAmRef() {
        return amRef;
    }

    public void setAmRef(int amRef) {
        this.amRef = amRef;
    }

    @Basic
    @Column(name = "AM_WIDTH")
    public Integer getAmWidth() {
        return amWidth;
    }

    public void setAmWidth(Integer amWidth) {
        this.amWidth = amWidth;
    }

    @Basic
    @Column(name = "AM_HEIGHT")
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
        return amId == that.amId && articleId == that.articleId && amType == that.amType && amSize == that.amSize && amRef == that.amRef && Objects.equals(ariId, that.ariId) && Objects.equals(userId, that.userId) && Objects.equals(anonId, that.anonId) && Objects.equals(amToken, that.amToken) && Objects.equals(amOFilename, that.amOFilename) && Objects.equals(amFilename, that.amFilename) && Objects.equals(amExt, that.amExt) && Objects.equals(amIp, that.amIp) && Objects.equals(amWriteTime, that.amWriteTime) && Objects.equals(amWidth, that.amWidth) && Objects.equals(amHeight, that.amHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amId, articleId, ariId, userId, anonId, amToken, amOFilename, amFilename, amType, amSize, amExt, amIp, amWriteTime, amRef, amWidth, amHeight);
    }
}
