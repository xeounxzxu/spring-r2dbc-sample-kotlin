create table mileage
(
    id         bigint   NOT NULL AUTO_INCREMENT,
    user_id    bigint   NOT NULL unique,
    point      bigint   not null,
    created_at datetime null,
    updated_at datetime null,
    CONSTRAINT mileage_pk PRIMARY KEY (id)
);