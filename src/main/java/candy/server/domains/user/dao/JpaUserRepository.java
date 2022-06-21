package candy.server.domains.user.controller;

import candy.server.domains.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<CaUserEntity, Long> {
    Optional<CaUserEntity> findByUserNickname(String name);
    Optional<CaUserEntity> findByUserIdid(String idid);
    Optional<CaUserEntity> findByUserEmail(String email);
}
