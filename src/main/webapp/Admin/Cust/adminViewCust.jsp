<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <style>
        .admin-cust{
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
<%@include file="../../menuHtml/menuAdminCust.html"%>
<div class="admin-cust">
    <center>
        <br><br>
        <h1>MANAGE CUSTOMER</h1>
        <hr>
            <table>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>E-MAIL</th>
                    <th>PHONE</th>
                    <th>ADDRESS</th>
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

                    String sql  ="SELECT * from customer order by custID";

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
                                <td><%=res.getString("custID")%></td>
                                <td><%=res.getString("custName")%></td>
                                <td><%=res.getString("custPhone")%></td>
                                <td><%=res.getString("custEmail")%></td>
                                <td><%=res.getString("custAddress")%></td>
                                <form action="" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="custid" value="<%=res.getString("custID")%>">
                                    <td><button type="submit" name="submit" onclick="form.action='../../CustomerServlet'" >Delete</button></td>
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
