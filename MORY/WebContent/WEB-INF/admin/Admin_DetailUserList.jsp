<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeatilUserList.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <!-- jquery 다운받아서 경로잡고 지정해줘야함 -->
<script src="assets/jquery.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
    a{color:black;}
    .drop-menu{border: 1px solid grey;}
    .drop-menu-top{background: gray; color:white; border: gray;}
    th{background:lightgrey;}
    th, td{padding:5px 0px;  text-align: center; border-bottom: 1px solid grey; border-top: 1px solid grey;}
    a:hover{text-decoration: none;}
    footer a{color:grey; text-decoration: underline;}
</style>

<div class="container">
	<!-- 첫번째 row  -->
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
	                  <img src="img/logo.png" width="100"/>
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



<!-- side부분  -->
<c:import url="/menu/Admin_side-menu.jsp"></c:import>
<!-- 본문시작 부분  -->
<div class="col-xs-12 col-md-9">
		<div class="row" style="border-bottom: 2px solid grey; padding: 20px;">
			<div class="col-xs-3 col-md-3" style="padding: 0px; margin-right: 15px; text-align:right">
				<select class="form-control" style="width:100%;">
					<option>아이디</option>
					<option>이름</option>
					<option>닉네임</option>
					<option>계정 상태</option>
				</select>
			</div>
			<div class="col-xs-3 col-md-3" style="padding: 0px;">
				<input type="text" class="form-control" style="width: 250px;">
			</div>
			<div class="col-xs-3 col-md-1 text-right">
				<button class="btn btn-default">검색</button>
			</div>
			
		</div>
		<div class="row" style="padding: 30px 0px;">
			<table class="col-xs-12 text-center">
				<tr>
					<th class="col-xs-1">No</th>
					<th class="col-xs-2">아이디</th>
					<th class="col-xs-3">생일</th>
					<th class="col-xs-2">전화번호</th>
				</tr>
			<c:if test="${!empty list}">
				 <c:forEach items="${list}" var="list">
					<tr>
						<td>${list.USER_ID}</td>
						<td>${list.USER_BIRTH}</td>
						<td>${list.USER_TEL}</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list}"><td>계정리스트가 없습니다.</c:if>	
			</table>
		</div>
	</div>
	<c:import url="/menu/Admin_Detail.jsp"></c:import>
</div>	
</head>
<body>

</body>
</html>