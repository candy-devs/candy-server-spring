package candy.server.domain.auth.controller;

import candy.server.domain.auth.dto.AuthLoginRequestDto;
import candy.server.domain.auth.dto.AuthSignupResponseDto;
import candy.server.domain.auth.dto.AuthSignupRequestDto;
import candy.server.domain.auth.dto.AuthSignupResponseDtoCode;
import candy.server.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

        log.info(String.format("signup: %s, %s", dto.getId(), dto.getNickname()));

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> userLoginJson(HttpSession session, @Valid @RequestBody AuthLoginRequestDto dto) {
        log.info(String.format("login: %s", dto.getId()));

        boolean tryLogin = authService.tryLogin(session, dto);

        return ResponseEntity.ok()
                .body(tryLogin ? 0 : -1);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void userLoginForm(HttpServletRequest req,
                              HttpServletResponse res,
                              HttpSession session,
                              @Valid AuthLoginRequestDto dto) throws IOException {
        log.info(String.format("login: %s", dto.getId()));

        boolean tryLogin = authService.tryLogin(session, dto);

        String redirectUrl = req.getHeader("referer").split("\\?")[0];

        if (tryLogin) {
            // success
            res.sendRedirect(redirectUrl + "?result=0");
        } else {
            // fail=
            res.sendRedirect(redirectUrl + "?result=1&redirect=" +
                    (dto.getRedirect() != null ? URLEncoder.encode(dto.getRedirect(), StandardCharsets.UTF_8) : ""));
        }
    }

    @PostMapping("/loginapp")
    public ResponseEntity<String> loginApp(@RequestBody AuthLoginRequestDto dto) {
        String result = authService.tryLoginApp(dto);

        return ResponseEntity.ok()
                .body(result);
    }
}
