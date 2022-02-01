<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 27/1/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="adminAddWorker.css">
    <title>Worker</title>
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
            <input type="text" name="" placeholder="Worker Name"><br><br>
            <input type="text" name="" placeholder="Worker Username"><br><br>
            <input type="text" name="" placeholder="Worker IC"><br><br>
            <input type="text" name="" placeholder="Worker Email"><br><br>
            <textarea cols="37" rows="2" name="" placeholder="Worker Address"></textarea><br><br>

            <select>
                <option value="" disabled selected>--Choose Branch--</option>
                <option value="SIMPANG YOOI">SIMPANG YOOI</option>
                <option value="MATA AYER I">MATA AYER I</option>
                <option value="MATA AYER II">MATA AYER II</option>
            </select><br><br>
            <button type="submit" value="Register">REGISTER</button>
        </center>
    </div>
</form>
</body>
</html>
