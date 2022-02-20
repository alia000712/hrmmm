<%--
  Created by IntelliJ IDEA.
  User: ALIA
  Date: 21/2/2022
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ABOUT</title>
    <link rel="icon" href="image/logo.png">
    <link rel="stylesheet" href="style.css">
    <style>
        body{
            margin: 0;
            background-color: black;
        }
        h1{
            color: lightblue;
            font-size: 50px;
            padding: 0;
        }
        .bg-content{
            width: 50%;
        }
        .mySlides {display: none;}
        img {vertical-align: middle;}

        /* Slideshow container */
        .slideshow-container {
            max-width: 90%;
            position: relative;
            margin: auto;
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 5px;
            width: 100%;
            text-align: center;
        }

        /* The dots/bullets/indicators */
        .dot {
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        /* Fading animation */
        .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 1.5s;
            animation-name: fade;
            animation-duration: 1.5s;
        }

        @-webkit-keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        @keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {
            .text {font-size: 11px}
        }
        .aboutLast{
            width: 100%;
            height: 100vh;
            background-image: linear-gradient(rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0.75)), url("image/bgAbout.jpg");
            background-size: cover;
            background-position: center;
        }

        .copyright .cr{
            width: 100%;
            padding-top: 5px;
            padding-bottom: 5px;
            font-size: 14px;
            bottom: 0;
            background-color: cornflowerblue;
            position: fixed;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <img src="image/logoName.png" class="logo" id="logo-index">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a class="active" href="about.jsp">About</a></li>
        </ul>
    </div>

    <%------------------------------ background -------------------------------%>
    <br/><br/><br/>
    <center>
        <div class="">
            <h1>Background</h1>
            <hr style="width: 30%"><br>
            <img src="image/img1.jpeg" width="40%">
            <div class="bg-content">
                <p style="justify-content: center; text-align: justify; color: #f2f2f2"><br>
                    N Barbershop was established in 2018 by Hairul Nafeez Bin Fauzi. Previously, while in
                    his studies, he cut and styled his University’s friends' hair as a side job and then realized
                    that it was a skill that needed to be neutered and give attention to. After he completed his
                    studies, he realized that barbershops in his local town were few and decided to open his
                    own barbershop with the money he saved up from his previous side job. He first opened
                    a 6fx9f small barbershop where he works alone. After the barbershop became a hit at his
                    local town, he then upgraded to a permanent shop located in Simpang Yooi, Langkawi
                    Kedah. Because of his skills and well-known across his local town, he has loyal customers
                    from his previous shop and continues to support his business. A year later, because of his
                    success he resumed to expand his business by opening two branches. He did that within
                    a year and a half.
                    Alongside opening branches of his barbershop, he recruited a team to help him in his other
                    branches. He picked people who have passion to cut and style hair and trained them to
                    be in his recruit. Till this day, N Barbershop is still up and running for about 4 years now.
                    They are still going strong and are known by the locals.
                </p>
            </div>
        </div>

        <br/><br/><br/><br/><br/><br/>

        <%------------------------------ team member -------------------------------%>
        <div class="">
            <h1>Team Member</h1>
            <hr style="width: 30%"><br>
            <div class="slideshow-container">
                <div class="mySlides fade">
                    <img src="image/team/harris-modified.png" style="width:30%">
                    <div class="text">Harris</div>
                </div>
                <div class="mySlides fade">
                    <img src="image/team/aniq-modified.png" style="width:30%">
                    <div class="text">Aniq</div>
                </div>
                <div class="mySlides fade">
                    <img src="image/team/firdaus-modified.png" style="width:30%">
                    <div class="text">Firdaus</div>
                </div>

                <div class="mySlides fade">
                    <img src="image/team/alia-modified.png" style="width:30%">
                    <div class="text">Alia</div>
                </div>
                <div class="mySlides fade">
                    <img src="image/team/aila-modified.png" style="width:30%">
                    <div class="text">Aila</div>
                </div>
                <div class="mySlides fade">
                    <img src="image/team/intan-modified.png" style="width:30%">
                    <div class="text">Intan</div>
                </div>

            </div>
            <br>

            <div style="text-align:center">
                <span class="dot"></span>
                <span class="dot"></span>
                <span class="dot"></span>
                <span class="dot"></span>
                <span class="dot"></span>
                <span class="dot"></span>
            </div>

            <script>
                var slideIndex = 0;
                showSlides();

                function showSlides() {
                    var i;
                    var slides = document.getElementsByClassName("mySlides");
                    var dots = document.getElementsByClassName("dot");
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    slideIndex++;
                    if (slideIndex > slides.length) {slideIndex = 1}
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" active", "");
                    }
                    slides[slideIndex-1].style.display = "block";
                    dots[slideIndex-1].className += " active";
                    setTimeout(showSlides, 2000); // Change image every 2 seconds
                }
            </script>
        </div>
    </center>

    <%------------------------------ last part -------------------------------%>
    <div class="aboutLast">
        <div style="width: 100%; display: table; padding-top: 10%">
            <div style="display: table-row; height: 100px;">
                <div style="width: 50%; display: table-cell; background: transparent;">
                    <center>
                        <div style="width: 50%">
                            <img src="image/logoName.png" width="50%"><br>
                            <hr>
                            <p style="justify-content: center; text-align: justify; color: #f2f2f2; line-height: 40px">
                                First and foremost we are grateful to Allah because give us a chance to finished this website.
                                We also would like to thank to our subject ISP551 Lecturer Puan Rosdiana for the valuable
                                guidance and advice. She inspired us greatly to work in this project. We also would like to
                                thank her for showing us some example related to the project.
                            </p>
                        </div>
                    </center>
                </div>
                <div style="display: table-cell; background: transparent;">
                    <center>
                        <div style="width: 50%">
                            <h2 style="color: #f2f2f2">Address</h2>
                            <hr>
                            <p style="justify-content: center; text-align: justify; color: #f2f2f2; line-height: 40px">
                                <span style="font-weight: bold">BRANCH 1</span><br>
                                Mukim Bohor, Simpang Yooi,<br>
                                Jalan Padang Matsirat,<br>
                                07000, Langkawi,<br>
                                Kedah.<br><br>

                                <span style="font-weight: bold">BRANCH 2</span><br>
                                Lot 1210, Bukit Tangga<br>
                                Jalan Titi,<br>
                                07000, Langkawi,<br>
                                Kedah.
                            </p>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    </div>

    <center>
        <div class="copyright">
            <br/><br/><br/>
            <p class="cr" style="color: white; font-size: 18px">Copyright &copy; <script>document.write(new Date().getFullYear());</script>
                N' Barbershop Booking System | Universiti Teknologi MARA (UiTM) Jasin | Team Utara
            </p>
        </div>
    </center>
</body>
</html>
