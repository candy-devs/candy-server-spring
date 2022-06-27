package candy.server.domain.bookmark.service;

import candy.server.security.model.SessionUser;
import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.bookmark.dto.BookmarkDto;
import candy.server.domain.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domain.bookmark.repository.JpaArticleBookmarkRepository;
import candy.server.domain.bookmark.repository.JpaBoardBookmarkRepository;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookmarkService {
    private JpaUserRepository userRepository;
    private JpaArticleRepository articleRepository;
    private JpaArticleBookmarkRepository articleBookmarkRepository;
    private JpaBoardBookmarkRepository boardBookmarkRepository;

    public Long article(SessionUser sessionUser, BookmarkDto.ArticleRequest dto) {
        if (sessionUser == null) return -1L;

        /* todo: should we check user if a user exists? */
        CaUserEntity userEntity = userRepository.findById(sessionUser.getId()).orElse(null);
        if (userEntity == null) return -1L;

        CaArticleEntity article = articleRepository.findById(dto.getArticleId()).orElse(null);
        if (article == null) return -1L;

        articleBookmarkRepository.save(CaArticleBookmarkEntity.builder()
                        .articleId(article)
                        .userId(userEntity)
                .build());
        article.setArticleBookmarkCount(article.getArticleBookmarkCount() + 1);
        return 1L;
    }

    public Long unArticle(SessionUser sessionUser, BookmarkDto.ArticleRequest dto) {
        if (sessionUser == null) return -1L;

        /* todo: should we check user if a user exists? */
        CaUserEntity userEntity = userRepository.findById(sessionUser.getId()).orElse(null);
        if (userEntity == null) return -1L;

        CaArticleEntity article = articleRepository.findById(dto.getArticleId()).orElse(null);
        if (article == null) return -1L;

        Optional<CaArticleBookmarkEntity> articleBookmarkEntity = articleBookmarkRepository.findByUserIdAndArticleId(userEntity, article);
        if (articleBookmarkEntity.isEmpty()) return 1L;

        articleBookmarkRepository.delete(articleBookmarkEntity.get());
        article.setArticleBookmarkCount(article.getArticleBookmarkCount() - 1);
        return 1L;
    }
}
