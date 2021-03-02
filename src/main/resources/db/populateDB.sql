DELETE FROM author_book;
DELETE FROM book;
DELETE FROM author;

ALTER SEQUENCE author_seq RESTART WITH 100000;
ALTER SEQUENCE book_seq RESTART WITH 100000;

INSERT INTO author (name, surname, birthday, sex)
VALUES ('Евгений', 'Петров', '1902-12-13', 'MALE'),
       ('Илья', 'Ильф', '1897-10-15', 'MALE'),
       ('Гузель', 'Яхина', '1977-06-01', 'FEMALE'),
       ('Вадим', 'Волков', '1988-11-29', 'MALE'),
       ('George', 'Orwell', '1903-06-25', 'MALE'),
       ('Андрей', 'Волков', '1988-11-29', 'MALE');

INSERT INTO book (title, publication_year, publishing_house)
VALUES ('Двенадцать стульев', '1928-01-01', 'Земля и фабрика'),
       ('Золотой теленок', '1931-01-01', 'Журнал "30 дней"'),
       ('Зулейха открывает глаза', '2015-01-01', 'АСТ'),
       ('Дети мои', '2018-01-01', 'АСТ'),
       ('Animal Farm', '2018-01-01', 'Harvill Secker');

INSERT INTO author_book (author_id, book_id)
VALUES (100000, 100000),
       (100000, 100001),
       (100001, 100000),
       (100001, 100001),
       (100002, 100002),
       (100002, 100003),
       (100003, null),
       (100004, 100004),
       (100005, null);


