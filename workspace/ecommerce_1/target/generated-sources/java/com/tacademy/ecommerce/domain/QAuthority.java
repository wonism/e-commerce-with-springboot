package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAuthority is a Querydsl query type for Authority
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAuthority extends EntityPathBase<Authority> {

    private static final long serialVersionUID = -2116146640L;

    public static final QAuthority authority1 = new QAuthority("authority1");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath authority = createString("authority");

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final SetPath<User, QUser> users = this.<User, QUser>createSet("users", User.class, QUser.class, PathInits.DIRECT2);

    public QAuthority(String variable) {
        super(Authority.class, forVariable(variable));
    }

    public QAuthority(Path<? extends Authority> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthority(PathMetadata<?> metadata) {
        super(Authority.class, metadata);
    }

}

