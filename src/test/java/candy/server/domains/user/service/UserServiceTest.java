package candy.server.domains.user.service;

import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertThrows;

@SpringBootTest
//@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

}
