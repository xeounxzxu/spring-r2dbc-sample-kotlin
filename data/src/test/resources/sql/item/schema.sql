-- item
create table item
(
    id          bigint         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255)   NOT NULL,
    type        VARBINARY(255) null,
    count       bigint         null,
    limit_count bigint         null,
    -- bigint(19)
    created_at  bigint         null,
    CONSTRAINT item_pk PRIMARY KEY (id)
);

-- item_history
create table item_history
(
    id          bigint         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255)   NOT NULL,
    type        VARBINARY(255) null,
    count       bigint         null,
    limit_count bigint         null,
    item_id     INT            not null,
    -- bigint(19)
    created_at  bigint         null,
    CONSTRAINT item_history_pk PRIMARY KEY (id),
    constraint item_history_item_null_fk
        foreign key (item_id) references item (id)
);
