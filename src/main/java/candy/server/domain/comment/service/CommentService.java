package candy.server.domain.comment.service;

import candy.server.domain.article.dao.JpaArticleRepository;
import candy.server.domain.article.dto.ArticleWriteResponseDto;
import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.comment.dao.JpaCommentRepository;
import candy.server.domain.comment.dto.CommentWriteRequestDto;
import candy.server.domain.comment.dto.CommentWriteResponseDto;
import candy.server.domain.comment.entity.CaCommentEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.domain.user.entity.CaUserEntity;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final JpaCommentRepository jpaCommentRepository;
    private final JpaUserRepository userRepository;
    private final JpaArticleRepository articleRepository;


    public CommentWriteResponseDto writeComment(SessionUser user, CommentWriteRequestDto dto) {
        if (user.getId() == null) {
            return CommentWriteResponseDto.builder()
                    .message("존재하지 않는 유저입니다.")
                    .build();
        }
        CaUserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null)
            return CommentWriteResponseDto.builder()
                    .message("user not found")
                    .build();

        CaArticleEntity articleEntity = articleRepository.findById(dto.getArticleId()).orElse(null);

        if (articleEntity == null)
            return CommentWriteResponseDto.builder()
                    .message("article not found")
                    .build();

        CaCommentEntity caCommentEntity = CaCommentEntity.builder()
                                                         .comment(dto.getBody())
                                                         .userId(userEntity)
                                                         .articlePassword(dto.getPassword())
                                                         .build();

        jpaCommentRepository.save(caCommentEntity);

        return CommentWriteResponseDto.builder().message("댓글 작성 완료").build();
    }
}
