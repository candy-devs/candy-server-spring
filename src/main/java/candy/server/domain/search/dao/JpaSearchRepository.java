package candy.server.domain.search.dao;

import candy.server.domain.article.entity.CaArticleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface JpaSearchRepository extends ElasticsearchRepository<CaArticleEntity,Long> {
    List<CaArticleEntity> findByArticleTitle_Contains(String name);
    List<CaArticleEntity> findByArticleBody_Contains(String contents);
}
