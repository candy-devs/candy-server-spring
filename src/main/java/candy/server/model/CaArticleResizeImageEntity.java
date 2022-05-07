package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE_RESIZE_IMAGE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleResizeImageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARI_ID")
    private long ariId;
    @Basic
    @Column(name = "ARI_SIZE")
    private int ariSize;
    @Basic
    @Column(name = "ARI_TOKEN")
    private String ariToken;
    @Basic
    @Column(name = "ARI_FILENAME")
    private String ariFilename;
    @Basic
    @Column(name = "ARI_EXT", length = 10)
    private String ariExt;

    @OneToOne(mappedBy = "ariId")
    private CaArticleMetaEntity caArticleMetaEntity;

    public long getAriId() {
        return ariId;
    }

    public void setAriId(long ariId) {
        this.ariId = ariId;
    }

    public int getAriSize() {
        return ariSize;
    }

    public void setAriSize(int ariSize) {
        this.ariSize = ariSize;
    }

    public String getAriToken() {
        return ariToken;
    }

    public void setAriToken(String ariToken) {
        this.ariToken = ariToken;
    }

    public String getAriFilename() {
        return ariFilename;
    }

    public void setAriFilename(String ariFilename) {
        this.ariFilename = ariFilename;
    }

    public String getAriExt() {
        return ariExt;
    }

    public void setAriExt(String ariExt) {
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
