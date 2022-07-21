package candy.server.domain.account.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
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

@SpringBootTest
@Transactional
public class AccountServiceTest {

    private CaUserEntity senderUser;
    private CaUserEntity receiverUser;
    private CaAccountEntity caAccountEntity;
    private CaAccountEntity caAccountEntity2;
    @Autowired
    private AccountSendService accountSendService;
    @Autowired
    JpaAccountRepository accountRepository;
    @Autowired
    JpaUserRepository userRepository;
    @BeforeEach
    void beforeEach(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        senderUser = CaUserEntity.UserBuilder()
                .userIdid("test_id")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(senderUser);
        receiverUser = CaUserEntity.UserBuilder()
                .userIdid("test_id2")
                .userPw("testpw")
                .userNickname("testnickname2")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(receiverUser);
        caAccountEntity =CaAccountEntity.builder()
                .accountId(senderUser.getUserId())
                .caUserEntity(senderUser)
                .accountUserCandyCnt(3L)
                .build();
        accountRepository.save(caAccountEntity);
        caAccountEntity2 =CaAccountEntity.builder()
                .accountId(receiverUser.getUserId())
                .caUserEntity(receiverUser)
                .accountUserCandyCnt(3L)
                .build();
        accountRepository.save(caAccountEntity2);
    }

    @Test
    void sendCandyTest(){
        System.out.println(accountRepository.findAll());
        CaAccountEntity accountSendUser = accountRepository.findByAccountId(senderUser.getUserId()).get();
        CaAccountEntity accountReceiveUser = accountRepository.findByAccountId(receiverUser.getUserId()).get();
        accountSendService.sendCandy(AccountSendRequestDto.builder()
                .accountSenderId(accountSendUser.getAccountId())
                .accountReceiverId(accountReceiveUser.getAccountId())
                .accountCandyCnt(3L)
                .build());
        Assertions.assertThat(accountReceiveUser.getAccountUserCandyCnt()).isEqualTo(6L);
    }
}
