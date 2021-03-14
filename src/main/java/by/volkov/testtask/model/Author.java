package by.volkov.testtask.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Author.DELETE, query = "DELETE FROM Author a WHERE a.id=:id"),
        @NamedQuery(name = Author.GET_ALL, query = "SELECT a FROM Author a")
})
@Entity
@Table(name = "author")
public class Author extends AbstractBaseEntity {

    public static final String DELETE = "Author.delete";
    public static final String GET_ALL = "Author.getAll";

    @Column(name = "name")
    @NotNull(message = "Name is empty")
    @NotBlank(message = "Name is empty")
    private String name;

    @Column(name = "surname")
    @NotNull(message = "Surname is empty")
    @NotBlank(message = "Surname is empty")
    private String surname;

    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotNull(message = "Date is empty")
    @Past(message = "Date should be in the past")
    private LocalDate birthday;

    @Column(name = "sex")
    @NotNull(message = "Sex is empty")
    @Enumerated(EnumType.STRING)
    private SexType sex;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
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

    public Author(Integer id, String name, String surname, LocalDate birthday, SexType sex) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", books=" + books +
                '}';
    }
}
