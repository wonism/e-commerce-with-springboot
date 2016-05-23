package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCartProduct is a Querydsl query type for CartProduct
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCartProduct extends EntityPathBase<CartProduct> {

    private static final long serialVersionUID = -444972708L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartProduct cartProduct = new QCartProduct("cartProduct");

    public final NumberPath<Integer> buyCount = createNumber("buyCount", Integer.class);

    public final QCart cart;

    public final QCartProduct_Id id;

    public final QProduct product;

    public QCartProduct(String variable) {
        this(CartProduct.class, forVariable(variable), INITS);
    }

    public QCartProduct(Path<? extends CartProduct> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCartProduct(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCartProduct(PathMetadata<?> metadata, PathInits inits) {
        this(CartProduct.class, metadata, inits);
    }

    public QCartProduct(Class<? extends CartProduct> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new QCart(forProperty("cart"), inits.get("cart")) : null;
        this.id = inits.isInitialized("id") ? new QCartProduct_Id(forProperty("id")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

