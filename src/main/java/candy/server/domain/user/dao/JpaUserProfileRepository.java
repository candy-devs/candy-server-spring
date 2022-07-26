package candy.server.domain.user.dao;

import candy.server.domain.user.entity.CaUserEntity;
import candy.server.domain.user.entity.CaUserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserProfileRepository  extends JpaRepository<CaUserProfileEntity, Long> {
    Optional<CaUserProfileEntity> findByUserId_UserSpecificId(String specific);
    Optional<CaUserProfileEntity> findByUserId_UserNickname(String specific);

}
