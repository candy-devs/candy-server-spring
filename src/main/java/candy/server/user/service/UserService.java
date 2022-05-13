package candy.server.user.service;

import candy.server.user.dto.UserDto;
import candy.server.model.CaUserEntity;
import candy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
