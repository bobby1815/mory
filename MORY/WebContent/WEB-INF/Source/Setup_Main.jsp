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
  

<title>Update Profile</title>

<script type="text/javascript">
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/MORY/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/*Modal*/

$(document).ready(function () {

    $('#myModal').modal('show');

});



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
<form action="" id="setup_main" >
<div class="container"  id="container">
      <!--Header  -->   
	<c:import url="../main/Mainmenu.jsp" />    
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
	           	<th id="setup_th"><p onclick="location.href='setprofile.do'">PROFILE</p></th>
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
            <!-- Acordian Action -->
           <div class="w3-container">
           
			<a onclick="myFunction('Demo1')" style="width: 100px; " class="glyphicon glyphicon-plus-sign btn-lg"></a>
			<div id="Demo1" class="w3-container w3-hide">
			  <a href="" style="width: 100px;"  class="glyphicon glyphicon-user btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-time btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-pencil btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-plus btn-lg"></a><br />
			</div>			
			</div>
            
            </div>

           
         
           
        <!--Center End  -->
            </div>



      
      
      
      <!-- 세번째 row  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
 
</div>

<!-- MODAL  -->
<div id="myModal" class="modal fade" role="dialog" >
  <div class="modal-dialog modal-sm"  aria-labelledby="mySmallModalLabel" >

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">회원 정보 입력</h4>
      </div>
      <div class="modal-body">
        	<table>
        		<tr>
        			<th>아이디</th>
        			<td><input type="text" id="user_id" name="user_Id"/></td>
        		</tr>
        		<tr>
        		<th>비밀번호</th>
        			<td><input type="password" id="user_pw" name="user_Pw"/></td>
        		</tr>
           	</table>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-default " data-dismiss="modal" onclick="location.href='userlogin_setmain.do'">본인확인</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">돌아가기</button>
      </div>
    </div>

  </div>
</div>

</form>
</body>
</html>