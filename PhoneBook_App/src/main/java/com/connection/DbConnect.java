package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

    private static Connection conn;
    private static final String url="jdbc:mysql://localhost:3306/phonebook";
    private static final String user="root";
    private static final String pass="deepak123";
    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

}
