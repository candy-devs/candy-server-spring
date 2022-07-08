package candy.server.domain.auth.service;

import candy.server.domain.auth.dto.AuthLoginRequestDto;
import candy.server.domain.auth.dto.AuthSignupRequestDto;
import candy.server.domain.auth.dto.AuthSignupResponseDtoCode;
import candy.server.security.model.JwtProvider;
import candy.server.security.model.SessionUser;
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
    private final JwtProvider jwtProvider;

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

    public AuthSignupResponseDtoCode join(AuthSignupRequestDto dto) {
        if (!checkProperIdFormat(dto.getId())) {
            return AuthSignupResponseDtoCode.INVALID_ID_FORMAT;
        }

        if (!checkProperPwFormat(dto.getPw())) {
            return AuthSignupResponseDtoCode.INVALID_PW_FORMAT;
        }

        if (userRepository.findByUserIdid(dto.getId()).isPresent())
            return AuthSignupResponseDtoCode.USERID_ALREADY_EXISTS;
        if (userRepository.findByUserNickname(dto.getNickname()).isPresent())
            return AuthSignupResponseDtoCode.NICKNAME_ALREADY_EXISTS;

        dto.setPw(convertPasswordToHash(dto.getPw()));

        CaUserEntity user = dto.toEntity();
        user.setUserRole(UserRoleEnum.USER);
        user.createAndSetUserSpecificIfNotExists();

        userRepository.save(user);

        return AuthSignupResponseDtoCode.SUCCESS;
    }

    public boolean tryLogin(HttpSession session, AuthLoginRequestDto dto) {
        Optional<CaUserEntity> user = userRepository.findByUserIdid(dto.getId());
        if (user.isEmpty())
            return false;

        if (!passwordEncoder.matches(dto.getPw(), user.get().getUserPw()))
            return false;

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.get().getUserIdid(), dto.getPw());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // login success
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        session.setAttribute("user", SessionUser.fromEntity(user.get()));

        return true;
    }

    public String tryLoginApp(AuthLoginRequestDto dto) {
        Optional<CaUserEntity> user = userRepository.findByUserIdid(dto.getId());
        if (user.isEmpty())
            return "";

        if (!passwordEncoder.matches(dto.getPw(), user.get().getUserPw()))
            return "";

        return jwtProvider.createToken(user.get());
    }
}
