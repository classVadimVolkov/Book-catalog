package by.volkov.testtask.repository.jdbc;

import by.volkov.testtask.model.Author;
import by.volkov.testtask.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
                .withTableName("author")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Author save(Author author) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", author.getName())
                .addValue("surname", author.getSurname())
                .addValue("birthday", author.getBirthday())
                .addValue("sex", author.getSex().toString());

        if (author.isNew()) {
            Number newId = insertAuthor.executeAndReturnKey(parameterSource);
            author.setId(newId.intValue());
        } else if (namedParameterJdbcTemplate.update("UPDATE author SET name=:name, surname=:surname, " +
                        "birthday=:birthday, sex=:sex WHERE id=:id",
                parameterSource.addValue("id", author.getId())) == 0) {
            return null;
        }
        return author;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM author WHERE id=?", id) != 0;
    }

    @Override
    public Author get(int id) {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM author WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(authors);
    }

    @Override
    public List<Author> getAll() {
        return jdbcTemplate.query("SELECT * FROM author", ROW_MAPPER);
    }
}
