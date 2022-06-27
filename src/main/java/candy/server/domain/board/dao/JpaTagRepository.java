package candy.server.domain.board.dao;

import candy.server.domain.board.entity.CaTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTagRepository extends JpaRepository<CaTagEntity, Long> {
    Optional<CaTagEntity> findByTagName(String tagName);
}
