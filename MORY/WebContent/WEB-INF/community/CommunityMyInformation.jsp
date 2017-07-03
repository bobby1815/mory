<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<!-- 아코디언  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- 아이콘  -->



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	
	
	
	<!-- 유저 얼굴 -->


<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




<!-- 알림 -->


<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




<!-- 작성 -->


 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<!-- 회전목마 -->


 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Layout.jsp</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/new.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<style type="text/css">
/*   div{border:1px solid gray;}   */


#img
{
  
	height: 200px;
	background-image: url('img/건강한아기1.jpg'),url('img/보기 좋다.jpg'),url('img/하트.jpg');
	background-size: contain;
	
}




.modal-header, h4, .close 
{
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer 
  {
      background-color: #f9f9f9;
  }





</style>




<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="../main/Mainmenu.jsp" /> 
	<div class="container" id="container">
		<!-- 첫번째 row  -->
	


		<!-- 	두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1">b1</div>
			<div class="col-xs-10 col-md-10" id="b2">

				<div class="col-xs-12 col-md-12"
					style="height: 50px; border: 3px solid lightgray;">

					<div class="col-xs-6 col-md-6" style="margin-top: 15px;">
						<div class="col-xs-6 col-md-6">공지사항</div>
						<div class="col-xs-6 col-md-6">육아정보</div>
					</div>
					<div class="col-xs-6 col-md-6" style="margin-top: 15px;">
						<div class="col-xs-6 col-md-6" style="text-align: right;">
							초보육아Q&A</div>
						<div class="col-xs-6 col-md-6" style="text-align: right;">
							육아건강</div>

					</div>
				</div>

				<div class="col-xs-12 col-md-12" style="height: 1200px;border: 1px solid lightgray; margin-top: 7px; ">
				
								<div  class="col-xs-12 col-md-12">
								
									
									<div  class="col-xs-12 col-md-12 container " style=" height: 200px; margin-top: 10px;">
									
										
									
									
									<div id="myCarousel" class="carousel slide" data-ride="carousel">
								    <!-- Indicators -->
								    <ol class="carousel-indicators">
								      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								      <li data-target="#myCarousel" data-slide-to="1"></li>
								      <li data-target="#myCarousel" data-slide-to="2"></li>
								    </ol>
								
								    <!-- Wrapper for slides -->
								    <div class="carousel-inner">
								
								      <div class="item active">
								        <img src="img/건강한아기1.jpg" id="img" alt="Los Angeles" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>건강한 아기</h3>
								          <p>건강 애기</p>
								        </div>
								      </div>
								
								      <div class="item">
								        <img src="img/보기 좋다.jpg" id="img" alt="Chicago" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>보기좋디</h3>
								          <p>좋아</p>
								        </div>
								      </div>
								    
								      <div class="item">
								        <img src="img/하트.jpg" id="img" alt="New York" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>하트</h3>
								          <p>사랑이다.</p>
								        </div>
								      </div>
								  
								    </div>
								
								    <!-- Left and right controls -->
								    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
								      <span class="glyphicon glyphicon-chevron-left"></span>
								      <span class="sr-only">Previous</span>
								    </a>
								    <a class="right carousel-control" href="#myCarousel" data-slide="next">
								      <span class="glyphicon glyphicon-chevron-right"></span>
								      <span class="sr-only">Next</span>
								    </a>
								  </div>
								</div>								
						</div>	
					<div class="col-xs-12 col-md-12"
						style="border: 1px solid lightgray; height: 30px; margin-top: 10px; text-align: center;">
						공지사항</div>

					<div class="col-xs-12 col-md-12"
						style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>

						<div class="col-xs-2 col-md-2"
							style="margin-top: 50px; text-align: center;">
							<button type="button" value="더보기" style="width: 80px;">더보기</button>
						</div>

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>

					</div>

					<div class="col-xs-12 col-md-12"
						style="border: 1px solid lightgray; height: 30px; margin-top: 10px; text-align: center;">
						육아 정보</div>

					<div class="col-xs-12 col-md-12"
						style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>

						<div class="col-xs-2 col-md-2"
							style="margin-top: 50px; text-align: center;">
							<button type="button" value="더보기" style="width: 80px;">더보기</button>
						</div>

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>
					</div>

					<div class="col-xs-12 col-md-12"
						style="border: 1px solid lightgray; height: 30px; margin-top: 10px; text-align: center;">
						초보육아Q&A</div>



					<div class="col-xs-12 col-md-12"
						style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>

						<div class="col-xs-2 col-md-2"
							style="margin-top: 50px; text-align: center;">
							<button type="button" value="더보기" style="width: 80px;">더보기</button>
						</div>

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>
					</div>
					<div class="col-xs-12 col-md-12"
						style="border: 1px solid lightgray; height: 30px; margin-top: 10px; text-align: center;">
						육아 건강</div>

					<div class="col-xs-12 col-md-12"
						style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>

						<div class="col-xs-2 col-md-2"
							style="margin-top: 50px; text-align: center;">
							<button type="button" value="더보기" style="width: 80px;">더보기</button>
						</div>

						<div class="col-xs-5 col-md-5"
							style="height: 100px; border: 1px solid lightgray; margin-top: 20px;">

						</div>
					</div>






					<div class="col-xs-12 col-md-12"
						style="height: 40px; border: 1px solid lightgray; margin-top: 100px;">


						<div class="col-xs-3 col-md-3">
							<select nama="name"
								style="height: 30px; margin-top: 5px; margin-left: 115px;">
								<option value="닉네임">닉네임</option>
								<option value="내용">내용</option>
								<option value="제목+내용">제목+내용</option>
							</select>
						</div>
						<div class="col-xs-6 col-md-6"
							style="height: 30px; border: 1px solid lightgray; margin-top: 5px;">

						</div>

						<div class="col-xs-3 col-md-3"
							style="margin-top: 5px; text-align: left">
							<button type="button" value="검색"
								style="height: 30px; width: 50px; margin-right: 150px;">검색</button>
						</div>


					</div>





				</div>





			</div>


			<div class="col-xs-1 col-md-1" id="b3">


				<div class="container" style="margin-top: 800px;">


					

						
					<div id="collapse1" class="panel-collapse collapse" >
						<ul>
							<li>   
							
							
						
					
							
							
							
							
							
							</li>
							<li><a href="#"><span class="glyphicon glyphicon-exclamation-sign"></span></a></li>
							<li> <a href="#"><span class="glyphicon glyphicon-pencil"></span></a></li>
							
						</ul>

					</div>
				</div>
			</div>
		</div>
		<!-- 세번째 row  -->
		<div class="row " id="all2">
			<div class="col-xs-1 col-md-1" id="f1">f1</div>
			<div class="col-xs-10 col-md-10" id="f2">f2</div>
			<div class="col-xs-1 col-md-1" id="f3">f3</div>
		</div>


	</div>




</body>
</html>