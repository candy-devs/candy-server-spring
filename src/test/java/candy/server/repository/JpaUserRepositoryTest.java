package candy.server.repository;

import candy.server.model.CaUserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest
@Transactional
public class JpaUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

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
        userRepository.save(caUserEntity);
    }

    @Test
    void  findByUserNickname() {
        CaUserEntity caUserEntity = userRepository.findByUserNickname("testnickname").get();
        Assertions.assertThat(caUserEntity).isNotNull();
    }

}
