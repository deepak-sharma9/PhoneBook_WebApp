<%@ page import="com.dao.ContactDAO" %>
<%@ page import="com.connection.DbConnect" %>
<%@ page import="com.entity.Contact" %><%--
  Created by IntelliJ IDEA.
  User: deepak sharma
  Date: 12-12-2024
  Time: 07:34 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="component/css.jsp"%>
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

<div class="container-fluid">
    <div class="row p-5">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body>">
                    <h3 class="text-center text-success">Add Contact Page</h3>
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
                    <form action="updateContact" method="post">
                        <%
                            int id=Integer.parseInt(request.getParameter("id"));
                            ContactDAO dao=new ContactDAO(DbConnect.getConn());
                            Contact c=dao.getContactById(id);
                        %>
                        <div class="form-group mx-3">
                            <input type="hidden" name="cid" value="<%=id%>">
                            <label for="name" >Enter Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" value="<%=c.getName()%>">
                        </div>

                        <div class="form-group mx-3">
                            <label for="email" >Email address</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" value="<%=c.getEmail()%>">
                        </div>

                        <div class="form-group mx-3">
                            <label for="num" >Enter Phone No</label>
                            <input type="text" class="form-control" id="num" aria-describedby="emailHelp" name="number" value="<%=c.getPhone()%>">
                        </div>

                        <div class="form-group mx-3">
                            <textarea name="about" class="form-control" placeholder="Enter About" ><%=c.getAbout()%></textarea>

                        </div>


                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Update Contact</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-top: 130px">
    <%@include file="component/footer.jsp"%>
</div>

</body>
</html>
