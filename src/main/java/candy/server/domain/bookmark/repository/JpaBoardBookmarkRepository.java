package candy.server.domain.bookmark.repository;

import candy.server.domain.board.entity.CaBoardEntity;
import candy.server.domain.bookmark.entity.CaBoardBookmarkEntity;
import candy.server.domain.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBoardBookmarkRepository extends JpaRepository<CaBoardBookmarkEntity, Long> {
    Optional<List<CaBoardBookmarkEntity>> findByUserId(CaUserEntity user);
    Optional<List<CaBoardBookmarkEntity>> findByBoardId(CaBoardEntity board);
}
