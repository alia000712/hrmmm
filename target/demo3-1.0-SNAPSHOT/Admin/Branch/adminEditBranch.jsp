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
    <link rel="stylesheet" href="adminEditBranch.css">
    <title>Branch</title>
</head>
<body>
<%@include file="../../menuHtml/menuAdminBranch.html"%>
<br>
<form action="" method="post">
    <div class="edit">
        <center>
            <br>
            <div class="exit"><a href="adminViewBranch.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>UPDATE BRANCH</h1>
            <div class="rectangle"></div><br>
            <div>
                <input type="text" name="branchname" placeholder="Branch Name" value="${br.branchName}"><br><br>
                <input type="text" name="branchid" placeholder="Branch ID" value="${br.branchID}"><br><br>
                <input type="text" name="branchaddress" placeholder="Branch Address" value="${br.branchAddress}"><br><br>
                <input type="text" name="branchphone" placeholder="Branch Phone" value="${br.branchPhone}"><br><br>
                <input type="number" name="numofworker" placeholder="Number of Worker" value="${br.numOfWorker}"><br><br>
            </div>
            <div>
                <input type="hidden" name="action" value="update">
                <button type="submit" name="submit" onclick="form.action='../../BranchServlet'">UPDATE</button>
            </div>
        </center>
    </div>
</form>
</body>
</html>