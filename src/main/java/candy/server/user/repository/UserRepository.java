package candy.server.user.repository;

import candy.server.model.CaUserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<CaUserEntity> findByUserNickname(String name);
    Optional<CaUserEntity> findByUserIdid(String idid);

    CaUserEntity save(CaUserEntity caUserEntity);

    List<CaUserEntity> findAll();
}
