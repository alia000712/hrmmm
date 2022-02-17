<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Package</title>
    <link href='https://fonts.googleapis.com/css?family=ABeeZee' rel='stylesheet'>
    <link rel="stylesheet" href="adminViewPackage.css">
</head>
<body>
<%@include file="../../menuHtml/menuAdminPackage.html"%>
<br>
<div class="view">
    <center>
        <br>

        <div class="exit"><a href="adminPackage.jsp">&#9746;</a></div>
        <img src="../../image/logo.png" style="width:150px; height:150px" >
        <h1>MANAGE PACKAGE</h1>
        <div class="rectangle"></div><br>

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
        <form action="" method="post">
            <input name="packageid" value="<%=res.getString("packageid")%>" hidden>
            <input name="packagename" value="<%=res.getString("packagename")%>" hidden>
            <input name="packageprice" value="<%=res.getString("packageprice")%>" hidden>
            <input type="hidden" name="action" value="view">
            <button class="platter"  type="submit" name="submit" onclick="form.action='../../PackageServlet'">
                <div>
                    <div style="font-size: 10px ;color: rgba(255, 255, 255, 0.6);display: flex;flex-direction: column;justify-content: flex-start;align-items: flex-start;">NBARBERSHOP</div><br>
                    <div style="font-size: 23px; color: white; display: flex;flex-direction: column;justify-content: flex-start;align-items: flex-start;">PACKAGE: <%=res.getString("packagename") %></div>
                </div>
            </button>
        </form>
        <br>
        <%
                    }
                }
            }
            catch (Exception e) {e.printStackTrace();}
        %>
        <br>
    </center>
</div>
</body>
</html>
