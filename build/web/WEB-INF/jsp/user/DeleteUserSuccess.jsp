<%-- 
    Document   : DeleteUserSuccess
    Created on : Dec 8, 2014, 12:41:09 PM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">
        <title>Delete user success</title>
    </head>
    <body>
        <div class="navigation">
            <ul>
                <li><a href="/SpringApp/">Front page</a></li>
                <li><a href="/SpringApp/Users/">Users</a></li>
                <li><a href="/SpringApp/Exercises/">Exercises</a></li>
            </ul>
        </div>
        <div class="container">
            <h1>User deleted!</h1>
            <p><a href="/SpringApp/Users/">Back to users</a></p>
        </div>
    </body>
</html>
