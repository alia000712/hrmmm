<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.demo3.customer" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" href="custViewBooking.css">
    <style>
        table{
            font-size: 15px;
            width: 80%;
            margin-left: 15%;
        }
        tr, td{
            text-align: center;
            padding-bottom: 10px;
            padding-top: 10px;
        }
        table th{
            border-bottom: 3px solid white;
        }
        button a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuCustBooking.html"%>
<br>
<div class="view">
    <center>
        <br>
        <div class="exit"><a href="custBooking.jsp">&#9746;</a></div>
        <img src="../../image/logo.png" style="width:150px; height:150px" >
        <h1>BOOKING DETAIL</h1>
        <div class="rectangle"></div><br><br>
    </center>

        <table>
            <tr>
                <th>BOOKING ID</th>
                <th>BOOKING DATE</th>
                <th>BOOKING TIME</th>
                <th>PACKAGE ID</th>
                <th>PACKAGE PRICE</th>
                <th>BRANCH ID</th>
                <th>WORKER ID</th>
                <th colspan="2">ACTION</th>
            </tr>
                    <%
                        try
                        {
                            Class.forName("org.postgresql.Driver"); // ni stay
                            String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                            String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                            String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                            Connection conn = DriverManager.getConnection(dbURL, user, pass);

                            customer cust = (customer) session.getAttribute("cust");
                            int custID = cust.getCustID();

                            String sql  ="SELECT b.bookingid,b.branchid,b.custid,b.workerid," +
                                    "b.bookingdate,b.bookingtime,b.packageid, p.packageprice," +
                                    "p.packagename,br.branchname" +
                                    " from booking b join package p " +
                                    "on (b.packageid = p.packageid)" +
                                    "join branch br " +
                                    "on (b.branchid=br.branchid)" +
                                    "where b.custID='"+custID+"' and workerid is null " +
                                    "order by b.bookingid";

                            if (conn != null)
                            {
                                DatabaseMetaData dm = conn.getMetaData();
                                System.out.println("Driver name: " + dm.getDriverName());
                                System.out.println("Driver version: " + dm.getDriverVersion());
                                System.out.println("Product Name: " + dm.getDatabaseProductName());
                                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                                Statement statement = conn.createStatement();
                                ResultSet res = statement.executeQuery(sql);

                                while (res.next())
                                {
                    %>
            <tr>
                <td><%=res.getInt("bookingid")%></td>
                <td><%=res.getDate("bookingdate")%></td>
                <td><%=res.getString("bookingtime")%></td>
                <td><%=res.getString("packageid")%></td>
                <td><%=res.getString("packageprice")%></td>
                <td><%=res.getString("branchid")%></td>
                <td><%=res.getString("workerid")%></td>

                <form action="" method="post">
                    <input name="bookingid" value="<%=res.getInt("bookingid")%>" hidden>
                    <input name="custid" value="<%=res.getInt("custid")%>" hidden>
                    <input name="bookingdate" value="<%=res.getDate("bookingdate")%>" hidden>
                    <input name="bookingtime" value="<%=res.getString("bookingtime")%>" hidden>
                    <input name="packageid" value="<%=res.getString("packageid")%>" hidden>
                    <input name="branchid" value="<%=res.getString("branchid")%>" hidden>
                    <input name="workerid" value="<%=res.getInt("workerid")%>" hidden>
                    <input name="packagename" value="<%=res.getString("packagename")%>" hidden>
                    <input name="branchname" value="<%=res.getString("branchname")%>" hidden>

                    <input type="hidden" name="action" value="viewcust">
                    <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">EDIT</button></td>
                </form>

                <form action="" method="post">
                    <input type="hidden" name="action" value="deletecust">
                    <input type="hidden" name="bookingid" value="<%=res.getInt("bookingid")%>">
                    <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">CANCEL</button></td>
                </form>
            </tr>
                <%
                                }
                            }
                        }
                    catch (Exception e) {e.printStackTrace();}
                %>
        </table>

    <br><br><br>


    <center>
        <h1>ACCEPTED BOOKING DETAIL</h1>
        <div class="rectangle"></div><br><br>
    </center>

    <table>
        <tr>
            <th>BOOKING ID</th>
            <th>BOOKING DATE</th>
            <th>BOOKING TIME</th>
            <th>PACKAGE ID</th>
            <th>PACKAGE PRICE</th>
            <th>BRANCH ID</th>
            <th>WORKER ID</th>
            <th colspan="2">ACTION</th>
        </tr>
        <%
            try
            {
                Class.forName("org.postgresql.Driver");
                String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt";
                String user = "ffkacpfvbcmcwa";
                String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf";
                Connection conn = DriverManager.getConnection(dbURL, user, pass);

                customer cust = (customer) session.getAttribute("cust");
                int custID = cust.getCustID();

                String sql  ="SELECT b.bookingid,b.branchid,b.custid,b.workerid," +
                        "b.bookingdate,b.bookingtime,b.packageid, p.packageprice," +
                        "p.packagename,br.branchname" +
                        " from booking b join package p " +
                        "on (b.packageid = p.packageid)" +
                        "join branch br " +
                        "on (b.branchid=br.branchid)" +
                        "where b.custID='"+custID+"' and workerid is not null";

                if (conn != null)
                {
                    DatabaseMetaData dm = conn.getMetaData();
                    System.out.println("Driver name: " + dm.getDriverName());
                    System.out.println("Driver version: " + dm.getDriverVersion());
                    System.out.println("Product Name: " + dm.getDatabaseProductName());
                    System.out.println("Product version: " + dm.getDatabaseProductVersion());

                    Statement statement = conn.createStatement();
                    ResultSet res = statement.executeQuery(sql);

                    while (res.next())
                    {
        %>
        <tr>
            <td><%=res.getInt("bookingid")%></td>
            <td><%=res.getDate("bookingdate")%></td>
            <td><%=res.getString("bookingtime")%></td>
            <td><%=res.getString("packageid")%></td>
            <td><%=res.getString("packageprice")%></td>
            <td><%=res.getString("branchid")%></td>
            <td><%=res.getString("workerid")%></td>

            <form action="" method="post">
                <input type="hidden" name="action" value="deletecust">
                <input type="hidden" name="bookingid" value="<%=res.getInt("bookingid")%>">
                <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">CANCEL</button></td>
            </form>
            <form action="" method="post">
                <input type="hidden" name="action" value="printcust">
                <input type="hidden" name="bookingid" value="<%=res.getInt("bookingid")%>">
                <input type="hidden" name="bookingdate" value="<%=res.getDate("bookingdate")%>">
                <input type="hidden" name="bookingtime" value="<%=res.getString("bookingtime")%>">
                <input type="hidden" name="packageid" value="<%=res.getString("packageid")%>">
                <input type="hidden" name="packageprice" value="<%=res.getString("packageprice")%>">
                <input type="hidden" name="packagename" value="<%=res.getString("packagename")%>">
                <input type="hidden" name="branchid" value="<%=res.getString("branchid")%>">
                <input type="hidden" name="branchname" value="<%=res.getString("branchname")%>">
                <input type="hidden" name="workerid" value="<%=res.getInt("workerid")%>">
                <input type="hidden" name="custid" value="<%=res.getInt("custid")%>">
                <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">VIEW</button></td>
            </form>
        </tr>
        <%
                    }
                }
            }
            catch (Exception e) {e.printStackTrace();}
        %>
    </table>
</div>
</body>
</html>
