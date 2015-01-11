<%-- 
    Document   : EditUser
    Created on : Dec 8, 2014, 12:17:32 AM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">
        <title>Edit user</title>
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
            <h1>Edit user</h1>
            <p><a href="/SpringApp/Users/deleteUser.html?id=${user.id}">Delete user</a></p>
            <form:errors path="user.*"/>
            <form:form action="/SpringApp/Users/saveUser.html" method="post" modelAttribute="user" >
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td>First name:</td>
                        <td><form:input path="firstname"/></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><form:input path="lastname"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td>Number:</td>
                        <td><form:input path="number"/></td>
                    </tr>
                    <tr>
                        <td>Street address:</td>
                        <td><form:input path="address.streetaddress"/>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><form:input path="address.city"/></td>
                    </tr>
                    <tr>
                        <td>Zipcode:</td>
                        <td><form:input path="address.zipcode"/></td>
                    </tr>
                    <tr>
                        <td>Belt level:</td>
                        <td>
                            <select name="belt">
                                <option value="White">White</option>
                                <option value="Yellow">Yellow</option>
                                <option value="Green">Green</option>
                                <option value="Blue">Blue</option>
                                <option value="BlueRed">BlueRed</option>
                                <option value="Brown">Brown</option>
                                <option value="Red">Red</option>
                                <option value="RedBlack">RedBlack</option>
                                <option value="1.Dan">1.Dan</option>
                                <option value="2.Dan">2.Dan</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
