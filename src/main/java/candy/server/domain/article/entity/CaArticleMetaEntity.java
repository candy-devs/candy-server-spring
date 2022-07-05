package candy.server.domain.article.entity;

import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CaArticleMetaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long amId;
    @ManyToOne
    @JoinColumn(name = "articleId")
    private CaArticleEntity articleId;
    @OneToOne
    private CaArticleResizeImageEntity ariId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;
    private String amURL;
    private String amToken;
    private String amOFilename;
    private String amFilename;
    private int amType;
    private long amSize;
    @Column( length = 10)
    private String amExt;
    private String amIp;
    @CreationTimestamp
    private Timestamp amWriteTime;
    private int amRef;
    private Integer amWidth;
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
