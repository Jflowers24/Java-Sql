CREATE SCHEMA IF NOT EXISTS Library;

SET search_path TO Library;

CREATE TABLE IF NOT EXISTS Members(
    MemName varchar(500),
    MemNumber varchar(500),
    MemEmail varchar(500),
    ID serial PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Books(
    author varchar(500),
    illustrator varchar(500),
    genre varchar(500),
    pagenum int,
    title varchar(500),
    member int,
    FOREIGN KEY (member) REFERENCES Members(ID)
);

SELECT * FROM Library.Members;
SELECT * FROM Library.Books;