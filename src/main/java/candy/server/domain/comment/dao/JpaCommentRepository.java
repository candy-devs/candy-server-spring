package candy.server.domain.comment.dao;


import candy.server.domain.comment.entity.CaCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<CaCommentEntity,Long> {
}
