package candy.server.domains.user.repository;

import candy.server.domains.user.entity.CaUserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
//@Transactional
public class JpaUserRepositoryTest {

    @Autowired
    private JpaUserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        CaUserEntity caUserEntity = CaUserEntity.UserBuilder()
                .userIdid("testid")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .build();
        userRepository.saveAndFlush(caUserEntity);
    }

    @Test
    void  findByUserNickname() {
        System.out.println(userRepository.count());
        CaUserEntity caUserEntity = userRepository.findByUserNickname("testnickname").get();
        Assertions.assertThat(caUserEntity).isNotNull();
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
                    .build();

            userRepository.save(user);
        }

        System.out.println(userRepository.count());

        Optional<CaUserEntity> user = userRepository.findById(85L);
        Assertions.assertThat(user.isPresent()).isTrue();
    }
}
