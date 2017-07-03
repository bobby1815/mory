<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 
<link rel="stylesheet" href="css/new.css">
 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


</head>
<style>
/* 	 div {border:1px solid lightgrey;}  */
body{
background-image:url("img/pinkback02.png"); 
    background-size: cover;
}
.
</style>
</head>
<body>
	<div class="container" id="container">
		<header>
			<!-- 첫번째 row  -->
			<div class="row " id="all0">
				<div class="col-xs-1 col-md-1" id="h1"></div>
				<div class="col-xs-10 col-md-10  text-center"
					style="margin-bottom: 30px;" id="h2">
					<h1>
						<img alt="error" src="img/mainimage.png" style="width: 80px;"><img src="img/Mainmory.png" width="100" />
					</h1>
				</div>
				<div class="col-xs-1 col-md-1" id="h3"></div>
			</div>
		</header>
		<form action="loginmain.do" name="form" id="form" method="post">
			<!-- 	두번째 row  -->
			<div class="row " id="all1">
				<div class="col-xs-1 col-md-0" id="b1"></div>

				<!-- Center middle  -->
				<div  class="col-xs-10 col-md-12">
					<div id="moryCarousel" class="col-md-6 carousel slide" data-ride="carousel" data-interval="1500"
						style="height: 500px;">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#b2" data-slide-to="0" class="active"></li>
							<li data-target="#b2" data-slide-to="1"></li>
							<li data-target="#b2" data-slide-to="2"></li>
						</ol>


						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="image/morymain1.jpg" alt="Mory" style=" padding-top:70px; padding-bottom:70px; width: 100%; height: 500px;">
							</div>

							<div class="item">
								<img src="image/test01.png" alt="Hi" style="padding-top:70px; padding-bottom:70px; width: 100%; height: 500px;">
							</div>

							<div class="item">
								<img src="image/morymain11.jpg" alt="love" style="padding-top:70px; padding-bottom:70px; width: 100%; height: 500px;">
							</div>
						</div>


						<!-- Left controls -->
						
					</div>


					<div class="col-md-6 " style="padding: 150px 20px 100px 30px">
						<div class=" col-md-12 text-left">
							<div class="col-xs-12 txt-left">
								<input type="text" placeholder="userName" id="user_id" name="user_id" style="margin-bottom: 10px; width: 300px;" class="form-control">
							</div>
							<div class="col-xs-12  col-md-12text-left">
								<input type="password" placeholder="Password" id="user_pw" name="user_pw"	style="margin-bottom: 10px; width: 300px;" class="form-control">
								<div style="margin-bottom: 10px;">
								로그인 상태 유지<input type="radio">
								</div>
								<button type="submit" class="btn btn-default form-control" style="height: 30px; width: 300px; margin-bottom: 10px;" id="btnLogin">로그인</button>
								<br> <a>아이디/비밀번호가 기억나지 않으세요?</a>
								<button type="button" class="btn btn-default form-control" style="height: 30px; width: 300px; margin-bottom: 10px;" id="btnJoin" onclick="location.href='joinprocess.do'">회원가입</button>
							</div>
						</div>
					</div>
				</div>









				<div class="col-xs-1 col-md-0" id="b3"></div>
			</div>

		</form>

		<footer >
			<!-- 세번째 row  -->
			<div class="row " id="all2" style="height: 60px;">
				<div class="col-xs-1 col-md-0" id="f1"></div>
				<div class="col-xs-10 col-md-12" id="f2" align="middle">
					<div>
						<ul class="list-inline">
							<li><a>Mory정보</a></li>
							<li><a>지원</a></li>
							<li><a>블로그</a></li>
							<li><a>개인정보처리방침</a></li>
							<li><a>홍보센터</a></li>
							<li><a>API</a></li>
							<li><a>약관</a></li>
							<li><a>참여정보</a></li>
						</ul>
					</div>
				</div>
				<div class="col-xs-1 col-md-0" id="f3"></div>
			</div>
		</footer>

	</div>
</body>
</html>