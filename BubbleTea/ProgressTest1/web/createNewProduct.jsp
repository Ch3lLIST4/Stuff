<%-- 
    Document   : createNewProduct
    Created on : Aug 24, 2019, 7:12:46 PM
    Author     : haway
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Product</title>
        
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link href="./CSS/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <c:if test="${sessionScope.USERROLE ne 'Admin'}">
            <jsp:forward page="index.html"></jsp:forward>
        </c:if>
        
        <h1>Create New Product</h1>
        <a href="searchmanager.jsp">Back to Search Page</a><br/><br/>
        
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.TEAERR}"/>
            Tea ID <input type="text" name="txtTeaID" value="${param.txtTeaID}" />(3-10 chars)<br/>
            <c:if test="${not empty errors.teaIDLengthErr}">
                <font color="red">
                    ${errors.teaIDLengthErr}
                </font><br/>
            </c:if>
            Name <input type="text" name="txtName" value="${param.txtName}" />(3-20 chars)<br/>
            <c:if test="${not empty errors.nameLengthErr}">
                <font color="red">
                    ${errors.nameLengthErr}
                </font><br/>
            </c:if>
            Price <input type="text" name="txtPrice" value="${param.txtPrice}" /><br/>
            <c:if test="${not empty errors.priceFormatErr}">
                <font color="red">
                    ${errors.priceFormatErr}
                </font><br/>
            </c:if>      
            <input type="submit" value="Create New Product" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
        <c:if test="${not empty errors.teaIDisExisted}">
            <font color="red">
                ${errors.teaIDisExisted}
            </font><br/>
        </c:if>         
    </body>
</html>
