package candy.server.domain.upload.service;

import candy.server.domain.article.dao.JpaArticleMetaEntity;
import candy.server.domain.article.entity.CaArticleMetaEntity;
import candy.server.domain.upload.dto.UploadResponseDto;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.security.model.SessionUser;
import candy.server.utils.HttpReqRespUtils;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UploadService {
    private final JpaArticleMetaEntity articleMetaEntity;
    private final JpaUserRepository userRepository;
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String rawImageBucket;

    // 30mb
    static final long MAX_UPLOAD_FILE_LENGTH = 1024 * 1024 * 30;

    private boolean isValidExtension(String ext) {
        return switch (ext.toLowerCase()) {
            case "png", "jpg", "jpeg", "bmp", "gif", "webp" -> true;
            default -> false;
        };
    }

    private boolean checkDto(String fileName, String ext, long fileLength) {
        if (fileName.length() > 255) return false;
        if (fileLength > MAX_UPLOAD_FILE_LENGTH) return false;
        return isValidExtension(ext);
    }

    static String getExtensionFromFileName(String fileName) {
        if (fileName.indexOf('.') < 0) {
            return "";
        }

        String[] split = fileName.split("\\.");
        return split[split.length - 1];
    }

    private String getPreSignedURL(String hashedFileName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(rawImageBucket, hashedFileName)
                        .withMethod(HttpMethod.PUT);

        generatePresignedUrlRequest.addRequestParameter(Headers.S3_CANNED_ACL,
                CannedAccessControlList.PublicRead.toString());

        URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);

        return url.toString();
    }

    public UploadResponseDto requestPresignedURL(SessionUser sessionUser,
                                                String fileName,
                                                long fileLength) {
        String ext = getExtensionFromFileName(fileName);

        if (!checkDto(fileName, ext, fileLength))
            return UploadResponseDto.builder()
                    .success(1)
                    .build();

        // TODO: user 정보가 필요한가?
        Optional<CaUserEntity> user = sessionUser != null ?
                userRepository.findByUserId(sessionUser.getId()) :
                Optional.empty();

        // TODO: s3 pre-signed URL 발급
        String hashedFileName = UUID.randomUUID().toString() +"." +  ext;
        String url = getPreSignedURL(hashedFileName);

        log.info(String.format("upload: get presigned %s", url));

        CaArticleMetaEntity meta = CaArticleMetaEntity.builder()
                .amOFilename(fileName)
                .amFilename(hashedFileName)
                .amExt(ext)
                .amSize(fileLength)
                .amIp(HttpReqRespUtils.getClientIpAddressIfServletRequestExist())
                .amURL(String.format("https://%s.ap-northeast-2.amazonaws.com/%s", rawImageBucket, hashedFileName))
                .userId(user.orElse(null))
                .build();

        articleMetaEntity.save(meta);

        return UploadResponseDto.builder()
                .uploadUrl(url)
                .success(0)
                .build();
    }
}
