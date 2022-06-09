package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserEntity is a Querydsl query type for CaUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserEntity extends EntityPathBase<CaUserEntity> {

    private static final long serialVersionUID = -933650987L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserEntity caUserEntity = new QCaUserEntity("caUserEntity");

    public final ListPath<CaUserLoginEntity, QCaUserLoginEntity> caUserLoginEntityList = this.<CaUserLoginEntity, QCaUserLoginEntity>createList("caUserLoginEntityList", CaUserLoginEntity.class, QCaUserLoginEntity.class, PathInits.DIRECT2);

    public final QCaUserRoleEntity caUserRoleEntity;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userIdid = createString("userIdid");

    public final DateTimePath<java.sql.Timestamp> userLastLoginTime = createDateTime("userLastLoginTime", java.sql.Timestamp.class);

    public final StringPath userNickname = createString("userNickname");

    public final StringPath userPw = createString("userPw");

    public final NumberPath<Integer> userRest = createNumber("userRest", Integer.class);

    public final DateTimePath<java.sql.Timestamp> userSignupTime = createDateTime("userSignupTime", java.sql.Timestamp.class);

    public QCaUserEntity(String variable) {
        this(CaUserEntity.class, forVariable(variable), INITS);
    }

    public QCaUserEntity(Path<? extends CaUserEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserEntity.class, metadata, inits);
    }

    public QCaUserEntity(Class<? extends CaUserEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.caUserRoleEntity = inits.isInitialized("caUserRoleEntity") ? new QCaUserRoleEntity(forProperty("caUserRoleEntity")) : null;
    }

}

