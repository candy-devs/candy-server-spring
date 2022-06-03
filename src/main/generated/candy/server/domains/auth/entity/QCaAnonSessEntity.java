package candy.server.domains.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaAnonSessEntity is a Querydsl query type for CaAnonSessEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaAnonSessEntity extends EntityPathBase<CaAnonSessEntity> {

    private static final long serialVersionUID = 1639897157L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaAnonSessEntity caAnonSessEntity = new QCaAnonSessEntity("caAnonSessEntity");

    public final candy.server.domains.user.entity.QCaAnonEntity anonId;

    public final NumberPath<Long> anonsessId = createNumber("anonsessId", Long.class);

    public final StringPath anonsessIp = createString("anonsessIp");

    public final StringPath anonsessPreSess = createString("anonsessPreSess");

    public final NumberPath<Integer> anonsessRefresh = createNumber("anonsessRefresh", Integer.class);

    public final DateTimePath<java.sql.Timestamp> anonsessTime = createDateTime("anonsessTime", java.sql.Timestamp.class);

    public QCaAnonSessEntity(String variable) {
        this(CaAnonSessEntity.class, forVariable(variable), INITS);
    }

    public QCaAnonSessEntity(Path<? extends CaAnonSessEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaAnonSessEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaAnonSessEntity(PathMetadata metadata, PathInits inits) {
        this(CaAnonSessEntity.class, metadata, inits);
    }

    public QCaAnonSessEntity(Class<? extends CaAnonSessEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.anonId = inits.isInitialized("anonId") ? new candy.server.domains.user.entity.QCaAnonEntity(forProperty("anonId")) : null;
    }

}

