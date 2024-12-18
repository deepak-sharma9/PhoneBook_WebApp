package com.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session=request.getSession();
        session.removeAttribute("user");

        HttpSession session2=request.getSession();
        session2.setAttribute("logout","Logout Successfully..");
        response.sendRedirect("login.jsp");
    }
}
