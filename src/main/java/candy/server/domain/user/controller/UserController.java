package candy.server.domain.user.controller;

import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.user.dto.UserDto;
import candy.server.domain.user.service.UserService;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/user")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    @ResponseBody
    public List<CaUserEntity> userAll() {
        return userService.findAll();
    }

//    @PostMapping("/user/signup-guest")
//    public String userSignupGuest(HttpSession session, @RequestBody UserDto.SignupRequest dto) {
//
//    }

    @GetMapping("/mysinfo")
    @ResponseBody
    public UserDto.UserSimpInfoResponse mySimpInfo(@LoginUser SessionUser user) {
        if (user != null)
            return new UserDto.UserSimpInfoResponse(user);
        return null;
    }
}
