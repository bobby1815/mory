<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sys.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
<script type="text/javascript">

	function setDetail(blind_cnt, sanc_type_code, blind_sanc_seq)
	{
		$("#blind_cnt").attr("value", blind_cnt);
		$("#sanc_type_code")
		
	}
	
</script>
</head>
<body>

<div class="container">
<!-- 헤더시작  -->
<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2" >
				<div class="col-xs-4 col-md-12"style="text-align: center;">	
					<a href="/userlist.do" style="margin:0px ; color:black;">
	                  <img src="img/Mory_logo.png" width="100"/>
                       <!-- <span style="font-size:30px; text-align: center;"><b>MORY</b></span> -->
                       <img src="img/Mainlogo.png" width="100" />
	                </a>
	            </div>
				
		</div>
				<div class="col-xs-1 col-md-1"  id="h3"></div>
		</div>		



<!--사이드 시작  -->
<c:import url="/menu/Admin_side-menu.jsp"></c:import>
	<!-- 본문시작  -->
	<div class="col-xs-12 col-md-9">
	   <h1>시스템 설정</h1>
			<div class="col-xs-12" style="margin-top:20px; text-align: left;">
					<h3>탈퇴 유예기간 설정</h3>
			</div>
			<form action="systemleavesetup.do?leave_seq=${leave_seq }" method="post">
			<div class="row col-xs-12 col-md-12"style="height: 50px;background-color: lightgray; margin-left: 3px;">
					<div class="col-xs-4 col-md-4">현재 유예기간 <input type="text" class="" style="width:60px; height: 40px;" readonly="readonly" value="${leave_code}">일 </div>
					<div class="col-xs-4 col-md-4">변경 유예기간 <input type="text"style="width:60px; height: 40px;" name="leave_code">일</div>
					<div class="col-xs-3 col-md-3"><button type="submit" style="width:90px;" class="btn btn-default md" >저장</button></div>
			</div>
			</form>
			
			<c:forEach var="dto" items="${blindList }">
			<div class="col-xs-12">
				<c:choose>
					<c:when test="${dto.page_code eq 'N' }">
						<h3 >뉴스피드 블라인드 처리 설정</h3>
					</c:when>
					<c:otherwise>
						<h3 >게시물 블라인드 처리 설정</h3>
					</c:otherwise>
				</c:choose>
				<form action="systemblindsetup.do?page_code=${dto.page_code }&setup_seq=${dto.setup_seq}" method="post" >
					<div class="row col-xs-12 col-md-12"style=" height: 50px;background-color: lightgray;">
						<div class="col-xs-4 col-md-4">신고 횟수<input type="text"style="width:60px; height: 40px; margin-left: 30px;"readonly="readonly" value="${dto.decl_cnt }">건 </div>
						<div class="col-xs-4 col-md-4">변경 횟수<input type="text"style="width:60px; height: 40px; margin-left: 30px;" name="decl_cnt">건</div>
						<div class="col-xs-3 col-md-3"><button type="submit" style="width:90px;" class="btn btn-default md">저장</button></div>
					</div>
				</form>
			</div>
			</c:forEach>
			
			<div class="col-xs-12">
				<h3>상태 설정</h3>
			</div>
		
			<div class="row col-xs-12 col-md-12"style="height: 200px;background-color: lightgray;">
					<div class="col-xs-5 col-md-5">
						<table border="1px;" style="margin-top: 15px;background-color: white;">
							<tr>
								<th>블라인드 피드 수</th>
								<th>계정 상태</th>
							</tr>
							<c:forEach var="dto" items="${blindSanctionList }">
							<tr style="cursor: pointer;" onclick="setDetail('${dto.blind_cnt}','${dto.sanc_type_code }','${dto.blind_sanc_seq }')">
								<td>${ dto.blind_cnt}</td>
								<td>${dto.sanc_type_name}</td>							
							</tr>
							</c:forEach>
						</table>
					</div>
					<div class="col-xs-6 col-md-6">
								블라인드 피드 수 <input type="text" id="blind_cnt" style="width:60px; height: 40px; margin-left: 30px; margin-top:15px;">
					</div>
					
					<div class="row col-xs-6 col-md-6" style="margin-top: 20px;">
						<div class="col-xs-5 col-md-5">계정 상태</div>
						<div class="col-xs-3 col-md-3">
							<select class="form-control" id="sanc_type_code" style="width:150px;">
							<c:forEach var="dto" items="${sanctionList }">
								<option value="${dto.sanc_type_code }">${dto.sanc_type_name}</option>
							</c:forEach>
							</select>
						</div>		
					</div>
					<div class="col-xs-12 col-md-12">
						<div class="col-xs-6 col-md-6"></div>
						<div class="col-xs-2 col-md-2 text-right"> <button class="btn btn-default" style="width: 70px;">추가</button></div>
						<div class="col-xs-2 col-md-2 text-right"> <button class="btn btn-default" style="width: 70px;">수정</button></div>
						<div class="col-xs-2 col-md-2 text-right"> <button class="btn btn-default" style="width: 70px;">삭제</button></div>
					</div>
					

			</div>
	
	</div>
</div>


</body>
</html>