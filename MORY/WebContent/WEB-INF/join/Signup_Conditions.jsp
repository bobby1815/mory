<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conditions.jsp</title>
<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/Mainmenu.css" />

<style type="text/css">
div 
{
	border: 1px solid lightgrey;
}

.btn 
{
	height: 50px;
	width: 100px;
}

textarea 
{
	margin-bottom: 10px;
}
</style>

<!-- jQuery 영역 -->
<script type="text/javascript">

	$(document).ready(function()
	{
		$("#nextBtn").click(function()
		{
			//alert($("#chk1").is(":checked"));
			if ($("#chk1").is(":checked")==false || $("#chk2").is(":checked")==false || $("#chk3").is(":checked")==false)
			{
				alert("모든 약관에 동의하셔야 합니다.");
				return false;
			}
			
			$(location).attr("href","joinformprocess.do");
			
		});
	});

</script>


</head>
<body>



	<div class="container" id="container">
		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../../Mainmenu.jsp" />

		<!-- 	두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1">b1</div>
			<div class="col-xs-10 col-md-10" id="b2">
				<!-- 1번째 area -->
				<div class="row text-center">
					<textarea rows="6" cols="75">약관</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row   col-md-6">
					<input type="checkbox" id="chk1"><label for="chk1">위 약관을 확인 하였고 동의합니다.</label>
				</div>

				<!-- 2번째 area -->
				<div class="row  text-center">
					<textarea rows="6" cols="75">약관</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row col-md-6">
					<input type="checkbox" id="chk2"><label for="chk2">위 약관을 확인 하였고 동의합니다.</label>
				</div>

				<!-- 3번째 area -->
				<div class="row  text-center">
					<textarea rows="6" cols="75">약관</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row col-md-6">
					<input type="checkbox"  id="chk3"><label for="chk3">위 약관을 확인 하였고 동의합니다.</label>
				</div>

				<div class=" col-xs-6 col-md-6 text-center">
					<button type="button" class="btn btn-primary" onclick="location.href='main.do'" id="preBtn">이전</button>
				</div>
				<div class=" col-xs-6col-md-6 text-center">
					<button type="button" class="btn btn-primary" id="nextBtn">다음</button>
				</div>

			</div>
			<div class="col-xs-11 col-md-1" id="b3">b3</div>
		</div>


		<!-- 세번째 row  -->
		<c:import url="../../Footer.jsp" />

	</div>

</body>
</html>