package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DatabaseManager {

	  private static String databaseURL = "jdbc:mysql://node71581-env-9265129.whelastic.net/license";// address
          private static String databaseURLTest = "jdbc:mysql://sql3.freemysqlhosting.net/sql3241442";// address
          private static String localDatabaseURL = "jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
	
          private static String embeddedURL="jdbc:derby:sample";
          private static boolean isProduction = true;

    public static boolean isIsProduction() {
        return isProduction;
    }

    public static void setIsProduction(boolean isProduction) {
        DatabaseManager.isProduction = isProduction;
    }
    private final static Logger LOGGER = Logger.getLogger(DatabaseManager.class
            .getName());
    
    private static String driverName = "com.mysql.jdbc.Driver";
     private static String localDriverName = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws Exception {
       
        StringBuilder builder = new StringBuilder();
        Connection connection = null;
        if (isProduction) {
             java.lang.Class.forName(driverName);
           
             connection = DriverManager.getConnection(localDatabaseURL,
                   "license", "AVNS_mOUXndVvrMMxFzVCCPH");
        } 
       
        return connection;
    }
    
    public static void main(String args[]) {
        isProduction = false;
              try {
                  getConnection();
              } catch (Exception ex) {
                  Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
              }
        
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


