package hr.ntp.resttutory.locations;

import hr.ntp.resttutory.fields.Field2;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location2> {
    @Override
    public Location2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location2 location = new Location2();
        location.setId(rs.getLong("ID"));
        location.setName(rs.getString("NAME"));

        return location;
    }
}
