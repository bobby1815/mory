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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/Mainmenu.css" />
  
   

<title>Update Profile</title>

<script type="text/javascript">


$(document).ready(function () {

    $('#myModal').modal('show');
    
    $("#myBtn").click(function(){
        	remote : "/userloginsetmain.do"
    });

});


</script>
<style type="text/css">
#b3
{
	margin-top: 30%;
}
#container
{
	margin: 0 auto;
}
.modal-header, h4, .close {
    background-color: #5cb85c;
    color:white !important;
    text-align: center;
    font-size: 30px;
}
.modal-footer {
    background-color: #f9f9f9;
}

.setup_icon {
  -webkit-animation: spin 4s infinite linear;
  -o-animation: spin 4s infinite linear;
  -moz-animation: spin 4s infinite linear;
  animation: spin 4s infinite linear;
}
 
@-webkit-keyframes spin {
    0%  {-webkit-transform: rotate(0deg);}
    100% {-webkit-transform: rotate(360deg);}
}
 
@-moz-keyframes spin {
   0%  {-moz-transform: rotate(0deg);}
    100% {-moz-transform: rotate(360deg);}
}
@keyframes spin {
    0%  {transform: rotate(0deg);}
    100% {transform: rotate(360deg);}
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

		<!--Center-middle   -->
            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">
            
          <!--Center -middle left  -->  	
           <div class="col-md-3" id="b2_left" style="width: 25%; height: 700px;">
            <table>
            <tr>
	           	<th id="setup_th">PROFILE</th>
	           </tr>
	           <tr>
	           	<th id="setup_th">COSTUMER CENTER</th>
	           </tr>
	           <tr>
	           	<th id="setup_th">REALATION MANAGEMET</th>
	           </tr>
	           <tr>
	           	<th id="setup_th">REPORT LIST</th>
	           </tr>
	           <tr>
	           	<th id="setup_th">MENUAL</th>
	           </tr>
           </table>
           </div> 
          
          <!--Center middle-middle  -->
           <div class="col-md-6" id="b2_center" style="width: 50%; height: 700px;"  align="middle">
         
           <p><img style="margin-top: 25%; margin-left: 50%;" src="img/1497876788_Settings.png" alt="" class="setup_icon" /></p>
           
            <!--center-middle-middle end  -->
            </div>
        
           <!--b2 center middle right  -->
           <div class="col-md-3" style="width: 25%; height: 700px;">
   
            <!--center-middle right end  -->
           </div>
      
           <!--center-middle end  -->
           </div>
           
			<!--Center right  -->
            <div class="col-xs-1 col-md-1"  id="b3">
            </div>
           
        <!--Center End  -->
            </div>



      
      
      
      <!-- 세번째 row  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
 

 
 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> 본인 확인</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action="/userloginsetmain.do" method="post" >
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> 아이디</label>
              <input type="text" class="form-control" name="user_id" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
              <input type="password" class="form-control" name="user_pw" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>로그인 유지</label>
            </div>
              <button type="submit" id="mybtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 로그인</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
      
    </div>
  </div> 

</div>

	




</body>
</html>