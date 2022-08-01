//package candy.server.domain.search.dao;
//
//import candy.server.domain.article.entity.CaArticleEntity;
//import candy.server.domain.board.entity.CaBoardEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.Criteria;
//import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import java.awt.print.Pageable;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Component
//public class SearchRepositoryImpl implements SearchRepository {
//    private final ElasticsearchOperations elasticsearchOperations;
//
//    @Override
//    public List<CaArticleEntity> searchByName(String name, org.springframework.data.domain.Pageable pageable) {
//        Criteria criteria = Criteria.where("articleTitle").contains(name);
//        System.out.println(criteria);
////        Criteria criteria = Criteria.where("")
//        Query query = new CriteriaQuery(criteria).setPageable((org.springframework.data.domain.Pageable) pageable);
//        SearchHits<CaArticleEntity> search = elasticsearchOperations.search(query, CaArticleEntity.class);
//        return search.stream()
//                .map(SearchHit::getContent)
//                .collect(Collectors.toList());
//    }
//}
