package com.servlet;

import com.connection.DbConnect;
import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        HttpSession session=request.getSession();
        User u=new User(name,email,password);
        try {
            UserDAO dao=new UserDAO(DbConnect.getConn());
            if(dao.userRegister(u)){
                session.setAttribute("success","Registered Successfully");
                response.sendRedirect("register.jsp");
            }else {
                session.setAttribute("fail","Error, Register Unsuccessful!!");
                response.sendRedirect("register.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
