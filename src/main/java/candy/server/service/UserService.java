package candy.server.service;

import candy.server.model.CaUserEntity;
import candy.server.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<CaUserEntity> findAll() {
        return userRepository.findAll();
    }

    public void join(CaUserEntity caUserEntity) {
        userRepository.save(caUserEntity);
    }
}
