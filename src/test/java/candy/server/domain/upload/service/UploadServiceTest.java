package candy.server.domain.upload.service;

import candy.server.domain.upload.dto.UploadResponseDto;
import candy.server.domain.user.service.UserService;
import com.amazonaws.services.s3.transfer.Upload;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UploadServiceTest {

    @Autowired
    private UploadService uploadService;

    @Test
    void getExtensionFromFileName() {
        Assertions.assertThat(UploadService.getExtensionFromFileName("test.jpg"))
                .isEqualTo("jpg");
    }

    @Test
    void validFilenameTest() {
        UploadResponseDto result = uploadService
                .requestResignedURL(null, "test.jpg", 1000);

        Assertions.assertThat(result.getSuccess()).isEqualTo(0);
    }

}