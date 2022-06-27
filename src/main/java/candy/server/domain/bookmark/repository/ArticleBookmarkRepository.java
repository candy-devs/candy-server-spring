package candy.server.domain.bookmark.repository;

import candy.server.domain.bookmark.entity.CaArticleBookmarkEntity;
import candy.server.domain.user.entity.CaUserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ArticleBookmarkRepository {
    @PersistenceContext
    private EntityManager em;

    public List<CaArticleBookmarkEntity> queryBookmarkLimitsByUserId(CaUserEntity user, int limit, int offset) {
        return em.createQuery("select b from CaArticleBookmarkEntity b where b.userId = ?1 order by b.id desc",
                        CaArticleBookmarkEntity.class)
                .setParameter("1", user.getUserId())
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
