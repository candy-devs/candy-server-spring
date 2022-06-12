package candy.server.domains.user.controller;

import candy.server.config.auth.SessionUser;
import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.service.UserService;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/user/all")
    @ResponseBody
    public List<CaUserEntity> userAll() {
        return userService.findAll();
    }

    @PostMapping("/user/signup")
    @ResponseBody
    public String userSignup(@RequestBody UserDto.SignupRequest dto) throws Exception {
        userService.join(dto);
        log.info("/user/signup!");
        return "redirect:/";
    }

//    @PostMapping("/user/signup-guest")
//    public String userSignupGuest(HttpSession session, @RequestBody UserDto.SignupRequest dto) {
//
//    }

    @PostMapping(value = "/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String userLogin(HttpSession session, @RequestBody UserDto.LoginRequest dto) {
        if (userService.tryLogin(session, dto)) {
            return "success";
        }
       return "fail";
    }

    @GetMapping("/user/mysinfo")
    @ResponseBody
    public UserDto.UserSimpInfoResponse mySimpInfo(HttpSession session) {
        var userData = session.getAttribute("user");
        if (userData != null)
            return new UserDto.UserSimpInfoResponse((SessionUser)userData);
        return null;
    }
}
