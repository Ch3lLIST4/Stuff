<%-- 
    Document   : viewCart
    Created on : Aug 18, 2019, 10:07:31 PM
    Author     : haway
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link href="./CSS/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${sessionScope.USERROLE ne 'User'}">
            <jsp:forward page="index.html"></jsp:forward>
        </c:if>
        
        <div class="welcome">Welcome, ${sessionScope.USERID} <br/>
            <a href="LogoutServlet">Logout</a>
            <a href="shopping.jsp">Shopping Page</a><br/>
        </div>
            
        <h1>Your Shopping Cart</h1>
        <a href="shopping.jsp">Go back to shopping page</a><br/>
        
        Your cart includes:<br/>
        <c:if test="${not empty sessionScope}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart}">
                <c:set var="items" value="${cart.cart}" />
                <c:if test="${not empty items}" >          
                    <table border="2">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Tea ID</th>
                                <th>Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Total</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>                    
                            <c:forEach var="list" items="${items}" varStatus="counter">
                                <form action="DispatchServlet">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <td>
                                            ${list.key}
                                            <input type="hidden" name="txtTeaID" value="${list.key}" />
                                        </td>
                                        <td>
                                            ${list.value.name}
                                        </td>
                                        <td>
                                            <input type="text" name="txtQuantity" required="required" value="${list.value.quantity}" pattern="[0-9]{1,3}" title="Valid quantity requires 1 to 3 digits (max 999)" />
                                        </td>
                                        <td>
                                            ${list.value.price}
                                        </td>
                                        <td>
                                            ${list.value.price * list.value.quantity}
                                            <c:set var="total" value="${total + list.value.price * list.value.quantity}" />
                                        </td>
                                        <td>
                                            <input type="submit" value="Delete Item" name="btnAction" />
                                        </td>
                                        <td>
                                            <input type="submit" value="Update Item" name="btnAction" />
                                        </td>
                                    </tr>                         
                                </form>
                            </c:forEach>      
                        </tbody>
                    </table>
                    <h3>Total Cost: $${total}</h3>
                </c:if>
                <c:if test="${empty total}">
                    <div>There is nothing in your cart!</div>
                </c:if>
                <c:if test="${total > 0}">
                    
                    <div class="buy-info-box">
                        Please enter your Information to purchase! <br/>
                        <form action="DispatchServlet">
                            Address <input type="text" name="txtAddress" required="required" value="" maxlength="50"/><br/>
                            Phone Number <input type="text" name="txtPhone" required="required" value="" pattern="[0-9]{10}" title="Valid phone number contains 10 digits!"/><br/>
                            <input type="hidden" name="total" value="${total}" />

                            <input type="submit" value="Buy Cart!" name="btnAction" />
                            <input type="reset" value="Reset" />
                        </form>
                    </div>
                </c:if>
            </c:if>           
        </c:if>
    </body>
</html>
