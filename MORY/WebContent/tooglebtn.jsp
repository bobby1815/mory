<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" 
  "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<!-- <svg version="1.1" id="blob"xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
<path id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z"/>
</svg>   -->
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link rel="stylesheet" href="../css/acordian.css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">




<style type="text/css">

 /*        body, html {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            background-color:#26394E ;
        } */

       #menu {
            height: 100%;
            position: fixed;
            background-color: #FED057;  
            width: 300px;
            transition: 1000ms all cubic-bezier(0.19, 1, 0.22, 1);
            transform: translateX(-100%);
            left: 60px;
        } 

        #menu.expanded {
            transform: translateX(0%);
            left: 0px;
        }

        .menu-inner {
            width: 100%;
            height: 100%;
            position: relative;
        }

        #blob {
            top: 0;
            z-index: -1;
            right: 60px;
            transform: translateX(100%);
            height: 100%;
            position: absolute;
        }

        #blob-path {
            height: 100%;
            fill:  #FED057;
        }

     /*    .hamburger {
            right: 20px;
            position: absolute;
            width: 20px;
            height: 20px;
            margin-top: -10px;  
        } */

        .hamburger .line {
            width: 100%;
            height: 4px;
             background-color: #fff; 
            position: absolute;
        }

        .hamburger .line:nth-child(2) {
            top: 50%;
            margin-top: -2px;
        }

        .hamburger .line:nth-child(3) {
            bottom: 0;
        }

        h1 {
            position: fixed;
            right: 0;
            margin: 0;
        }

        ul {
            padding: 0;
            list-style: none;
            width: 80%;
            margin-left: 10%;
            position: absolute;
            top: 10px;
        }

        ul li {
             color: #fff; 
            font-family: sans-serif;
            padding: 20px 0;
        }

        nav {
            position: absolute;
           left: 50%;
       color: #fff; 
            margin: 0;
      font-size: 16px;
      font-family: sans-serif;
      font-weight: 100;
        }


</style>

<script type="text/javascript">

$(window).load(function(){
    var height = window.innerHeight,
  x= 0, y= height/2,
    curveX = 10,
    curveY = 0,
    targetX = 0,
    xitteration = 0,
    yitteration = 0,
    menuExpanded = false;
    
    blob = $('#blob'),
    blobPath = $('#blob-path'),

    hamburger = $('.hamburger');

    $(this).on('mousemove', function(e){
        x = e.pageX;
        
        y = e.pageY;
    });

    $('.hamburger, .menu-inner').on('mouseenter', function(){
        $(this).parent().addClass('expanded');
        menuExpanded = true;
    });

    $('.menu-inner').on('mouseleave', function(){
        menuExpanded = false;
        $(this).parent().removeClass('expanded');
    });

    function easeOutExpo(currentIteration, startValue, changeInValue, totalIterations) {
        return changeInValue * (-Math.pow(2, -10 * currentIteration / totalIterations) + 1) + startValue;
    }

    var hoverZone = 150;
    var expandAmount = 20;
    
    function svgCurve() {
        if ((curveX > x-1) && (curveX < x+1)) {
            xitteration = 0;
        } else {
            if (menuExpanded) {
                targetX = 0;
            } else {
                xitteration = 0;
                if (x > hoverZone) {
                    targetX = 0;
                } else {
                    targetX = -(((60+expandAmount)/100)*(x-hoverZone));
                }           
            }
            xitteration++;
        }

        if ((curveY > y-1) && (curveY < y+1)) {
            yitteration = 0;
        } else {
            yitteration = 0;
            yitteration++;  
        }

        curveX = easeOutExpo(xitteration, curveX, targetX-curveX, 100);
        curveY = easeOutExpo(yitteration, curveY, y-curveY, 100);

        var anchorDistance = 200;
        var curviness = anchorDistance - 40;

        var newCurve2 = "M60,"+height+"H0V0h60v"+(curveY-anchorDistance)+"c0,"+curviness+","+curveX+","+curviness+","+curveX+","+anchorDistance+"S60,"+(curveY)+",60,"+(curveY+(anchorDistance*2))+"V"+height+"z";

        blobPath.attr('d', newCurve2);

        blob.width(curveX+60);

        hamburger.css('transform', 'translate('+curveX+'px, '+curveY+'px)');
    
    $('nav').css('transform', 'translateY('+curveY+'px)');
        window.requestAnimationFrame(svgCurve);
    }

    window.requestAnimationFrame(svgCurve);
    
});





</script>


</head>
<body>





<div class="col-xs-1 col-md-1" id="b3">
<nav class="menu">
  <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open"/>
  <label class="menu-open-button" for="menu-open">
 <!--    <span class="hamburger hamburger-1"></span>
    <span class="hamburger hamburger-2"></span>
    <span class="hamburger hamburger-3"></span> -->
  </label>

  <a href="#" class="menu-item"> <i class="fa fa-cog"></i> </a>  
  <a href="newsfeedinsertform.do" class="menu-item"> <i class="fa fa-plus"></i> </a>
  <a href="#" class="menu-item"> <i class="fa fa-heart"></i> </a>
  <a href="#" class="menu-item"> <i class="fa fa-envelope"></i> </a>


</nav>


<!-- filters -->
<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
    <defs>
      <filter id="shadowed-goo">
          
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feGaussianBlur in="goo" stdDeviation="3" result="shadow" />
          <feColorMatrix in="shadow" mode="matrix" values="0 0 0 0 0  0 0 0 0 0  0 0 0 0 0  0 0 0 1 -0.2" result="shadow" />
          <feOffset in="shadow" dx="1" dy="1" result="shadow" />
          <feBlend in2="shadow" in="goo" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
      <filter id="goo">
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
    </defs>
    </svg>
    </div>


















</body>
</html>