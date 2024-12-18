package com.servlet;

import com.connection.DbConnect;
import com.dao.ContactDAO;
import com.entity.Contact;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String about=request.getParameter("about");

        Contact c=new Contact(name,email,number,about,id);
        HttpSession session2=request.getSession();
        ContactDAO dao=new ContactDAO(DbConnect.getConn());
        if (dao.saveContact(c)){

            session2.setAttribute("success","Contact saved successfully");
            response.sendRedirect("addContact.jsp");
        }else {
            session2.setAttribute("fail","Error!! Contact not saved");
            response.sendRedirect("addContact.jsp");
        }
    }
}
