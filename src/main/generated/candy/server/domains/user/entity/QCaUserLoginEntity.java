package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserLoginEntity is a Querydsl query type for CaUserLoginEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserLoginEntity extends EntityPathBase<CaUserLoginEntity> {

    private static final long serialVersionUID = -892569094L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserLoginEntity caUserLoginEntity = new QCaUserLoginEntity("caUserLoginEntity");

    public final NumberPath<Long> loginId = createNumber("loginId", Long.class);

    public final StringPath loginIp = createString("loginIp");

    public final EnumPath<CaUserLoginLocEnum> loginLoc = createEnum("loginLoc", CaUserLoginLocEnum.class);

    public final EnumPath<CaUserLoginSuccEnum> loginSucc = createEnum("loginSucc", CaUserLoginSuccEnum.class);

    public final DateTimePath<java.sql.Timestamp> loginTime = createDateTime("loginTime", java.sql.Timestamp.class);

    public final EnumPath<CaUserLoginTypeEnum> loginType = createEnum("loginType", CaUserLoginTypeEnum.class);

    public final NumberPath<Integer> oauthId = createNumber("oauthId", Integer.class);

    public final QCaUserEntity userId;

    public QCaUserLoginEntity(String variable) {
        this(CaUserLoginEntity.class, forVariable(variable), INITS);
    }

    public QCaUserLoginEntity(Path<? extends CaUserLoginEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserLoginEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserLoginEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserLoginEntity.class, metadata, inits);
    }

    public QCaUserLoginEntity(Class<? extends CaUserLoginEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new QCaUserEntity(forProperty("userId")) : null;
    }

}

