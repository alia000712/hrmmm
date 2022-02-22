<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <link rel="stylesheet" href="adminAddWorker.css">
    <title>Worker</title>
    <style>
        td{
            font-size: 23px;
            color: white;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminWorker.html"%>
<form action="" method="post">
    <div class="register">
        <center>
            <br>
            <div class="exit"><a href="adminWorker.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>NEW WORKER</h1>
            <div class="rectangle"></div><br>
            <table>
                <tr>
                    <td>Worker Name</td>
                    <td>: <input type="text" name="workername" placeholder="Worker Name"></td>
                </tr>
                <tr>
                    <td>Worker IC</td>
                    <td>: <input type="text" name="workeric" placeholder="Worker IC"></td>
                </tr>
                <tr>
                    <td>Worker Phone</td>
                    <td>: <input type="text" name="workerphone" placeholder="Worker Phone"></td>
                </tr>
                <tr>
                    <td>Worker Email</td>
                    <td>: <input type="text" name="workeremail" placeholder="Worker Email"></td>
                </tr>
                <tr>
                    <td>Worker Address</td>
                    <td>: <textarea cols="37" rows="2" name="workeraddress" placeholder="Worker Address"></textarea></td>
                </tr>
                <tr>
                    <td>Branch</td>
                    <td>:
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
            </table><br><br>

            <input type="hidden" name="action" value="register">
            <button type="submit" name="submit" onclick="form.action='../../WorkerServlet'">REGISTER</button>
        </center>
    </div>
</form>
</body>
</html>
