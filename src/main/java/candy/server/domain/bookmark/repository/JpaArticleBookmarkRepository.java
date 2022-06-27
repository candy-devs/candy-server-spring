package candy.server.domain.bookmark.repository;

import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domain.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaArticleBookmarkRepository extends JpaRepository<CaArticleBookmarkEntity, Long> {
    Optional<List<CaArticleBookmarkEntity>> findByUserId(CaUserEntity user);
    Optional<Integer> countByArticleId(CaArticleEntity article);
    Optional<Integer> countByUserId(CaUserEntity user);
    Optional<CaArticleBookmarkEntity> findByUserIdAndArticleId(CaUserEntity user, CaArticleEntity article);
}
