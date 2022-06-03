package candy.server.model;

import candy.server.domains.article.entity.CaArticleEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CaArticleEntityTest {

    @Test
    void 글_생성_성공() {
        final CaArticleEntity caArticleEntity = CaArticleEntity.ArticleBuilder().build();

        Assertions.assertThat(caArticleEntity.getArticleId()).isEqualTo(0);
    }

}