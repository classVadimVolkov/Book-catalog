package by.volkov.testtask.repository;

import by.volkov.testtask.model.Author;

import java.util.List;

public interface AuthorRepository {
    Author save(Author author);

    boolean delete(int id);

    Author get(int id);

    List<Author> getAll();
}
