package by.volkov.testtask.model;

import java.time.LocalDate;
import java.util.Set;

public class Author extends AbstractBaseEntity {
    private String name;

    private String surname;

    private LocalDate birthday;

    private SexType sex;

    private Set<Book> books;

    public Author() {
    }

    public Author(Integer id, String name, String surname, LocalDate birthday, SexType sex, Set<Book> books) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
