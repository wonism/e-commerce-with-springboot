package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCart is a Querydsl query type for Cart
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCart extends EntityPathBase<Cart> {

    private static final long serialVersionUID = -945063917L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCart cart = new QCart("cart");

    public final SetPath<CartProduct, QCartProduct> cartProduct = this.<CartProduct, QCartProduct>createSet("cartProduct", CartProduct.class, QCartProduct.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QCart(String variable) {
        this(Cart.class, forVariable(variable), INITS);
    }

    public QCart(Path<? extends Cart> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCart(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCart(PathMetadata<?> metadata, PathInits inits) {
        this(Cart.class, metadata, inits);
    }

    public QCart(Class<? extends Cart> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

