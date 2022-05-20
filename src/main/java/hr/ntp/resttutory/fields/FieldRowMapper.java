package hr.ntp.resttutory.fields;

import hr.ntp.resttutory.users.User2;
import org.springframework.jdbc.core.RowMapper;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class FieldRowMapper implements RowMapper<Field2> {

    @Override
    public Field2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Field2 field = new Field2();
        field.setId(rs.getLong("ID"));
        field.setName(rs.getString("NAME"));

        return field;
    }
}
