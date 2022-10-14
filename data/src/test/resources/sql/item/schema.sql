create table item
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    type        VARBINARY(255) null,
    count       bigint null,
    limit_count bigint null,
    -- bigint(19)
    created_at  bigint null,
    CONSTRAINT item_pk PRIMARY KEY (id)
);
