package hr.ntp.resttutory.users;

import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class CustomRowMapper implements RowMapper<User2> {
    @Override
    public User2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        User2 user = new User2();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("FIRSTNAME"));
        user.setLastName(rs.getString("LASTNAME"));
        user.setUsername(rs.getString("USERNAME"));
        user.setEmail(rs.getString("EMAIL"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setDateOfBirth(rs.getDate("BIRTH"));
        try {
            user.setProfilePicture(Base64.getEncoder()
                    .encodeToString(rs.getBlob("PROFILE_PIC").getBinaryStream().readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setContact(rs.getString("CONTACT"));

        return user;
    }
}
