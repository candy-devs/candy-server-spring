package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_RESIZE_IMAGE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleResizeImageEntity {
    private int ariId;
    private int ariSize;
    private Object ariToken;
    private Object ariFilename;
    private Object ariExt;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARI_ID")
    public int getAriId() {
        return ariId;
    }

    public void setAriId(int ariId) {
        this.ariId = ariId;
    }

    @Basic
    @Column(name = "ARI_SIZE")
    public int getAriSize() {
        return ariSize;
    }

    public void setAriSize(int ariSize) {
        this.ariSize = ariSize;
    }

    @Basic
    @Column(name = "ARI_TOKEN")
    public Object getAriToken() {
        return ariToken;
    }

    public void setAriToken(Object ariToken) {
        this.ariToken = ariToken;
    }

    @Basic
    @Column(name = "ARI_FILENAME")
    public Object getAriFilename() {
        return ariFilename;
    }

    public void setAriFilename(Object ariFilename) {
        this.ariFilename = ariFilename;
    }

    @Basic
    @Column(name = "ARI_EXT")
    public Object getAriExt() {
        return ariExt;
    }

    public void setAriExt(Object ariExt) {
        this.ariExt = ariExt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleResizeImageEntity that = (CaArticleResizeImageEntity) o;
        return ariId == that.ariId && ariSize == that.ariSize && Objects.equals(ariToken, that.ariToken) && Objects.equals(ariFilename, that.ariFilename) && Objects.equals(ariExt, that.ariExt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ariId, ariSize, ariToken, ariFilename, ariExt);
    }
}
