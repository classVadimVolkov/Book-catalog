package by.volkov.testtask.model;

import java.util.Set;

public class Book extends AbstractBaseEntity {
    private String title;

    private int year;

    private String publishingHouse;

    private Set<Author> authors;

    public Book() {
    }

    public Book(Integer id, String title, int year, String publishingHouse, Set<Author> authors) {
        super(id);
        this.title = title;
        this.year = year;
        this.publishingHouse = publishingHouse;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
}
