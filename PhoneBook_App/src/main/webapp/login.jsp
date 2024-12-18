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
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body>">
                    <h3 class="text-center text-success">Login Page</h3>
                    <%
                        String message=(String) session.getAttribute("fail");
                        if (message!=null){
                    %>
                    <p class="text-danger text-center"><%=message%></p>
                    <% session.removeAttribute("fail");
                        }
                    %>

                    <%
                        String logoutMessage=(String) session.getAttribute("logout");
                        if (logoutMessage!=null){
                    %>
                    <p class="text-success text-center"><%=logoutMessage%></p>
                    <% session.removeAttribute("logout");
                    }
                    %>

                    <form action="login" method="post">

                        <div class="form-group mx-3">
                            <label for="email" >Email address</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                        </div>

                        <div class="form-group mx-3">
                            <label for="pass" >Password</label>
                            <input type="password" class="form-control" id="pass" aria-describedby="emailHelp" name="password">
                        </div>


                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-top: 200px">
    <%@include file="component/footer.jsp"%>
</div>
</body>
</html>
