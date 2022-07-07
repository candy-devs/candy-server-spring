package candy.server.domain.upload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UploadResponseDto {
    private String uploadUrl;
    private String message;
    // 0: ok, 1: fail
    private long success;
}
