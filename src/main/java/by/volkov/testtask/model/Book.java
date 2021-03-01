package by.volkov.testtask.model;

public class Book extends AbstractBaseEntity {
    private String title;

    private int year;

    private Author author;

    private String publishingHouse;

    public Book() {
    }

    public Book(Integer id, String title, int year, Author author, String publishingHouse) {
        super(id);
        this.title = title;
        this.year = year;
        this.author = author;
        this.publishingHouse = publishingHouse;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
