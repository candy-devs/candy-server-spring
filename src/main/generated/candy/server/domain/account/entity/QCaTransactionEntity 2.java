package candy.server.domain.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaTransactionEntity is a Querydsl query type for CaTransactionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaTransactionEntity extends EntityPathBase<CaTransactionEntity> {

    private static final long serialVersionUID = 1848689729L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaTransactionEntity caTransactionEntity = new QCaTransactionEntity("caTransactionEntity");

    public final NumberPath<Long> candyCnt = createNumber("candyCnt", Long.class);

    public final candy.server.domain.user.entity.QCaUserEntity caReceiverEntity;

    public final candy.server.domain.user.entity.QCaUserEntity caSenderEntity;

    public final NumberPath<Long> transactionId = createNumber("transactionId", Long.class);

    public final DateTimePath<java.sql.Timestamp> transactionTime = createDateTime("transactionTime", java.sql.Timestamp.class);

    public QCaTransactionEntity(String variable) {
        this(CaTransactionEntity.class, forVariable(variable), INITS);
    }

    public QCaTransactionEntity(Path<? extends CaTransactionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaTransactionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaTransactionEntity(PathMetadata metadata, PathInits inits) {
        this(CaTransactionEntity.class, metadata, inits);
    }

    public QCaTransactionEntity(Class<? extends CaTransactionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.caReceiverEntity = inits.isInitialized("caReceiverEntity") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("caReceiverEntity"), inits.get("caReceiverEntity")) : null;
        this.caSenderEntity = inits.isInitialized("caSenderEntity") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("caSenderEntity"), inits.get("caSenderEntity")) : null;
    }

}

