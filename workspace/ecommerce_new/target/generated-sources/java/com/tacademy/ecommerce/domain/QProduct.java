package com.tacademy.ecommerce.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1752316132L;

    public static final QProduct product = new QProduct("product");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath color = createString("color");

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageFileName = createString("imageFileName");

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath name = createString("name");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata<?> metadata) {
        super(Product.class, metadata);
    }

}

