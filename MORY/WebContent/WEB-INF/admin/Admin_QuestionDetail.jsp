<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">

	function addlist() 
	{
		alert("ddd");
		var url = ""+ques_User_Id;
		$(location).attr('href',url);
		
		
	}

</script>
</head>
<body>


<div class="container"  id="container">
		<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2" >

		<hr style="border:dark;">				
		</div>
				<div class="col-xs-1 col-md-1"  id="h3"></div>
		</div>		

	<!-- 	두번째 row  --> 
		<div class="row " id="all1" >
				<div class="col-xs-1 col-md-1"  id="b1"></div>
				<div class="col-xs-10 col-md-10"  id="b2">
					<!-- 제목 -->
					<div class="col-md-12" style="margin-top: 30px;">
						<div class="col-md-1">
							<input type="text" class="form-control" placeholder="제목" readonly="readonly" style="width:75px;">
						</div>
						<div class="col-md-11">
								<input type="text" class="form-control" value="${ques_Title}">
						</div>
					</div>
					<!-- 작성자  -->
					<div class="row col-md-12">
					
					  <div class="col-md-6">
							<div class="col-md-2">
								<input type="text" class="form-control" placeholder="작성자" readonly="readonly" style="width:73px;">
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control" style="width: 380px;" value="${ques_User_Id}">
							</div>
					   </div>
					   
					   <!-- 작성일  -->
					   <div class="col-md-6"> 
					   		<div class="col-md-2">
								<input type="text" class="form-control" placeholder="작성일" readonly="readonly" style="width:73px;">
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control"style="width: 350px;" value="${ques_Reg_Dtm}" >
							</div>
					   </div>
					</div>
					
					<!-- 답변자  -->
					<div class="row col-md-12">
					  <div class="col-md-6">
							<div class="col-md-2">
								<input type="text" class="form-control" placeholder="답변자" readonly="readonly" style="width:73px;">
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control" style="width: 380px;" value="${answ_User_Id }"  >
							</div>
					   </div>
					   
					   
					   <div class="col-md-6"> 
					   		<div class="col-md-2">
								<input type="text" class="form-control" placeholder="답변일" readonly="readonly" style="width:73px;">
							</div>
							<div class="col-md-10">
								<input type="text" class="form-control"style="width: 350px;" value="${checks }">
							</div>
					   </div>
					</div>
					<div class=" col-md-12">
					
							<div class="col-md-1" style="height: 200px;">
									<input type="text" value="내용"  class="form-control" style="height: 200px; width:80px; text-align: center;">
							</div>
							
							<div class="col-md-11">
									<input type="text"class="form-control" style="height: 200px;" value="${answ_Cont}">
							</div>
					
					</div>
					
					<div class=" col-md-12">
					
							<div class="col-md-1" style="height: 200px;">
									<input type="text" value="답글"  class="form-control" style="height: 200px; width:80px; text-align: center;">
							</div>
							
							<div class="col-md-11">
									<input type="text"class="form-control" style="height: 200px;" value="${ques_Cont}">
							</div>
					
					</div>
					<div class="row col-md-12" style="margin-top: 30px;">
							<div class="col-md-8"></div>
							<div class="col-md-4">
								<div class="col-md-4"></div>
								<div class="col-md-4">
									<button class="btn btn-info btn-lg" onclick="addlist('${ques_User_Id}')">저장</button>
								</div>
								<div class="col-md-4">
									<a href="/question.do"><button class="btn btn-info btn-lg">취소</button></a>
								</div>	
							</div>
					</div>
				
				</div>
				
				<div class="col-xs-11 col-md-1"  id="b3"></div>
		</div>	 
		
		<!-- 세번째 row  -->
		<div class="row " id="all2">
				<div class="col-xs-1 col-md-1"  id="f1"></div>
				<div class="col-xs-10 col-md-10"  id="f2">
				</div>
				<div class="col-xs-1 col-md-1"  id="f3"></div>
		</div>		
 
</div>

</body>
</html>