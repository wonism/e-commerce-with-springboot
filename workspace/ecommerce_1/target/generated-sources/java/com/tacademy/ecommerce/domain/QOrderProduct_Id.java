package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QOrderProduct_Id is a Querydsl query type for Id
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QOrderProduct_Id extends BeanPath<OrderProduct.Id> {

    private static final long serialVersionUID = 197043637L;

    public static final QOrderProduct_Id id = new QOrderProduct_Id("id");

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public QOrderProduct_Id(String variable) {
        super(OrderProduct.Id.class, forVariable(variable));
    }

    public QOrderProduct_Id(Path<? extends OrderProduct.Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderProduct_Id(PathMetadata<?> metadata) {
        super(OrderProduct.Id.class, metadata);
    }

}

