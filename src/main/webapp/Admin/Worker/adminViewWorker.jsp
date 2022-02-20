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
    <title>Worker</title>
    <style>
        .admin-worker{
            margin-left: 20%;
        }
        h1{
            font-size: 40px;
            font-family: "Inter", sans-serif;
        }
        hr{
            border: 1px solid honeydew;
            width: 70%;
            height: 8px;
            background: white;
            border-radius: 30px;
        }
        table{
            text-align: center;
            padding: 20px;
        }
        table tr, td{
            padding: 20px;
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminWorker.html"%>
<div class="admin-worker">
    <center>
        <br><br>
        <h1>MANAGE WORKER</h1>
        <hr>
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>E-MAIL</th>
                <th>PHONE</th>
                <th>ADDRESS</th>
                <th>NO IC</th>
                <th>BRANCH ID</th>
                <th>ACTION</th>
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

                    String sql  ="SELECT w.workerid,w.workername,w.workeremail,w.workeraddress,w.workeric," +
                            "w.branchid,w.workerphone, b.branchname from worker w " +
                            "join branch b on w.branchid=b.branchid where w.workerid not in (0) order by w.workerid";

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
                        <td><%=res.getInt("workerID")%></td>
                        <td><%=res.getString("workerName")%></td>
                        <td><%=res.getString("workerEmail")%></td>
                        <td><%=res.getString("workerPhone")%></td>
                        <td><%=res.getString("workerAddress")%></td>
                        <td><%=res.getString("workerIC")%></td>
                        <td><%=res.getString("branchID")%></td>

                        <form action="" method="post">
                            <input type="hidden" name="workerid" value="<%=res.getInt("workerID")%>">
                            <input type="hidden" name="workername" value="<%=res.getString("workerName")%>">
                            <input type="hidden" name="workeremail" value="<%=res.getString("workerEmail")%>">
                            <input type="hidden" name="workeraddress" value="<%=res.getString("workerAddress")%>">
                            <input type="hidden" name="workeric" value="<%=res.getString("workerIC")%>">
                            <input type="hidden" name="branchid" value="<%=res.getString("branchID")%>">
                            <input type="hidden" name="workerphone" value="<%=res.getString("workerPhone")%>">
                            <input type="hidden" name="branchname" value="<%=res.getString("branchName")%>">
                            <input type="hidden" name="action" value="view">
                            <td><button type="submit" name="submit" onclick="form.action='../../WorkerServlet'" >EDIT</button></td>
                        </form>
                        <form action="" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="workerid" value="<%=res.getInt("workerID")%>">
                            <td><button type="submit" name="submit" onclick="form.action='../../WorkerServlet'" >DELETE</button></td>
                        </form>
                    </tr>
            <%
                        }
                    }
                }
                catch (Exception e) {e.printStackTrace();}
            %>
        </table>
    </center>
</div>
</body>
</html>