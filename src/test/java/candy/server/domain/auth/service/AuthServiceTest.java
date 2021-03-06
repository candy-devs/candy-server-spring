package candy.server.domain.auth.service;

import candy.server.domain.auth.dto.AuthSignupRequestDto;
import candy.server.domain.auth.dto.AuthSignupResponseDtoCode;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
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
        AuthSignupRequestDto signup = AuthSignupRequestDto
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        authService.join(signup);
    }

    @Test
    void 유저_회원가입_실패() throws Exception {
        AuthSignupRequestDto signup = AuthSignupRequestDto
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        authService.join(signup);
        Assertions.assertThat(authService.join(signup).getValue()).isEqualTo(
                AuthSignupResponseDtoCode.USERID_ALREADY_EXISTS.getValue());
    }

    @Test
    void 유저_로그인_실패() {
        AuthSignupRequestDto login = AuthSignupRequestDto
                .builder()
                .id("testid")
                .pw("testpw")
                .build();

        // 유저가 없어야하기 때문에 실패함.
//        assertThatIllegalArgumentException().isThrownBy(() -> userService.login(login));
    }
}
