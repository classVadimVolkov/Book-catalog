package by.volkov.testtask.repository.jdbc;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository {
    @Override
    public Book save(Book book, int authorId) {
        return null;
    }

    @Override
    public boolean delete(int id, int authorId) {
        return false;
    }

    @Override
    public Book get(int id, int authorId) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> getAllByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> getAllByYear(int year) {
        return null;
    }

    @Override
    public List<Book> getAllByPublishingHouse(String publishingHouse) {
        return null;
    }

    @Override
    public List<Author> getAllByAuthorNameOrSurname(String name, String surname, int authorId) {
        return null;
    }

    @Override
    public List<Author> getAllByAuthorSex(SexType sex, int authorId) {
        return null;
    }

    @Override
    public List<Author> getAllByAuthorBirthday(String birthday, int authorId) {
        return null;
    }
}
