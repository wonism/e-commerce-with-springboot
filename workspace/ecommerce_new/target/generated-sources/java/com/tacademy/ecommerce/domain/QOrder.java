package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 779364539L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath deliveryAddress = createString("deliveryAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> orderDate = createDateTime("orderDate", java.util.Date.class);

    public final NumberPath<Long> orderDateTimestamp = createNumber("orderDateTimestamp", Long.class);

    public final NumberPath<Double> orderPrice = createNumber("orderPrice", Double.class);

    public final SetPath<OrderProduct, QOrderProduct> orderProducts = this.<OrderProduct, QOrderProduct>createSet("orderProducts", OrderProduct.class, QOrderProduct.class, PathInits.DIRECT2);

    public final EnumPath<OrderStatus> orderStatus = createEnum("orderStatus", OrderStatus.class);

    public final EnumPath<PayMethod> payMethod = createEnum("payMethod", PayMethod.class);

    public final StringPath recipientName = createString("recipientName");

    public final StringPath recipientTel = createString("recipientTel");

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final QUser user;

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrder(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrder(PathMetadata<?> metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

