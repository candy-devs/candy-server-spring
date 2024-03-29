package candy.server.domain.article.entity;

import candy.server.domain.user.entity.CaAnonEntity;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.global.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
//@Document(indexName = "article")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "article")
public class CaArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @org.springframework.data.annotation.Id
    private long articleId;
    @ManyToOne
    @JoinColumn(name = "boardId")
    private CaBoardEntity boardId;
    @ManyToOne
    @JoinColumn(nullable = true, name = "anonId")
    private CaAnonEntity anonId;
    @ManyToOne
    @JoinColumn(nullable = true, name = "userId")
    private CaUserEntity userId;
    @Column(length = 50)
    private String articleTitle;
    @Column(length = 50)
    private String articleTitlePretty;
    @Lob
    private String articleBody;
    @Column(length = 255)
    private String articleTags;
    private Integer articleUserSpecific;
    @Column(length = 64)
    private String articleIp;
    @Column(length = 50)
    private String articleNickname;
    @Column(length = 255)
    private String articlePassword;
    private CaArticleTypeEnum articleType;
    @CreationTimestamp
    private Timestamp articleWriteTime;
    @UpdateTimestamp
    private Timestamp articleLastUpdateTime;
    private int articleCommentCount;
    private int articleNotice;
    private int articleView;
    private int articleUpvote;
    private int articleDownvote;
    private int articleDevice;
    private int articleAbuse;
    private int articleDel;
    private int articleHide;
    private int articleBookmarkCount;

    @OneToMany(mappedBy = "articleId")
    private List<CaArticleMetaEntity> caArticleMetaEntityList;
    @OneToMany(mappedBy = "articleId")
    private List<CaArticleReadAnonEntity> caArticleReadAnonEntityList;
    @OneToMany(mappedBy = "articleId")
    private List<CaArticleAbuseEntity> caArticleAbuseEntityList;
    @OneToMany(mappedBy = "articleId")
    private List<CaArticleUpdateRecordEntity> caArticleUpdateRecordEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaArticleEntity that = (CaArticleEntity) o;
        return articleId == that.articleId && boardId == that.boardId && userId == that.userId && articleType == that.articleType && articleCommentCount == that.articleCommentCount && articleNotice == that.articleNotice && articleView == that.articleView && articleUpvote == that.articleUpvote && articleDownvote == that.articleDownvote && articleDevice == that.articleDevice && articleAbuse == that.articleAbuse && articleDel == that.articleDel && articleHide == that.articleHide && articleBookmarkCount == that.articleBookmarkCount && Objects.equals(anonId, that.anonId) && Objects.equals(articleTitle, that.articleTitle) && Objects.equals(articleTitlePretty, that.articleTitlePretty) && Objects.equals(articleBody, that.articleBody) && Objects.equals(articleUserSpecific, that.articleUserSpecific) && Objects.equals(articleIp, that.articleIp) && Objects.equals(articleNickname, that.articleNickname) && Objects.equals(articlePassword, that.articlePassword) && Objects.equals(articleWriteTime, that.articleWriteTime) && Objects.equals(articleLastUpdateTime, that.articleLastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, boardId, anonId, userId, articleTitle, articleTitlePretty, articleBody, articleUserSpecific, articleIp, articleNickname, articlePassword, articleType, articleWriteTime, articleLastUpdateTime, articleCommentCount, articleNotice, articleView, articleUpvote, articleDownvote, articleDevice, articleAbuse, articleDel, articleHide, articleBookmarkCount);
    }
}
