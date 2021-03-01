package by.volkov.testtask.model;

import java.time.LocalDate;

public class Author extends AbstractBaseEntity {
    private String name;

    private String surname;

    private LocalDate birthday;

    private SexType sex;

    public Author() {
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
}
