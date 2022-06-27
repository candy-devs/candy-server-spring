package candy.server.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;

@SpringBootTest
//@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

}
