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
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/ckeditor/config.js"></script>
<link rel="stylesheet" href="css/sample.css" />
<title>QnA</title>
<script type="text/javascript">

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

</style>

</head>

<body>
<div class="container"  id="container">
   <!-- header -->
      <div class="row " id="all0">
      <div class="col-xs-1  col-md-1"  id="h1"></div>
      <div class="col-xs-10 col-md-10" id="h2" >
            <div class="col-xs-2 col-md-2">
               <button type="button" value="뉴스피드" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" class="btn btn-primary" >뉴스피드</button>
            </div>
            <div class="col-xs-2 col-md-2">   
               <button type="button" value="다이어리" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" class="btn btn-primary">다이어리</button>
            </div>
            <div class="col-xs-4 col-md-4"style="text-align: center;">   
               <a href="http://localhost:8090/Mory/new/NewSpead.jsp" style="margin:0px ; color:black;">
                     <img src="img/Mory_logo.png" width="100"/>
                       <span style="font-size:30px; text-align: center;"><b>MORY</b></span>
                   </a>
               </div>
               <div class="col-xs-2 col-md-2" style="">    
                   <button type="button" value="커뮤니티" style="margin-top: 26px; margin-left:20px;  height: 40px; width: 100px;" class="btn btn-primary">커뮤니티</button>
               </div>  
               <div class="col-xs-2 col-md-2">
               <button type="button" value="환경설정" style="margin-top: 26px; margin-left:20px; height: 40px; width: 100px;" class="btn btn-primary">환경설정</button>
            </div>
            
      </div>
            <div class="col-xs-1 col-md-1"  id="h3"></div>
</div>       
      
   <!--    Center  --> 
      <div class="row " id="Center">
      
      <!-- Center_left  -->
            <div class="col-xs-1 col-md-1"  id="b1"></div>

		<!--Center-middle   -->
            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">
            
          <!--Center -middle left  -->  	
           <div class="col-md-3" id="b2_left" style="width: 25%; height: 700px; ; ">
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
           <div class="col-md-6" id="b2_center" style="width: 50%; height: 700px; ">
           <textarea class="ckeditor" name="editor1" id="editor1" cols="1" rows="15"></textarea>
           
            <!--center-middle-middle end  -->
            </div>
           <!--b2 center middle right  -->
           <div class="col-md-3" style="width: 25%; height: 700px; background-color: ">
           
           
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
			  <a href="" style="width: 100px;" class="glyphicon glyphicon-user btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-time btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-pencil btn-lg"></a><br />
			  <a href="" class="glyphicon glyphicon-plus btn-lg"></a><br />
			</div>			
			</div>
            
            </div>
	 <!--Center End  -->
     </div>



      
      
      
      <!-- Footer  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
 
</div>

<script>
	CKEDITOR.replace( 'editor1', {
	filebrowserUploadUrl: '/file/ckeditorImageUpload.do'	
	});
</script>



</body>
</html>