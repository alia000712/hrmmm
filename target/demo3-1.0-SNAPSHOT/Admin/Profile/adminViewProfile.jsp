<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="icon" href="../../image/logo.png">
    <link rel="stylesheet" href="adminViewProfile.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <style>
        .edit-profile
        {
            margin: 0;
            position: absolute;
            top: 85%;
            left: 60%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        button
        {
            color: transparent;
            border: 1px solid black;
            border-radius: 30px;
            padding: 15px;
            padding-left: 30px;
            padding-right: 30px;
            justify-content: center;
        }
        button:hover
        {
            background-color: #695466;
            cursor: pointer;
        }
        button a
        {
            text-decoration: none;
            text-align: center;
            text-transform: uppercase;
            font-size: 15px;
            color: black;
        }
        button a:hover
        {
            color: #D8A8FA;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminProfile.html"%>
<div class="admin-profile" id="blurr">
    <br>
    <h2>Profile Details</h2>
    <hr>
    <form action="" method="post">
        <input type="number" name="adminid" value="${adminID}" hidden>
        <table class="table">
            <tr>
                <td>ADMIN ID</td>
                <td><input type="number" readonly value="${adm.adminID}"></input></td>
            </tr>
            <tr>
                <td>USERNAME</td>
                <td><input type="text" readonly value="${adm.adminUsername}"></td>
            </tr>
            <tr>
                <td>PASSWORD</td>
                <td><input type="password" readonly value="${adm.adminPass}"></td>
            </tr>
        </table>
        <button type="submit" name="submit" class="edit-profile"><a href="adminEditProfile.jsp">EDIT<i class="fas fa-edit"></i></a></button>
    </form>
</div>
</body>
</html>
