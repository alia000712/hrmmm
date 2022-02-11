<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/1/2022
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Account</title>
    <link rel="icon" href="image/logo.png">
    <link rel="stylesheet" href="admin-createAcc.css">
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-in-container">
            <form action="" method="post">
                <img src="image/logo.png" style="width: 30%;">
                <h1>Login: Admin</h1>
                <input type="text" name="adminusername" placeholder="Admin Username" required />
                <input type="password" name="adminpass" placeholder="Password" required /> <br>
                <input type="hidden" name="action" value="login">
                <button type="submit" name="submit" onclick="form.action='AdminServlet'">LOGIN</button><br>
                <button type="button" id="cancel">CANCEL</button><br>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Admin!</h1>
                    <p> Login now and manage your system!</p>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        document.getElementById("cancel").onclick = function ()
        {
            location.href = "index.jsp";
        }
        document.getElementById("login").onclick = function ()
        {
            location.href = "Admin/Home/adminHome.jsp";
        }
    </script>

</body>
</html>
