package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleUpdateRecordEntity is a Querydsl query type for CaArticleUpdateRecordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleUpdateRecordEntity extends EntityPathBase<CaArticleUpdateRecordEntity> {

    private static final long serialVersionUID = -411550966L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleUpdateRecordEntity caArticleUpdateRecordEntity = new QCaArticleUpdateRecordEntity("caArticleUpdateRecordEntity");

    public final candy.server.domain.user.entity.QCaAnonEntity anonId;

    public final QCaArticleEntity articleId;

    public final NumberPath<Long> aurId = createNumber("aurId", Long.class);

    public final StringPath aurIp = createString("aurIp");

    public final DateTimePath<java.sql.Timestamp> aurTime = createDateTime("aurTime", java.sql.Timestamp.class);

    public final candy.server.domain.user.entity.QCaUserEntity userId;

    public QCaArticleUpdateRecordEntity(String variable) {
        this(CaArticleUpdateRecordEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleUpdateRecordEntity(Path<? extends CaArticleUpdateRecordEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleUpdateRecordEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleUpdateRecordEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleUpdateRecordEntity.class, metadata, inits);
    }

    public QCaArticleUpdateRecordEntity(Class<? extends CaArticleUpdateRecordEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.anonId = inits.isInitialized("anonId") ? new candy.server.domain.user.entity.QCaAnonEntity(forProperty("anonId")) : null;
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

