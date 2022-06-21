package candy.server.domains.article.dao;

import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.board.entity.CaBoardEntity;
import candy.server.domains.user.entity.CaUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaArticleRepository extends JpaRepository<CaArticleEntity, Long> {
    Page<CaArticleEntity> findByBoardId(CaBoardEntity boardId, Pageable pageable);
}
