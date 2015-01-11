<%-- 
    Document   : FrontPage
    Created on : Dec 8, 2014, 2:26:43 PM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">
        <title>Training tracker</title>
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
            <h1>Training tracker</h1>
            <div class="newEntry">
                <h2>Add new entry for exercise</h2>
                <form:errors path="exercise.*"/>
                <form method="post" action="/SpringApp/saveEntry.html">
                    <table>
                        <tr>
                            <td>Date:</td>
                            <td><input type="text" name="date"/><td>
                        </tr>
                        <tr>
                            <td>Hours:</td>
                            <td><input type="number" min="0.5" max="10" step="0.5" name="hours"/></td>
                        </tr>
                        <tr>
                            <td>Users:</td>
                            <td>
                                <select name="userids" multiple>
                                    <c:forEach var="user" items="${listUsers}">
                                        <option value="${user.id}">${user.firstname} ${user.lastname}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save entry"/></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="recentExercises">
                <h2>Exercises:</h2>
               
                <c:forEach var="lista" items="${recentEwp}">
                    <div class="recentExercise">
                    <c:set var="listItem" value="${lista}" />
                    <p><b>${listItem[0].date}</b></p>

                    <c:forEach var="ewp" items="${lista}">
                        <p>${ewp.firstname} ${ewp.lastname} ${ewp.hours}h</p>
                    </c:forEach>
                    </div>
                </c:forEach>
                
            </div>
        </container>
    </body>
</html>
