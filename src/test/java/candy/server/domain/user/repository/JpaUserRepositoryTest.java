package candy.server.domain.user.repository;

import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
@Transactional
public class JpaUserRepositoryTest {

    @Autowired
    private JpaUserRepository userRepository;

    @Test
    void  findByUserNickname() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        CaUserEntity caUserEntity = CaUserEntity.UserBuilder()
                .userIdid("testid")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.saveAndFlush(caUserEntity);

        CaUserEntity caUserEntity1 = userRepository.findByUserNickname("testnickname").get();
        Assertions.assertThat(caUserEntity1).isNotNull();
    }

    @Test
    public void userRoleTest() {
        for (int i = 0; i < 100; i++) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            CaUserEntity user = CaUserEntity.UserBuilder()
                    .userIdid("test-id-" + i)
                    .userPw("test-pw-" + i)
                    .userRest(0)
                    .userNickname("test-nick-" + i)
                    .userSignupTime(timestamp)
                    .userLastLoginTime(timestamp)
                    .userRole(UserRoleEnum.USER)
                    .build();

            userRepository.save(user);
        }

        System.out.println(userRepository.count());

        Optional<CaUserEntity> user = userRepository.findById(85L);
        Assertions.assertThat(user.isPresent()).isTrue();
    }
}
