package candy.server.domains.user.controller;

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
    public String userSignup(@RequestBody UserDto.Signup dto) throws Exception {
        userService.join(dto);
        log.info("/user/signup!");
        return "redirect:/";
    }

    @PostMapping(value = "/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userLogin(HttpSession session, @RequestBody UserDto.Login dto) {
        userService.tryLogin(session, dto);
        return "redirect:/";
    }

}
