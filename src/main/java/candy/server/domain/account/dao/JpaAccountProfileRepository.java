package candy.server.domain.account.dao;

import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.user.entity.CaUserProfileEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountProfileRepository extends JpaRepository<CaUserProfileEntity,Long> {
//    Optional<CaAccountEntity> findByCaUserEntity_UserNickname(String name, Pageable pageable);

}
