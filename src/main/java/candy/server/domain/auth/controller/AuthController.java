package candy.server.domain.auth.controller;

import candy.server.domain.auth.service.AuthService;
import candy.server.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseBody
    public String userSignup(@RequestBody UserDto.SignupRequest dto) throws Exception {
        authService.join(dto);
        log.info("/user/signup!");
        return "redirect:/";
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> userLogin(HttpSession session, @RequestBody UserDto.LoginRequest dto) {
        boolean tryLogin = authService.tryLogin(session, dto);

        return ResponseEntity.ok()
                .body(tryLogin ? 0 : -1);
    }
}
