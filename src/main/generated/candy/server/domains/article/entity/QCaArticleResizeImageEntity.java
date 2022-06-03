package candy.server.domains.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleResizeImageEntity is a Querydsl query type for CaArticleResizeImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleResizeImageEntity extends EntityPathBase<CaArticleResizeImageEntity> {

    private static final long serialVersionUID = 1168547460L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleResizeImageEntity caArticleResizeImageEntity = new QCaArticleResizeImageEntity("caArticleResizeImageEntity");

    public final StringPath ariExt = createString("ariExt");

    public final StringPath ariFilename = createString("ariFilename");

    public final NumberPath<Long> ariId = createNumber("ariId", Long.class);

    public final NumberPath<Integer> ariSize = createNumber("ariSize", Integer.class);

    public final StringPath ariToken = createString("ariToken");

    public final QCaArticleMetaEntity caArticleMetaEntity;

    public QCaArticleResizeImageEntity(String variable) {
        this(CaArticleResizeImageEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleResizeImageEntity(Path<? extends CaArticleResizeImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleResizeImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleResizeImageEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleResizeImageEntity.class, metadata, inits);
    }

    public QCaArticleResizeImageEntity(Class<? extends CaArticleResizeImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.caArticleMetaEntity = inits.isInitialized("caArticleMetaEntity") ? new QCaArticleMetaEntity(forProperty("caArticleMetaEntity"), inits.get("caArticleMetaEntity")) : null;
    }

}

