package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection conn;
    public UserDAO(Connection conn){
        this.conn=conn;
    }

    public boolean userRegister(User u){
        try{
            String query="INSERT INTO user(name,email,password) VALUES(?,?,?)";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,u.getName());
            pst.setString(2,u.getEmail());
            pst.setString(3,u.getPassword());
            int rowsAffected=pst.executeUpdate();
            if(rowsAffected>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
       return false;
    }

    public User LoginUser(String email,String password){
        User user=new User();
        try {
            String query="SELECT * FROM user WHERE email=? and password=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,email);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

}
