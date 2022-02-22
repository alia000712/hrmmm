<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Sales</title>
    <link rel="stylesheet" href="workerAddSales.css">
    <style>
        td{
            font-size: 25px;
            color: white;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuWorkerSales.html"%>
<br>
<form action="" method="post">
    <div class="addsales">
        <center>
            <br>
            <div class="exit"><a href="workerSales.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>ADD SALES</h1>
            <div class="rectangle"></div><br>
            <input type="hidden" name="workerid" value="${wk.workerID}">
            <table>
                <tr>
                    <td style="font-size: 25px; color: white">Sales Date</td>
                    <td>: <input type="date" name="salesdate" placeholder="Sales Date"></td>
                </tr>
                <tr>
                    <td style="font-size: 25px; color: white">Walkin Sales</td>
                    <td>: <input type="text" name="saleswalkin" placeholder="Walkin Sales"></td>
                </tr>
            </table><br/><br/>
            <input type="hidden" name="branchid" value="${wk.branchID}">
            <input type="hidden" name="action" value="addsalesworker">
            <button type="submit" name="submit" onclick="form.action='../../SalesServlet'">ADD</button>
        </center>
    </div>
</form>
</body>
</html>
