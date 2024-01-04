package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectDB {


    public Connection connect() {
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/prj_se_02", "root", "");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;

    }



}

