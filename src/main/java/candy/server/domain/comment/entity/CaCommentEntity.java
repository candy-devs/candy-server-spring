package candy.server.domain.comment.entity;

import candy.server.domain.article.entity.CaArticleEntity;
import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaCommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long commentId;
    @Column
    private String comment;
    @Column
    private int upvote;
    @Column(length = 255)
    private String articlePassword;
    @CreationTimestamp
    private Timestamp articleWriteTime;
    @UpdateTimestamp
    private Timestamp articleLastUpdateTime;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private CaArticleEntity articleId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;
}
