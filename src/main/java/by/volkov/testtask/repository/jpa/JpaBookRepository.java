package by.volkov.testtask.repository.jpa;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.Book;
import by.volkov.testtask.model.SexType;
import by.volkov.testtask.repository.BookRepository;
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
    public List<Book> getAllByTitle(String title) {
        return em.createNamedQuery(Book.GET_ALL_BY_TITLE, Book.class)
                .setParameter("title", title)
                .getResultList();
    }

    @Override
    public List<Book> getAllByPublicationYear(LocalDate publicationYear) {
        return em.createNamedQuery(Book.GET_ALL_BY_PUBLICATION_YEAR, Book.class)
                .setParameter("publicationYear", publicationYear)
                .getResultList();
    }

    @Override
    public List<Book> getAllByPublishingHouse(String publishingHouse) {
        return em.createNamedQuery(Book.GET_ALL_BY_PUBLISHING_HOUSE, Book.class)
                .setParameter("publishingHouse", publishingHouse)
                .getResultList();
    }

    @Override
    public List<Book> getAllByAuthorNameOrSurname(String name, String surname) {
        return em.createNamedQuery(Book.GET_ALL_BY_AUTHOR_NAME_OR_SURNAME, Book.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getResultList();
    }

    @Override
    public List<Book> getAllByAuthorFirstLetters(String name, String surname) {
        return getAll().stream()
                .filter(book -> book.getAuthors().stream().allMatch(author -> author.getName().startsWith(name)))
                .filter(book -> book.getAuthors().stream().allMatch(author -> author.getName().startsWith(surname)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllByAuthorSex(SexType sex) {
        return em.createNamedQuery(Book.GET_ALL_BY_AUTHOR_SEX, Book.class)
                .setParameter("sex", sex)
                .getResultList();
    }

    @Override
    public List<Book> getAllByAuthorBirthday(LocalDate birthday) {
        return em.createNamedQuery(Book.GET_ALL_BY_AUTHOR_BIRTHDAY, Book.class)
                .setParameter("birthday", birthday)
                .getResultList();
    }

    @Override
    public List<Book> getAllFiltered(String title, LocalDate publicationYear,
                                     String publishingHouse, String authorName, String authorSurname,
                                     SexType authorSex, LocalDate authorBirthday) {

        return getAll().stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getPublicationYear().getYear() == publicationYear.getYear())
                .filter(book -> book.getPublishingHouse().equals(publishingHouse))
                .filter(book -> book.getAuthors().stream().allMatch(
                        author -> author.getName().startsWith(authorName)))
                .filter(book -> book.getAuthors().stream().allMatch(
                        author -> author.getSurname().startsWith(authorSurname)))
                .filter(book -> book.getAuthors().stream().allMatch(
                        author -> author.getBirthday().compareTo(authorBirthday) == 0))
                .collect(Collectors.toList());
    }
}
