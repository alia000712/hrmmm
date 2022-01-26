<%--
  Created by IntelliJ IDEA.
  User: Unknown
  Date: 13/1/2022
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driver = "org.postgresql.Driver";
    String connectionUrl = "jdbc:postgresql://ec2-3-216-113-109.compute-1.amazonaws.com:5432/d2588ossjegiv9";
    String userid = "onjnznphtpvlzb";
    String password = "ff8e836fb7a630d275b8e9109cb04b91a5fd0937b959cfa509cc007809d6d1b7";
    try
    {
        Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>



<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=ABeeZee' rel='stylesheet'>
    <link rel="stylesheet" href="ViewBranch.css">
    <title>Manage Branch</title>
</head>
<body>
<%@include file="../../menuHtml/menuAdminBranch.html"%>
<br>
<form action="" method="">
    <div class="view">
        <center>
            <br>
            <div class="exit"><a href="branch.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>MANAGE BRANCH</h1>
            <div class="rectangle"></div><br>

            <%
                try
                {
                    connection = DriverManager.getConnection(connectionUrl, userid, password);
                    statement=connection.createStatement();
                    String sql ="select * from branch";
                    resultSet = statement.executeQuery(sql);

                    while(resultSet.next())
                    {
            %>



            <a href="EditBranch.jsp">
                <div class="platter">
                    <div style="font-size: 10px ;color: rgba(255, 255, 255, 0.6)">NBARBERSHOP</div><br>
                    <div style="font-size: 23px">BRANCH</div>
                    <div style="font-size: 30px"><%=resultSet.getString("branchName") %></div>
                </div>
            </a><br>

            <%
                    }
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>

        </center>
    </div>
</form>
</body>
</html>
