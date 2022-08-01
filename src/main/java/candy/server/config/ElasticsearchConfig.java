package candy.server.config;

import candy.server.domain.search.dao.JpaSearchRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackageClasses = JpaSearchRepository.class)
@Configuration
public class ElasticsearchConfig {
}
