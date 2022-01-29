<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="icon" href="../../image/logo.png">
    <link rel="stylesheet" href="custViewProfile.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<%@include file="../../menuHtml/menuCustProfile.html"%>
<div class="cust-profile" id="blurr">
    <br>
    <h2>Profile Details</h2>
    <hr>
    <form action="" method="post">
        <input type="number" name="custid" value="${custid}" hidden>
        <table class="table">
            <tr>
                <td>USER ID</td>
                <td><input type="text" readonly >${cust.custid}</td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><input type="text" readonly>${cust.custname}</td>
            </tr>
            <tr>
                <td>E-MAIL</td>
                <td><input type="text" readonly>${cust.custemail}</td>
            </tr>
            <tr>
                <td>PHONE</td>
                <td><input type="text" readonly>${cust.custphone}</td>
            </tr>
            <tr>
                <td>ADDRESS</td>
                <td><input type="text" readonly>${cust.custaddress}</td>
            </tr>
        </table>

        <div class="edit-profile">
            <button type="submit"><a href="custEditProfile.jsp">EDIT<i class="fas fa-edit"></i></a></button>
        </div>

        <input type="hidden" name="action" value="delete">
        <button type="submit" class="button button1" name="submit"><a href="Student-updateprofile.jsp">Update</a></button>
        <button type="submit" class="button button1" name="submit" onclick="form.action='StudentServlet'">Delete</button><br><br>
    </form>
</div>
</body>
</html>
