package candy.server.domains.board.dao;

import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.board.entity.CaBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBoardRepository extends JpaRepository<CaBoardEntity, Long> {
    Optional<CaBoardEntity> findByBoardKey(String key);
}
