BEGIN;


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id   bigserial PRIMARY KEY,
    name varchar(50),
    age  int
);
INSERT INTO users (name, age)
VALUES ('Patrick', 15),
       ('Bob', 55),
       ('John', 33),
       ('Lolly', 18),
       ('Typhoon', 13),
       ('Sam', 27),
       ('Carol', 25),
       ('Fish', 30);


DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items
(
    id          bigserial PRIMARY KEY,
    productname varchar(50),
    price       int
);
INSERT INTO items (productname, price)
VALUES ('cup', 20),
       ('maul', 100),
       ('bag', 50),
       ('poop', 25);

COMMIT;