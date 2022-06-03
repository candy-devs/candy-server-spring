package candy.server.domains.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserOauthEntity is a Querydsl query type for CaUserOauthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserOauthEntity extends EntityPathBase<CaUserOauthEntity> {

    private static final long serialVersionUID = 1931669355L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserOauthEntity caUserOauthEntity = new QCaUserOauthEntity("caUserOauthEntity");

    public final QCaOauthEntity oauthId;

    public final candy.server.domains.user.entity.QCaUserEntity userId;

    public QCaUserOauthEntity(String variable) {
        this(CaUserOauthEntity.class, forVariable(variable), INITS);
    }

    public QCaUserOauthEntity(Path<? extends CaUserOauthEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserOauthEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserOauthEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserOauthEntity.class, metadata, inits);
    }

    public QCaUserOauthEntity(Class<? extends CaUserOauthEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.oauthId = inits.isInitialized("oauthId") ? new QCaOauthEntity(forProperty("oauthId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domains.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

