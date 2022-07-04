package candy.server.domain.user.service;

import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.dto.UserModifyRequestDto;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import candy.server.security.model.SessionUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.Assert.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private JpaUserRepository userRepository;

    @BeforeEach
    void 테스트_유저_생성() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        CaUserEntity caUserEntity = CaUserEntity.UserBuilder()
                .userIdid("testid")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(caUserEntity);
    }

    @Test
    void test_modify() {
        Optional<CaUserEntity> userEntity = userRepository.findByUserNickname("testnickname");
        SessionUser sessionUser = SessionUser.builder()
                .id(userEntity.get().getUserId())
                .build();
        userService.modify(sessionUser, UserModifyRequestDto.builder()
                .nickname("testnickname-modify")
                .build());

        Assertions.assertThat(userEntity.get().getUserNickname()).isEqualTo("testnickname-modify");
    }
}
