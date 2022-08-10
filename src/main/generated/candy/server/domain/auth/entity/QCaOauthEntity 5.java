package candy.server.domain.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaOauthEntity is a Querydsl query type for CaOauthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaOauthEntity extends EntityPathBase<CaOauthEntity> {

    private static final long serialVersionUID = 765837263L;

    public static final QCaOauthEntity caOauthEntity = new QCaOauthEntity("caOauthEntity");

    public final StringPath email = createString("email");

    public final StringPath name = createString("name");

    public final NumberPath<Long> oauthId = createNumber("oauthId", Long.class);

    public final StringPath oauthMeta = createString("oauthMeta");

    public final DateTimePath<java.sql.Timestamp> oauthTimed = createDateTime("oauthTimed", java.sql.Timestamp.class);

    public final EnumPath<CaOauthTypeEnum> oauthType = createEnum("oauthType", CaOauthTypeEnum.class);

    public final StringPath picture = createString("picture");

    public QCaOauthEntity(String variable) {
        super(CaOauthEntity.class, forVariable(variable));
    }

    public QCaOauthEntity(Path<? extends CaOauthEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaOauthEntity(PathMetadata metadata) {
        super(CaOauthEntity.class, metadata);
    }

}

