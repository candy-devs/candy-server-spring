package candy.server.domain.search.service;

import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.search.dao.JpaSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class SearchService {
    private final JpaSearchRepository searchRepository;
    private final JpaArticleRepository articleRepository;
    @Transactional
    public void save(String title,String contents) {
        CaArticleEntity user = CaArticleEntity.builder().articleTitle(title).articleBody(contents).build();
        searchRepository.save(user);
        articleRepository.save(user);
    }
    public List<String> searchByTitle(String name) {
        // userSearchRepository.findByBasicProfile_NameContains(name) 가능
        return searchRepository.findByArticleTitle_Contains(name)
                .stream()
                .map(CaArticleEntity::getArticleTitle)
                .collect(Collectors.toList());
    };
    public List<String> searchByBody(String name) {
        // userSearchRepository.findByBasicProfile_NameContains(name) 가능
        return searchRepository.findByArticleBody_Contains(name)
                .stream()
                .map(CaArticleEntity::getArticleBody)
                .collect(Collectors.toList());
    };


}
