<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14/1/2022
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Account</title>
    <link rel="icon" href="image/logo.png">
    <link rel="stylesheet" href="cust-createAcc.css">
</head>
<body>
    <div class="container" id="container">
        <div class="form-container sign-up-container">

            <%--form register--%>
            <form action="" method="post">
                <div>
                    <img src="image/logo.png" style="width: 30%;">
                    <h1 style="font-size: 16px"> Customer: Register</h1>
                    <input type="text" name="custname" placeholder="Name" required/>
                    <input type="text" name="custusername" placeholder="Username" required/>
                    <input type="email" name="custemail" placeholder="Email" required/>
                    <input type="password" name="custpass" placeholder="Password" required/>
                    <input type="number" name="custphone" placeholder="Phone" required/>
                    <input type="text" name="custaddress" placeholder="Address" required/>
                    <input type="hidden" name="action" value="signup">
                </div>
                <div>
                    <button type="submit" name="submit" onclick="form.action='CustomerServlet'">REGISTER</button>
                </div>
            </form>
        </div>

        <%--form login--%>
        <div class="form-container sign-in-container">
            <form action="" method="post">
                <div>
                    <div>
                        <img src="image/logo.png" style="width: 30%;">
                        <h1>Customer: Login</h1>
                        <input type="text" name="custusername" placeholder="Username" required/>
                        <input type="password" name="custpass" placeholder="Password" required/> <br>
                        <input type="hidden" name="action" value="login">
                    </div>
                    <button type="submit" name="submit" onclick="form.action='CustomerServlet'">LOGIN</button><br>
                    <button type="button" id="cancel">CANCEL</button><br>
                </div>
            </form>
        </div>


        <%-- overlay animation--%>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>Already have an account? Login now and make your hair flip fabulous!</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Peeps!</h1>
                    <p>Don't have an account yet? Register now for great services!</p>
                    <button class="ghost" id="signUp">REGISTER</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        document.getElementById("login").onclick = function ()
        {
            location.href = "Customer/Home/custHome.jsp";
        }
        document.getElementById("cancel").onclick = function ()
        {
            location.href = "index.jsp";
        }
    </script>
    <script>
        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click', () => {
            container.classList.add("right-panel-active");
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove("right-panel-active");
        });
    </script>
</body>
</html>
