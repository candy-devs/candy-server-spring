package candy.server.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaArticleEntity is a Querydsl query type for CaArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaArticleEntity extends EntityPathBase<CaArticleEntity> {

    private static final long serialVersionUID = 761227120L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCaArticleEntity caArticleEntity = new QCaArticleEntity("caArticleEntity");

    public final candy.server.domain.user.entity.QCaAnonEntity anonId;

    public final NumberPath<Integer> articleAbuse = createNumber("articleAbuse", Integer.class);

    public final StringPath articleBody = createString("articleBody");

    public final NumberPath<Integer> articleBookmarkCount = createNumber("articleBookmarkCount", Integer.class);

    public final NumberPath<Integer> articleCommentCount = createNumber("articleCommentCount", Integer.class);

    public final NumberPath<Integer> articleDel = createNumber("articleDel", Integer.class);

    public final NumberPath<Integer> articleDevice = createNumber("articleDevice", Integer.class);

    public final NumberPath<Integer> articleDownvote = createNumber("articleDownvote", Integer.class);

    public final NumberPath<Integer> articleHide = createNumber("articleHide", Integer.class);

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final StringPath articleIp = createString("articleIp");

    public final DateTimePath<java.sql.Timestamp> articleLastUpdateTime = createDateTime("articleLastUpdateTime", java.sql.Timestamp.class);

    public final StringPath articleNickname = createString("articleNickname");

    public final NumberPath<Integer> articleNotice = createNumber("articleNotice", Integer.class);

    public final StringPath articlePassword = createString("articlePassword");

    public final StringPath articleTitle = createString("articleTitle");

    public final StringPath articleTitlePretty = createString("articleTitlePretty");

    public final EnumPath<CaArticleTypeEnum> articleType = createEnum("articleType", CaArticleTypeEnum.class);

    public final NumberPath<Integer> articleUpvote = createNumber("articleUpvote", Integer.class);

    public final NumberPath<Integer> articleUserSpecific = createNumber("articleUserSpecific", Integer.class);

    public final NumberPath<Integer> articleView = createNumber("articleView", Integer.class);

    public final DateTimePath<java.sql.Timestamp> articleWriteTime = createDateTime("articleWriteTime", java.sql.Timestamp.class);

    public final candy.server.domain.board.entity.QCaBoardEntity boardId;

    public final ListPath<CaArticleAbuseEntity, QCaArticleAbuseEntity> caArticleAbuseEntityList = this.<CaArticleAbuseEntity, QCaArticleAbuseEntity>createList("caArticleAbuseEntityList", CaArticleAbuseEntity.class, QCaArticleAbuseEntity.class, PathInits.DIRECT2);

    public final ListPath<CaArticleMetaEntity, QCaArticleMetaEntity> caArticleMetaEntityList = this.<CaArticleMetaEntity, QCaArticleMetaEntity>createList("caArticleMetaEntityList", CaArticleMetaEntity.class, QCaArticleMetaEntity.class, PathInits.DIRECT2);

    public final ListPath<CaArticleReadAnonEntity, QCaArticleReadAnonEntity> caArticleReadAnonEntityList = this.<CaArticleReadAnonEntity, QCaArticleReadAnonEntity>createList("caArticleReadAnonEntityList", CaArticleReadAnonEntity.class, QCaArticleReadAnonEntity.class, PathInits.DIRECT2);

    public final ListPath<CaArticleUpdateRecordEntity, QCaArticleUpdateRecordEntity> caArticleUpdateRecordEntityList = this.<CaArticleUpdateRecordEntity, QCaArticleUpdateRecordEntity>createList("caArticleUpdateRecordEntityList", CaArticleUpdateRecordEntity.class, QCaArticleUpdateRecordEntity.class, PathInits.DIRECT2);

    public final candy.server.domain.user.entity.QCaUserEntity userId;

    public QCaArticleEntity(String variable) {
        this(CaArticleEntity.class, forVariable(variable), INITS);
    }

    public QCaArticleEntity(Path<? extends CaArticleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCaArticleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCaArticleEntity(PathMetadata metadata, PathInits inits) {
        this(CaArticleEntity.class, metadata, inits);
    }

    public QCaArticleEntity(Class<? extends CaArticleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.anonId = inits.isInitialized("anonId") ? new candy.server.domain.user.entity.QCaAnonEntity(forProperty("anonId")) : null;
        this.boardId = inits.isInitialized("boardId") ? new candy.server.domain.board.entity.QCaBoardEntity(forProperty("boardId")) : null;
        this.userId = inits.isInitialized("userId") ? new candy.server.domain.user.entity.QCaUserEntity(forProperty("userId")) : null;
    }

}

