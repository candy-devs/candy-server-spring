package candy.server.domain.upload.controller;

import candy.server.domain.upload.dto.UploadResponseDto;
import candy.server.domain.upload.service.UploadService;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/upload")
public class UploadController {
    private final UploadService uploadService;

    @GetMapping
    private ResponseEntity<UploadResponseDto> request(@LoginUser SessionUser sessionUser,
                                                      @RequestParam String fileName,
                                                      @RequestParam long fileLength) {
        UploadResponseDto response = uploadService.requestPresignedURL(sessionUser, fileName, fileLength);

        return ResponseEntity.ok()
                .body(response);
    }
}
