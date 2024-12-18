package com.dao;

import com.entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection conn;
    public ContactDAO(Connection conn){
        this.conn=conn;
    }
    public boolean saveContact(Contact c){
        try{
            String query="INSERT INTO contact(name,email,phone,about,userId) VALUES( ?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,c.getName());
            pst.setString(2,c.getEmail());
            pst.setString(3,c.getPhone());
            pst.setString(4,c.getAbout());
            pst.setInt(5,c.getId());
            int rowsAffected=pst.executeUpdate();
            while(rowsAffected>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Contact> getAllContact(int id){
        List<Contact> list=new ArrayList<>();
        Contact c=null;
        try {
            String query="SELECT * FROM contact WHERE userId=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                c=new Contact();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setAbout(rs.getString(5));
                list.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public Contact getContactById(int cid){
        Contact c=new Contact();
        try{
            String query="SELECT * FROM contact where id=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1,cid);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setAbout(rs.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    public boolean updateContact(Contact c){
        String query="UPDATE contact SET name=?,email=?,phone=?,about=? where id=?";
        try {
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,c.getName());
            pst.setString(2,c.getEmail());
            pst.setString(3,c.getPhone());
            pst.setString(4, c.getAbout());
            pst.setInt(5,c.getId());
            int rowsAffected=pst.executeUpdate();
            if (rowsAffected>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteContactById(int id){
        String query="DELETE FROM contact WHERE id=?";
        try {
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1,id);
            int rowsAffected=pst.executeUpdate();
            if (rowsAffected>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
