package jpa.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmp is a Querydsl query type for Emp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmp extends EntityPathBase<Emp> {

    private static final long serialVersionUID = -135704048L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmp emp = new QEmp("emp");

    public final QDept dept;

    public final NumberPath<Long> empno = createNumber("empno", Long.class);

    public final StringPath ename = createString("ename");

    public final StringPath job = createString("job");

    public final NumberPath<Long> sal = createNumber("sal", Long.class);

    public QEmp(String variable) {
        this(Emp.class, forVariable(variable), INITS);
    }

    public QEmp(Path<? extends Emp> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmp(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmp(PathMetadata metadata, PathInits inits) {
        this(Emp.class, metadata, inits);
    }

    public QEmp(Class<? extends Emp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dept = inits.isInitialized("dept") ? new QDept(forProperty("dept")) : null;
    }

}

