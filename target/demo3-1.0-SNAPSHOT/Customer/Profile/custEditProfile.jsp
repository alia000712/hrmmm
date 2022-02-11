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
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
        .container{
            width: 50%;
            height: 95%;
            background: white;
            top: 50%;
            left: 50%;
            border-radius: 30px;
            position: absolute;
            transform: translate(-50%,-50%);
            box-sizing: border-box;
        }
        h2{
            font-size: 40px;
            text-align: center;
        }
        hr{
            width: 50%;
            background-color: #D8A8FA;
            height: 1%;
            border-radius: 50px;
        }
        form{
            font-size: 20px;
        }
        .custid{
            font-size: 20px;
        }
        .custid input{
            color: #7e08a5;
        }
        .table{
            margin-left: 0%;
            margin-right: 0%;
            text-align: center;
            font-size: 20px;
        }
        .table tr, td{
            padding: 15px;
        }
        input{
            text-align: center;
            padding: 10px;
            border: none;
            border-bottom: 3px solid black;
            color: #7e08a5;
            font-size: 20px;
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
        button{
            padding: 5px;
            padding-left: 10px;
            padding-right: 10px;
            font-size: 20px;
            border-radius: 30px;
            border: 3px solid #7e08a5;
            cursor: pointer;
        }
        button a{
            color: black;
            text-decoration: none;
            cursor: pointer;
        }


    </style>
</head>
<body>
<%@include file="../../menuHtml/menuCustProfile.html"%>
<div class="overlay"></div>
<div class="container">
    <div class="exit"><a href="custViewProfile.jsp">&#9746;</a></div>
    <center><br/>
        <h2>Edit Profile</h2>
        <hr><br/><br/>
        <form method="post" action="">
            <input type="hidden" name="custid" value="${cust.custID}">
            USER ID : <br/>
            <input style="color: #7e08a5" class="custid" type="number" name="custid" readonly value="${cust.custID}"> <br/><br/>
            <table class="table" >
                <tr>
                    <td>
                        NAME : <br/>
                        <input type="text" placeholder="name" name="custname" value="${cust.custName}">
                    </td>
                    <td>
                        EMAIL : <br/>
                        <input type="text" placeholder="E-mail" name="custemail" value="${cust.custEmail}">
                    </td>
                </tr>
                <tr>
                    <td>
                        PHONE : <br/>
                        <input type="text" placeholder="Phone" name="custphone" value="${cust.custPhone}">
                    </td>
                    <td>
                        ADDRESS : <br/>
                        <input type="text" placeholder="Address" name="custaddress" value="${cust.custAddress}">
                    </td>
                </tr>
                <tr>
                    <td>
                        PASSWORD : <br/>
                        <input type="text" placeholder="pass" name="custpass" value="${cust.custPass}">
                    </td>
                    <td>
                        USERNAME : <br/>
                        <input type="text" placeholder="username" name="custusername" value="${cust.custUsername}">
                    </td>
                </tr>
            </table><br/><br/>
            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn-edit" name="submit" onclick="form.action='../../CustomerServlet'" >UPDATE</button>
            <button><a href="custViewProfile.jsp">CANCEL</a></button>
        </form>

    </center>
</div>
</body>
</html>
