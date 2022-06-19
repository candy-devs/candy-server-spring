package candy.server.domains.board.dao;

import candy.server.domains.board.entity.CaTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTagRepository extends JpaRepository<CaTagEntity, Long> {
    Optional<CaTagEntity> findByTagName(String tagName);
}
