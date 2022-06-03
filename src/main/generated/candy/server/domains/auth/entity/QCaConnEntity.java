package candy.server.domains.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaConnEntity is a Querydsl query type for CaConnEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaConnEntity extends EntityPathBase<CaConnEntity> {

    private static final long serialVersionUID = 1703933395L;

    public static final QCaConnEntity caConnEntity = new QCaConnEntity("caConnEntity");

    public final NumberPath<Long> connId = createNumber("connId", Long.class);

    public final StringPath connIp = createString("connIp");

    public final DateTimePath<java.sql.Timestamp> connTime = createDateTime("connTime", java.sql.Timestamp.class);

    public final StringPath connUa = createString("connUa");

    public QCaConnEntity(String variable) {
        super(CaConnEntity.class, forVariable(variable));
    }

    public QCaConnEntity(Path<? extends CaConnEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaConnEntity(PathMetadata metadata) {
        super(CaConnEntity.class, metadata);
    }

}

