package candy.server.domain.user.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.dto.ArticleWriteRequestDto;
import candy.server.domain.article.service.ArticleService;
import candy.server.domain.board.dao.JpaBoardRepository;
import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.user.dao.JpaUserProfileRepository;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.dto.UserModifyRequestDto;
import candy.server.domain.user.dto.UserProfileRequestDto;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.CaUserProfileEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import candy.server.security.model.SessionUser;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.Assert.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private JpaUserRepository userRepository;
    @Autowired
    private JpaAccountRepository accountRepository;
    @Autowired
    private JpaUserProfileRepository userProfileRepository;
    @Autowired
    private JpaBoardRepository boardRepository;
    @Autowired
    private JpaArticleRepository articleRepository;
    private CaUserEntity caUserEntity;
    @BeforeEach
    void 테스트_유저_생성() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caUserEntity = CaUserEntity.UserBuilder()
                .userIdid("testid")
                .userPw("testpw")
                .userNickname("testnickname")
                .userSignupTime(timestamp)
                .userSpecificId("1234")
                .userLastLoginTime(timestamp)
                .userRole(UserRoleEnum.USER)
                .build();
        userRepository.save(caUserEntity);
    }
    private SessionUser mockSessionUser() {

        return SessionUser.fromEntity(caUserEntity);
    }
    @Test
    void test_modify() {
        Optional<CaUserEntity> userEntity = userRepository.findByUserNickname("testnickname");
        SessionUser sessionUser = SessionUser.builder()
                .id(userEntity.get().getUserId())
                .build();
        userService.modify(sessionUser, UserModifyRequestDto.builder()
                .nickname("testnickname-modify")
                .build());

        Assertions.assertThat(userEntity.get().getUserNickname()).isEqualTo("testnickname-modify");
    }

    @Test
    void test_Profile() {
//        Optional<CaUserProfileEntity> user = userProfileRepository.findByUserId_UserNickname("testnickname");
        userProfileRepository.save(CaUserProfileEntity.builder().userId(caUserEntity).writeArticleCount(3L).writeCommentCount(3L).build());
        CaAccountEntity accountEntity = CaAccountEntity.builder()
                .caUserEntity(caUserEntity)
                .accountCount(3L)
                .build();
        accountRepository.save(accountEntity);
        UserProfileRequestDto userProfileRequestDto = userService.getuserProfileRequestDto("1234");
        Assertions.assertThat(userProfileRequestDto.getAccountCount()).isEqualTo(3L);
    }
    @Test
    void 특정유저_글찾기() {
        boardRepository.save(CaBoardEntity.builder()
                .boardKey("test-board")
                .boardName("test-board")
                .build());

        articleService.articleWrite(
                mockSessionUser(),
                ArticleWriteRequestDto.builder()
                        .nickname("test-nick")
                        .password("test-pw")
                        .boardKey("test-board")
                        .title("test-title")
                        .body("test-body")
                        .build()
        );
        var result = userService.articleProfileUser(0,"testnickname",mockSessionUser());
        Assertions.assertThat(result.getArticles().get(0).getTitle()).isEqualTo("test-title");
    }

}
