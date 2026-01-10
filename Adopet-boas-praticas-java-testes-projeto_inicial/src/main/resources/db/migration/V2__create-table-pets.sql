CREATE TABLE pets
(
    id        BIGINT GENERATED ALWAYS AS IDENTITY,
    tipo      VARCHAR(100)  NOT NULL,
    nome      VARCHAR(100)  NOT NULL,
    raca      VARCHAR(100)  NOT NULL,
    idade     INT           NOT NULL,
    cor       VARCHAR(100)  NOT NULL,
    peso      NUMERIC(4, 2) NOT NULL,
    abrigo_id BIGINT        NOT NULL,
    adotado   BOOLEAN       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_pets_abrigo
        FOREIGN KEY (abrigo_id)
            REFERENCES abrigos (id)
);
