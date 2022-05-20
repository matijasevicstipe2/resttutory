package hr.ntp.resttutory.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.Date;
import java.util.List;

@Repository
public class UserJdbcRepository implements UserRepository {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) throws IOException {
        Date dateOfBirth = Date.valueOf(user.getDateOfBirth());
        InputStream is = new FileInputStream(user.getProfilePictureFilePath());

        return jdbcTemplate.update("INSERT INTO USERS(FIRSTNAME,LASTNAME,USERNAME,EMAIL,PASSWORD,BIRTH,PROFILE_PIC,CONTACT) VALUES(?,?,?,?,?,?,?,?)",
                user.getName(),user.getLastName(),user.getUsername(),user.getEmail(),
                user.getPassword(),dateOfBirth,is.readAllBytes(),user.getContact());
    }

    @Override
    public List<User2> findAll() {
        return jdbcTemplate.query("SELECT * FROM USERS", new CustomRowMapper());
    }

    @Override
    public User2 findById(Long id) {
        try {
            User2 user = jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID=?",
                    new CustomRowMapper(), id);
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }


}
