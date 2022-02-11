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
        .overlay {
            position: absolute;
            left: 0;
            top: 0;
            right: 0;
            bottom: 0;
            background-color: black;
            opacity: 0.7;
        }
        .form{
            width: 50%;
            height: 85%;
            background: white;
            top: 50%;
            left: 50%;
            border-radius: 30px;
            position: absolute;
            transform: translate(-50%,-50%);
            box-sizing: border-box;
        }
        .exit {
            position: absolute;
            top: 8px;
            right: 20px;
            font-size: 35px;
        }
        .exit a {
            text-decoration: none;
            color: black;
        }
        .table{
            margin-left: 0%;
            margin-right: 30%;
            text-align: center;
        }
        table input{
            text-align: center;
        }
        .custid::placeholder{
            text-align: center;
            color: purple;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuCustProfile.html"%>
<div class="overlay"></div>

<div class="form">
    <div class="exit"><a href="custViewProfile.jsp">&#9746;</a></div>
    <center><br/>
        <h2>Edit Profile</h2>
        <hr><br/><br/>
        <form method="post" action="">
            <input type="hidden" name="custid" value="${cust.custID}">
            USER ID : <br/>
            <input class="custid" type="number" name="custid" readonly value="${cust.custID}">
            <table class="table" >
                <tr>
                    <td colspan="2" align="center">
                        NAME : <br/>
                        <input type="text" placeholder="Name" name="custname" value="${cust.custName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        EMAIL : <br/>
                        <input type="text" placeholder="E-mail" name="custemail" value="${cust.custEmail}">
                    </td>
                    <td>
                        PHONE : <br/>
                        <input type="text" placeholder="Phone" name="custphone" value="${cust.custPhone}">
                    </td>
                </tr>
                <tr>
                    <td>
                        ADDRESS : <br/>
                        <input type="text" placeholder="Address" name="custaddress" value="${cust.custAddress}">
                    </td>
                    <td>
                        PASSWORD : <br/>
                        <input type="text" placeholder="pass" name="custpass" value="${cust.custPass}">
                    </td>
                </tr>
                <tr>
                    <td>
                        USERNAME : <br/>
                        <input type="text" placeholder="username" name="custusername" value="${cust.custUsername}">
                    </td>
                    <td>
                        USERNAME : <br/>
                        <input type="text" placeholder="username" name="custusername" value="${cust.custUsername}">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn-edit" name="submit" onclick="form.action='../../CustomerServlet'" >Update</button>
            <button><a href="custViewProfile.jsp">CANCEL</a></button>
        </form>
    </center>
</div>
</body>
</html>
