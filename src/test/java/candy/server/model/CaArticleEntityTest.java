package candy.server.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CaArticleEntityTest {

    @Test
    void 글_생성_성공() {
        final CaArticleEntity caArticleEntity = new CaArticleEntity();

        Assertions.assertThat(caArticleEntity.getArticleId()).isEqualTo(0);
    }

}