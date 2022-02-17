<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>nbbs</title>
    <link rel="icon" href="image/logo.png">
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Merienda&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="banner">
        <div class="navbar">
            <img src="image/logoName.png" class="logo" id="logo-index">
            <ul>
                <li><a class="active" href="index.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
        </div>

            <div class="welcome">
                <h3>Welcome To...</h3>
            </div>

            <div class="neon-wrapper">
                <span class="txt">N'Barbershop</span>
            </div>

            <div class="booking-system">
                <h3><%= "Booking System" %></h3>
            </div><br><br>

            <div class="content">
                <p style="text-align: center; color: white; "> LIFE IS SHORT. <br> </p>
                <p style="text-align: center; color: white; "> MAKE EACH HAIR FLIP FABULOUS</p>
            </div><br><br/>


        <div>
            <button type="button" id="customer" style="width: 200px;
                                    padding: 15px 0;
                                    text-align: center;
                                    margin: 20px 10px;
                                    border-radius: 25px;
                                    font-weight: bold;
                                    border: 2px solid cornflowerblue;
                                    background: transparent;
                                    color: white;
                                    cursor: pointer;
                                    margin-left: 450px">
            CUSTOMER</button>
            <button type="button" id="worker" style="width: 200px;
                                    padding: 15px 0;
                                    text-align: center;
                                    margin: 20px 10px;
                                    border-radius: 25px;
                                    font-weight: bold;
                                    border: 2px solid cornflowerblue;
                                    background: transparent;
                                    color: white;
                                    cursor: pointer;" >
            WORKER</button>
            <button type="button" id="admin" style="width: 200px;
                                    padding: 15px 0;
                                    text-align: center;
                                    margin: 20px 10px;
                                    border-radius: 25px;
                                    font-weight: bold;
                                    border: 2px solid cornflowerblue;
                                    background: transparent;
                                    color: white;
                                    cursor: pointer;">
            ADMIN</button>
        </div>
    </div>
    <script type="text/javascript">
        document.getElementById("logo-index").onclick = function ()
        {
            location.href = "index.jsp";
        }
        document.getElementById("customer").onclick = function ()
        {
            location.href = "cust-createAcc.jsp";
        }
        document.getElementById("worker").onclick = function ()
        {
            location.href = "worker-createAcc.jsp";
        }
        document.getElementById("admin").onclick = function ()
        {
            location.href = "admin-createAcc.jsp";
        }
    </script>
</body>
</html>booking