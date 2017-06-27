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
<link rel="stylesheet" href="../css/Mainmenu.css" />
<style type="text/css">


</style>
</head>
<body>
	<div class="container" id="container">

		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../main/Mainmenu.jsp" />




		<!-- 	두번째 row  -->
		<form action="newspeedlist.do" method="post" enctype="multipart/form-data">
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1">body1</div>

			<div class="col-xs-10 col-md-10" id="b2">
				
			<div>
				<div><p id="user_id" >작성자</p></div>
				<div><p id="photo">사진</p></div>
				<div><p>내용</p></div>
				<div><p>사랑해욧ㅇ</p></div>
				<div><p>댓글염</p></div>
			</div>
			


			</div>

			<div class="col-xs-1 col-md-1" id="b3">body3</div>
		</div>
		</form>





		<!-- 세번째 row  -->
		<c:import url="../../Footer.jsp" />

	</div>
</body>
</html>