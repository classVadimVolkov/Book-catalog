package by.volkov.testtask.service;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.repository.AuthorRepository;
import by.volkov.testtask.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author create(Author author) {
        Assert.notNull(author, "Author must not be null");
        return repository.save(author);
    }

    public void delete(int id) {
        if (!repository.delete(id)) {
            throw new NotFoundException("Not found entity");
        }
    }

    public Author get(int id) {
        if (repository.get(id) == null) {
            throw new NotFoundException("Not found entity");
        }
        return repository.get(id);
    }

    public void update(Author author) {
        Assert.notNull(author, "Author must not be null");
        if (repository.save(author) == null) {
            throw new NotFoundException("Not found entity");
        }
    }

    public List<Author> getAll() {
        return repository.getAll();
    }
}
