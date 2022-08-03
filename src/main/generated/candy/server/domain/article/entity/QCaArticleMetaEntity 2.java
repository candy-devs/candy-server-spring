package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleMetaEntity is a Querydsl query type for CaArticleMetaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleMetaEntity extends EntityPathBase<CaArticleMetaEntity> {

    private static final long serialVersionUID = -1953004715L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleMetaEntity caArticleMetaEntity = new QCaArticleMetaEntity("caArticleMetaEntity");

    public final StringPath amExt = createString("amExt");

    public final StringPath amFilename = createString("amFilename");

    public final NumberPath<Integer> amHeight = createNumber("amHeight", Integer.class);

    public final NumberPath<Long> amId = createNumber("amId", Long.class);

    public final StringPath amIp = createString("amIp");

    public final StringPath amOFilename = createString("amOFilename");

    public final NumberPath<Integer> amRef = createNumber("amRef", Integer.class);

    public final NumberPath<Long> amSize = createNumber("amSize", Long.class);

    public final StringPath amToken = createString("amToken");

    public final NumberPath<Integer> amType = createNumber("amType", Integer.class);

    public final StringPath amURL = createString("amURL");

    public final NumberPath<Integer> amWidth = createNumber("amWidth", Integer.class);

    public final DateTimePath<java.sql.Timestamp> amWriteTime = createDateTime("amWriteTime", java.sql.Timestamp.class);

    public final QCaArticleResizeImageEntity ariId;

    public final QCaArticleEntity articleId;

    public final candy.server.domain.user.entity.QCaUserEntity userId;

    public QCaArticleMetaEntity(String variable) {
        this(CaArticleMetaEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleMetaEntity(Path<? extends CaArticleMetaEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleMetaEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleMetaEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleMetaEntity.class, metadata, inits);
    }

    public QCaArticleMetaEntity(Class<? extends CaArticleMetaEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ariId = inits.isInitialized("ariId") ? new QCaArticleResizeImageEntity(forProperty("ariId"), inits.get("ariId")) : null;
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("userId"), inits.get("userId")) : null;
    }

}

