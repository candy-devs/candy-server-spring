package candy.server.domain.article.util;

import candy.server.domain.article.entity.CaArticleEntity;

public class ArticleUtils {

    public static String getAuthor(CaArticleEntity article) {
        if (article.getArticleNickname() != null)
            return article.getArticleNickname();

        if (article.getUserId() == null)
            throw new UnsupportedOperationException();

        return article.getUserId().getUserNickname();
    }

}
