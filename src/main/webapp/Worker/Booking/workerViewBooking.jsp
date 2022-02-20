<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.demo3.customer" %>
<%@ page import="com.demo3.worker" %>
<html>
<head>
    <title>Booking</title>
    <style>
        .workerViewBook{
            margin-left: 25%;
            font-size: 16px;
        }
        h2{
            font-size: 50px;
            margin: 0;
            color: white;
        }
        hr{
            width: 50%;
            height: 1%;
            background: honeydew;
            border-radius: 50px;
            margin: 0;
        }
        table{
            width: 90%;
        }
        table th{
            border-bottom: 3px solid honeydew;
        }
        table tr, td{
            padding-top: 10px;
            padding-bottom: 10px;
        }
        button{
            box-sizing: border-box;
            padding-left: 4%;
            padding-right: 4%;
            padding-top: 2%;
            padding-bottom: 2%;
            box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.25);
            background-color: transparent;
            overflow: hidden;
            border-radius: 50px;
            border: 3px solid white;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%@include file="../../menuHtml/menuWorkerBooking.html"%>

    <div class="workerViewBook">
        <br/><br/>
        <center>
            <h2>CUSTOMERS BOOKING</h2>
            <hr><br/><br/>
        </center>

        <table>
            <tr>
                <th>BOOKING ID</th>
                <th>CUSTOMER ID</th>
                <th>PACKAGE ID</th>
                <th>BOOKING DATE</th>
                <th>BOOKING TIME</th>
                <th>ACTION</th>
            </tr>
            <%
                try
                {
                    Class.forName("org.postgresql.Driver"); // ni stay
                    String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                    String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                    String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                    Connection conn = DriverManager.getConnection(dbURL, user, pass);

                    worker wk = (worker) session.getAttribute("wk");
                    String branchID = wk.getBranchID();

                    String sql  ="SELECT b.bookingid,b.branchid,b.custid,b.workerid," +
                            "b.bookingdate,b.bookingtime,b.packageid," +
                            "p.packagename,br.branchname" +
                            " from booking b join package p " +
                            "on (b.packageid = p.packageid)" +
                            "join branch br " +
                            "on (b.branchid=br.branchid)" +
                            "where b.branchID='"+branchID+"' and b.workerid is null";

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
                <td><%=res.getInt("custid")%></td>
                <td><%=res.getString("packageid")%></td>
                <td><%=res.getDate("bookingdate")%></td>
                <td><%=res.getString("bookingtime")%></td>


                <form action="" method="post">
                    <input name="bookingid" value="<%=res.getInt("bookingid")%>" hidden>
                    <input name="custid" value="<%=res.getInt("custid")%>" hidden>
                    <input name="bookingdate" value="<%=res.getDate("bookingdate")%>" hidden>
                    <input name="bookingtime" value="<%=res.getString("bookingtime")%>" hidden>
                    <input name="packageid" value="<%=res.getString("packageid")%>" hidden>
                    <input name="branchid" value="<%=res.getString("branchid")%>" hidden>
                    <input name="workerid" value="${wk.workerID}" hidden>
                    <input name="packagename" value="<%=res.getString("packagename")%>" hidden>
                    <input name="branchname" value="<%=res.getString("branchname")%>" hidden>

                    <input type="hidden" name="action" value="viewworker">
                    <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">ACCEPT</button></td>
                </form>

                <form action="" method="post">
                    <input type="hidden" name="action" value="deletecust">
                    <input type="hidden" name="bookingid" value="<%=res.getInt("bookingid")%>">
                    <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">DELETE</button></td>
                </form>
            </tr>
            <%
                        }
                    }
                }
                catch (Exception e) {e.printStackTrace();}
            %>
        </table>

        <br/><br/>
        <center>
            <h2>ACCEPTED BOOKING</h2>
            <hr><br/><br/>
        </center>

        <table>
            <tr>
                <th>BOOKING ID</th>
                <th>CUSTOMER ID</th>
                <th>PACKAGE ID</th>
                <th>BOOKING DATE</th>
                <th>BOOKING TIME</th>
                <th>WORKER ID</th>
                <th>ACTION</th>
            </tr>
            <%
                try
                {
                    Class.forName("org.postgresql.Driver"); // ni stay
                    String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                    String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                    String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                    Connection conn = DriverManager.getConnection(dbURL, user, pass);

                    worker wk = (worker) session.getAttribute("wk");
                    String branchID = wk.getBranchID();
                    int workerID = wk.getWorkerID();

                    String sql  ="SELECT b.bookingid,b.branchid,b.custid,b.workerid," +
                            "b.bookingdate,b.bookingtime,b.packageid," +
                            "p.packagename,br.branchname" +
                            " from booking b join package p " +
                            "on (b.packageid = p.packageid)" +
                            "join branch br " +
                            "on (b.branchid=br.branchid)" +
                            "where b.branchID='"+branchID+"' and workerid is not null";

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
                <td><%=res.getInt("custid")%></td>
                <td><%=res.getString("packageid")%></td>
                <td><%=res.getDate("bookingdate")%></td>
                <td><%=res.getString("bookingtime")%></td>
                <td><%=res.getInt("workerid")%></td>


                <form action="" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="bookingid" value="<%=res.getInt("bookingid")%>">
                    <td><button type="submit" name="submit" onclick="form.action='../../BookingServlet'">DELETE</button></td>
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
