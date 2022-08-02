CREATE TABLE user (
    id                        BIGINT        NOT NULL auto_increment,
    username                  VARCHAR(255)  NOT NULL,
    password                  VARCHAR(255)  NOT NULL,
    roles                     VARCHAR(255)  NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id)
);

CREATE TABLE item (
    id                        BIGINT        NOT NULL auto_increment,
    sellable                  BOOLEAN       NOT NULL,
    item_name                 VARCHAR(255)  NOT NULL,
    description               VARCHAR(255)  NOT NULL,
    photourl                  VARCHAR(255)  NOT NULL,
    starting_price            INTEGER       NOT NULL,
    purchase_price            INTEGER       NOT NULL,
    last_offered_bid_id       BIGINT        NOT NULL,
    user_id                   BIGINT        NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id)
);

CREATE TABLE bid (
    id                        BIGINT        NOT NULL auto_increment,
    amount                    INTEGER       NOT NULL,
    creation_date             DATETIME(6)   NOT NULL,
    item_id                   BIGINT        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE item_placed_bids (
    bid_id                    BIGINT        NOT NULL,
    item_id                   BIGINT        NOT NULL
);

CREATE TABLE user_not_sold_items (
    user_id                   BIGINT        NOT NULL,
    item_id                   BIGINT        NOT NULL
);