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
    <style>
        @import url('https://fonts.googleapis.com/css?family=Source+Code+Pro');
        #parent {
            height: 40px;
            white-space: nowrap;
            overflow: hidden;
            font-family: 'Source Code Pro', monospace;
            font-size: 20px;
            color: rgba(255,255,255,.70);
            position: relative;
        }
        #border {
            border-bottom: solid 3px cornflowerblue;
            position: absolute;
            right: -7px;
            width: 20px;
        }
        /* Animation */
        #parent {
            animation: animated-text 2s steps(30,end) 1s 1 normal both
        }
        #border {
            animation: animated-cursor 600ms steps(30,end) infinite;
        }
        /* text animation */
        @keyframes animated-text{
            from{width: 0;}
            to{width: 555px;}
        }
        /* cursor animations */
        @keyframes animated-cursor{
            from{border-bottom-color: cornflowerblue;}
            to{border-bottom-color: transparent;}
        }
        .copyright .cr{
            padding-top: 5px;
            padding-bottom: 5px;
            font-size: 14px;
            bottom: 0;
            background-color: cornflowerblue;
            position: fixed;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="banner">
        <div class="navbar">
            <img src="image/logoName.png" class="logo" id="logo-index">
            <ul>
                <li><a class="active"  href="index.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
            </ul>
        </div>

        <br/><br/><br/><br/>
        <center>
            <div class="welcome">
                <h3>Welcome To...</h3>
            </div>

            <div class="neon-wrapper">
                <span class="txt">N'Barbershop</span>
            </div>
        </center>

            <div class="booking-system">
                <h3><%= "Booking System" %></h3>
            </div><br><br>

        <center>
            <br/><br/>
            <div id="parent">Life is short. Make each hair flip fabulous!
                <div id="border"></div>
            </div>

            <br/><br/><br/>
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
                                    cursor: pointer;">
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
        </center>

        <center>
            <div class="copyright">
                <br/><br/><br/>
                <p class="cr" style="color: white; font-size: 18px">Copyright &copy; <script>document.write(new Date().getFullYear());</script>
                    N' Barbershop Booking System | Universiti Teknologi MARA (UiTM) Jasin | Team Utara
                </p>
            </div>
        </center>
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
</html>