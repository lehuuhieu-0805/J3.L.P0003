<%-- 
    Document   : historyOrder
    Created on : 15-Feb-2023, 11:52:41
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>History Order Page</title>
    </head>
    <body class="container">
        <h1>History Order</h1>
        <a href="SearchController" class="btn btn-primary">Back</a>
        <c:set var="list" value="${requestScope.LIST}"/>
        <c:if test="${not empty list}">
            <table class="table table-bordered" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Date</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${list}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.date}</td>
                            <td>${dto.totalPrice}</td>
                            <td>
                                <a href="HistoryOrderController?orderId=${dto.id}" class="btn btn-primary">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty list}">
            <font color="red">
            No record found
            </font>
        </c:if>
        <c:set var="listDetail" value="${requestScope.LIST_DETAIL}"/>
        <c:if test="${not empty listDetail}">
            <table class="table table-bordered" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Hotel name</th>
                        <th scope="col">Room type</th>
                        <th scope="col">Price</th>
                        <th scope="col">Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${listDetail}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.hotelName}</td>
                            <td>${dto.roomType}</td>
                            <td>${dto.price}</td>
                            <td>${dto.amount}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
