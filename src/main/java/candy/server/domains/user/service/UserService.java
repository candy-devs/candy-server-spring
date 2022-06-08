package candy.server.domains.user.service;

import candy.server.domains.user.repository.JpaUserRepository;
import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static candy.server.session.SessionData.SESS_USER_ID;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final JpaUserRepository userRepository;

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

    public boolean tryLogin(HttpSession session, UserDto.Login dto) {
        Optional<CaUserEntity> userIdid = userRepository.findByUserIdid(dto.getId());
        if (userIdid.isEmpty())
            return false;

        if (!userIdid.get().getUserPw().equals(convertPasswordToHash(dto.getPw())))
            return false;

        // login success
        session.setAttribute(SESS_USER_ID.name(), userIdid.get().getUserId());
        return true;
    }
}
