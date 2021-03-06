<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />

<title>고객 센터</title>

<script type="text/javascript">
function goPopup(){


function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

</script>
<style type="text/css">
table.type07 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border: 1px solid #ccc;
    margin: 20px 10px;
}
table.type07 thead {
    border-right: 1px solid #ccc;
    border-left: 1px solid #ccc;
    background: #e7708d;
}
table.type07 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
}
table.type07 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #fcf1f4;
}
table.type07 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
#setup_th
{
width: 200px;
	height: 80px;
	font-size: 25px;
	font-weight: bold;
	font-family: 맑은고딕; 
}

#setup_th:HOVER {
		color: lightpink;
	
}

#fna:HOVER {
	background-color: lightpink;
	font-family: 맑은고딕;
	font-weight: bold;
}
#b3
{
	margin-top: 30%;
}
</style>

</head>
<body>
<c:import url="../main/Mainmenu.jsp" /> 
<div class="container"  id="container">
     <!--Header  -->   
	   
 <!--Header End-->   
      
   <!--    Center  --> 
      <div class="row " id="Center">
      
      <!-- Center_left  -->
            <div class="col-xs-1 col-md-1"  id="b1"></div>


            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">
            
            	<!--Center_middle_left  -->	
           <div class="col-md-3" id="b2_left" style="width: 25%; height: 700px; ">
      <table>
            <tr>
	           	<th id="setup_th"><p onclick="location.href='commonprofilesearch.do?type=modify'">PROFILE</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setcscenter.do'">COSTUMER CENTER</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setrhmanagement.do'">REALATION MANAGEMET</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setreportlist.do'">REPORT LIST</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setmenual.do'">MENUAL</p></th>
	           </tr>
           </table>
           	<!--Center_middle_left end  -->
           </div> 
          
          <!-- Center middle_header -->
           <div class="col-md-6" id="b2_center" style="width: 50%; height: 700px; ">
          
          	<div class="col-md-12" style=" margin-top: 50px;" align="middle" >
          		<h2 style="text-align: center;"> Customer Service Center</h2>
          		<img src="img/1497870225_22.png" alt="ㅎㅇ" >
          
          	</div>
          	
          	
          	
         	<!--Center-middle-div1  -->
          	<div id="fna" class="col-md-4" style="margin-top: 20px;">
          	
          	<img src="img/1497870494_qna.png" alt="" onclick="location.href='setcsqna.do'"/>
          	<h6>1:1 문의</h6>
          	
          
          	</div>
          	
          	<!--Center-middle-div2  -->
          	<div id="fna"  class="col-md-4" style="margin-top: 20px; ">          
          <img  src="img/1497870209_icon-ios7-people.png" alt="" onclick="location.href='setcsfna.do'" />
          	<h6>자주하는질문</h6>
          
          	</div>
          	<!--Center-middle-div3  -->
          	<div id="fna" class="col-md-4" style="margin-top: 20px;">
          	
          		<img src="img/1497870614_List.png" alt="" onclick="location.href='setcsmyqna.do'"/>
          	<h6>내 문의내역	</h6>
          
          	</div>
          	
          	<!--Center-body end  -->
          </div>
          
          
           <div class="col-md-3" style="width: 25%; height: 700px;">
           <!-- Acordian Action -->
           
           </div>
           
         
         </div>  
         	<!--Center right  -->
            <div class="col-xs-1 col-md-1"  id="b3">
			<c:import url="../../tooglebtn.jsp"/> 
			</div>
			
			</div>
			<!-- Center_body End -->
			</div>
           <!--Center body End  -->
        </div>

		



      
      
      
      <!-- 세번째 row  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
</div>
</body>
</html>