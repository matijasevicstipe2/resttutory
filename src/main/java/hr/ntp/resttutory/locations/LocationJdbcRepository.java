package hr.ntp.resttutory.locations;

import hr.ntp.resttutory.fields.Field2;
import hr.ntp.resttutory.fields.FieldRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationJdbcRepository implements LocationRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Location2> findAll() {
        return jdbcTemplate.query("SELECT * FROM LOCATIONS", new LocationRowMapper());
    }

    @Override
    public Location2 findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM LOCATIONS WHERE ID = ?",new LocationRowMapper(),id);
    }
}
