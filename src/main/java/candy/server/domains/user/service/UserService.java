package candy.server.domains.user.service;

import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.repository.UserRepository;
import candy.server.model.CaUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public List<CaUserEntity> findAll() {
        return userRepository.findAll();
    }

    private String convertPasswordToHash(String pw) {
        return pw;
    }

    public void join(UserDto.Signup dto) {
        if (userRepository.findByUserIdid(dto.getId()).isPresent())
            throw new IllegalArgumentException("User-id is exists!");
        if (userRepository.findByUserNickname(dto.getNickname()).isPresent())
            throw new IllegalArgumentException("User-nickname is exists!");

        dto.setPw(convertPasswordToHash(dto.getPw()));

        userRepository.save(dto.toEntity());
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
