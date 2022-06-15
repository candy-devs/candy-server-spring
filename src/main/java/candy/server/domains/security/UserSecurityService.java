package candy.server.domains.security;

import candy.server.config.auth.SessionUser;
import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.controller.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final JpaUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CaUserEntity user = userRepository.findByUserIdid(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        httpSession.setAttribute("user", SessionUser.fromEntity(user));

        return User.builder()
                .username(user.getUserIdid())
                .password(user.getUserPw())
                .roles(user.getUserRole().name())
                .build();
    }
}