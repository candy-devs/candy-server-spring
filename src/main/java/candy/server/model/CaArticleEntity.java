package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARTICLE_ID")
    private long articleId;
    @Basic
    @Column(name = "BOARD_ID")
    private int boardId;
    @Basic
    @Column(name = "ANON_ID")
    private Integer anonId;
    @Basic
    @Column(name = "USER_ID")
    private int userId;
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

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Integer getAnonId() {
        return anonId;
    }

    public void setAnonId(Integer anonId) {
        this.anonId = anonId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitlePretty() {
        return articleTitlePretty;
    }

    public void setArticleTitlePretty(String articleTitlePretty) {
        this.articleTitlePretty = articleTitlePretty;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public Integer getArticleUserSpecific() {
        return articleUserSpecific;
    }

    public void setArticleUserSpecific(Integer articleUserSpecific) {
        this.articleUserSpecific = articleUserSpecific;
    }

    public String getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp;
    }

    public String getArticleNickname() {
        return articleNickname;
    }

    public void setArticleNickname(String articleNickname) {
        this.articleNickname = articleNickname;
    }

    public String getArticlePassword() {
        return articlePassword;
    }

    public void setArticlePassword(String articlePassword) {
        this.articlePassword = articlePassword;
    }

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    public Timestamp getArticleWriteTime() {
        return articleWriteTime;
    }

    public void setArticleWriteTime(Timestamp articleWriteTime) {
        this.articleWriteTime = articleWriteTime;
    }

    public Timestamp getArticleLastUpdateTime() {
        return articleLastUpdateTime;
    }

    public void setArticleLastUpdateTime(Timestamp articleLastUpdateTime) {
        this.articleLastUpdateTime = articleLastUpdateTime;
    }

    public int getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(int articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public int getArticleNotice() {
        return articleNotice;
    }

    public void setArticleNotice(int articleNotice) {
        this.articleNotice = articleNotice;
    }

    public int getArticleView() {
        return articleView;
    }

    public void setArticleView(int articleView) {
        this.articleView = articleView;
    }

    public int getArticleUpvote() {
        return articleUpvote;
    }

    public void setArticleUpvote(int articleUpvote) {
        this.articleUpvote = articleUpvote;
    }

    public int getArticleDownvote() {
        return articleDownvote;
    }

    public void setArticleDownvote(int articleDownvote) {
        this.articleDownvote = articleDownvote;
    }

    public int getArticleDevice() {
        return articleDevice;
    }

    public void setArticleDevice(int articleDevice) {
        this.articleDevice = articleDevice;
    }

    public int getArticleAbuse() {
        return articleAbuse;
    }

    public void setArticleAbuse(int articleAbuse) {
        this.articleAbuse = articleAbuse;
    }

    public int getArticleDel() {
        return articleDel;
    }

    public void setArticleDel(int articleDel) {
        this.articleDel = articleDel;
    }

    public int getArticleHide() {
        return articleHide;
    }

    public void setArticleHide(int articleHide) {
        this.articleHide = articleHide;
    }

    public int getArticleBookmarkCount() {
        return articleBookmarkCount;
    }

    public void setArticleBookmarkCount(int articleBookmarkCount) {
        this.articleBookmarkCount = articleBookmarkCount;
    }

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
