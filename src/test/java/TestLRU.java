import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yzhao on 7/18/16.
 */
public class TestLRU extends TestCase {
    // assigning the values
    protected void setUp(){

    }

    private void jdbcSolution() {

        // JDBC driver name and database URL
         String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/geoip";

        //  Database credentials
        String USER = "om";
        String PASS = "N3wQA3ra.";
        int mb = 1024 * 1024;


        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            long lStartTime = System.currentTimeMillis();
            long lEndTime = System.currentTimeMillis();

            long difference = lEndTime - lStartTime;

            System.out.println("Elapsed time:" + difference + "ms");


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }
}
