package by.volkov.testtask.repository;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository {
    Book save(Book book, int... authorId);

    boolean delete(int id);

    Book get(int id);

    List<Book> getAll();

    List<Book> getAllByTitle(String title);

    List<Book> getAllByPublicationYear(LocalDate publicationYear);

    List<Book> getAllByPublishingHouse(String publishingHouse);

    List<Book> getAllByAuthorFirstLettersNameOrSurname(String name, String surname);

    List<Book> getAllByAuthorSex(SexType sex);

    List<Book> getAllByAuthorBirthday(LocalDate birthday);

    List<Book> getAllFiltered(String title, LocalDate publicationYear, String publishingHouse,
                              String name, String surname, SexType sex, LocalDate birthday);
}
