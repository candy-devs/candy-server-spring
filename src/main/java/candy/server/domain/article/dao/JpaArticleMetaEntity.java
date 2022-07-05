package candy.server.domain.article.dao;

import candy.server.domain.article.entity.CaArticleMetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaArticleMetaEntity extends JpaRepository<CaArticleMetaEntity, Long> {
}
