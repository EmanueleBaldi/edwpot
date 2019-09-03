package country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DaoRegionCountry {
	private Connection conn;

    public DaoRegionCountry(DataSource ds) {
        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Country> getQuery(int value) {
        List<Country> results = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        String updateString = "SELECT c.country_id, c.country_name FROM countries c JOIN regions r ON (c.region_id=r.region_id) WHERE r.region_id= ?";

        try {
        	pstmt = conn.prepareStatement(updateString);
        	pstmt.setInt(1, value);
   
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                results.add(new Country(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }

}
