package candy.server.domain.auth.service;

import candy.server.security.model.SessionUser;
import candy.server.domain.user.dto.UserDto;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.UserRoleEnum;
import candy.server.domain.user.dao.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class AuthService {
    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    private String convertPasswordToHash(String pw) {
        return passwordEncoder.encode(pw);
    }

    private boolean checkProperIdFormat(String id) {
        if (id.length() < 6 || id.length() > 255)
            return false;
        return id.matches("\\w+");
    }

    private boolean checkProperPwFormat(String pw) {
        return 8 <= pw.length() && pw.length() <= 64;
    }

    public void join(UserDto.SignupRequest dto) throws Exception {
        if (userRepository.findByUserIdid(dto.getId()).isPresent())
            throw new IllegalArgumentException("User-id is exists!");
        if (userRepository.findByUserNickname(dto.getNickname()).isPresent())
            throw new IllegalArgumentException("User-nickname is exists!");

        if (!checkProperIdFormat(dto.getId()) || !checkProperPwFormat(dto.getPw())) {
            throw new IllegalArgumentException("check id or pw format!");
        }

        dto.setPw(convertPasswordToHash(dto.getPw()));

        CaUserEntity user = dto.toEntity();
        user.setUserRole(UserRoleEnum.USER);

        userRepository.save(user);
    }

    public boolean tryLogin(HttpSession session, UserDto.LoginRequest dto) {
        Optional<CaUserEntity> userIdid = userRepository.findByUserIdid(dto.getId());
        if (userIdid.isEmpty())
            return false;

        if (!passwordEncoder.matches(dto.getPw(), userIdid.get().getUserPw()))
            return false;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userIdid.get().getUserIdid(), dto.getPw()));
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // login success
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        session.setAttribute("user", SessionUser.fromEntity(userIdid.get()));

        return true;
    }
}
