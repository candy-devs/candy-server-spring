package candy.server.service;

import candy.server.model.CaUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void join() {
        CaUserEntity caUserEntity = new CaUserEntity();
        caUserEntity.setUserIdid("testid");
        caUserEntity.setUserPw("testpw");
        caUserEntity.setUserNickname("testnickname");
        caUserEntity.setUserSignupTime(new Timestamp(System.currentTimeMillis()));
        caUserEntity.setUserLastLoginTime(new Timestamp(System.currentTimeMillis()));
        caUserEntity.setUserRest(0);
        userService.join(caUserEntity);
    }

}
