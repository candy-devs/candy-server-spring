package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_ARTICLE", schema = "PUBLIC", catalog = "TEST")
public class CaArticleEntity {
    private int articleId;
    private int boardId;
    private Integer userId;
    private Integer anonId;
    private Object articleTitle;
    private Object articleTitlePretty;
    private Object articleBody;
    private Integer articleUserSpecific;
    private Object articleIp;
    private Object articleNickname;
    private Object articlePassword;
    private int articleType;
    private Timestamp articleWriteTime;
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

    @Basic
    @Column(name = "ARTICLE_ID")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "BOARD_ID")
    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
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
    @Column(name = "ARTICLE_TITLE")
    public Object getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(Object articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "ARTICLE_TITLE_PRETTY")
    public Object getArticleTitlePretty() {
        return articleTitlePretty;
    }

    public void setArticleTitlePretty(Object articleTitlePretty) {
        this.articleTitlePretty = articleTitlePretty;
    }

    @Basic
    @Column(name = "ARTICLE_BODY")
    public Object getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(Object articleBody) {
        this.articleBody = articleBody;
    }

    @Basic
    @Column(name = "ARTICLE_USER_SPECIFIC")
    public Integer getArticleUserSpecific() {
        return articleUserSpecific;
    }

    public void setArticleUserSpecific(Integer articleUserSpecific) {
        this.articleUserSpecific = articleUserSpecific;
    }

    @Basic
    @Column(name = "ARTICLE_IP")
    public Object getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(Object articleIp) {
        this.articleIp = articleIp;
    }

    @Basic
    @Column(name = "ARTICLE_NICKNAME")
    public Object getArticleNickname() {
        return articleNickname;
    }

    public void setArticleNickname(Object articleNickname) {
        this.articleNickname = articleNickname;
    }

    @Basic
    @Column(name = "ARTICLE_PASSWORD")
    public Object getArticlePassword() {
        return articlePassword;
    }

    public void setArticlePassword(Object articlePassword) {
        this.articlePassword = articlePassword;
    }

    @Basic
    @Column(name = "ARTICLE_TYPE")
    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    @Basic
    @Column(name = "ARTICLE_WRITE_TIME")
    public Timestamp getArticleWriteTime() {
        return articleWriteTime;
    }

    public void setArticleWriteTime(Timestamp articleWriteTime) {
        this.articleWriteTime = articleWriteTime;
    }

    @Basic
    @Column(name = "ARTICLE_LAST_UPDATE_TIME")
    public Timestamp getArticleLastUpdateTime() {
        return articleLastUpdateTime;
    }

    public void setArticleLastUpdateTime(Timestamp articleLastUpdateTime) {
        this.articleLastUpdateTime = articleLastUpdateTime;
    }

    @Basic
    @Column(name = "ARTICLE_COMMENT_COUNT")
    public int getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(int articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    @Basic
    @Column(name = "ARTICLE_NOTICE")
    public int getArticleNotice() {
        return articleNotice;
    }

    public void setArticleNotice(int articleNotice) {
        this.articleNotice = articleNotice;
    }

    @Basic
    @Column(name = "ARTICLE_VIEW")
    public int getArticleView() {
        return articleView;
    }

    public void setArticleView(int articleView) {
        this.articleView = articleView;
    }

    @Basic
    @Column(name = "ARTICLE_UPVOTE")
    public int getArticleUpvote() {
        return articleUpvote;
    }

    public void setArticleUpvote(int articleUpvote) {
        this.articleUpvote = articleUpvote;
    }

    @Basic
    @Column(name = "ARTICLE_DOWNVOTE")
    public int getArticleDownvote() {
        return articleDownvote;
    }

    public void setArticleDownvote(int articleDownvote) {
        this.articleDownvote = articleDownvote;
    }

    @Basic
    @Column(name = "ARTICLE_DEVICE")
    public int getArticleDevice() {
        return articleDevice;
    }

    public void setArticleDevice(int articleDevice) {
        this.articleDevice = articleDevice;
    }

    @Basic
    @Column(name = "ARTICLE_ABUSE")
    public int getArticleAbuse() {
        return articleAbuse;
    }

    public void setArticleAbuse(int articleAbuse) {
        this.articleAbuse = articleAbuse;
    }

    @Basic
    @Column(name = "ARTICLE_DEL")
    public int getArticleDel() {
        return articleDel;
    }

    public void setArticleDel(int articleDel) {
        this.articleDel = articleDel;
    }

    @Basic
    @Column(name = "ARTICLE_HIDE")
    public int getArticleHide() {
        return articleHide;
    }

    public void setArticleHide(int articleHide) {
        this.articleHide = articleHide;
    }

    @Basic
    @Column(name = "ARTICLE_BOOKMARK_COUNT")
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
        return articleId == that.articleId && boardId == that.boardId && articleType == that.articleType && articleCommentCount == that.articleCommentCount && articleNotice == that.articleNotice && articleView == that.articleView && articleUpvote == that.articleUpvote && articleDownvote == that.articleDownvote && articleDevice == that.articleDevice && articleAbuse == that.articleAbuse && articleDel == that.articleDel && articleHide == that.articleHide && articleBookmarkCount == that.articleBookmarkCount && Objects.equals(userId, that.userId) && Objects.equals(anonId, that.anonId) && Objects.equals(articleTitle, that.articleTitle) && Objects.equals(articleTitlePretty, that.articleTitlePretty) && Objects.equals(articleBody, that.articleBody) && Objects.equals(articleUserSpecific, that.articleUserSpecific) && Objects.equals(articleIp, that.articleIp) && Objects.equals(articleNickname, that.articleNickname) && Objects.equals(articlePassword, that.articlePassword) && Objects.equals(articleWriteTime, that.articleWriteTime) && Objects.equals(articleLastUpdateTime, that.articleLastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, boardId, userId, anonId, articleTitle, articleTitlePretty, articleBody, articleUserSpecific, articleIp, articleNickname, articlePassword, articleType, articleWriteTime, articleLastUpdateTime, articleCommentCount, articleNotice, articleView, articleUpvote, articleDownvote, articleDevice, articleAbuse, articleDel, articleHide, articleBookmarkCount);
    }
}
