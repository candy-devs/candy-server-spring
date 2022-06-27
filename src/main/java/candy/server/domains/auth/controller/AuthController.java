package candy.server.domains.auth.controller;

import candy.server.domains.auth.service.AuthService;
import candy.server.domains.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    @ResponseBody
    public String userSignup(@RequestBody UserDto.SignupRequest dto) throws Exception {
        authService.join(dto);
        log.info("/user/signup!");
        return "redirect:/";
    }

    @PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String userLogin(HttpSession session, @RequestBody UserDto.LoginRequest dto) {
        if (authService.tryLogin(session, dto)) {
            return "success";
        }
        return "fail";
    }
}
