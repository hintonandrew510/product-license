/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ResourceBundle;

/**
 *
 * @author wtccuser
 */
public class DatabaseBundle {

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
   private static ResourceBundle resourceBundle = ResourceBundle.getBundle("data.databaseproperties");   
   private static String DATABASE;
   private static String USER;
   private static String URL;
   private static String PORT;
   private static String PASSWORD;
   private static boolean USELOCALDATABASE;
   
   public static boolean useLocalDatabase () {
       String localDatabase = resourceBundle.getString("uselocaldatabase");

       if (localDatabase != null && localDatabase.equalsIgnoreCase("true")) {
           return true;
       } else {
           return false;
       }
   }

    public static String getURL() {
        URL = resourceBundle.getString("url");
        return URL;
    }

    public static String getPORT() {
        PORT = resourceBundle.getString("port");
        return PORT;
    }

    public static String getPASSWORD() {
        PASSWORD = resourceBundle.getString("password");
        return PASSWORD;
    }

    public static String getUSER() {
        USER = resourceBundle.getString("user");
        return USER;
    }

    public static String getDATABASE() {
        DATABASE = resourceBundle.getString("database");
        return DATABASE;
    }

    
    
}
