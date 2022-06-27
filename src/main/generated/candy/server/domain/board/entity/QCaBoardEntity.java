package candy.server.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaBoardEntity is a Querydsl query type for CaBoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaBoardEntity extends EntityPathBase<CaBoardEntity> {

    private static final long serialVersionUID = -1165609680L;

    public static final QCaBoardEntity caBoardEntity = new QCaBoardEntity("caBoardEntity");

    public final NumberPath<Long> boardId = createNumber("boardId", Long.class);

    public final StringPath boardKey = createString("boardKey");

    public final StringPath boardName = createString("boardName");

    public final ListPath<candy.server.domain.article.entity.CaArticleEntity, candy.server.domain.article.entity.QCaArticleEntity> caArticleEntityList = this.<candy.server.domain.article.entity.CaArticleEntity, candy.server.domain.article.entity.QCaArticleEntity>createList("caArticleEntityList", candy.server.domain.article.entity.CaArticleEntity.class, candy.server.domain.article.entity.QCaArticleEntity.class, PathInits.DIRECT2);

    public QCaBoardEntity(String variable) {
        super(CaBoardEntity.class, forVariable(variable));
    }

    public QCaBoardEntity(Path<? extends CaBoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaBoardEntity(PathMetadata metadata) {
        super(CaBoardEntity.class, metadata);
    }

}

