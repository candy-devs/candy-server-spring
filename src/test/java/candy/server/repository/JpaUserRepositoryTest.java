package candy.server.repository;

import candy.server.model.CaUserEntity;
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
        CaUserEntity caUserEntity = new CaUserEntity();
        caUserEntity.setUserIdid("testid");
        caUserEntity.setUserPw("testpw");
        caUserEntity.setUserNickname("testnickname");
        caUserEntity.setUserSignupTime(new Timestamp(System.currentTimeMillis()));
        caUserEntity.setUserLastLoginTime(new Timestamp(System.currentTimeMillis()));
        caUserEntity.setUserRest(0);
        userRepository.save(caUserEntity);
    }

    @Test
    void  findByUserNickname() {
        CaUserEntity caUserEntity = userRepository.findByUserNickname("testnickname").get();
        Assertions.assertThat(caUserEntity).isNotNull();
    }


}
