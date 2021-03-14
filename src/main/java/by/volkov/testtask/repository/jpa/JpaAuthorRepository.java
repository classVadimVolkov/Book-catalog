package by.volkov.testtask.repository.jpa;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.model.Book;
import by.volkov.testtask.repository.AuthorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaAuthorRepository implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Author save(Author author) {
        if (author.isNew()) {
            em.persist(author);
            return author;
        } else {
            return get(author.getId()) == null ? null : em.merge(author);
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        Author author = em.find(Author.class, id);
        for (Book book : author.getBooks()) {
            if (book.getAuthors().size() == 1) {
                em.remove(book);
            } else {
                book.getAuthors().remove(author);
            }
        }
        return em.createNamedQuery(Author.DELETE, Author.class)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Author get(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public List<Author> getAll() {
        return em.createNamedQuery(Author.GET_ALL, Author.class).getResultList();
    }
}

