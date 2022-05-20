package hr.ntp.resttutory.fields;

import hr.ntp.resttutory.users.CustomRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldJdbcRepository implements FieldRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Field2> findAll() {
        return jdbcTemplate.query("SELECT * FROM FIELDS", new FieldRowMapper());
    }

    @Override
    public Field2 findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM FIELDS WHERE ID = ?",new FieldRowMapper(),id);
    }
}
