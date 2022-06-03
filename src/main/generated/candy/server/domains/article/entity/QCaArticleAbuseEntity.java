package candy.server.domains.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleAbuseEntity is a Querydsl query type for CaArticleAbuseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleAbuseEntity extends EntityPathBase<CaArticleAbuseEntity> {

    private static final long serialVersionUID = -166448253L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleAbuseEntity caArticleAbuseEntity = new QCaArticleAbuseEntity("caArticleAbuseEntity");

    public final StringPath aaBody = createString("aaBody");

    public final NumberPath<Long> aaId = createNumber("aaId", Long.class);

    public final StringPath aaIp = createString("aaIp");

    public final QCaArticleEntity articleId;

    public QCaArticleAbuseEntity(String variable) {
        this(CaArticleAbuseEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleAbuseEntity(Path<? extends CaArticleAbuseEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleAbuseEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleAbuseEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleAbuseEntity.class, metadata, inits);
    }

    public QCaArticleAbuseEntity(Class<? extends CaArticleAbuseEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
    }

}

