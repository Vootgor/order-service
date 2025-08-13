CREATE TABLE orders
(
    id              UUID            PRIMARY KEY,
    user_id         UUID            NOT NULL,
    created         TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated         TIMESTAMPTZ,
    order_status          TEXT            NOT NULL,
    total_amount    NUMERIC(10,2)   NOT NULL
);

CREATE TABLE order_items (
    id          UUID            PRIMARY KEY,
    order_id    UUID            NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    product_id  UUID            NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    price       NUMERIC(10,2)   NOT NULL,
    quantity    INTEGER         NOT NULL
);