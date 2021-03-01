package by.volkov.testtask.repository;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;

import java.util.List;

public interface BookRepository {
    Book save(Book book, int authorId);

    boolean delete(int id, int authorId);

    Book get(int id, int authorId);

    List<Book> getAll();

    List<Book> getAllByTitle(String title);

    List<Book> getAllByYear(int year);

    List<Book> getAllByPublishingHouse(String publishingHouse);

    List<Author> getAllByAuthorNameOrSurname(String name, String surname, int authorId);

    List<Author> getAllByAuthorSex(SexType sex, int authorId);

    List<Author> getAllByAuthorBirthday(String birthday, int authorId);
}
