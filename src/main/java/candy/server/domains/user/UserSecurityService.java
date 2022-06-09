package candy.server.domains.user;

import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final JpaUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CaUserEntity user = userRepository.findByUserIdid(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        return User.builder()
                .username(user.getUserIdid())
                .password(user.getUserPw())
                .roles(user.getCaUserRoleEntity().getRoleName())
                .build();
    }
}