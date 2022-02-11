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
<%@include file="../../menuHtml/menuCustProfile.html"%>
<div class="cust-profile" id="blurr">
    <br>
    <h2>Profile Details</h2>
    <hr>
    <form action="" method="post">
        <input type="number" name="custid" value="${custID}" hidden>
        <table class="table">
            <tr>
                <td>USER ID</td>
                <td><input type="number" readonly value="${cust.custID}"></input></td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><input type="text" readonly value="${cust.custName}"></td>
            </tr>
            <tr>
                <td>E-MAIL</td>
                <td><input type="text" readonly value="${cust.custEmail}"></td>
            </tr>
            <tr>
                <td>PHONE</td>
                <td><input type="text" readonly value="${cust.custPhone}"></td>
            </tr>
            <tr>
                <td>ADDRESS</td>
                <td><textarea cols="37" rows="4">${cust.custAddress}</textarea></td>
            </tr>
        </table>
        <button type="submit" name="submit" class="edit-profile"><a href="custEditProfile.jsp">EDIT<i class="fas fa-edit"></i></a></button>
    </form>

</div>
</body>
</html>
