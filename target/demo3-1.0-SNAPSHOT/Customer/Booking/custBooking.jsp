<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <style>
        .booking
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
            border: none;
            cursor: pointer;
        }
        .rectangle
        {
            height: 10px;
            width: 800px;
            background-color: white;
            border-radius: 50px;
        }

        button a
        {
            text-decoration: none;
            color: pink;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuCustBooking.html"%>
<div class="booking">
    <center>
        <br><br><br>
        <h2>ADD NEW BOOKING</h2>
        <button><a href="custAddBooking.jsp">ADD</a></button>
        <br><br><br>
        <div class="rectangle"></div><br>
        <h2>VIEW BOOKING</h2>
        <button><a href="custViewBooking.jsp">VIEW</a></button>
    </center>
</div>
</body>
</html>
