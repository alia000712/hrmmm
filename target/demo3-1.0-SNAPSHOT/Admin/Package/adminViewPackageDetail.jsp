<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 14/2/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Package</title>
    <link href='https://fonts.googleapis.com/css?family=ABeeZee' rel='stylesheet'>
    <link rel="stylesheet" href="adminViewPackageDetail.css">
    <style>
        button{
            padding: 10px 20px;
            border-radius: 50px;
            border :3px solid white;
            color: white;
            background: transparent;
            cursor: pointer;
        }
        button:hover{
            color: mediumpurple;
            background: white;
        }
        button a{
            text-decoration: none;
            color: white;
        }
        button a:hover{
            color: mediumpurple;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminPackage.html"%>
<form action="" method="post">
    <div class="view">
        <center>
            <br>
            <div class="exit"><a href="adminViewPackage.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>PACKAGE DETAIL</h1>
            <div class="rectangle"></div><br>
            <div class="platter">
                <div style="font-size: 10px ;color: rgba(255, 255, 255, 0.6)">NBARBERSHOP</div><br>
                <div style="font-size: 25px">Package ID: ${pk.packageID}</div><br>
                <div style="font-size: 25px">Package Name: ${pk.packageName}</div><br>
                <div style="font-size: 25px">Package Price: ${pk.packagePrice}</div><br><br>
                <input type="hidden" name="packageid" value="${pk.packageID}">
                <input type="hidden" name="packagename" value="${pk.packageName}">
                <input type="hidden" name="packageprice" value="${pk.packagePrice}">
                <div>
                    <button type="submit"  name="submit" ><a href="adminEditPackage.jsp">EDIT</a></button>
                </div><br/>
                <div>
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" name="submit" onclick="form.action='../../PackageServlet'">DELETE</button>
                </div>
            </div>
        </center>
    </div>
</form>
</body>
</html>
