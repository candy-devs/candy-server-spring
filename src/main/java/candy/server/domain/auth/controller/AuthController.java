package candy.server.domain.auth.controller;

import candy.server.domain.auth.dto.AuthSignupResponseDto;
import candy.server.domain.auth.dto.AuthSignupRequestDto;
import candy.server.domain.auth.dto.AuthSignupResponseDtoCode;
import candy.server.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthSignupResponseDto> userSignup(@RequestBody AuthSignupRequestDto dto) {
        AuthSignupResponseDtoCode responseCode = authService.join(dto);
        AuthSignupResponseDto response = AuthSignupResponseDto.builder()
                .code(responseCode)
                .message(responseCode.name().toLowerCase())
                .build();

        log.info("/user/signup!");

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> userLogin(HttpSession session, @RequestBody AuthSignupRequestDto dto) {
        boolean tryLogin = authService.tryLogin(session, dto);

        return ResponseEntity.ok()
                .body(tryLogin ? 0 : -1);
    }
}
