package candy.server.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaTagEntity is a Querydsl query type for CaTagEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaTagEntity extends EntityPathBase<CaTagEntity> {

    private static final long serialVersionUID = -60640092L;

    public static final QCaTagEntity caTagEntity = new QCaTagEntity("caTagEntity");

    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    public final StringPath tagName = createString("tagName");

    public final NumberPath<Integer> tagRef = createNumber("tagRef", Integer.class);

    public QCaTagEntity(String variable) {
        super(CaTagEntity.class, forVariable(variable));
    }

    public QCaTagEntity(Path<? extends CaTagEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaTagEntity(PathMetadata metadata) {
        super(CaTagEntity.class, metadata);
    }

}

