DROP TABLE mydata IF EXISTS;

CREATE TABLE mydata  (
    id INTEGER IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    mail VARCHAR(20),
    tel VARCHAR(20),
    age INTEGER
);