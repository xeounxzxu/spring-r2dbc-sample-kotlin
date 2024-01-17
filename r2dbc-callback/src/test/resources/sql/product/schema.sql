create table product
(
    id         bigint        NOT NULL AUTO_INCREMENT,
    title      varchar2(500) NOT NULL unique,
    sale_point bigint        not null,
    created_at timestamp     not null,
    updated_at timestamp     not null,
    CONSTRAINT product_pk PRIMARY KEY (id)
);