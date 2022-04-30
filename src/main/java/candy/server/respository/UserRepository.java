package candy.server.respository;

import candy.server.model.CaUserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<CaUserEntity> findByUserNickName(String name);

    CaUserEntity save(CaUserEntity caUserEntity);

    List<CaUserEntity> findAll();
}
