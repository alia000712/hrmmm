<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Package</title>
    <link rel="stylesheet" href="adminAddPackage.css">
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
    <div class="addpackage">
        <center>
            <br>
            <div class="exit"><a href="adminPackage.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>ADD NEW PACKAGE</h1>
            <div class="rectangle"></div><br>

            <table>
                <tr>
                    <td>Package Name</td>
                    <td>: <input type="text" name="packagename" placeholder="Package Name"></td>
                </tr>
                <tr>
                    <td>Pakcage ID</td>
                    <td>: <input type="text" name="packageid" placeholder="Package ID"></td>
                </tr>
                <tr>
                    <td>Pakcage Price</td>
                    <td>: <input type="text" name="packageprice" placeholder="Package Price"></td>
                </tr>
            </table><br><br>

            <input type="hidden" name="action" value="add">
            <div>
                <button type="submit" name="submit" onclick="form.action='../../PackageServlet'">ADD PACKAGE</button>
            </div>
        </center>
    </div>
</form>
</body>
</html>
