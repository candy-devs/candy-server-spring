package candy.server.controller;

import candy.server.model.CaUserEntity;
import candy.server.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
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

    @GetMapping("/user/insert")
    public String userInsert(@RequestParam(value = "id", required = true) String id,
                             @RequestParam(value = "pw", required = true) String pw,
                             @RequestParam(value = "nickname", required = true) String nickname) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        CaUserEntity caUserEntity = CaUserEntity.UserBuilder()
                .userIdid(id)
                .userPw(pw)
                .userNickname(nickname)
                .userSignupTime(currentTime)
                .userLastLoginTime(currentTime)
                .userRest(0)
                .build();
        userService.join(caUserEntity);
        log.info("/user/insert!");
        return "redirect:/";
    }
}
