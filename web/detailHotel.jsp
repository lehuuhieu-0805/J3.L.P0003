<%-- 
    Document   : detailHotel
    Created on : 14-Feb-2023, 20:06:49
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Detail Hotel Page</title>
    </head>
    <body class="container">
        <h1>Detail Hotel</h1>
        <a href="SearchController" class="btn btn-link">Back</a>
        <a href="viewCart.jsp" class="btn btn-primary">View Your Cart</a>
        <c:set var="result" value="${requestScope.LIST_ROOM}"/>
        <c:if test="${not empty result}">
            <table class="table table-bordered" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Type</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Price</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.type}</td>
                            <td>${dto.amount}</td>
                            <td>${dto.price}</td>
                            <td>
                                <a href="AddCartController?id=${dto.id}" class="btn btn-primary">Booking</a>
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
