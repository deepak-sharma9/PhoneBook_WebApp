package com.servlet;

import com.connection.DbConnect;
import com.dao.ContactDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteContact")
public class DeleteContactServlet extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{

        HttpSession session= request.getSession();
        int id=Integer.parseInt(request.getParameter("id"));
        ContactDAO dao=new ContactDAO(DbConnect.getConn());
        if (dao.deleteContactById(id)){
            session.setAttribute("success","Contact deleted successfully");
            response.sendRedirect("viewContact.jsp");
        }else {
            session.setAttribute("fail","Error!! Contact not deleted");
            response.sendRedirect("viewContact.jsp");
        }
    }
}
