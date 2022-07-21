package candy.server.domain.bookmark.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleBookmarkEntity is a Querydsl query type for CaArticleBookmarkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleBookmarkEntity extends EntityPathBase<CaArticleBookmarkEntity> {

    private static final long serialVersionUID = -1589345738L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleBookmarkEntity caArticleBookmarkEntity = new QCaArticleBookmarkEntity("caArticleBookmarkEntity");

    public final candy.server.domain.article.entity.QCaArticleEntity articleId;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final candy.server.domain.user.entity.QCaUserEntity userId;

    public QCaArticleBookmarkEntity(String variable) {
        this(CaArticleBookmarkEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleBookmarkEntity(Path<? extends CaArticleBookmarkEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleBookmarkEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleBookmarkEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleBookmarkEntity.class, metadata, inits);
    }

    public QCaArticleBookmarkEntity(Class<? extends CaArticleBookmarkEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.articleId = inits.isInitialized("articleId") ? new candy.server.domain.article.entity.QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

