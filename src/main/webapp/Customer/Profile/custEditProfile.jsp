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
    <link rel="stylesheet" href="custEditProfile.css">
    <style>
        .btn-edit
        {
            margin-left: 40%;
            background-color: limegreen;
            padding: 10px;
            padding-right: 15px;
            padding-left: 15px;
            border-radius: 7px;
            border: none;
        }
        .btn-edit a
        {
            text-decoration: none;
            font-weight: bold;
            color: white;
            font-size: 15px;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuCustProfile.html"%>
<div class="overlay"></div>
<div class="container">
    <div class="form-container">
        <form action="" method="post">
            <h2>PROFILE DETAILS</h2>
            <input type="hidden" name="custid" value="${custID}">
            <hr><br/><br/>
            <p>USER ID :</p>
            <input type="number" readonly value="${cust.custID}">
            <p>NAME :</p>
            <input type="text" placeholder="Name" name="custname" value="${cust.custName}">
            <p>E-MAIL :</p>
            <input type="email" placeholder="E-mail" name="custemail" value="${cust.custEmail}">
            <p>PHONE :</p>
            <input type="text" placeholder="Phone" name="custphone" value="${cust.custPhone}">
            <p>E-MAIL :</p>
            <input type="text" placeholder="Address" name="custaddress" value="${cust.custAddress}"><br/><br/><br/>
            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn-edit" name="submit" onclick="form.action='CustomerServlet'" >Update<i class="fas fa-edit"></i></button>
            <button class="btn-cancel"><a href="custViewProfile.jsp">CANCEL</a></button>
        </form>
    </div>
</div>
</body>
</html>
