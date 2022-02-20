<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" href="workerEditBooking.css">
    <style>
        .container-bg{
            background: transparent;
            border-radius: 10px;
            box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
            overflow: hidden;
            width: 80%;
            height: 77%;
            max-width: 100%;
            min-height: 60%;
            position: relative;
        }
        button:hover{
            color: black;
        }
        button a{
            color: white;
            text-decoration: none;
        }
        button a:hover{
            color: black;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuWorkerBooking.html"%>
<form class="editBooking" method="post" action="">
    <br/><br/>
    <h1>BOOKING DETAILS</h1>
    <hr><br>
    <center>
        <div class="container-bg">
        <table>
            <tr>
                <td>
                    Booking ID
                </td>
                <td>
                    : <input type="text"  name="bookingid" value="${bk.bookingID}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Customer ID
                </td>
                <td>
                    : <input type="text"  name="custid" value="${bk.custID}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Booking Date
                </td>
                <td>
                    : <input class="date" type="date"  name="bookingdate" value="${bk.bookingDate}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Booking Time
                </td>
                <td>
                    : <input type="time"  name="bookingtime" value="${bk.bookingTime}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Branch ID
                </td>
                <td>
                    : <input type="text" name="branchid" value="${bk.branchID}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    Package ID
                </td>
                <td>
                    : <input type="text"  name="packageid" value="${bk.packageID}" readonly>
                </td>
            </tr>
        </table>

        <br><br>
        <input type="hidden" name="workerid" value="${wk.workerID}">
        <input type="hidden" name="action" value="updateworker">
        <button type="submit" name="submit" onclick="form.action='../../BookingServlet'">ACCEPT</button>
        <button><a href="workerViewBooking.jsp">CANCEL</a></button>
        </div>
    </center>

</form>
</body>
</html>
