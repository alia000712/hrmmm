<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Sales</title>
    <style>
        td{
            font-size: 23px;
            color: white;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuWorkerSales.html"%>
<link rel="stylesheet" href="workerEditSales.css">

<br>
<form action="" method="post">
    <div class="editsales">
        <center>
            <br>
            <div class="exit"><a href="workerViewSales.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>EDIT SALES</h1>
            <div class="rectangle"></div><br>
            <input type="hidden" name="adminid" value="${sl.adminID}">
            <input type="hidden" name="workerid" value="${wk.workerID}">
            <table>
                <tr>
                    <td>Sales ID</td>
                    <td>: <input type="text" name="salesid" placeholder="Sales ID" value="${sl.salesID}" readonly></td>
                </tr>
                <tr>
                    <td><span style="color: red">*</span>Sales Date</td>
                    <td>: <input type="date" name="salesdate" placeholder="Sales Date" value="${sl.salesDate}"></td>
                </tr>
                <tr>
                    <td>Total Sales</td>
                    <td>: <input type="text" name="salesamount" placeholder="Sales Amount" value="${sl.salesAmount}" readonly></td>
                </tr>
                <tr>
                    <td><span style="color: red">*</span>Walkin Sales</td>
                    <td>: <input type="text" name="saleswalkin" placeholder="Walkin Sales" value="${sl.salesWalkin}"></td>
                </tr>
                <tr>
                    <td>Booking Sales</td>
                    <td>: <input type="text" name="salesbooking" placeholder="Booking Sales" value="${sl.salesBooking}" readonly></td>
                </tr>
            </table><br/><br/>

            <input type="hidden" name="branchid" value="${wk.branchID}">
            <input type="hidden" name="action" value="updatesalesworker">
            <button type="submit" name="submit" onclick="form.action='../../SalesServlet'">UPDATE</button>
        </center>
    </div>
</form>
</body>
</html>
