<%-- 
    Document   : register
    Created on : 09-Jan-2023, 15:07:18
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Register Page</title>
    </head>
    <body>
        <div class="container" style="max-width: 500px">
            <h1 style="text-align: center">Register</h1>
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
                    <div class="col-12">Phone:</div>
                    <div class="col-12">
                        <input type="number" name="txtPhone" value="${param.txtPhone}" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.phoneError}</div>
                    </div>
                </div>
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Name:</div>
                    <div class="col-12">
                        <input type="text" name="txtName" value="${param.txtName}" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.nameError}</div>
                    </div>
                </div>
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Address:</div>
                    <div class="col-12">
                        <input type="text" name="txtAddress" value="${param.txtAddress}" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.addressError}</div>
                    </div>
                </div>
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Password:</div>
                    <div class="col-12">
                        <input type="password" name="txtPassword" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.passwordError}</div>
                    </div>
                </div>
                <div class="row" style="margin-bottom:20px">
                    <div class="col-12">Confirm password:</div>
                    <div class="col-12">
                        <input type="password" name="txtConfirmPassword" class="form-control"/>
                        <div style="color:red">${requestScope.INVALID.confirmPasswordError}</div>
                    </div>
                </div>
                <div class="row" style="display:flex; justify-content: space-evenly">
                    <input type="submit" name="action" value="Register" class="btn btn-primary"/>
                    <a href="login.jsp" class="btn btn-link">Back to login</a>
                </div>
            </form>
        </div>
    </body>
</html>
