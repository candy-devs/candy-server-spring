package candy.server.domain.user.controller;

import candy.server.domain.user.dto.UserModifyRequestDto;
import candy.server.domain.user.dto.UserSimpleInfoResponseDto;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import candy.server.domain.user.service.UserService;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<CaUserEntity>> all() {
        List<CaUserEntity> response = userService.findAll();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/info")
    public ResponseEntity<UserSimpleInfoResponseDto> info(@LoginUser SessionUser user) {
        if (user != null) {
            UserSimpleInfoResponseDto response = UserSimpleInfoResponseDto.fromSessionUser(user);
            return ResponseEntity.ok()
                    .body(response);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Long> modify(@LoginUser SessionUser user, @RequestBody UserModifyRequestDto dto) {
        if (user != null) {
            Long response = userService.modify(user, dto);

            return ResponseEntity.ok()
                    .body(response);
        }

        return ResponseEntity.badRequest().build();
    }
}
