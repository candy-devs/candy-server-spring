package candy.server.domain.account.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.dao.JpaTransactionRepository;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.entity.CaTransactionEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import candy.server.domain.user.service.UserService;
import candy.server.security.model.SessionUser;
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
    private Optional<CaTransactionEntity> caTransactionEntity;
    @Autowired
    private AccountSendService accountSendService;
    @Autowired
    private UserService userService;
    @Autowired
    JpaAccountRepository accountRepository;
    @Autowired
    JpaUserRepository userRepository;
    @Autowired
    JpaTransactionRepository transactionRepository;
    @BeforeEach
    void beforeEach(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        senderUser = CaUserEntity.UserBuilder()
                .userIdid("test_id")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSpecificId("test")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(senderUser);
        receiverUser = CaUserEntity.UserBuilder()
                .userIdid("test_id2")
                .userPw("testpw")
                .userNickname("testnickname2")
                .userSpecificId("test2")
                .userSignupTime(timestamp)
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(receiverUser);
        caAccountEntity =CaAccountEntity.builder()
//                .accountId(receiverUser.getUserSpecificId())
                .caUserEntity(senderUser)
                .accountCount(3L)
                .build();
        accountRepository.save(caAccountEntity);
        caAccountEntity2 =CaAccountEntity.builder()
//                .accountId(receiverUser.getUserSpecificId())
                .caUserEntity(receiverUser)
                .accountCount(3L)
                .build();
        accountRepository.save(caAccountEntity2);
    }
    private SessionUser mockSessionUser() {

        return SessionUser.fromEntity(senderUser);
    }
    @Test
    void sendCandyTest(){
        CaAccountEntity accountReceiveUser = accountRepository.findByCaUserEntity_UserSpecificId(receiverUser.getUserSpecificId()).get();
        var result = accountSendService.sendCandy(mockSessionUser(),AccountSendRequestDto.builder()
                .receiver("test2")
                .count(3L)
                .build());

        Assertions.assertThat(accountReceiveUser.getAccountCount()).isEqualTo(6L);
    }

    @Test
    void checkCountError(){
        CaAccountEntity accountReceiveUser = accountRepository.findByCaUserEntity_UserSpecificId(receiverUser.getUserSpecificId()).get();
        var result = accountSendService.sendCandy(mockSessionUser(),AccountSendRequestDto.builder()
                .receiver(accountReceiveUser.getCaUserEntity().getUserSpecificId())
                .count(4L)
                .build());
        Assertions.assertThat(result.getMessage()).isEqualTo("보유하신 캔디보다 많이 보낼 수 없습니다.");
    }

    @Test
    void checkReceiverError(){
        var result = accountSendService.sendCandy(mockSessionUser(),AccountSendRequestDto.builder()
                .receiver("-1")
                .count(4L)
                .build());
        Assertions.assertThat(result.getMessage()).isEqualTo("받는 사람이 존재하지 않습니다.");
    }

    @Test
    void checkTransactionError(){
        CaAccountEntity accountReceiveUser = accountRepository.findByCaUserEntity_UserSpecificId(receiverUser.getUserSpecificId()).get();
        var result = accountSendService.sendCandy(mockSessionUser(),AccountSendRequestDto.builder()
                .receiver(accountReceiveUser.getCaUserEntity().getUserSpecificId())
                .count(4L)
                .build());
        caTransactionEntity=transactionRepository.findCaTransactionEntityByCaReceiverEntity_UserSpecificId("test2");
        Assertions.assertThat(caTransactionEntity.equals("test2"));
    }

    @Test
    void checkTranscationProfile(){
        CaAccountEntity accountReceiveUser = accountRepository.findByCaUserEntity_UserSpecificId(receiverUser.getUserSpecificId()).get();
        var result = accountSendService.sendCandy(mockSessionUser(),AccountSendRequestDto.builder()
                .receiver(accountReceiveUser.getCaUserEntity().getUserSpecificId())
                .count(4L)
                .build());
        caTransactionEntity=transactionRepository.findCaTransactionEntityByCaReceiverEntity_UserSpecificId("test2");
        var accountResult = userService.accountProfileUser(0,"testnickname",mockSessionUser());

        Assertions.assertThat(accountResult.getAccounts().get(0).getTransactionSenderName()).isEqualTo("testnickname");
    }
}
