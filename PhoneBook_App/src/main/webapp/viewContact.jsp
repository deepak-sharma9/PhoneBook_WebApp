<%@ page import="com.entity.Contact" %>
<%@ page import="com.dao.ContactDAO" %>
<%@ page import="com.connection.DbConnect" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: deepak sharma
  Date: 11-12-2024
  Time: 10:33 am

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="component/css.jsp"%>

    <style type="text/css">
        .crd-ho{
            background-color: #f7f7f7;
        }
    </style>

</head>
<body>
<%@include file="component/navbar.jsp"%>

<%
    if(user==null){
        session.setAttribute("fail","Login Please..");
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%
    String failMessage=(String) session.getAttribute("fail");
    if (failMessage!=null){
%>
<p class="text-danger text-center"><%=failMessage%></p>
<% session.removeAttribute("fail");
}
%>

<%
    String successMessage=(String) session.getAttribute("success");
    if (successMessage!=null){
%>
<p class="text-success text-center"><%=successMessage%></p>
<% session.removeAttribute("success");
}
%>
<div class="container">
    <div class="row p-2">

            <%
                if (user!=null){
                    ContactDAO dao=new ContactDAO(DbConnect.getConn());
                    List<Contact> contact=dao.getAllContact(user.getId());
                    for (Contact c:contact){
            %>
        <div class="col-md-3.5 p-1">
            <div class="card crd-ho">
                <div class="card-body">
                    <h6><b>Name:</b> <%=c.getName()%></h6>
                    <p><b>PhoneNo:</b> <%=c.getPhone()%></p>
                    <p><b>Email:</b>  <%=c.getEmail()%></p>
                    <p><b>About:</b> <%=c.getAbout()%></p>
                    <div class="text-center">
                        <a href="editContact.jsp?id=<%=c.getId()%>" class="btn btn-success btn-sm text-white">Edit</a>
                        <a href="deleteContact?id=<%=c.getId()%>" class="btn btn-danger btn-sm text-white">Remove</a>
                    </div>
                </div>
            </div>
        </div>
            <%
                     }
                }
            %>

    </div>
</div>

</body>
</html>
