package com.servlet;

import com.connection.DbConnect;
import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String email=request.getParameter("email");
        String pass=request.getParameter("password");

        System.out.println(email);
        System.out.println(pass);

        HttpSession session=request.getSession();
        UserDAO dao=new UserDAO(DbConnect.getConn());
        User u=dao.LoginUser(email,pass);
        if (u!=null){
            session.setAttribute("user",u);
            response.sendRedirect("index.jsp");
        }else {
            session.setAttribute("fail","Invalid Email & Password");
            response.sendRedirect("login.jsp");
        }

    }



}
