<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 21/2/2022
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BOOKING - RECEIPT</title>
    <style>
        .container{
            border: 5px solid black;
            width: 80%;
            height: 90%;
        }
        h2{
            font-size: 25px;
            margin-top: 0;
        }
        table{
            width: 70%;
        }
        th{
            text-align: center;
            font-size: 20px;
        }
        tr, td, th{
            padding: 10px;
        }
        input{
            border: none;
        }
        button{
            padding: 10px 25px;
            border-radius: 50px;
            color: black;
            background-color: cornflowerblue;
            border: 2px solid cornflowerblue;
            cursor: pointer;
        }
        button a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<center><br/><br/>
    <div class="container">
        <br/>
        <img src="/image/logo1.png" width="10%">
        <h2>N'Barbershop <br> Booking System</h2>
        <table border="1">
            <tr>
                <th colspan="2">CUSTOMER DETAILS</th>
            </tr>
            <tr>
                <td style="text-align: right">USER ID</td>
                <td style="text-align: left">: <input type="text" value="${cust.custID}"  readonly></td>
            </tr>
            <tr>
                <td style="text-align: right">NAME</td>
                <td style="text-align: left">: <input type="text" value="${cust.custName}" readonly></td>
            </tr>
            <tr>
                <td style="text-align: right">CONTACT NO.</td>
                <td style="text-align: left">: <input type="text" value="${cust.custPhone}" readonly></td>
            </tr>
            <tr>
                <th colspan="2">BOOKING DETAILS</th>
            </tr>
            <tr>
                <td style="text-align: right">Booking ID</td>
                <td style="text-align: left">: <input type="text" value="${bk.bookingID}" readonly></td>
            </tr>
            <tr>
                <td style="text-align: right">Booking ID</td>
                <td style="text-align: left">: <input type="text" readonly></td>
            </tr>
            <tr>
                <td style="text-align: right">Booking ID</td>
                <td style="text-align: left">: <input type="text" readonly></td>
            </tr>
            <tr>
                <td style="text-align: right">Booking ID</td>
                <td style="text-align: left">: <input type="text" readonly></td>
            </tr>
        </table><br/><br/>
        <button onclick="window.print()">PRINT</button>
        <button><a href="custViewBooking.jsp">BACK</a> </button>
    </div>
</center>
</body>
</html>
