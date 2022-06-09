package candy.server.domains.user.repository;


import candy.server.domains.user.entity.CaUserEntity;
import candy.server.domains.user.entity.CaUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRoleRepository extends JpaRepository<CaUserRoleEntity, Long> {
    Optional<CaUserRoleEntity> findByRoleName(String name);
}
