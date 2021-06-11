CREATE TABLE public.persons
(
    id        serial PRIMARY KEY,
    code      VARCHAR(50) UNIQUE NOT NULL,
    firstname VARCHAR(255)       NOT NULL,
    lastname  VARCHAR(255)       NOT NULL
);