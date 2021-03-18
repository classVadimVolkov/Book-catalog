[![Codacy Badge](https://app.codacy.com/project/badge/Grade/f1d99b8a37d9467ba0ac7803086332c7)](https://www.codacy.com/gh/classVadimVolkov/Book-catalog/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=classVadimVolkov/Book-catalog&amp;utm_campaign=Badge_Grade)

Book catalog app

-----------------------------
1. Clone

git clone https://github.com/classVadimVolkov/Book-catalog.git

------------------------
2. Run Tomcat as a local server

------------------------
3. Open Postman for test

For authors:

GET http://localhost:8080/authors

GET http://localhost:8080/authors/100001

POST http://localhost:8080/authors

PUT http://localhost:8080/authors/100006

DELETE http://localhost:8080/authors/100006

For books:

GET http://localhost:8080/books

GET http://localhost:8080/books/100004

POST http://localhost:8080/authors/100003/books

PUT http://localhost:8080/authors/100003/books/100005

DELETE http://localhost:8080/authors/100003/books/100005

GET http://localhost:8080/books/getAllByTitle?title=Дети_мои

GET http://localhost:8080/books/getAllByPublicationYear?publicationYear=1931-01-01

GET http://localhost:8080/books/getAllByPublishingHouse?publishingHouse=ACT

GET http://localhost:8080/books/getAllByAuthorFirstLettersNameOrSurname?authorName=Илья&authorSurname=Ильф

GET http://localhost:8080/books/getAllByAuthorSex?sex=MALE

GET http://localhost:8080/books/getAllByAuthorBirthday?birthday=1897-10-15

GET http://localhost:8080/books/getAllFiltered
