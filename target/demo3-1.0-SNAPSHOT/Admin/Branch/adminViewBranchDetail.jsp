<%--
  Created by IntelliJ IDEA.
  User: Unknown
  Date: 13/1/2022
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=ABeeZee' rel='stylesheet'>
    <link rel="stylesheet" href="adminViewBranchDetail.css">
    <title>Branch</title>
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
<%@include file="../../menuHtml/menuAdminBranch.html"%>
<br>
<form action="" method="post">
    <div class="view">
        <center>
            <br>
            <div class="exit"><a href="adminViewBranch.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>BRANCH DETAIL</h1>
            <div class="rectangle"></div><br>
                <div class="platter">
                    <div style="font-size: 10px ;color: rgba(255, 255, 255, 0.6)">NBARBERSHOP</div><br>
                    <div style="font-size: 25px">Branch ID: ${br.branchID}</div><br>
                    <div style="font-size: 25px">Branch Name: ${br.branchName}</div><br>
                    <div style="font-size: 25px">Branch Address: ${br.branchAddress}</div><br>
                    <div style="font-size: 25px">Branch Address: ${br.branchPhone}</div><br>
                    <div style="font-size: 25px">Number of worker: ${br.numOfWorker} </div><br><br>
                    <input type="hidden" name="branchid" value="${br.branchID}">
                    <input type="hidden" name="branchname" value="${br.branchName}">
                    <input type="hidden" name="branchaddress" value="${br.branchAddress}">
                    <input type="hidden" name="branchphone" value="${br.branchPhone}">
                    <input type="hidden" name="numofworker" value="${br.numOfWorker}">
                    <div>
                        <center>
                            <button type="submit"  name="submit" ><a href="adminEditBranch.jsp">EDIT</a></button>
                        </center>
                        </div><br>
                    <div>
                        <center>
                            <input type="hidden" name="action" value="delete">
                            <button type="submit" name="submit" onclick="form.action='../../BranchServlet'">DELETE</button>
                        </center>
                        </div>
                </div>
        </center>
    </div>
</form>
</body>
</html>
