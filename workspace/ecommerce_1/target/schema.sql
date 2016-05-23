
    alter table t_cart 
        drop 
        foreign key FK_8x24uj0agcrrqnt4pi49r0ixv;

    alter table t_cart_product 
        drop 
        foreign key FK_p8xr3tl91yvfhbwajpdb3i9om;

    alter table t_cart_product 
        drop 
        foreign key FK_n37ri7gg0u2nvt45pa50xpvkq;

    alter table t_order 
        drop 
        foreign key FK_75ffb6s55q5aibdhqs2unu49q;

    alter table t_order_product 
        drop 
        foreign key FK_1sg939jxjmxxgg5htbnodrjgc;

    alter table t_order_product 
        drop 
        foreign key FK_8jk77c74fo7usb55302do1oeh;

    alter table t_user_authority 
        drop 
        foreign key FK_9ooafeckmhk0vd0if8oust4u1;

    alter table t_user_authority 
        drop 
        foreign key FK_pkm88ipfoxp80vvihh7i5bqrs;

    drop table if exists t_authority;

    drop table if exists t_cart;

    drop table if exists t_cart_product;

    drop table if exists t_order;

    drop table if exists t_order_product;

    drop table if exists t_product;

    drop table if exists t_user;

    drop table if exists t_user_authority;

    create table t_authority (
        id bigint not null auto_increment,
        created_by bigint,
        created_date datetime,
        updated_by bigint,
        updated_date datetime,
        authority varchar(30),
        primary key (id)
    ) ENGINE=InnoDB;

    create table t_cart (
        id bigint not null,
        user_id bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table t_cart_product (
        buy_count integer,
        cart_id bigint,
        product_id bigint,
        primary key (cart_id, product_id)
    ) ENGINE=InnoDB;

    create table t_order (
        id bigint not null auto_increment,
        delevery_address varchar(255),
        order_date date,
        order_price double precision,
        order_status varchar(255),
        pay_method varchar(255),
        recipient_name varchar(30),
        recipient_tel varchar(15),
        user_id bigint,
        primary key (id)
    ) ENGINE=InnoDB;

    create table t_order_product (
        order_count integer,
        order_id bigint,
        product_id bigint,
        primary key (order_id, product_id)
    ) ENGINE=InnoDB;

    create table t_product (
        id bigint not null auto_increment,
        color varchar(255),
        desription longtext,
        image_file_name varchar(100),
        name varchar(30),
        price double precision,
        primary key (id)
    ) ENGINE=InnoDB;

    create table t_user (
        id bigint not null auto_increment,
        email varchar(100),
        mobile varchar(20),
        name varchar(30),
        password varchar(255),
        username varchar(50),
        primary key (id)
    ) ENGINE=InnoDB;

    create table t_user_authority (
        user_id bigint not null,
        authority_id bigint not null,
        primary key (user_id, authority_id)
    ) ENGINE=InnoDB;

    alter table t_cart 
        add constraint UK_8x24uj0agcrrqnt4pi49r0ixv  unique (user_id);

    alter table t_cart 
        add constraint FK_8x24uj0agcrrqnt4pi49r0ixv 
        foreign key (user_id) 
        references t_user (id);

    alter table t_cart_product 
        add constraint FK_p8xr3tl91yvfhbwajpdb3i9om 
        foreign key (cart_id) 
        references t_cart (id);

    alter table t_cart_product 
        add constraint FK_n37ri7gg0u2nvt45pa50xpvkq 
        foreign key (product_id) 
        references t_product (id);

    alter table t_order 
        add constraint FK_75ffb6s55q5aibdhqs2unu49q 
        foreign key (user_id) 
        references t_user (id);

    alter table t_order_product 
        add constraint FK_1sg939jxjmxxgg5htbnodrjgc 
        foreign key (order_id) 
        references t_order (id);

    alter table t_order_product 
        add constraint FK_8jk77c74fo7usb55302do1oeh 
        foreign key (product_id) 
        references t_product (id);

    alter table t_user_authority 
        add constraint FK_9ooafeckmhk0vd0if8oust4u1 
        foreign key (authority_id) 
        references t_authority (id);

    alter table t_user_authority 
        add constraint FK_pkm88ipfoxp80vvihh7i5bqrs 
        foreign key (user_id) 
        references t_user (id);
