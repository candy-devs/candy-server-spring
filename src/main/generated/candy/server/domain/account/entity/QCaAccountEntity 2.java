package candy.server.domain.account.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaAccountEntity is a Querydsl query type for CaAccountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaAccountEntity extends EntityPathBase<CaAccountEntity> {

    private static final long serialVersionUID = -1029344176L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaAccountEntity caAccountEntity = new QCaAccountEntity("caAccountEntity");

    public final NumberPath<Integer> accountUserCandyCnt = createNumber("accountUserCandyCnt", Integer.class);

    public final candy.server.domain.user.entity.QCaUserEntity accountUserId;

    public QCaAccountEntity(String variable) {
        this(CaAccountEntity.class, forVariable(variable), INITS);
    }

    public QCaAccountEntity(Path<? extends CaAccountEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaAccountEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaAccountEntity(PathMetadata metadata, PathInits inits) {
        this(CaAccountEntity.class, metadata, inits);
    }

    public QCaAccountEntity(Class<? extends CaAccountEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountUserId = inits.isInitialized("accountUserId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("accountUserId")) : null;
    }

}

