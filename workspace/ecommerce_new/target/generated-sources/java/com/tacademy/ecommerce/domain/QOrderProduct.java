package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrderProduct is a Querydsl query type for OrderProduct
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrderProduct extends EntityPathBase<OrderProduct> {

    private static final long serialVersionUID = -934214732L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderProduct orderProduct = new QOrderProduct("orderProduct");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final QOrderProduct_Id id;

    public final QOrder order;

    public final NumberPath<Integer> orderCount = createNumber("orderCount", Integer.class);

    public final QProduct product;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QOrderProduct(String variable) {
        this(OrderProduct.class, forVariable(variable), INITS);
    }

    public QOrderProduct(Path<? extends OrderProduct> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderProduct(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderProduct(PathMetadata<?> metadata, PathInits inits) {
        this(OrderProduct.class, metadata, inits);
    }

    public QOrderProduct(Class<? extends OrderProduct> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QOrderProduct_Id(forProperty("id")) : null;
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

