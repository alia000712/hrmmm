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
            <div>
                <input type="text" name="packagename" placeholder="Package Name" value="${pk.packageName}"><br><br>
                <input type="text" name="packageid" placeholder="Package ID" value="${pk.packageID}"><br><br>
                <input type="number" name="packageprice" placeholder="Package Price" value="${pk.packagePrice}"><br><br>
            </div>
            <div>
                <input type="hidden" name="action" value="edit">
                <button type="submit" name="submit" onclick="form.action='../../PackageServlet'">EDIT</button>
            </div><br>
        </center>
    </div>
</form>
</body>
</html>
