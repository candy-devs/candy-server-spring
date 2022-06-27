package candy.server.domain.article.dao;

import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.board.entity.CaBoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaArticleRepository extends JpaRepository<CaArticleEntity, Long> {
    Page<CaArticleEntity> findByBoardId(CaBoardEntity boardId, Pageable pageable);
    Page<CaArticleEntity> findTopByOrderByArticleIdDesc(Pageable pageable);

    /* for reduce inquiry cost, we separate article to article and deleted article */
    Page<CaArticleEntity> findByArticleDelAndArticleHideOrderByArticleIdDesc(int articleDel, int articleHide, Pageable pageable);
}
