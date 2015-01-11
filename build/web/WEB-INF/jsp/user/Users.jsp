<%-- 
    Document   : Users
    Created on : Dec 7, 2014, 6:15:49 PM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">
        <title>Users</title>
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
            <h1>Users</h1>
            <p class="center"><a href="/SpringApp/Users/userForm.html">Add new user</a></p>
            <c:forEach var="user" items="${listUser}">
            <tr>
                <td>Name: ${user.firstname} ${user.lastname}</td><br>
                <td>Email: ${user.email}</td><br>
                <td>Number: ${user.number}</td><br>
                <td>Belt level: ${user.belt}</td><br>
                <td>Address: ${user.address.streetaddress} ${user.address.zipcode} ${user.address.city}</td><br>
                <td>Total hours: ${user.totalHours}</td><br>
            </tr>
            <p><a href="/SpringApp/Users/editUser.html?id=${user.id}&firstname=${user.firstname}&lastname=${user.lastname}&email=${user.email}&number=${user.number}&address.streetaddress=${user.address.streetaddress}&address.city=${user.address.city}&address.zipcode=${user.address.zipcode}&belt=${user.belt}">Edit user</a></p>
            <br><br>
            </c:forEach>
        </div>
    </body>
</html>
