<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Sales</title>
    <link rel="stylesheet" href="adminAddSales.css">
</head>
<body>
<%@include file="../../menuHtml/menuAdminSales.html"%>
<br>
<form action="" method="post">
    <div class="addsales">
        <center>
            <br>
            <div class="exit"><a href="adminSales.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>ADD SALES</h1>
            <div class="rectangle"></div><br>
            <input type="hidden" name="adminid" value="${adm.adminID}">
            <input type="date" name="salesdate" placeholder="Sales Date"><br><br>
            <input type="text" name="saleswalkin" placeholder="Walkin Sales"><br><br>
            <input type="text" name="salesbooking" placeholder="Booking Sales"><br><br>

            <select name="branchid">
                <option value="" disabled selected>--Choose Branch--</option>

                <%
                    try
                    {
                        Class.forName("org.postgresql.Driver"); // ni stay
                        String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                        String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                        String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                        Connection conn = DriverManager.getConnection(dbURL, user, pass);

                        String sql  ="SELECT * from branch";

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
            </select><br><br>
            <input type="hidden" name="action" value="addsalesadmin">
            <button type="submit" name="submit" onclick="form.action='../../SalesServlet'">ADD</button>
        </center>
    </div>
</form>
</body>
</html>
