package by.volkov.testtask.repository.jdbc;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcAuthorRepository implements AuthorRepository {

    private static final BeanPropertyRowMapper<Author> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Author.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert insertAuthor;

    @Autowired
    public JdbcAuthorRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertAuthor = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("authors")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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
