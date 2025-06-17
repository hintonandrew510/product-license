/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productlcense.databaseconversion;


import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

public class DatabaseConverter {
private static String formateDate(java.sql.Date dateSQL) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
   String test =  sdf.format(dateSQL);
    
    //TIMESTAMP'2017-09-07 00:00:00.000000
   // 1/25/23, 12:00 AM;
    return test;
}
    public static void main(String args[]) {
        System.out.println("start conversion");

        Connection mysqlconnection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("com.mysql.cj.jdbc.Driver");
            // connection = DriverManager.getConnection(
            //"jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false",
            //"license", "AVNS_mOUXndVvrMMxFzVCCPH");

           // String url = "jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
             String url = "jdbc:mysql://db-mysql-nyc1-75629-jun-andrew-do-user-13210603-0.m.db.ondigitalocean.com:25060/license?useSSL=false";
            
// String url = "jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
           //
            //   String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?user=license&password=AVNS_mOUXndVvrMMxFzVCCPH";
            /*   VARCHAR(250) not null,
 
 

   datetime DEFAULT NULL,
   datetime NOT NULL,
  timestamp DEFAULT NULL,
  datetime NOT NULL,
   varchar(250) NOT NULL,
   tinyint DEFAULT NULL,
   varchar(45) NOT NULL,
varchar(250) NOT NULL,
  city varchar(250) NOT NULL,
   varchar(250) NOT NULL,
   varchar(250) NOT NULL,
   varchar(250) DEFAULT NULL,
   varchar(50) NOT NULL,
             */
            mysqlconnection = DriverManager.getConnection(url, "license", "AVNS_mOUXndVvrMMxFzVCCPH");

           // Class.forName("org.hsqldb.jdbc.JDBCDriver");
           // System.out.println("com.mysql.jdbc.Driverdriver");
            String hsqldbURL = "jdbc:hsqldb:file:/opt/wizard/database/db/license;ifexists=true;hsqldb.lock_file=false;hsqldb.sqllog=3";
            Driver registeredDriver = new org.hsqldb.jdbc.JDBCDriver();
            DriverManager.registerDriver(registeredDriver);
            Connection hsqldbConnection = DriverManager.getConnection(hsqldbURL, "SA", "");
            Statement hsqldbstmt = hsqldbConnection.createStatement();

            StringBuilder contactbuilder = new StringBuilder();
            contactbuilder.append("INSERT INTO contact ("
                    + "contact_id"
                    + ", name, "
                    + "uuid, "
                    + "license, "
                    + "general_information"
                    + ", phone, "
                    + "address, "
                    + "streetaddress, "
                    + "city, "
                    + "state, "
                    + "zipcode,"
                    + " emailaddress, "
                    + "password,"
                    + " client_type"
                    + ", usage_date, "
                    + "created_date, "
                    + "start_date,"
                    + " end_date,"
                    + " active) ");
            contactbuilder.append(" VALUES ");
            contactbuilder.append("("
                    + "?, "
                    + "?,"
                    + " ?, "
                    + "?, "
                    + "? ,"
                    + " ?,"
                    + " ?,"
                    + " ?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, ?)");

            System.out.println("connected");
            String QUERY = "SELECT * from contact";
            Statement stmt = mysqlconnection.createStatement();
            //delete data
            // String sql = "delete from contact where contact_id > 0";
            //PreparedStatement p = null;
            //p = mysqlconnection.prepareStatement(sql);
            //p.execute();
            // System.out.println("deleted");

            
            
            //insert statement
           String insertStringCol = " INSERT INTO contact (contact_id, "
                   + "name, "
                   + "uuid, "
                   + "license, "
                   + "general_information, "
                   + "phone, "
                   + "address, "
                   + "streetaddress, "
                   + "city, "
                   + "state, "
                   + "zipcode, "
                   + "emailaddress, "
                   + "password, "
                   + "client_type, "
                   + "usage_date, "
                   + "created_date, "
                   + "start_date, "
                   + "end_date, "
                   + "active)";
           
              String instertStringValues = " VALUES ({0} , ''{1}'' , ''{2}'' , ''{3}'' , ''{4}''  "
                      + ", ''{5}'' , ''{6}'' , ''{7}'' , ''{8}'' , ''{9}'' , ''{10}'' , ''{11}'' , ''{12}'' , ''{13}'' , 'TIMESTAMP' ''{14}'' ,"
                      + " 'TIMESTAMP' ''{15}'' , 'TIMESTAMP' ''{16}'' , 'TIMESTAMP' ''{17}'' , {18} )";
           
           
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                //Display values
                int id = rs.getInt("contact_id");
               
                String name = rs.getString("name");
                String uuid = rs.getString("uuid");
                String license = rs.getString("license");
                String generalinformation = rs.getString("general_information");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String streetaddress = rs.getString("streetaddress");
                String city = rs.getString("city");

                String state = rs.getString("state");
                String zipcode = rs.getString("zipcode");
                String emailaddress = rs.getString("emailaddress");
                String password = rs.getString("password");
                String client_type = rs.getString("client_type");

                 java.sql.Date usage_date = rs.getDate("usage_date");
                java.sql.Date created_date = rs.getDate("created_date");
                java.sql.Date start_date = rs.getDate("start_date");
                java.sql.Date end_date = rs.getDate("end_date");
                Boolean active = rs.getBoolean("active");
                
                int activeInt = active ? 1:0;
                String createDateStr = formateDate(created_date);
                String usagedateDateStr = formateDate(usage_date);
                String startdateStr = formateDate(start_date);
                String enddateStr = formateDate(end_date);
                
                String message = MessageFormat.format(instertStringValues,
                    id //0
                   , name //1     
                   ,uuid //2
                   ,license //3
                   ,generalinformation//4
                   ,phone //5
                   ,address//6
                   ,streetaddress//7
                   ,city//8
                   ,state//9
                   ,zipcode//10
                   ,emailaddress//11
                   ,password//12
                   ,client_type//13
                   ,usagedateDateStr
                   ,createDateStr
                   ,startdateStr
                   ,enddateStr //17
                   ,activeInt);

                
                String finalStatement = insertStringCol + message;
                
              //  hsqldbstmt.executeUpdate(finalStatement);
                System.out.println(finalStatement);
              
                 //
//                PreparedStatement preparedStatement = hsqldbConnection.prepareStatement(contactbuilder.toString());
//                preparedStatement.setInt(1, id);
//                preparedStatement.setString(2, name);
//                preparedStatement.setString(3, uuid);
//                preparedStatement.setString(4, license);
//                preparedStatement.setString(5, generalinformation);
//                preparedStatement.setString(6, phone);
//                preparedStatement.setString(7, address);
//                preparedStatement.setString(8, streetaddress);
//                preparedStatement.setString(9, city);
//                preparedStatement.setString(10, state);
//
//                preparedStatement.setString(11, zipcode);
//                preparedStatement.setString(12, emailaddress);
//                preparedStatement.setString(13, password);
//                preparedStatement.setString(14, client_type);
//
//                preparedStatement.setDate(15, usage_date);
//                preparedStatement.setDate(16, created_date);
//                preparedStatement.setDate(17, start_date);
//                preparedStatement.setDate(18, end_date);
//                preparedStatement.setBoolean(19, active);
//                System.out.println(preparedStatement.toString());
//            // System.out.println(((JDBC4PreparedStatement)preparedStatement).asSql());
;
              //  preparedStatement.executeUpdate();
               // System.out.println("data inserted");

            }

            //jdbc:hsqldb:file:/Users/andrewhinton/Documents/GitHub/wizardfrontendToday//db/license;ifexists=true
            mysqlconnection.close();

            hsqldbConnection.close();

        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

}
