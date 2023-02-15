<%-- 
    Document   : login
    Created on : 09-Jan-2023, 16:00:35
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container" style="max-width: 500px">
            <h1 style="text-align: center">Login</h1>
            <hr/>
            <form action="MainController" method="POST">
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Email:</div>
                    <div class="col-12">
                        <input type="text" name="txtEmail" value="${param.txtEmail}" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.emailError}</div>
                    </div>
                </div>
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Password:</div>
                    <div class="col-12">
                        <input type="password" name="txtPassword" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.passwordError}</div>
                        <div style="color:red">${requestScope.INVALID.userError}</div>
                    </div>
                </div>
                <div class="row" style="display: flex; justify-content: space-evenly">
                    <input type="submit" name="action" value="Login" class="btn btn-primary"/>
                    <a href="register.jsp" class="btn btn-link">Register an account</a>
                </div>
            </form>
        </div>
    </body>
</html>
