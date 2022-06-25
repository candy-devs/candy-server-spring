package candy.server.domains.bookmark.repository;

import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.bookmark.entity.CaBoardBookmarkEntity;
import candy.server.domains.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBoardBookmarkRepository extends JpaRepository<CaBoardBookmarkEntity, Long> {
    Optional<List<CaBoardBookmarkEntity>> findByUserId(CaUserEntity user);
    Optional<List<CaBoardBookmarkEntity>> findByBoardId(CaBoardEntity board);
}
