package candy.server.domains.user.service;

import candy.server.domains.user.entity.CaUserRoleEntity;
import candy.server.domains.user.repository.JpaUserRepository;
import candy.server.domains.user.dto.UserDto;
import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.repository.JpaUserRoleRepository;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@Slf4j
public class UserService {
    private final JpaUserRepository userRepository;
    private final JpaUserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public List<CaUserEntity> findAll() {
        return userRepository.findAll();
    }

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

    private CaUserRoleEntity getUserRoleEntity() {
        Optional<CaUserRoleEntity> roleEntityOptional = userRoleRepository.findByRoleName("USER");
        return roleEntityOptional.orElseGet(() ->
                userRoleRepository.save(CaUserRoleEntity.builder().roleName("USER").build()));
    }

    public void join(UserDto.Signup dto) throws Exception {
        if (userRepository.findByUserIdid(dto.getId()).isPresent())
            throw new IllegalArgumentException("User-id is exists!");
        if (userRepository.findByUserNickname(dto.getNickname()).isPresent())
            throw new IllegalArgumentException("User-nickname is exists!");

        if (!checkProperIdFormat(dto.getId()) || !checkProperPwFormat(dto.getPw())) {
            throw new IllegalArgumentException("check id or pw format!");
        }

        dto.setPw(convertPasswordToHash(dto.getPw()));

        CaUserEntity user = dto.toEntity();
        user.setCaUserRoleEntity(getUserRoleEntity());

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<UserDto.UserListsResponse> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDto.UserListsResponse::new)
                .collect(Collectors.toList());
    }

    public void tryLogin(HttpSession session, UserDto.Login dto) {
        Optional<CaUserEntity> userIdid = userRepository.findByUserIdid(dto.getId());
        if (userIdid.isEmpty())
            throw new IllegalArgumentException();

        if (!passwordEncoder.matches(dto.getPw(), userIdid.get().getUserPw()))
            throw new IllegalArgumentException();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userIdid.get().getUserIdid(), dto.getPw()));
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // login success
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//        session.setAttribute(SESS_USER_ID.name(), userIdid.get().getUserId());
    }
}
