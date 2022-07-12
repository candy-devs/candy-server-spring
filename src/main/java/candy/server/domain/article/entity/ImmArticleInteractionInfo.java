package candy.server.domain.article.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
public class ImmArticleInteractionInfo {
    private int articleCommentCount;
    private int articleNotice;
    private int articleView;
    private int articleUpvote;
    private int articleDownvote;
    private int articleBookmarkCount;

    protected ImmArticleInteractionInfo() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmArticleInteractionInfo that = (ImmArticleInteractionInfo) o;
        return articleCommentCount == that.articleCommentCount && articleNotice == that.articleNotice && articleView == that.articleView && articleUpvote == that.articleUpvote && articleDownvote == that.articleDownvote && articleBookmarkCount == that.articleBookmarkCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleCommentCount, articleNotice, articleView, articleUpvote, articleDownvote, articleBookmarkCount);
    }
}
