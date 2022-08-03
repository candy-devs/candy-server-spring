package candy.server.domain.user.entity;

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

    private static final long serialVersionUID = -2100471971L;

    public static final QCaAnonEntity caAnonEntity = new QCaAnonEntity("caAnonEntity");

    public final NumberPath<Long> anonId = createNumber("anonId", Long.class);

    public final StringPath anonJwt = createString("anonJwt");

    public final DateTimePath<java.sql.Timestamp> anonLastTime = createDateTime("anonLastTime", java.sql.Timestamp.class);

    public final StringPath anonSess = createString("anonSess");

    public final DateTimePath<java.sql.Timestamp> anonTime = createDateTime("anonTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> anonType = createNumber("anonType", Integer.class);

    public final ListPath<candy.server.domain.auth.entity.CaAnonJwtEntity, candy.server.domain.auth.entity.QCaAnonJwtEntity> caAnonJwtEntityList = this.<candy.server.domain.auth.entity.CaAnonJwtEntity, candy.server.domain.auth.entity.QCaAnonJwtEntity>createList("caAnonJwtEntityList", candy.server.domain.auth.entity.CaAnonJwtEntity.class, candy.server.domain.auth.entity.QCaAnonJwtEntity.class, PathInits.DIRECT2);

    public final ListPath<candy.server.domain.auth.entity.CaAnonSessEntity, candy.server.domain.auth.entity.QCaAnonSessEntity> caAnonSessEntityList = this.<candy.server.domain.auth.entity.CaAnonSessEntity, candy.server.domain.auth.entity.QCaAnonSessEntity>createList("caAnonSessEntityList", candy.server.domain.auth.entity.CaAnonSessEntity.class, candy.server.domain.auth.entity.QCaAnonSessEntity.class, PathInits.DIRECT2);

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

