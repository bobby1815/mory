<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList.jsp</title>
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

<form action="./adminsearch.do" method="post">
<div class="container">
	<!-- 첫번째 row  -->
	<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2" >
				<div class="col-xs-12col-md-12"style="text-align: center;">	
					<a href="http://localhost:8090/Mory/new/NewSpead.jsp" style="margin:0px ; color:black;">
	                  <img src="./logo.png"width="100"/>
	                    <span style="font-size:30px; text-align: center;"><b>MORY</b></span>
	                </a>
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
				<select class="form-control" style="width:100%;" name="value" id="value1">
					<option value="1">아이디</option>
					<option value="2">이름</option>
					<option value="3">닉네임</option>
					<option value="4">계정 상태</option>
				</select>
			</div>
			<div class="col-xs-3 col-md-3" style="padding: 0px;">
				<input type="text" class="form-control" style="width: 250px;" name="name" id="name">
			</div>
			<div class="col-xs-3 col-md-1 text-right">
				<button class="btn btn-default" type="submit" id="searchBtn">검색</button>
			</div>
			
		</div>
		<div class="row" style="padding: 30px 0px;">
			<table class="col-xs-12 text-center" border="1">
				<tr>
					<th class="col-xs-1 col-md-1">No</th>
					<th class="col-xs-2 col-md-2">아이디</th>
					<th class="col-xs-3 col-md-1">이름</th>
					<th class="col-xs-2 col-md-2"  >닉네임</th>
					<th class="col-xs-2 col-md-2">전화번호</th>
					<th class="col-xs-2 col-md-2">주소</th>
					<th class="col-xs-2 col-md-3">계정상태</th>
				</tr>
				
				<c:forEach   var="result"   items="${result}">
					<c:choose>
						<c:when test="${result >='1'}">
							<tr id="list" style="text-align: center;" onclick="detailsearch('${result.user_Id}')">
								<td>${result.num }</td>
								<td>${result.user_Id }</td>
								<td>${result.user_Name }</td>
								<td>${result.user_Nic }</td>
								<td>${result.user_Tel }</td>
								<td>${result.basic_Addr }</td>
								<td>${result.sanc_Type_Name }</td>
							</tr>
						</c:when>	
						<c:when test="${result=='0'}">
							<tr>
								<td colspan="7">
										<p>조회하신 목록이 없습니다.</p>
								</td>
							<tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- 데이터 상세조회  -->
	<div id="lista" class="row"  style="display: none;">
			<c:import url="/WEB-INF/menu/Admin_Detail.jsp"></c:import>
	</div>
</div>	
</head>
<body>
</form>
</body>
</html>