package candy.server.service;

import candy.server.dto.UserDto;
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
        UserDto.Insert insert = UserDto.Insert
                .builder()
                .id("testid")
                .pw("testpw")
                .nickname("testnickname")
                .build();

        userService.join(insert);
    }

}
