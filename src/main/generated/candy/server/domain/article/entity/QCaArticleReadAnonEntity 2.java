package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleReadAnonEntity is a Querydsl query type for CaArticleReadAnonEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleReadAnonEntity extends EntityPathBase<CaArticleReadAnonEntity> {

    private static final long serialVersionUID = -1745182062L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleReadAnonEntity caArticleReadAnonEntity = new QCaArticleReadAnonEntity("caArticleReadAnonEntity");

    public final candy.server.domain.user.entity.QCaAnonEntity anonId;

    public final QCaArticleEntity articleId;

    public final NumberPath<Integer> readaClock = createNumber("readaClock", Integer.class);

    public final NumberPath<Long> readaId = createNumber("readaId", Long.class);

    public final DateTimePath<java.sql.Timestamp> readaTime = createDateTime("readaTime", java.sql.Timestamp.class);

    public QCaArticleReadAnonEntity(String variable) {
        this(CaArticleReadAnonEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleReadAnonEntity(Path<? extends CaArticleReadAnonEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleReadAnonEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleReadAnonEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleReadAnonEntity.class, metadata, inits);
    }

    public QCaArticleReadAnonEntity(Class<? extends CaArticleReadAnonEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.anonId = inits.isInitialized("anonId") ? new candy.server.domain.user.entity.QCaAnonEntity(forProperty("anonId")) : null;
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
    }

}

