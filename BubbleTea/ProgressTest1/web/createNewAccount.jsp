<%-- 
    Document   : createNewAccount
    Created on : Aug 17, 2019, 3:50:18 PM
    Author     : haway
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
        
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link href="./CSS/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>Create New Account</h1>
        
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.INSERTERR}"/>
            Username <input type="text" name="txtUserID" value="${param.txtUserID}" />(3-20 chars)<br/>
            <c:if test="${not empty errors.userIDLengthErr}">
                <font color="red">
                    ${errors.userIDLengthErr}
                </font><br/>
            </c:if>
            Password <input type="password" name="txtPassword" value="" />(3-24 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                    ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            Full name <input type="text" name="txtFullName" value="${param.txtFullName}" />(2-50 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}">
                <font color="red">
                    ${errors.fullNameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
        <c:if test="${not empty errors.userIDisExisted}">
            <font color="red">
                ${errors.userIDisExisted}
            </font><br/>
        </c:if>
    </body>
</html>
