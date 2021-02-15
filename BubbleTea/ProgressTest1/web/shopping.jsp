<%-- 
    Document   : shopping
    Created on : Aug 18, 2019, 2:24:54 PM
    Author     : haway
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Milk Tea Store</title>
        
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link href="./CSS/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${sessionScope.USERROLE ne 'User'}">
            <jsp:forward page="index.html"></jsp:forward>
        </c:if>
        
        <div class="welcome">Welcome, ${sessionScope.USERID} <br/>
            <a href="LogoutServlet">Logout</a>
        </div>
        
        <h1>Welcome to our store !</h1>
        
        <div class="store">
            <font color="darkred">Take your time here, ${sessionScope.USERID}</font><br/><br/><br/>
        
            <form action="DispatchServlet">
                Select your tea:
                <select name="cmbTea">
                    <c:forEach var="dto" items="${sessionScope.PRODUCTS}">
                        <option value="${dto.teaID}-${dto.name}-${dto.price}">${dto.name} Tea</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Add to Cart" name="btnAction" />
                <input type="submit" value="Show Cart" name="btnAction" />
            </form>  <br/>
            
            <c:set var="message" value="${requestScope.message}"/>
            <c:if test="${not empty message}">
                <font color="darkred">${message}</font>
            </c:if>
        </div>           
        
            
    </body>
</html>
