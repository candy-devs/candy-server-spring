package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaUserRoleEntity is a Querydsl query type for CaUserRoleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserRoleEntity extends EntityPathBase<CaUserRoleEntity> {

    private static final long serialVersionUID = 1019285739L;

    public static final QCaUserRoleEntity caUserRoleEntity = new QCaUserRoleEntity("caUserRoleEntity");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath roleName = createString("roleName");

    public QCaUserRoleEntity(String variable) {
        super(CaUserRoleEntity.class, forVariable(variable));
    }

    public QCaUserRoleEntity(Path<? extends CaUserRoleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaUserRoleEntity(PathMetadata metadata) {
        super(CaUserRoleEntity.class, metadata);
    }

}

