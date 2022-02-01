<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 15/1/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="adminAddBranch.css">
    <title>Branch</title>
</head>
<body>
<%@include file="../../menuHtml/menuAdminBranch.html"%>
<br>
<form action="" method="post">
    <div class="register">
        <center>
            <br>
            <div class="exit"><a href="adminBranch.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>NEW BRANCH</h1>
            <div class="rectangle"></div><br>
            <div>
                <input type="text" name="branchname" placeholder="Branch Name"><br><br>
                <input type="text" name="branchid" placeholder="Branch ID"><br><br>
                <input type="text" name="branchaddress" placeholder="Branch Address"><br><br>
                <input type="text" name="branchphone" placeholder="Branch Phone"><br><br>
                <input type="number" name="numofworker" placeholder="Number of Worker"><br><br>
                <input type="hidden" name="action" value="add">
            </div>
            <div>
                <button type="submit" name="submit" onclick="form.action='../../BranchServlet'">REGISTER</button>
            </div>
        </center>
    </div>
</form>
</body>
</html>