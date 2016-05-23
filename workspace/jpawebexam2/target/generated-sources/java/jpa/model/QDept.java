package jpa.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDept is a Querydsl query type for Dept
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDept extends EntityPathBase<Dept> {

    private static final long serialVersionUID = 88104445L;

    public static final QDept dept = new QDept("dept");

    public final NumberPath<Long> deptno = createNumber("deptno", Long.class);

    public final StringPath dname = createString("dname");

    public QDept(String variable) {
        super(Dept.class, forVariable(variable));
    }

    public QDept(Path<? extends Dept> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDept(PathMetadata metadata) {
        super(Dept.class, metadata);
    }

}

