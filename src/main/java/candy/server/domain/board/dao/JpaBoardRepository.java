package candy.server.domain.board.dao;

import candy.server.domain.board.entity.CaBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBoardRepository extends JpaRepository<CaBoardEntity, Long> {
    Optional<CaBoardEntity> findByBoardKey(String key);
    Optional<CaBoardEntity> findByBoardKeyOrBoardName(String key, String name);
}
