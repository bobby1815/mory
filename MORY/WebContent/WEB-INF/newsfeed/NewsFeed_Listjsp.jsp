<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewsFeed_InputList.jsp</title>
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
					<div>작성자</div>
					<div>사진</div>
					<div>내용</div>
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