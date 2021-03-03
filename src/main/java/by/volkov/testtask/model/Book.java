package by.volkov.testtask.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Book.DELETE, query = "DELETE FROM Book b WHERE b.id=:id"),
        @NamedQuery(name = Book.GET_ALL, query = "SELECT b FROM Book b"),
        @NamedQuery(name = Book.GET_ALL_BY_TITLE, query = "SELECT b FROM Book b WHERE b.title=:title"),
        @NamedQuery(name = Book.GET_ALL_BY_PUBLICATION_YEAR, query = "SELECT b FROM Book b " +
                "WHERE b.publicationYear=:publicationYear"),
        @NamedQuery(name = Book.GET_ALL_BY_PUBLISHING_HOUSE, query = "SELECT b FROM Book b " +
                "WHERE b.publishingHouse=:publishingHouse"),
        @NamedQuery(name = Book.GET_ALL_BY_AUTHOR_NAME_OR_SURNAME, query = "SELECT b FROM Book b " +
                "JOIN b.authors a WHERE a.name=:name OR a.surname=:surname"),
        @NamedQuery(name = Book.GET_ALL_BY_AUTHOR_SEX, query = "SELECT b FROM Book b " +
                "JOIN b.authors a WHERE a.sex=:sex"),
        @NamedQuery(name = Book.GET_ALL_BY_AUTHOR_BIRTHDAY, query = "SELECT b FROM Book b " +
                "JOIN b.authors a WHERE a.birthday=:birthday")
})
@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {

    public static final String DELETE = "Book.delete";
    public static final String GET_ALL = "Book.getAll";
    public static final String GET_ALL_BY_PUBLICATION_YEAR = "Book.getAllByPublicationYear";
    public static final String GET_ALL_BY_TITLE = "Book.getAllByTitle";
    public static final String GET_ALL_BY_PUBLISHING_HOUSE = "Book.getAllByPublishingHouse";
    public static final String GET_ALL_BY_AUTHOR_NAME_OR_SURNAME = "Book.getAllByAuthorNameOrSurname";
    public static final String GET_ALL_BY_AUTHOR_SEX = "Book.getAllByAuthorSex";
    public static final String GET_ALL_BY_AUTHOR_BIRTHDAY = "Book.getAllByAuthorBirthday";

    @NotNull(message = "Title is empty")
    @NotBlank(message = "Title is empty")
    private String title;

    @NotNull(message = "Date is empty")
    @Past(message = "Date should be in the past")
    private LocalDate publicationYear;

    @NotNull(message = "Name of publishing house is empty")
    @NotBlank(message = "Name of publishing house is empty")
    private String publishingHouse;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    public Book() {
    }

    public Book(Integer id, String title, LocalDate publicationYear, String publishingHouse, Set<Author> authors) {
        super(id);
        this.title = title;
        this.publicationYear = publicationYear;
        this.publishingHouse = publishingHouse;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", publicationYear=" + publicationYear +
                ", publishingHouse=" + publishingHouse +
                ", authors=" + authors +
                '}';
    }
}
