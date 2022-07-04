package candy.server.domain.user.dao;

import candy.server.domain.user.entity.CaUserEntity;
import org.objectweb.asm.Opcodes;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<CaUserEntity, Long> {
    Optional<CaUserEntity> findByUserId(long id);
    Optional<CaUserEntity> findByUserNickname(String name);
    Optional<CaUserEntity> findByUserIdid(String idid);
    Optional<CaUserEntity> findByUserEmail(String email);
}
