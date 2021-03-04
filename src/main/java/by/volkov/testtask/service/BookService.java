package by.volkov.testtask.service;

import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.BookRepository;
import by.volkov.testtask.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(Book book, int... authorId) {
        Assert.notNull(book, "book must not be null");
        Assert.notEmpty(Arrays.stream(authorId).boxed().collect(Collectors.toList()),
                "author id must not be empty");
        return repository.save(book, authorId);
    }

    public void delete(int id) {
        if (!repository.delete(id)) throw new NotFoundException("Not found entity");
    }

    public Book get(int id) {
        if (repository.get(id) == null) {
            throw new NotFoundException("Not found entity");
        }
        return repository.get(id);
    }

    public void update(Book book, int... authorId) {
        Assert.notNull(book, "author must not be null");
        Assert.notEmpty(Arrays.stream(authorId).boxed().collect(Collectors.toList()),
                "author id must not be empty");
        if (repository.save(book) == null) {
            throw new NotFoundException("Not found entity");
        }
    }

    public List<Book> getAll() {
        return repository.getAll();
    }

    public List<Book> getAllByTitle(@Nullable String title) {
        return repository.getAllByTitle(title);
    }

    public List<Book> getAllByPublicationYear(@Nullable LocalDate publicationYear) {
        return repository.getAllByPublicationYear(publicationYear);
    }

    public List<Book> getAllByPublishingHouse(@Nullable String publishingHouse) {
        return repository.getAllByPublishingHouse(publishingHouse);
    }

    public List<Book> getAllByAuthorFirstLettersNameOrSurname(@Nullable String name, @Nullable String surname) {
        return repository.getAllByAuthorFirstLettersNameOrSurname(name, surname);
    }

    public List<Book> getAllByAuthorSex(@Nullable SexType sex) {
        return repository.getAllByAuthorSex(sex);
    }

    public List<Book> getAllByAuthorBirthday(@Nullable LocalDate birthday) {
        return repository.getAllByAuthorBirthday(birthday);
    }

    public List<Book> getAllFiltered(@Nullable String title, @Nullable LocalDate publicationYear,
                                     @Nullable String publishingHouse, @Nullable String authorName,
                                     @Nullable String authorSurname, @Nullable SexType authorSex,
                                     @Nullable LocalDate authorBirthday) {

        return repository.getAllFiltered(title, publicationYear, publishingHouse,
                authorName, authorSurname, authorSex, authorBirthday);
    }
}
