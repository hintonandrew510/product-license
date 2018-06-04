package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



public class DatabaseManager {
/*
    Host: node71581-env-9265129.whelastic.net 
Login: root 
Password: OSCaki79649 
Database: (create it using phpMyAdmin above)
    */
    // jbossewsalex
	  private static String databaseURL = "jdbc:mysql://node71581-env-9265129.whelastic.net/license";// address
    private final static Logger LOGGER = Logger.getLogger(DatabaseManager.class
            .getName());
    // to the
    // database
    private static String driverName = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws Exception {
        java.lang.Class.forName(driverName);
        StringBuilder builder = new StringBuilder();
        Connection connection = null;
        connection = DriverManager.getConnection(databaseURL,
                    "root", "OSCaki79649");
      

        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


