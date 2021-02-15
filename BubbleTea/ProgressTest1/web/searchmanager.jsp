<%-- 
    Document   : searchadmin.jsp
    Created on : Aug 11, 2019, 7:50:19 PM
    Author     : haway
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Manager</title>
        
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
        <link href="./CSS/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>  
        <c:if test="${sessionScope.USERROLE ne 'Admin'}">
            <jsp:forward page="index.html"></jsp:forward>
        </c:if>
        
        <div class="welcome">Welcome, ${sessionScope.USERID} <br/>
            <a href="LogoutServlet">Logout</a>
            <a href="createNewProduct.jsp">Create Products</a>
        </div>
        
        <h1>Search Manager</h1>
        <h2>Search user by user full name:</h2>
        <form action="DispatchServlet">
            Search Value <input type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}" /><br/>
            <input type="submit" value="Search Manager" name="btnAction" />
        </form><br/>
        
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1" class="content-table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>User ID</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "dto" items="${result}" varStatus="counter">
                            <form>
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        ${dto.userID}
                                        <input type="hidden" name="txtUserID" value="${dto.userID}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" required="required" value="${dto.password}" maxlength="24" />
                                    </td>
                                    <td>${dto.fullName}</td>
                                    <td>
                                        ${dto.role}
                                        <select name="ddlRole">
                                            <option>User</option>
                                            <option>Admin</option>
                                        </select>
                                    </td>
                                    <td>
                                        <c:url var="delLink" value="DispatchServlet">
                                            <c:param name="btnAction" value="DeleteAccount" />
                                            <c:param name="pk" value="${dto.userID}" />
                                            <c:param name="lastSearchValue" value="${searchValue}" />
                                        </c:url>
                                        <a href="${delLink}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update Account" name="btnAction" />
                                        <input type="hidden" name="lastSearchValue" 
                                               value="${searchValue}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <h2>
                    No record is matched!!!!
                </h2>
            </c:if>        
        </c:if>
    </body>
</html>
