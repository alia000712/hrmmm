<%--
  Created by IntelliJ IDEA.
  User: Unknown
  Date: 13/1/2022
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Branch</title>
    <style>
        .branch
        {
            margin-left:20%;
            padding:10px 16px;
            height:730px;
            overflow: hidden;
            color: white;
            font-family: Inter-Bold, Inter, sans-serif;
            font-size:30px;
        }
        button
        {
            background-color: black;
            border-radius: 40px;
            font-size:20px;
            width: 20%;
            padding: 16px 8px;
        }
        .rectangle
        {
            height: 10px;
            width: 800px;
            background-color: white;
        }

        button a
        {
            text-decoration: none;
            color: pink;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminBranch.html"%>
<div class="branch">
    <center>
        <br><br><br>
        <h2>REGISTER BRANCH</h2>
        <button><a href="adminAddBranch.jsp">REGISTER</a></button>
        <br><br><br>
        <div class="rectangle"></div><br>
        <h2>VIEW BRANCH</h2>
        <button><a href="adminViewBranch.jsp">VIEW</a></button>
    </center>
</div>
</body>
</html>
