<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  content="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>이웃/기웃/가족</title>

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
</style>

<script type="text/javascript">

	
	$(document).ready(function()
	{
		// 사용자 검색
		$("#userSearch").click(function()
		{
			$.post("searchuser.do",{user_Id:$("#user_id").val(), value : "family"}, function(data)
			{
				$("#userlistTbl > tbody:last").append(data);
			});
		});
	});
	
	
	
	
	// 공유 다이어리 멤버 요청
	function memberinvite(nei_user_id)
	{
		//alert(nei_user_id);
		var value = nei_user_id;
		$.post("/memberinvite.do", {nei_user_id: value}, function(data)
		{
			if (data == 1)
			{
				alert("멤버요청이 완료되었습니다.");
			}
		});
		
	}

</script>

</head>
<body>
<div class="container"  id="container">
   <!--Header  -->   
	<c:import url="../main/Mainmenu.jsp" />    
 <!--Header End--> 
   <!--   Center  --> 
      <div class="row " id="Center">
      
      <!-- Center_left  -->
            <div class="col-xs-1 col-md-1"  id="b1"></div>
            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">                  	
           <div class="col-md-3" id="b2_left" style="width: 25%; height: 700px;  ">
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
          
          <!-- Center middle -->
           <div class="col-md-6" id="b2_center" style="width: 50%; height: 700px;">
          	
          	<div class="col-md-12" style="  margin-top: 10px; width: 100%;" >
          	<div align="middle" style="margin-bottom: 50px;">
          		<img src="img/searchUser.png" align="middle" width="200px" />
          	</div>
          	<div class="col-md-12" style="width: 100%;">
          	<input type="text" name="user_Id" id="user_id" style="width: 60%;" placeholder="search" />
          	<button type="button" class="btn btn-default" id="userSearch" >검색</button>
          	</div>
          	<div class="col-md-12">
          	<table style="width: 100%" id="userlistTbl">
          		<tr></tr>
          	</table>
          	
          	</div>
         	
         	
          	<div class="list-group col col-md-6" style="overflow:scroll; margin-top: 20px; height: 300px;">
          	 	<h1>다이어리멤버</h1>
         	 <ul class="list-group">
         	 <c:forEach var="memberdto" items="${memberlist }">
			    <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/>${memberdto.acce_user_name }</li>
			     </c:forEach>
			  </ul>
          	</div>

			     	
          	<div class="list-group col col-md-6" style="overflow:scroll; margin-top: 20px; height: 300px;">
          	<h1>기웃다이어리</h1>     
          	<ul class="list-group">
          	<c:forEach var="diarylistDTO" items="${shareDiaryList }">
          		<li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/>${diarylistDTO.share_diary_name }</li>
          	</c:forEach>
			   <!-- 
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 장 슬기</li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 구 성민</li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 필용</li>
			   <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/> 김 솔잎 </li>
			    -->
			  </ul>
          	</div>
          	</div>
          	
 
			
           </div>
          
           
         
           
           <!--Center middle End  -->
            </div>

			<!--Center right  -->
            <div class="col-xs-1 col-md-1"  id="b3">
		
			 
			 </div>

<!-- Center_body End -->
      </div>    
      
      
      
      <!-- 세번째 row  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
	</div>
</div>
</body>
</html>