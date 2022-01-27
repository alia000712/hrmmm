<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sales</title>
    <style>
        .sales
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
<%@include file="../../menuHtml/menuWorkerSales.html"%>
<div class="sales">
    <center>
        <br><br><br>
        <h2>ADD NEW SALES</h2>
        <button><a href="workerAddSales.jsp">ADD</a></button>
        <br><br><br>
        <div class="rectangle"></div><br>
        <h2>VIEW SALES</h2>
        <button><a href="workerViewSales.jsp">VIEW</a></button>
    </center>
</div>
</body>
</html>
