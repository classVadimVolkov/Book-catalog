package by.volkov.testtask.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {
    private String title;

    private LocalDate publicationYear;

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
