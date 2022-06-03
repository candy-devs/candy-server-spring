package candy.server.domains.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleTagEntity is a Querydsl query type for CaArticleTagEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleTagEntity extends EntityPathBase<CaArticleTagEntity> {

    private static final long serialVersionUID = 350638295L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleTagEntity caArticleTagEntity = new QCaArticleTagEntity("caArticleTagEntity");

    public final QCaArticleEntity articleId;

    public final candy.server.domains.board.entity.QCaTagEntity tagId;

    public QCaArticleTagEntity(String variable) {
        this(CaArticleTagEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleTagEntity(Path<? extends CaArticleTagEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleTagEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleTagEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleTagEntity.class, metadata, inits);
    }

    public QCaArticleTagEntity(Class<? extends CaArticleTagEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.articleId = inits.isInitialized("articleId") ? new QCaArticleEntity(forProperty("articleId"), inits.get("articleId")) : null;
        this.tagId = inits.isInitialized("tagId") ? new candy.server.domains.board.entity.QCaTagEntity(forProperty("tagId")) : null;
    }

}

