package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QImmArticleInteractionInfo is a Querydsl query type for ImmArticleInteractionInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QImmArticleInteractionInfo extends BeanPath<ImmArticleInteractionInfo> {

    private static final long serialVersionUID = 1604736424L;

    public static final QImmArticleInteractionInfo immArticleInteractionInfo = new QImmArticleInteractionInfo("immArticleInteractionInfo");

    public final NumberPath<Integer> articleBookmarkCount = createNumber("articleBookmarkCount", Integer.class);

    public final NumberPath<Integer> articleCommentCount = createNumber("articleCommentCount", Integer.class);

    public final NumberPath<Integer> articleDownvote = createNumber("articleDownvote", Integer.class);

    public final NumberPath<Integer> articleNotice = createNumber("articleNotice", Integer.class);

    public final NumberPath<Integer> articleUpvote = createNumber("articleUpvote", Integer.class);

    public final NumberPath<Integer> articleView = createNumber("articleView", Integer.class);

    public QImmArticleInteractionInfo(String variable) {
        super(ImmArticleInteractionInfo.class, forVariable(variable));
    }

    public QImmArticleInteractionInfo(Path<? extends ImmArticleInteractionInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImmArticleInteractionInfo(PathMetadata metadata) {
        super(ImmArticleInteractionInfo.class, metadata);
    }

}

