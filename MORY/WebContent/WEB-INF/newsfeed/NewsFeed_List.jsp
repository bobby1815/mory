<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewsFeed_InputList.jsp</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />

<style type="text/css">

#b3
{
	margin-top: 30%;
}
.uplo
{
	width: 100%;
	height: auto;
	background-size: contain;
} 
p
{
	text-align: left;
}
</style>
</head>
<body>
		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../main/Mainmenu.jsp" />


 

		<!-- 	두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1"></div>

			<div class="col-xs-8 col-md-" id="b2">
			<c:forEach var="dto" items="${list }">
				<div class="col-xs-12 col-md-12" style="text-align: center;">
					<p id="user_id">${dto.write_user_id } </p>
					<img class="uplo"  src="newsfeedupload/${dto.uplo_loca }" >
					<p>${dto.write_cont }</p>
					<p>${dto.feed_love_cnt }</p>
					<p>댓글염</p>
				</div>
			</c:forEach>

			
			</div>
			<div class="col-xs-3 col-md-3" id="b3">
			<c:import url="../../tooglebtn.jsp"/> 
			</div>
		
		<!-- 세번째 row  -->
		
		</div>
		
		<c:import url="../../Footer.jsp" />
</body>
</html>