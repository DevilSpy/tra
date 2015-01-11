<%-- 
    Document   : Exercise
    Created on : Dec 8, 2014, 2:07:20 PM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">
        <title>Exercises</title>
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
            <h1>Exercises</h1>
            <c:forEach var="exercise" items="${listExercises}">
            <tr>
                <td>Date: ${exercise.date}</td>
                <td>Hours: ${exercise.hours}</td>
                <td>User: ${exercise.userid}</td>
            </tr>
            <br><br>
            </c:forEach>
        </div>
    </body>
</html>
