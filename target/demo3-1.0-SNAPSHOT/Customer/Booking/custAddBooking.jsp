<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" href="custAddBooking.css">
    <style>
        button a{
            text-decoration: none;
            color: white;
        }
        .container-bg{
            background: transparent;
            border-radius: 10px;
            box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
            overflow: hidden;
            width: 80%;
            height: 70%;
            max-width: 100%;
            min-height: 60%;
            position: relative;
        }
    </style>
</head>
<body>
    <%@include file="../../menuHtml/menuCustBooking.html"%>
    <form class="addBooking" method="post" action="">
        <br/><br/>
        <h1>Add new Booking</h1>
        <hr><br><br/>
        <center>
        <div class="container-bg">
            <center><br/><br/><br/>
                <table>
                    <tr>
                        <td>
                            Booking Date
                        </td>
                        <td>
                            : <input class="date" type="date" placeholder="Booking Date" name="bookingdate" required> (Choose at least two days early)
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Booking Time
                        </td>
                        <td>
                            : <input type="time" placeholder="Booking Time" name="bookingtime" required> (Choose from 10.00 am until 8.30 pm only)
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Choose Branch
                        </td>
                        <td>
                            : <select name="branchid" required>
                            <option value="" disabled selected>--Choose Branch--</option>
                            <%
                                try
                                {
                                    Class.forName("org.postgresql.Driver"); // ni stay
                                    String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                                    String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                                    String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                                    Connection conn = DriverManager.getConnection(dbURL, user, pass);

                                    String sql  ="SELECT * from branch where branchid not in ('0');";

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

                            <option value="<%=res.getString("branchid")%>"><%=res.getString("branchName")%></option>
                            <%
                                        }
                                    }
                                }
                                catch (Exception e) {e.printStackTrace();}
                            %>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Choose Package </td>
                        <td>
                            : <select name="packageid" required>
                            <option value="" disabled selected>--Choose Package--</option>
                            <%
                                try
                                {
                                    Class.forName("org.postgresql.Driver"); // ni stay
                                    String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                                    String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                                    String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                                    Connection conn = DriverManager.getConnection(dbURL, user, pass);

                                    String sql  ="SELECT * from package";

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

                            <option value="<%=res.getString("packageid")%>"><%=res.getString("packagename")%></option>
                            <%
                                        }
                                    }
                                }
                                catch (Exception e) {e.printStackTrace();}
                            %>
                        </select>
                        </td>
                    </tr>
                </table>
                <br><br><br>
                <input type="hidden" name="custid" value="${cust.custID}">
                <input type="hidden" name="action" value="addbooking">
                <button type="submit" name="submit" onclick="form.action='../../BookingServlet'">ADD</button>
                <button><a href="custBooking.jsp">CANCEL</a></button>
            </center>
        </div>
        </center>
    </form>
</body>
</html>
