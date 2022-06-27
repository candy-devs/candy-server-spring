package candy.server.domains.user.controller;

import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.service.UserService;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/user/signup-guest")
//    public String userSignupGuest(HttpSession session, @RequestBody UserDto.SignupRequest dto) {
//
//    }

    @GetMapping("/user/mysinfo")
    @ResponseBody
    public UserDto.UserSimpInfoResponse mySimpInfo(@LoginUser SessionUser user) {
        if (user != null)
            return new UserDto.UserSimpInfoResponse(user);
        return null;
    }
}
