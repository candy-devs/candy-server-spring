package candy.server.domains.user;

import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.repository.JpaUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {
    private JpaUserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CaUserEntity> userEntityOptional = userRepository.findByUserIdid(username);
        if (userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        CaUserEntity user = userEntityOptional.get();

        return User.builder()
                .username(user.getUserIdid())
                .password(user.getUserPw())
                .roles(user.getCaUserRoleEntity().getRoleName())
                .build();
    }
}