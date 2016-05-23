package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCartProduct_Id is a Querydsl query type for Id
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QCartProduct_Id extends BeanPath<CartProduct.Id> {

    private static final long serialVersionUID = -1912822003L;

    public static final QCartProduct_Id id = new QCartProduct_Id("id");

    public final NumberPath<Long> cartId = createNumber("cartId", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public QCartProduct_Id(String variable) {
        super(CartProduct.Id.class, forVariable(variable));
    }

    public QCartProduct_Id(Path<? extends CartProduct.Id> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCartProduct_Id(PathMetadata<?> metadata) {
        super(CartProduct.Id.class, metadata);
    }

}

