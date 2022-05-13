package candy.server.user.repository;

import candy.server.model.CaUserEntity;
import candy.server.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
