package candy.server.domain.user.service;

import candy.server.domain.user.dto.UserListsResponseDto;
import candy.server.domain.user.dto.UserModifyRequestDto;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
