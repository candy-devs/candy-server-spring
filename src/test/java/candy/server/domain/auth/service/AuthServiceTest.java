package candy.server.domain.auth.service;

import candy.server.domain.user.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;

@SpringBootTest
//@Transactional
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void 유저_회원가입_성공() throws Exception {
        UserDto.SignupRequest signup = UserDto.SignupRequest
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        authService.join(signup);
    }

    @Test
    void 유저_회원가입_실패() throws Exception {
        UserDto.SignupRequest signup = UserDto.SignupRequest
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        authService.join(signup);
        assertThrows(IllegalArgumentException.class, () -> authService.join(signup));
    }

    @Test
    void 유저_로그인_실패() {
        UserDto.SignupRequest login = UserDto.SignupRequest
                .builder()
                .id("testid")
                .pw("testpw")
                .build();

        // 유저가 없어야하기 때문에 실패함.
//        assertThatIllegalArgumentException().isThrownBy(() -> userService.login(login));
    }
}
