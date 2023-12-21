package com.example.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/resort_management";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        catch (Exception e){
            System.out.println("bug");
        }
        return null;
    }
}
