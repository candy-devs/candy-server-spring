package candy.server.domains.article.util;

import candy.server.domains.article.entity.CaArticleEntity;

public class ArticleUtils {

    public static String getAuthor(CaArticleEntity article) {
        if (article.getArticleNickname() != null)
            return article.getArticleNickname();

        if (article.getUserId() == null)
            throw new UnsupportedOperationException();

        return article.getUserId().getUserNickname();
    }

}
