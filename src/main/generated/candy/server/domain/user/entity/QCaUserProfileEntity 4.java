package candy.server.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserProfileEntity is a Querydsl query type for CaUserProfileEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserProfileEntity extends EntityPathBase<CaUserProfileEntity> {

    private static final long serialVersionUID = 2016408467L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserProfileEntity caUserProfileEntity = new QCaUserProfileEntity("caUserProfileEntity");

    public final StringPath description = createString("description");

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final QCaUserEntity userId;

    public final NumberPath<Long> writeArticleCount = createNumber("writeArticleCount", Long.class);

    public final NumberPath<Long> writeCommentCount = createNumber("writeCommentCount", Long.class);

    public QCaUserProfileEntity(String variable) {
        this(CaUserProfileEntity.class, forVariable(variable), INITS);
    }

    public QCaUserProfileEntity(Path<? extends CaUserProfileEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserProfileEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserProfileEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserProfileEntity.class, metadata, inits);
    }

    public QCaUserProfileEntity(Class<? extends CaUserProfileEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new QCaUserEntity(forProperty("userId")) : null;
    }

}

