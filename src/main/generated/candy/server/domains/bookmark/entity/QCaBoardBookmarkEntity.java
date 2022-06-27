package candy.server.domains.bookmark.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaBoardBookmarkEntity is a Querydsl query type for CaBoardBookmarkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaBoardBookmarkEntity extends EntityPathBase<CaBoardBookmarkEntity> {

    private static final long serialVersionUID = -2049726003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaBoardBookmarkEntity caBoardBookmarkEntity = new QCaBoardBookmarkEntity("caBoardBookmarkEntity");

    public final candy.server.domains.board.entity.QCaBoardEntity boardId;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final candy.server.domains.user.entity.QCaUserEntity userId;

    public QCaBoardBookmarkEntity(String variable) {
        this(CaBoardBookmarkEntity.class, forVariable(variable), INITS);
    }

    public QCaBoardBookmarkEntity(Path<? extends CaBoardBookmarkEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaBoardBookmarkEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaBoardBookmarkEntity(PathMetadata metadata, PathInits inits) {
        this(CaBoardBookmarkEntity.class, metadata, inits);
    }

    public QCaBoardBookmarkEntity(Class<? extends CaBoardBookmarkEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardId = inits.isInitialized("boardId") ? new candy.server.domains.board.entity.QCaBoardEntity(forProperty("boardId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domains.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

