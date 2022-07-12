package candy.server.domain.article.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class XSSFilterServiceTest {

    private XSSFilterService xssFilterService;

    @BeforeEach
    void init() {
        xssFilterService = new XSSFilterService();
    }

    @Test
    void HappyTest() {
        String s = xssFilterService.makeSafeDocument("A<script>Test</script>B");

        Assertions.assertThat(s).isEqualTo("AB");
    }
}