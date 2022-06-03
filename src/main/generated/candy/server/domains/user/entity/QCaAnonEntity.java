package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaAnonEntity is a Querydsl query type for CaAnonEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaAnonEntity extends EntityPathBase<CaAnonEntity> {

    private static final long serialVersionUID = 142176278L;

    public static final QCaAnonEntity caAnonEntity = new QCaAnonEntity("caAnonEntity");

    public final NumberPath<Long> anonId = createNumber("anonId", Long.class);

    public final StringPath anonJwt = createString("anonJwt");

    public final DateTimePath<java.sql.Timestamp> anonLastTime = createDateTime("anonLastTime", java.sql.Timestamp.class);

    public final StringPath anonSess = createString("anonSess");

    public final DateTimePath<java.sql.Timestamp> anonTime = createDateTime("anonTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> anonType = createNumber("anonType", Integer.class);

    public final ListPath<candy.server.domains.auth.entity.CaAnonJwtEntity, candy.server.domains.auth.entity.QCaAnonJwtEntity> caAnonJwtEntityList = this.<candy.server.domains.auth.entity.CaAnonJwtEntity, candy.server.domains.auth.entity.QCaAnonJwtEntity>createList("caAnonJwtEntityList", candy.server.domains.auth.entity.CaAnonJwtEntity.class, candy.server.domains.auth.entity.QCaAnonJwtEntity.class, PathInits.DIRECT2);

    public final ListPath<candy.server.domains.auth.entity.CaAnonSessEntity, candy.server.domains.auth.entity.QCaAnonSessEntity> caAnonSessEntityList = this.<candy.server.domains.auth.entity.CaAnonSessEntity, candy.server.domains.auth.entity.QCaAnonSessEntity>createList("caAnonSessEntityList", candy.server.domains.auth.entity.CaAnonSessEntity.class, candy.server.domains.auth.entity.QCaAnonSessEntity.class, PathInits.DIRECT2);

    public QCaAnonEntity(String variable) {
        super(CaAnonEntity.class, forVariable(variable));
    }

    public QCaAnonEntity(Path<? extends CaAnonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaAnonEntity(PathMetadata metadata) {
        super(CaAnonEntity.class, metadata);
    }

}

