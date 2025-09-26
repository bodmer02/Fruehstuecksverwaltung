CREATE TABLE product_entity
(
    id      UUID             NOT NULL,
    user_id UUID,
    name    VARCHAR(50)      NOT NULL,
    product VARCHAR(50)      NOT NULL,
    price   DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_productentity PRIMARY KEY (id)
);

CREATE TABLE the_entity
(
    id             UUID       NOT NULL,
    text_attribute VARCHAR(8) NOT NULL,
    CONSTRAINT pk_theentity PRIMARY KEY (id)
);

CREATE TABLE user_entity
(
    id   UUID        NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_userentity PRIMARY KEY (id)
);

CREATE TABLE user_entity_product_entities
(
    user_entity_id      UUID NOT NULL,
    product_entities_id UUID NOT NULL,
    CONSTRAINT pk_userentity_productentities PRIMARY KEY (user_entity_id, product_entities_id)
);

ALTER TABLE user_entity_product_entities
    ADD CONSTRAINT uc_user_entity_product_entities_productentities UNIQUE (product_entities_id);

ALTER TABLE product_entity
    ADD CONSTRAINT FK_PRODUCTENTITY_ON_USER FOREIGN KEY (user_id) REFERENCES user_entity (id);

ALTER TABLE user_entity_product_entities
    ADD CONSTRAINT fk_useentproent_on_product_entity FOREIGN KEY (product_entities_id) REFERENCES product_entity (id);

ALTER TABLE user_entity_product_entities
    ADD CONSTRAINT fk_useentproent_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);