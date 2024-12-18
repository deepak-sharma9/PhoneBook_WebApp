<%--
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
</head>
<body style="background-color: #f0f1f2; ">
<%@include file="component/navbar.jsp"%>

<div class="container-fluid">
    <div class="row p-5">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body>">
                    <h4 class="text-center text-success">Registration Page</h4>

                    <%
                        String successMessage=(String) session.getAttribute("success");
                        if(successMessage!=null){
                            %>
                    <p class="text-success text-center"><%=successMessage%></p>
                    <%session.removeAttribute("success");
                        }
                        String failMessage=(String) session.getAttribute("fail");
                        if (failMessage!=null){
                            %>
                    <p class="text-danger text-center"><%=failMessage%></p>
                    <% session.removeAttribute("fail");
                        }
                    %>


                    <form action="register" method="post">

                        <div class="form-group mx-3">
                            <label for="name" >Enter Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
                        </div>

                        <div class="form-group mx-3">
                            <label for="email" >Email address</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                        </div>

                        <div class="form-group mx-3">
                            <label for="pass" >Password</label>
                            <input type="password" class="form-control" id="pass" aria-describedby="emailHelp" name="password">
                        </div>


                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-top: 120px">
    <%@include file="component/footer.jsp"%>
</div>
</body>
</html>
