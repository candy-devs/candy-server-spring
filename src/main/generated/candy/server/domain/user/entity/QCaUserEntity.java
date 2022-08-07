package candy.server.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserEntity is a Querydsl query type for CaUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserEntity extends EntityPathBase<CaUserEntity> {

    private static final long serialVersionUID = 1118668060L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaUserEntity caUserEntity = new QCaUserEntity("caUserEntity");

    public final candy.server.domain.account.entity.QCaAccountEntity caAccountEntity;

    public final ListPath<candy.server.domain.account.entity.CaTransactionEntity, candy.server.domain.account.entity.QCaTransactionEntity> caTransactionReceiverEntity = this.<candy.server.domain.account.entity.CaTransactionEntity, candy.server.domain.account.entity.QCaTransactionEntity>createList("caTransactionReceiverEntity", candy.server.domain.account.entity.CaTransactionEntity.class, candy.server.domain.account.entity.QCaTransactionEntity.class, PathInits.DIRECT2);

    public final ListPath<candy.server.domain.account.entity.CaTransactionEntity, candy.server.domain.account.entity.QCaTransactionEntity> caTransactionSenderEntity = this.<candy.server.domain.account.entity.CaTransactionEntity, candy.server.domain.account.entity.QCaTransactionEntity>createList("caTransactionSenderEntity", candy.server.domain.account.entity.CaTransactionEntity.class, candy.server.domain.account.entity.QCaTransactionEntity.class, PathInits.DIRECT2);

    public final ListPath<CaUserLoginEntity, QCaUserLoginEntity> caUserLoginEntityList = this.<CaUserLoginEntity, QCaUserLoginEntity>createList("caUserLoginEntityList", CaUserLoginEntity.class, QCaUserLoginEntity.class, PathInits.DIRECT2);

    public final StringPath userEmail = createString("userEmail");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userIdid = createString("userIdid");

    public final StringPath userImage = createString("userImage");

    public final DateTimePath<java.sql.Timestamp> userLastLoginTime = createDateTime("userLastLoginTime", java.sql.Timestamp.class);

    public final StringPath userNickname = createString("userNickname");

    public final StringPath userPw = createString("userPw");

    public final NumberPath<Integer> userRest = createNumber("userRest", Integer.class);

    public final EnumPath<UserRoleEnum> userRole = createEnum("userRole", UserRoleEnum.class);

    public final DateTimePath<java.sql.Timestamp> userSignupTime = createDateTime("userSignupTime", java.sql.Timestamp.class);

    public final StringPath userSpecificId = createString("userSpecificId");

    public QCaUserEntity(String variable) {
        this(CaUserEntity.class, forVariable(variable), INITS);
    }

    public QCaUserEntity(Path<? extends CaUserEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaUserEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaUserEntity(PathMetadata metadata, PathInits inits) {
        this(CaUserEntity.class, metadata, inits);
    }

    public QCaUserEntity(Class<? extends CaUserEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.caAccountEntity = inits.isInitialized("caAccountEntity") ? new candy.server.domain.account.entity.QCaAccountEntity(forProperty("caAccountEntity"), inits.get("caAccountEntity")) : null;
    }

}

