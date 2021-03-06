DROP TABLE IF EXISTS author_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP SEQUENCE IF EXISTS author_seq;
DROP SEQUENCE IF EXISTS book_seq;

CREATE SEQUENCE author_seq START WITH 100000;
CREATE SEQUENCE book_seq START WITH 100000;

CREATE TABLE author
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('author_seq'),
    name     VARCHAR                                 NOT NULL,
    surname  VARCHAR                                 NOT NULL,
    birthday DATE                                    NOT NULL,
    sex      VARCHAR             DEFAULT 'UNDEFINED' NOT NULL
);

CREATE TABLE book
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('book_seq'),
    title            VARCHAR NOT NULL,
    publication_year DATE    NOT NULL,
    publishing_house VARCHAR NOT NULL
);

CREATE TABLE author_book
(
    author_id INTEGER NOT NULL,
    book_id   INTEGER,
    UNIQUE (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);