package com.mycompany.mydbgui.config;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection{
private  static Connection connection = null;
private static  DbConnection instance = new DbConnection();
private DbConnection()   {
    System.out.println("Hello java Dao implementation ");
    FileReader file;
    try {
        file = new FileReader("src\\main\\resources\\datasource.properties");
        Properties properties = new Properties();
        properties.load(file);
        var userName = properties.getProperty("userName");
        var password = properties.getProperty("password");
        var driver = properties.getProperty("driver");
        var jdbcUrl = properties.getProperty("jdbcUrl");
        connection = DriverManager.getConnection(jdbcUrl, userName,password);
        System.out.println("Connection created");
    } catch (SQLException | IOException e) {
        Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE,null,e);
    }
}

public static Connection getConnection(){
    return connection;
    }

}
