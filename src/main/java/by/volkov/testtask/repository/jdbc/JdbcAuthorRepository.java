package by.volkov.testtask.repository.jdbc;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcAuthorRepository implements AuthorRepository {
    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Author get(int id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }
}
