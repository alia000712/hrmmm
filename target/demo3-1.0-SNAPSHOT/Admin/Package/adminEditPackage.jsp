<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Package</title>
    <link rel="stylesheet" href="adminEditPackage.css">
    <style>
        td{
            font-size: 23px;
            color: white;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminPackage.html"%>
<br>
<form action="" method="post">
    <div class="editpackage">
        <center>
            <br>
            <div class="exit"><a href="adminPackage.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>EDIT PACKAGE</h1>
            <div class="rectangle"></div><br>

            <table>
                <tr>
                    <td>Package Name</td>
                    <td>: <input type="text" name="packagename" placeholder="Package Name" value="${pk.packageName}"></td>
                </tr>
                <tr>
                    <td>Package ID</td>
                    <td>: <input type="text" name="packageid" placeholder="Package ID" value="${pk.packageID}"></td>
                </tr>
                <tr>
                    <td>Package Price</td>
                    <td>: <input type="number" name="packageprice" placeholder="Package Price" value="${pk.packagePrice}"></td>
                </tr>
            </table><br/><br/>

            <div>
                <input type="hidden" name="action" value="edit">
                <button type="submit" name="submit" onclick="form.action='../../PackageServlet'">EDIT</button>
            </div><br>
        </center>
    </div>
</form>
</body>
</html>
