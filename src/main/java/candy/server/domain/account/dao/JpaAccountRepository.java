package candy.server.domain.account.dao;

import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<CaAccountEntity,Long> {
    Optional<CaAccountEntity> findByAccountId(Long id);
    Optional<CaAccountEntity> findByCaUserEntity_UserSpecificId(String id);
}
