package by.volkov.testtask.repository.jpa;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaAuthorRepository implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author save(Author author) {
        if (author.isNew()) {
            em.persist(author);
            return author;
        } else {
            return get(author.getId()) == null ? null : em.merge(author);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Author.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Author get(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return em.createNamedQuery(Author.GET_ALL_AUTHORS, Author.class).getResultList();
    }
}

