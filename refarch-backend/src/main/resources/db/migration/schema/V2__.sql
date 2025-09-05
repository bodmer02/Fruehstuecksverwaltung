CREATE TABLE breakfast_entity
(
    id      UUID             NOT NULL,
    name    VARCHAR(50)      NOT NULL,
    product VARCHAR(50)      NOT NULL,
    price   DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_breakfastentity PRIMARY KEY (id)
);

CREATE TABLE the_entity
(
    id             UUID       NOT NULL,
    text_attribute VARCHAR(8) NOT NULL,
    CONSTRAINT pk_theentity PRIMARY KEY (id)
);