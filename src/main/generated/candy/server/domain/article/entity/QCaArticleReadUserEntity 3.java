package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleReadUserEntity is a Querydsl query type for CaArticleReadUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleReadUserEntity extends EntityPathBase<CaArticleReadUserEntity> {

    private static final long serialVersionUID = 1473957969L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleReadUserEntity caArticleReadUserEntity = new QCaArticleReadUserEntity("caArticleReadUserEntity");

    public final QCaArticleEntity articleId;

    public final NumberPath<Integer> readClock = createNumber("readClock", Integer.class);

    public final NumberPath<Long> readId = createNumber("readId", Long.class);

    public final DateTimePath<java.sql.Timestamp> readTime = createDateTime("readTime", java.sql.Timestamp.class);

    public final candy.server.domain.user.entity.QCaUserEntity userId;

    public QCaArticleReadUserEntity(String variable) {
        this(CaArticleReadUserEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleReadUserEntity(Path<? extends CaArticleReadUserEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleReadUserEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleReadUserEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleReadUserEntity.class, metadata, inits);
    }

    public QCaArticleReadUserEntity(Class<? extends CaArticleReadUserEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

