<%-- 
    Document   : UserForm
    Created on : Dec 7, 2014, 6:45:33 PM
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
        <title>Create new user</title>
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
            <h1>Create new user</h1>

            <form:errors path="user.*"/>

            <form action="/SpringApp/Users/submitUserForm.html" method="post">
                <table>
                    <tr>
                        <td>First name: </td>
                        <td><input type="text" name="firstname"/></td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td><input type="text" name="lastname"/></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Number: </td>
                        <td><input type="text" name="number"/></td>
                    </tr>
                    <tr>
                        <td>Street address: </td>
                        <td><input type="text" name="address.streetaddress"/></td>
                    </tr>
                    <tr>
                        <td>City: </td>
                        <td><input type="text" name="address.city"/></td>
                    </tr>
                    <tr>
                        <td>Zipcode: </td>
                        <td><input type="text" name="address.zipcode"/></td>
                    </tr>
                    <tr>
                        <td>Belt level: </td>
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
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>    
            </form>
        </div>
    </body>
</html>
