<%--
  Created by IntelliJ IDEA.
  User: Unknown
  Date: 14/1/2022
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Home</title>
    <style>
        .banner{
            margin-left: 20%;
        }
        h1{
            color: white;
            font-size: 50px;
        }
        hr{
            height: 1%;
            width: 50%;
            background: white;
            border-radius: 50px;
        }
        /* Slideshow container */
        .slideshow-container {
            max-width: 55%;
            max-height: 40%;
            position: relative;
            margin: auto;
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* The dots/bullets/indicators */
        .dot {
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.1s ease;
        }

        .active {
            background-color: #717171;
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

        .line-1{
            position: relative;
            top: 50%;
            width: 24em;
            margin: 0 auto;
            border-right: 2px solid rgba(255,255,255,.75);
            font-size: 180%;
            text-align: center;
            white-space: nowrap;
            overflow: hidden;
            transform: translateY(-50%);
        }

        /* Animation */
        .anim-typewriter{
            animation: typewriter 4s steps(44) 1s 1 normal both,
            blinkTextCursor 500ms steps(44) infinite normal;
        }
        @keyframes typewriter{
            from{width: 0;}
            to{width: 24em;}
        }
        @keyframes blinkTextCursor{
            from{border-right-color: rgba(255,255,255,.75);}
            to{border-right-color: transparent;}
        }
    </style>
</head>
<body>
<%@include file="../../menuHtml/menuAdminHome.html"%>
<br/><br/>
<div class="banner">
    <center>
        <h1>NBBS SYSTEM</h1>
        <hr>
    </center>

    <br/><br/>
    <p class="line-1 anim-typewriter">
        Manage and track all changes now! Happy working :)
    </p>

    <div class="slideshow-container">

        <div class="mySlides fade">
            <div class="numbertext">1 / 3</div>
            <img src="https://i.pinimg.com/564x/21/5e/02/215e02ad0298d5d763bae5e74bd5ae0c.jpg" style="width:100%">
        </div>

        <div class="mySlides fade">
            <div class="numbertext">2 / 3</div>
            <img src="https://i.pinimg.com/564x/42/85/31/428531809da0986e374cc37169ccc8ec.jpg" style="width:110%">
        </div>

        <div class="mySlides fade">
            <div class="numbertext">3 / 3</div>
            <img src="https://i.pinimg.com/564x/15/d4/4e/15d44e2bdc1c96f748444de381cf22e1.jpg" style="width:100%">
        </div>
    </div>

    <br/><br/><br/><br/><br/><br/><br/><br/>
    <div style="text-align:center">
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
</body>
</html>
