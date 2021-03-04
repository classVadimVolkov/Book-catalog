package by.volkov.testtask.repository.jpa;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.BookRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book save(Book book, int... authorId) {
        book.setAuthors(Arrays.stream(authorId)
                .mapToObj(id -> em.getReference(Author.class, id))
                .collect(Collectors.toSet()));

        if (book.isNew()) {
            em.persist(book);
            return book;
        } else {
            return get(book.getId()) == null ? null : em.merge(book);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Book get(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return em.createNamedQuery(Book.GET_ALL, Book.class).getResultList();
    }

    @Override
    public List<Book> getAllByTitle(@Nullable String title) {
        if (title == null) {
            return getAll();
        }
        return em.createNamedQuery(Book.GET_ALL_BY_TITLE, Book.class)
                .setParameter("title", title)
                .getResultList();
    }

    @Override
    public List<Book> getAllByPublicationYear(@Nullable LocalDate publicationYear) {
        if (publicationYear == null) {
            return getAll();
        }
        return em.createNamedQuery(Book.GET_ALL_BY_PUBLICATION_YEAR, Book.class)
                .setParameter("publicationYear", publicationYear)
                .getResultList();
    }

    @Override
    public List<Book> getAllByPublishingHouse(@Nullable String publishingHouse) {
        if (publishingHouse == null) {
            return getAll();
        }
        return em.createNamedQuery(Book.GET_ALL_BY_PUBLISHING_HOUSE, Book.class)
                .setParameter("publishingHouse", publishingHouse)
                .getResultList();
    }

    @Override
    public List<Book> getAllByAuthorFirstLettersNameOrSurname(@Nullable String name, @Nullable String surname) {
        return getAll().stream()
                .filter(book -> name == null ||
                        book.getAuthors().stream().allMatch(author -> author.getName().startsWith(name)))
                .filter(book -> surname == null ||
                        book.getAuthors().stream().allMatch(author -> author.getName().startsWith(surname)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllByAuthorSex(@Nullable SexType sex) {
        if (sex == null) {
            getAll();
        }
        return em.createNamedQuery(Book.GET_ALL_BY_AUTHOR_SEX, Book.class)
                .setParameter("sex", sex)
                .getResultList();
    }

    @Override
    public List<Book> getAllByAuthorBirthday(@Nullable LocalDate birthday) {
        if (birthday == null) {
            return getAll();
        }
        return em.createNamedQuery(Book.GET_ALL_BY_AUTHOR_BIRTHDAY, Book.class)
                .setParameter("birthday", birthday)
                .getResultList();
    }

    @Override
    public List<Book> getAllFiltered(@Nullable String title, @Nullable LocalDate publicationYear,
                                     @Nullable String publishingHouse, @Nullable String authorName,
                                     @Nullable String authorSurname, @Nullable SexType authorSex,
                                     @Nullable LocalDate authorBirthday) {

        return getAll().stream()
                .filter(book -> title == null || book.getTitle().equals(title))
                .filter(book -> publicationYear == null || book.getPublicationYear().getYear() == publicationYear.getYear())
                .filter(book -> publishingHouse == null || book.getPublishingHouse().equals(publishingHouse))
                .filter(book -> authorName == null || book.getAuthors().stream().allMatch(
                        author -> author.getName().startsWith(authorName)))
                .filter(book -> authorSurname == null || book.getAuthors().stream().allMatch(
                        author -> author.getSurname().startsWith(authorSurname)))
                .filter(book -> authorBirthday == null || book.getAuthors().stream().allMatch(
                        author -> author.getBirthday().compareTo(authorBirthday) == 0))
                .collect(Collectors.toList());
    }
}
