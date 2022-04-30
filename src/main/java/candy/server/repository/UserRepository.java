package candy.server.repository;

import candy.server.model.CaUserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<CaUserEntity> findByUserNickname(String name);

    CaUserEntity save(CaUserEntity caUserEntity);

    List<CaUserEntity> findAll();
}
