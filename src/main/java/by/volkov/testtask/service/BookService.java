package by.volkov.testtask.service;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.BookRepository;
import by.volkov.testtask.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(Book book, int... authorId) {
        Assert.notNull(book, "book must not be null");
        Assert.notEmpty(Arrays.asList(authorId), "author id must not be empty");
        return repository.save(book, authorId);
    }

    public void delete(int id) {
        if (!repository.delete(id)) {
            throw new NotFoundException("Not found entity");
        }
    }

    public Book get(int id) {
        if (repository.get(id) == null) {
            throw new NotFoundException("Not found entity");
        }
        return repository.get(id);
    }

    public void update(Book book, int... authorId) {
        Assert.notNull(book, "author must not be null");
        Assert.notEmpty(Arrays.asList(authorId), "author id must not be empty");
        if (repository.save(book) == null) {
            throw new NotFoundException("Not found entity");
        }
    }

    public List<Book> getAll() {
        return repository.getAll();
    }

    public List<Book> getAllByTitle(String title) {
        Assert.notNull(title, "title must not be null");
        return repository.getAllByTitle(title);
    }

    public List<Book> getAllByPublicationYear(LocalDate publicationYear) {
        Assert.notNull(publicationYear, "publication year must not be null");
        return repository.getAllByPublicationYear(publicationYear);
    }

    public List<Book> getAllByPublishingHouse(String publishingHouse) {
        Assert.notNull(publishingHouse, "publishing house year must not be null");
        return repository.getAllByPublishingHouse(publishingHouse);
    }

    public List<Book> getAllByAuthorNameOrSurname(String name, String surname) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(surname, "surname must not be null");
        return repository.getAllByAuthorNameOrSurname(name, surname);
    }

    public List<Book> getAllByAuthorFirstLetters(String name, String surname) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(surname, "surname must not be null");
        return repository.getAllByAuthorFirstLetters(name, surname);
    }

    public List<Book> getAllByAuthorSex(SexType sex) {
        Assert.notNull(sex, "name must not be null");
        Assert.isInstanceOf(SexType.class, sex, "sex must be instance of SexType");
        return repository.getAllByAuthorSex(sex);
    }

    public List<Book> getAllByAuthorBirthday(LocalDate birthday) {
        Assert.notNull(birthday, "birthday must not be null");
        return repository.getAllByAuthorBirthday(birthday);
    }

    public List<Book> getAllFiltered(String title, LocalDate publicationYear,
                                     String publishingHouse, String authorName, String authorSurname,
                                     SexType authorSex, LocalDate authorBirthday) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(publicationYear, "publication year must not be null");
        Assert.notNull(publishingHouse, "publication year must not be null");
        Assert.notNull(authorName, "author's name must not be null");
        Assert.notNull(authorSurname, "author's surname must not be null");
        Assert.notNull(authorSex, "author's sex must not be null");
        Assert.isInstanceOf(SexType.class, authorSex, "sex must be instance of SexType");
        Assert.notNull(authorBirthday, "author's birthday must not be null");

        return repository.getAllFiltered(title, publicationYear, publishingHouse,
                authorName, authorSurname, authorSex, authorBirthday);
    }
}
