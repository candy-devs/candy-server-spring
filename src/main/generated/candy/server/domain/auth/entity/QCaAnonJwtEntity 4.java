package candy.server.domain.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaAnonJwtEntity is a Querydsl query type for CaAnonJwtEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaAnonJwtEntity extends EntityPathBase<CaAnonJwtEntity> {

    private static final long serialVersionUID = 1416160083L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaAnonJwtEntity caAnonJwtEntity = new QCaAnonJwtEntity("caAnonJwtEntity");

    public final candy.server.domain.user.entity.QCaAnonEntity anonId;

    public final NumberPath<Long> anonjwtId = createNumber("anonjwtId", Long.class);

    public final StringPath anonjwtIp = createString("anonjwtIp");

    public final StringPath anonjwtPreJwt = createString("anonjwtPreJwt");

    public final NumberPath<Integer> anonjwtRefresh = createNumber("anonjwtRefresh", Integer.class);

    public final DateTimePath<java.sql.Timestamp> anonjwtTime = createDateTime("anonjwtTime", java.sql.Timestamp.class);

    public QCaAnonJwtEntity(String variable) {
        this(CaAnonJwtEntity.class, forVariable(variable), INITS);
    }

    public QCaAnonJwtEntity(Path<? extends CaAnonJwtEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaAnonJwtEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaAnonJwtEntity(PathMetadata metadata, PathInits inits) {
        this(CaAnonJwtEntity.class, metadata, inits);
    }

    public QCaAnonJwtEntity(Class<? extends CaAnonJwtEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.anonId = inits.isInitialized("anonId") ? new candy.server.domain.user.entity.QCaAnonEntity(forProperty("anonId")) : null;
    }

}

