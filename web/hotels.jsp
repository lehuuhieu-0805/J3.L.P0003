<%-- 
    Document   : hotels
    Created on : 14-Feb-2023, 14:31:39
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Hotel Page</title>
    </head>
    <body class="container">
        <c:if test="${not empty sessionScope.name}">
            <h3>Welcome ${sessionScope.name}</h3>
            <a href="LogoutController" class="btn btn-link btn-sm">Logout</a>
        </c:if>
        <c:if test="${empty sessionScope.name}">
            <a href="login.jsp" class="btn btn-primary">Login</a>
        </c:if>
        <form action="MainController" style="margin-top: 20px; margin-bottom: 20px">
            <div class="form-group">
                <label for="exampleInputSearch">Search by hotel name or hotel area</label>
                <input type="text" class="form-control" id="exampleInputSearch" name="txtSearch" value="${param.txtSearch}" >
            </div>
            <div class="form-group">
                <label for="exampleInputAmount">Amount of room</label>
                <input type="number" class="form-control" id="exampleInputAmount" name="txtSearchAmount" value="${param.txtSearchAmount}" >
            </div>

            <input type="submit" value="Search" name="action" class="btn btn-primary"/>
        </form>
        <a href="viewCart.jsp" class="btn btn-primary">View Your Cart</a>
        <c:if test="${not empty sessionScope.name}">
            <a href="HistoryOrderController" class="btn btn-primary">History Order</a>
        </c:if>
        <h1>List hotel:</h1>
        <c:set var="search" value="${param.txtSearch}"/>
        <c:set var="searchAmount" value="${param.txtSearchAmount}"/>
        <%--<c:if test="${not empty searchContent}">--%>
        <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>
        <c:if test="${not empty result}">
            <table class="table table-bordered" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Name</th>
                        <th scope="col">Area</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.name}</td>
                            <td>${dto.area}</td>
                            <td>
                                <a href="DetailController?id=${dto.id}" class="btn btn-primary">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            <font color="red">No record found</font>
        </c:if>
    </body>
</html>
