package candy.server.domains.bookmark.repository;

import candy.server.domains.article.entity.CaArticleEntity;
import candy.server.domains.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domains.user.entity.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaArticleBookmarkRepository extends JpaRepository<CaArticleBookmarkEntity, Long> {
    Optional<List<CaArticleBookmarkEntity>> findByUserId(CaUserEntity user);
    Optional<Integer> countByArticleId(CaArticleEntity article);
    Optional<Integer> countByUserId(CaUserEntity user);
    Optional<CaArticleBookmarkEntity> findByUserIdAndArticleId(CaUserEntity user, CaArticleEntity article);
}
