package candy.server.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaBoardTagEntity is a Querydsl query type for CaBoardTagEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaBoardTagEntity extends EntityPathBase<CaBoardTagEntity> {

    private static final long serialVersionUID = -2079980624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaBoardTagEntity caBoardTagEntity = new QCaBoardTagEntity("caBoardTagEntity");

    public final QCaBoardEntity boardId;

    public final QCaTagEntity tagId;

    public QCaBoardTagEntity(String variable) {
        this(CaBoardTagEntity.class, forVariable(variable), INITS);
    }

    public QCaBoardTagEntity(Path<? extends CaBoardTagEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaBoardTagEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaBoardTagEntity(PathMetadata metadata, PathInits inits) {
        this(CaBoardTagEntity.class, metadata, inits);
    }

    public QCaBoardTagEntity(Class<? extends CaBoardTagEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardId = inits.isInitialized("boardId") ? new QCaBoardEntity(forProperty("boardId")) : null;
        this.tagId = inits.isInitialized("tagId") ? new QCaTagEntity(forProperty("tagId")) : null;
    }

}

