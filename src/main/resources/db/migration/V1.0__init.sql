CREATE TABLE tt_recipes
(
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    title VARCHAR NOT NULL,
    ingredients TEXT NOT NULL,
    instructions TEXT NOT NULL,
    difficulty VARCHAR NOT NULL,
    category VARCHAR NOT NULL,
    PRIMARY KEY (id)
);