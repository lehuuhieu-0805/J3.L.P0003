<%-- 
    Document   : viewCart
    Created on : 14-Feb-2023, 21:33:45
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Cart Page</title>
    </head>
    <body class="container">
        <h1>Your Cart</h1>
        <a href="SearchController" class="btn btn-primary">Back</a>
        <p>        
            <font color="red">
            ${requestScope.SUCCESS}
            ${requestScope.ERROR}
            ${requestScope.INVALID}
            </font>
        </p>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <table class="table table-bordered" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th scope="col">No.</th>
                        <th scope="col">Hotel Name</th>
                        <th scope="col">Room type</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Price</th>
                        <th scope="col">Total</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${cart.getCart().values()}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.hotelName}</td>
                            <td>${dto.type}</td>
                            <td>
                                <input class="form-control" type="number" value="${dto.amount}" name="txtAmountUpdate"/>
                            </td>
                            <td>${dto.price}</td>
                            <td>${dto.amount * dto.price}</td>
                            <td>
                                <a href="DeleteCartController?id=${dto.id}" class="btn btn-danger">Delete</a>
                                <input type="hidden" name="id" value="${dto.id}"/>
                                <input type="submit" class="btn btn-success" name="action" value="Update"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                <form action="MainController" method="POST">
                    <tr>
                        <td colspan="5">Total amount of this cart</td>
                        <c:set var="value" value="${requestScope.VALUE_DISCOUNT}"/>
                        <c:if test="${not empty value}">
                        <input type="hidden" name="txtTotalPrice" value="${cart.getTotal() - (cart.getTotal() * requestScope.VALUE_DISCOUNT / 100)}"/>
                        <td colspan="2">${cart.getTotal() - (cart.getTotal() * requestScope.VALUE_DISCOUNT / 100)}</td>
                    </c:if>
                    <c:if test="${empty value}">
                        <input type="hidden" name="txtTotalPrice" value="${cart.getTotal()}"/>
                        <td colspan="2">${cart.getTotal()}</td>
                    </c:if>
                    </tr>
                    <tr>
                        <td colspan="5">Discount code</td>
                        <td colspan="1">
                            <input class="form-control" type="text" name="txtDiscountCode" value="${param.txtDiscountCode}"/>
                            <input type="submit" class="btn btn-success mt-1" name="action" value="Apply Code"/>
                        </td>
                        <td>
                            <input type="submit" class="btn btn-primary" name="action" value="Buy"/>
                        </td>
                    </tr>
                </form>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty cart}">
        <font color="red">
        No record found
        </font>
    </c:if>
</body>
</html>
