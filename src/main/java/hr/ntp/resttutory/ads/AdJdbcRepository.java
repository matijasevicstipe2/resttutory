package hr.ntp.resttutory.ads;

import hr.ntp.resttutory.users.CustomRowMapper;
import hr.ntp.resttutory.users.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdJdbcRepository implements AdRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Ad ad) {

        String[] arrayString = ad.getUser().split("&");
        String userEmail = arrayString[0];
        String userPass = arrayString[1];

        User2 user = findByCredentials(userEmail,userPass);
        Date date = Date.valueOf(LocalDate.now());
        Long price = Long.valueOf(ad.getPrice());
        Long locationId = Long.valueOf(ad.getLocation());
        Long fieldId = Long.valueOf(ad.getField());
        return jdbcTemplate.update("INSERT INTO ADS_SUPPLY(TITLE,INFO,PRICE,PUBLISHED,LOCATION_ID,FIELD_ID,USER_ID) VALUES(?,?,?,?,?,?,?)",
                ad.getTitle(),ad.getInfo(),price,date,locationId,fieldId,user.getId());
    }

    @Override
    public void saveDemand(AdDemand adDemand) {
        //user
        String[] arrayString = adDemand.getUser().split("&");
        String userEmail = arrayString[0];
        String userPass = arrayString[1];
        User2 user = findByCredentials(userEmail,userPass);
        //delete
        jdbcTemplate.update("DELETE FROM ADS_DEMAND WHERE USER_ID = ?",user.getId());
        //location
        Long locationId = findUserLocation(adDemand.getLocation());
        //fields
        List<Long> fieldsIds = findUserFields(adDemand.getFields());
        for(Long id : fieldsIds){
            jdbcTemplate.update("INSERT INTO ADS_DEMAND(USER_ID,LOCATION_ID,FIELD_ID) VALUES (?,?,?)",
                    user.getId(),locationId,id);
        }

    }

    @Override
    public List<Ad2> findAll() {
        return jdbcTemplate.query("SELECT * from ADS_SUPPLY",new AdRowMapper());
    }

    @Override
    public List<Ad2> findAllCriteria(Long user) {
        return jdbcTemplate.query("SELECT * FROM ADS_DEMAND JOIN ADS_SUPPLY " +
                "ON ADS_SUPPLY.FIELD_ID = ADS_DEMAND.FIELD_ID WHERE " +
                "ADS_DEMAND.LOCATION_ID = ADS_SUPPLY.LOCATION_ID " +
                "AND ADS_DEMAND.USER_ID = ?",new AdRowMapper(),user);
    }

    @Override
    public List<Ad2> findUserAds(Long user) {
        return jdbcTemplate.query("SELECT * FROM ADS_SUPPLY WHERE USER_ID = ?",new AdRowMapper(),user);
    }

    public User2 findByCredentials(String userEmail, String userPass) {
        try {

            User2 user = jdbcTemplate.queryForObject("SELECT * FROM" +
                    " USERS where EMAIL = ? and PASSWORD = ?",new CustomRowMapper(),userEmail,userPass);
            return user;
        } catch (IncorrectResultSizeDataAccessException e) {

            return null;
        }
    }
    public Long findUserLocation(String location){
        Long id = jdbcTemplate.queryForObject("Select ID from LOCATIONS where NAME = ?",Long.class,location);
        return id;
    }

    public List<Long> findUserFields(List<String> fields){
        List<Long> ids = new ArrayList<>();
        for(String field : fields){
            Long id = jdbcTemplate.queryForObject("Select ID from FIELDS where NAME = ?",Long.class,field);
            ids.add(id);
        }
        return ids;
    }
}
