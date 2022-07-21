package candy.server.domain.account.repository;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.service.AccountSendService;
import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class JpaAccountRepositoryTest {

    @Autowired
    private JpaUserRepository userRepository;
    @Autowired
    private JpaAccountRepository accountRepository;

    CaUserEntity targetUser;
    @BeforeEach
    void before(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        targetUser = CaUserEntity.UserBuilder()
                .userIdid("test_id")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSpecificId("test123")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(targetUser);
    }



    @Test
    void findByUserId(){
        CaAccountEntity caAccountEntity =CaAccountEntity.builder()
                .caUserEntity(targetUser)
                .accountUserCandyCnt(3L)
                .build();
        System.out.println(caAccountEntity.getAccountId());
        accountRepository.saveAndFlush(caAccountEntity);

        CaAccountEntity caAccountEntity1 = accountRepository.findByCaUserEntity_UserSpecificId(targetUser.getUserSpecificId()).get();
        System.out.println(caAccountEntity1.getAccountUserCandyCnt());
        Assertions.assertThat(caAccountEntity1).isNotNull();
    }

}
