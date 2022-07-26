package candy.server.domain.user.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.dto.ArticleRecentResponseDto;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.article.util.ArticleUtils;
import candy.server.domain.user.dao.JpaUserProfileRepository;
import candy.server.domain.user.dto.*;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserProfileEntity;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class UserService {
    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JpaUserProfileRepository userProfileRepository;
    private final JpaAccountRepository accountRepository;
    private final JpaArticleRepository articleRepository;
    public List<CaUserEntity> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<UserListsResponseDto> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserListsResponseDto::new)
                .collect(Collectors.toList());
    }

    public Long modify(SessionUser sessionUser, UserModifyRequestDto dto) {
        Optional<CaUserEntity> user = userRepository.findByUserId(sessionUser.getId());

        if (user.isEmpty()) return -1L;

        user.get().setUserNickname(dto.getNickname());

        return 0L;
    }

    public String getSpecific(SessionUser sessionUser) {
        Optional<CaUserEntity> user = userRepository.findByUserId(sessionUser.getId());

        if (user.isEmpty()) return null;

        return user.get().getUserSpecificId();
    }

    public UserGetRequestDto getUserInfoFromSpecific(String specific) {
        Optional<CaUserEntity> user = userRepository.findByUserSpecificId(specific);

        if (user.isEmpty()) return null;

        CaUserEntity userEntity = user.get();

        return UserGetRequestDto.builder()
                .name(userEntity.getUserNickname())
                .picture(userEntity.getUserImage())
                .role(userEntity.getUserRole().name())
                .build();
    }

    public UserProfileRequestDto getuserProfileRequestDto(String specific) {
        Optional<CaUserProfileEntity> user = userProfileRepository.findByUserId_UserSpecificId(specific);

        if (user.isEmpty()) return null;

        CaUserProfileEntity userEntity = user.get();
        Optional<CaAccountEntity> accountEntity = accountRepository.findByCaUserEntity_UserSpecificId(specific);

        return UserProfileRequestDto.builder()
                .accountCount(accountEntity.get().getAccountCount())
                .ArticleCount(user.get().getWriteArticleCount())
                .CommentCount(user.get().getWriteCommentCount())
                .build();
    }

    public UserProfileArticleResponseDto articleProfileUser(int p, String name, SessionUser user) {
        /* todo: this query must get result with board key, user nickname (if exists) */
        Page<CaArticleEntity> articles;
        if(user.getName() == name) {
            articles = articleRepository
                    .findByArticleHideAndUserId_UserNickname(0, name, PageRequest.of(p, 10));
        }
        else {
            articles = articleRepository
                    .findByArticleHideAndUserId_UserNickname(1, name, PageRequest.of(p, 10));
        }
        List<UserProfileArticleResponseDto.PaginationItem> items = articles.stream().map(article ->
                UserProfileArticleResponseDto.PaginationItem.builder()
                        .id(article.getArticleId())
                        .title(article.getArticleTitlePretty())
                        .summary(article.getArticleBody())
                        .tags(article.getArticleTags() != null ? article.getArticleTags().split(",") : null)
                        .author(ArticleUtils.getAuthor(article))
                        .writeTime(article.getArticleWriteTime())
                        .up(article.getArticleUpvote())
                        .down(article.getArticleDownvote())
                        .view(article.getArticleView())
                        .bookmark(article.getArticleBookmarkCount())
                        .comments(article.getArticleCommentCount())
                        .board(article.getBoardId().getBoardName())
                        .build()
        ).collect(Collectors.toList());

        return UserProfileArticleResponseDto.builder()
                .articles(items)
                .build();
    }
}
