package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserRoleEntity is a Querydsl query type for CaUserRoleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserRoleEntity extends EntityPathBase<CaUserRoleEntity> {

    private static final long serialVersionUID = 1019285739L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserRoleEntity caUserRoleEntity = new QCaUserRoleEntity("caUserRoleEntity");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath roleName = createString("roleName");

    public final QCaUserEntity userId;

    public QCaUserRoleEntity(String variable) {
        this(CaUserRoleEntity.class, forVariable(variable), INITS);
    }

    public QCaUserRoleEntity(Path<? extends CaUserRoleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserRoleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserRoleEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserRoleEntity.class, metadata, inits);
    }

    public QCaUserRoleEntity(Class<? extends CaUserRoleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new QCaUserEntity(forProperty("userId")) : null;
    }

}

