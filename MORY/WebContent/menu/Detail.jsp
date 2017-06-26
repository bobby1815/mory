<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail.jsp</title>
<!-- jquery 다운받아서 경로잡고 지정해줘야함 -->
<script src="assets/jquery.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
</head>
<body>

<div class="container">
		<div class="col-md-12" style="margin-top: 20px;">
				<div class="col-md-8">
				
						<div class="col-xs-2 col-md-2">아이디</div>
						<div class="col-xs-2 col-md-4"><input type="text" class="form-control" value="데헷"></div>
						<div class="row col-xs-2 col-md-2">이름 : 신지섭 </div>
						<div class="col-xs-2 col-md-4"><input type="text" class="form-control" ></div>
				</div>
				<div class="col-xs-4 col-md-4">
					<div class="col-xs-4 col-md-4">닉네임 </div>
					<div class="col-xs-8 col-md-8"><input type="text" class="form-control" style="width: " readonly="readonly"></div>
				</div>
		</div>
		
		
		<div class="row col-xs-12 col-md-12" style="margin-top: 20px;"> 
		
			<div class="col-xs-8 col-md-8">
				<div class="col-xs-2 col-md-2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주소</div>
				<div class="col-xs-1 col-md-4"><input type="text" class="form-control" style="margin-left: 15px;" readonly="readonly"></div>
				<div class="col-xs-1 col-md-6"><input type="text" class="form-control" style="width: 300px;" readonly="readonly"></div>
			</div>
			
			<div class="col-xs-2 col-md-4" >
					<div class="col-xs-4 col-md-4">닉네임 </div>
					<div class="col-xs-5 col-md-8"><input type="text" class="form-control" style="margin-left: 15px;" readonly="readonly"></div>
				</div>
			
		</div>
		
		<div class="col-xs-12 col-md-12" style="margin-top: 20px;">
				<div class="col-xs-8 col-md-8">
						<div class="col-xs-2 col-md-2">이메일 </div>
						<div class="col-xs-4 col-md-4"><input type="text" class="form-control" style="" readonly="readonly"></div>
						<div class="row col-xs-2 col-md-2">생년월일 </div>
						<div class="col-xs-4 col-md-4"><input type="text" class="form-control" style="" readonly="readonly"></div>
				</div>
				<div class="col-xs-4 col-md-4">
					<div class="col-xs-4 col-md-4">제재상태</div>
					<div class="col-xs-8 col-md-8">
						<select class="form-control">
								<option>3일 정지</option>
								<option>5일 정지</option>
								<option>영구 정지</option>
						</select>
					</div>
				</div>
		</div>
		
		<div class="col-xs-12 col-md-12" style="margin-top: 20px;">
				<div class="col-xs-7 col-md-7">
						<div class="col-xs-2 col-md-7"></div>
						<div class="row col-xs-3  col-md-2">계정상태 </div>
						<div class="col-xs-1 col-md-3">
							<select class="form-control" style="width:210px;">
								<option>3일 정지</option>
								<option>5일 정지</option>
								<option>영구 정지</option>
							</select>
						</div>
				</div>
				<div class="col-xs-5 col-md-5">
					<div class="col-xs-4 col-md-5 text-right" >제재이전상태</div>
					<div class="col-xs-4 col-md-6 text-left">
						<select class="form-control" style="margin-left:25px; width: 190px;">
								<option>활동 중</option>
								<option>회원탈퇴</option>
								<option>탈퇴유예</option>
						</select>
					</div>
				</div>
		</div>
		<div class="row col-xs-12  col-md-12" style="margin-top: 20px;">
			<div class="col-xs-1 col-md-11"></div>
			<div class="col-xs-11 col-md-1"><button class="btn btn-default">변경</button></div>
		</div>
</div>		
</body>
</html>