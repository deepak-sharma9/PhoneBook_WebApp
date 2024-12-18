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

@WebServlet("/updateContact")
public class UpdateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String about=request.getParameter("about");

        Contact c=new Contact();
        c.setId(id);
        c.setName(name);
        c.setEmail(email);
        c.setPhone(number);
        c.setAbout(about);

        HttpSession session= request.getSession();
        ContactDAO dao=new ContactDAO(DbConnect.getConn());
        if (dao.updateContact(c)){
            session.setAttribute("success","Contact updated successfully");
            response.sendRedirect("viewContact.jsp");
        }else {
            session.setAttribute("fail","Error!! Contact not updated");
            response.sendRedirect("editContact.jsp");
        }
    }


}
