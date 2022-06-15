package candy.server.domains.user.service;

import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.controller.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<UserDto.UserListsResponse> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDto.UserListsResponse::new)
                .collect(Collectors.toList());
    }
}
