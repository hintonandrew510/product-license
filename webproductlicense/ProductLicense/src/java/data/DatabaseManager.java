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
          private static String databaseURLTest = "jdbc:mysql://sql3.freemysqlhosting.net/sql3241442";// address
          private static String localDatabaseURL = "jdbc:derby://localhost:8989/sample";
          
          private static boolean isProduction = true;

    public static boolean isIsProduction() {
        return isProduction;
    }

    public static void setIsProduction(boolean isProduction) {
        DatabaseManager.isProduction = isProduction;
    }
    private final static Logger LOGGER = Logger.getLogger(DatabaseManager.class
            .getName());
    // to the    sql3.freemysqlhosting.net/sql3241442 qAQVzm9Uiw
    // database
    private static String driverName = "com.mysql.jdbc.Driver";
     private static String localDriverName = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws Exception {
       
        StringBuilder builder = new StringBuilder();
        Connection connection = null;
        if (isProduction) {
             java.lang.Class.forName(driverName);
             connection = DriverManager.getConnection(databaseURL,
                   "root", "OSCaki79649");
        } else {
             java.lang.Class.forName("org.apache.derby.jdbc.ClientDriver");
             connection = DriverManager.getConnection(localDatabaseURL);
        }
       
        //connection = DriverManager.getConnection(databaseURLTest,
                   // "sql3241442", "qAQVzm9Uiw");
        
       /*prod connection = DriverManager.getConnection(databaseURL,
                    "root", "OSCaki79649");
        
        
        To change payment method for the license manager application goto https://app.whelastic.net/


logon with user name =hintonandrew510@gmail.com
password = mike123
        
   phpadmin     https://node71581-env-9265129.whelastic.net/
        */
        
         
        /* test connection = DriverManager.getConnection(databaseURLTest,
                    "sql3241442", "qAQVzm9Uiw");*/
        
        //sql3.freemysqlhosting.net	sql3241442	sql3241442
        /*
        sServer: sql3.freemysqlhosting.net
        Name:    sql3241442
       Username: sql3241442
        Password: qAQVzm9Uiw
        Port number: 3306
        
        jdbc:derby://localhost:1527/sample
        */
      

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


