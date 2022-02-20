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
    <link rel="stylesheet" href="adminEditWorker.css">
    <title>Worker</title>
</head>
<body>
<%@include file="../../menuHtml/menuAdminWorker.html"%>
<form action="" method="post">
    <div class="edit">
        <center>
            <br>
            <div class="exit"><a href="adminWorker.jsp">&#9746;</a></div>
            <img src="../../image/logo.png" style="width:150px; height:150px" >
            <h1>UPDATE WORKER</h1>
            <div class="rectangle"></div><br>
            <input type="number" name="workerid" value="${wk.workerID}" readonly><br><br>
            <input type="text" name="workername" placeholder="Worker Name" value="${wk.workerName}"><br><br>
            <input type="text" name="workeric" placeholder="Worker IC" value="${wk.workerIC}"><br><br>
            <input type="text" name="workerphone" placeholder="Worker Phone" value="${wk.workerPhone}"><br><br>
            <input type="text" name="workeremail" placeholder="Worker Email" value="${wk.workerEmail}"><br><br>
            <input type="text" name="workeraddress" placeholder="Worker Address" value="${wk.workerAddress}"><br><br>

            <select name="branchid">
                <option value="${wk.branchID}">${br.branchName}</option>
                <%
                    try
                    {
                        Class.forName("org.postgresql.Driver"); // ni stay
                        String dbURL = "jdbc:postgresql://ec2-50-19-32-96.compute-1.amazonaws.com:5432/d65mb698aandvt"; //ni url dri heroku database
                        String user = "ffkacpfvbcmcwa"; //ni user dri heroku database
                        String pass = "3939ef811721250f3db1595eb911cfcbac4e294a582158f13f9ef08dc63786bf"; //ni password dri heroku database
                        Connection conn = DriverManager.getConnection(dbURL, user, pass);

                        String sql  ="SELECT * from branch where branchid ('0');";

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
            <input type="hidden" name="action" value="update">
            <button type="submit" name="submit" onclick="form.action='../../WorkerServlet'">UPDATE</button>
        </center>
    </div>
</form>
</body>
</html>
