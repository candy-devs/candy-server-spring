package candy.server.service;

import candy.server.dto.UserDto;
import candy.server.model.CaUserEntity;
import candy.server.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<CaUserEntity> findAll() {
        return userRepository.findAll();
    }

    public void join(UserDto.Insert caUserEntity) {
        userRepository.save(caUserEntity.toEntity());
    }
}
