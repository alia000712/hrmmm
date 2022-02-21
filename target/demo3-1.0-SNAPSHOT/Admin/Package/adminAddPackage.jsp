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
            <div>
                <input type="text" name="packagename" placeholder="Package Name"><br><br>
                <input type="text" name="packageid" placeholder="Package ID"><br><br>
                <input type="text" name="packageprice" placeholder="Package Price"><br><br>
                <input type="hidden" name="action" value="add">
            </div>
            <div>
                <button type="submit" name="submit" onclick="form.action='../../PackageServlet'">ADD PACKAGE</button>
            </div>
        </center>
    </div>
</form>
</body>
</html>
