/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productlcense.databaseconversion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andrewhinton
 */
public class DatabaseTester {

    public static void main(String args[]) throws Exception {
        System.out.println("start conversion");
        //load drivers
        Driver mySqlDriver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(mySqlDriver);

        Driver hsqldbDriver = new org.hsqldb.jdbc.JDBCDriver();
        DriverManager.registerDriver(hsqldbDriver);
     //   Class.forName("com.mysql.cj.jdbc.Driver");
      //  Class.forName("com.mysql.jdbc.Driver");

        System.out.println("drivers loaded");
        Connection mysqlconnection = null;
        Connection hsqldbConnection = null;

        // below two lines are used for connectivity.
        //  Class.forName("com.mysql.cj.jdbc.Driver");
        // connection = DriverManager.getConnection(
        //"jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false",
        //"license", "AVNS_mOUXndVvrMMxFzVCCPH");
          // String url = "jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
        String url = "jdbc:mysql://db-mysql-nyc1-75629-jun-andrew-do-user-13210603-0.m.db.ondigitalocean.com:25060/license?useSSL=false";

// String url = "jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?useSSL=false";
        //
        //   String url ="jdbc:mysql://db-mysql-nyc1-75629-do-user-13210603-0.b.db.ondigitalocean.com:25060/license?user=license&password=AVNS_mOUXndVvrMMxFzVCCPH";
        //  mysqlconnection = DriverManager.getConnection(url, "license", "AVNS_mOUXndVvrMMxFzVCCPH");
        //System.out.println("mysql connected");
        //  mysqlconnection.close();
        // System.out.println("close mysql connected");
        // Class.forName("org.hsqldb.jdbc.JDBCDriver");
        // System.out.println("com.mysql.jdbc.Driverdriver");
        String hsqldbURL = "jdbc:hsqldb:file:/opt/wizard/database/db/license;ifexists=true;hsqldb.lock_file=false;hsqldb.sqllog=3";
        System.out.println("try to connect to mysql");
        mysqlconnection = DriverManager.getConnection(url, "license", "AVNS_mOUXndVvrMMxFzVCCPH");
        System.out.println("mysql connected");
        mysqlconnection.close();
        ///   Driver registeredDriver = new org.hsqldb.jdbc.JDBCDriver();
      //  DriverManager.registerDriver(registeredDriver);
        System.out.println("try to connect to hsqldbConnection");
        hsqldbConnection = DriverManager.getConnection(hsqldbURL, "SA", "");
        System.out.println("hsqldbConnection connected");
        // hsqldbConnection.close();

    }
}
