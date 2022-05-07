package candy.server.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Getter @Setter
@Table(name = "CA_ARTICLE", schema = "PUBLIC", catalog = "TEST")
@NoArgsConstructor(access  = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "ArticleBuilder")
public class CaArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARTICLE_ID")
    private long articleId;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private CaBoardEntity boardId;
    @ManyToOne
    @JoinColumn(nullable = true, name = "ANON_ID")
    private CaAnonEntity anonId;
    @ManyToOne
    @JoinColumn(nullable = true, name = "USER_ID")
    private CaUserEntity userId;
    @Basic
    @Column(name = "ARTICLE_TITLE")
    private String articleTitle;
    @Basic
    @Column(name = "ARTICLE_TITLE_PRETTY")
    private String articleTitlePretty;
    @Basic
    @Column(name = "ARTICLE_BODY")
    private String articleBody;
    @Basic
    @Column(name = "ARTICLE_USER_SPECIFIC")
    private Integer articleUserSpecific;
    @Basic
    @Column(name = "ARTICLE_IP")
    private String articleIp;
    @Basic
    @Column(name = "ARTICLE_NICKNAME")
    private String articleNickname;
    @Basic
    @Column(name = "ARTICLE_PASSWORD")
    private String articlePassword;
    @Basic
    @Column(name = "ARTICLE_TYPE")
    private int articleType;
    @Basic
    @Column(name = "ARTICLE_WRITE_TIME")
    private Timestamp articleWriteTime;
    @Basic
    @Column(name = "ARTICLE_LAST_UPDATE_TIME")
    private Timestamp articleLastUpdateTime;
    @Basic
    @Column(name = "ARTICLE_COMMENT_COUNT")
    private int articleCommentCount;
    @Basic
    @Column(name = "ARTICLE_NOTICE")
    private int articleNotice;
    @Basic
    @Column(name = "ARTICLE_VIEW")
    private int articleView;
    @Basic
    @Column(name = "ARTICLE_UPVOTE")
    private int articleUpvote;
    @Basic
    @Column(name = "ARTICLE_DOWNVOTE")
    private int articleDownvote;
    @Basic
    @Column(name = "ARTICLE_DEVICE")
    private int articleDevice;
    @Basic
    @Column(name = "ARTICLE_ABUSE")
    private int articleAbuse;
    @Basic
    @Column(name = "ARTICLE_DEL")
    private int articleDel;
    @Basic
    @Column(name = "ARTICLE_HIDE")
    private int articleHide;
    @Basic
    @Column(name = "ARTICLE_BOOKMARK_COUNT")
    private int articleBookmarkCount;

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
