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
          	<form action="searchuser.do" method="post">
          		
          	<div class="col-md-12" style="width: 100%;">
          	<input type="text" name="user_Id" style="width: 60%;" placeholder="search" />
          	<button type="submit" class="btn btn-default">검색</button>
          	</div>
          	</form>
          	
          	
          	<div class="col-md-12">
          	<table style="width: 100%" >
          		
          		<tbody>
          		<c:forEach var="list" items="${userlist }">
          		<tr>
          		<td><img src="img/1497890377_female-silhouette-sunglasses.png"  width="30px"/></td>
          			<td>${list.user_id }</td>
          			<td style="color:gray;">${list.user_nic }</td>
          			<td><img src="img/neighbor_non.png" width="30px" onclick="location.href='hi.do?nei_user_id=${list.user_id}'"/></td>
          		</tr>
          		
          		</c:forEach>
          		
          		</tbody>
         		
          	</table>
          	</div>
          	
          	</div>
         
          	<div id="Neighbor_other" class="list-group col col-md-6" style="overflow:scroll; margin-top: 20px; height: 300px;">
          	 <div align="middle">
          		<img src="img/hi.png"  width="100px" />
          		</div>
         	 <ul class="list-group" style="margin-top: 10px;">
			   <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/> 박 아영 <img src="img/neighbor_hihey.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/> 김 민혜 <img src="img/neighbor_hihey.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 임 재균  <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 민준 <img src="img/neighbor_hihey.png" width="20px"/></li>
			   <!--  <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 신 지섭 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 진호 <img src="img/neighbor_hihey.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 이 용진 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 이 송현 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 조 원희 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 장 슬기 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 구 성민 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 필용 <img src="img/neighbor_hi.png" width="20px"/></li>
			    <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/> 김 솔잎<img src="img/neighbor_hi.png" width="20px"/> </li>
			    <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 오 동연<img src="img/neighbor_hi.png" width="20px"/> </li> -->
			  </ul>
          	</div>

			     	
          	<div id="Neigher_me" class="list-group col col-md-6" style="overflow:scroll; margin-top: 20px; height: 300px;">
          		<div align="middle">
          		<img src="img/hey.png"  width="100px" />
          		</div>
          	<ul class="list-group" style="margin-top: 10px;">
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 민준 <img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 신 지섭<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 진호<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 이 용진<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 이 송현<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 조 원희<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 장 슬기<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 구 성민<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890656_Man-16.png" alt="" width="30px"/> 김 필용<img src="img/neighbor_hey.png" width="20px"/></li>
			   <li class="list-group-item"><img src="img/1497890377_female-silhouette-sunglasses.png" alt="" width="30px"/> 김 솔잎<img src="img/neighbor_hey.png" width="20px"/> </li>
			  </ul>
          	</div>
          	</div>
          	
          	<!--Center-middle right  -->
          	 <div class="col-md-3" style="width: 25%; height: 700px; ">
           <!-- Acordian Action -->
           
           	 <p class="listTitle">With a label</p>
			<input type="checkbox" class="common" id="switch4" checked="checked" />
			<label for="switch4">Click the label</label>
        
           </div>
          
           
         
           
           <!--Center middle End  -->
            </div>

			<!--Center right  -->
            <div class="col-xs-1 col-md-1"  id="b3">
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

<!-- Center_body End -->
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