package hr.ntp.resttutory.ads;

import hr.ntp.resttutory.ads.Ad2;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdRowMapper implements RowMapper<Ad2> {
    @Override
    public Ad2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ad2 ad = new Ad2();
        ad.setId(rs.getLong("ID"));
        ad.setTitle(rs.getString("TITLE"));
        ad.setInfo(rs.getString("INFO"));
        ad.setPrice(rs.getLong("PRICE"));
        ad.setPublished(rs.getDate("PUBLISHED"));
        ad.setLocationId(rs.getLong("LOCATION_ID"));
        ad.setFieldId(rs.getLong("FIELD_ID"));
        ad.setUserId(rs.getLong("USER_ID"));
        return ad;
    }
}
