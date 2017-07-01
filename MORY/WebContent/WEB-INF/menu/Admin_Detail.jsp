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
<script type="text/javascript">

		function detailsearch(user_Id) 
		{
			$.post("usersearch.do",{user_Id:user_Id},function(data){
				//alert(data);
				var array =data.split(",");
				$("#user_id").attr("value",array[0])
				$("#user_name").attr("value",array[1])
				$("#user_nic").attr("value",array[2])
				$("#user_basic").attr("value",array[3])
				$("#user_detail").attr("value",array[4])
				$("#user_tel").attr("value",array[5])
				$("#user_mail").attr("value",array[6])
				$("#user_birth").attr("value",array[7])
				$("#user_astate").attr("value",array[8])
				$("#user_sstate").attr("value",array[9])
			});
			$("#lista").fadeToggle();	
		}
		
	
</script>
</head>
<body>
<form action="/usermodify.do" method="post" >
<div class="container">
		<div class="col-md-12" style="margin-top: 20px;">
				<div class="col-md-8">
						<div class="col-xs-2 col-md-2" >아이디 </div>
						<div class="col-xs-2 col-md-4"><input type="text" class="form-control" name="id" id="user_id"  readonly="readonly"></div>
						<div class="row col-xs-2 col-md-2">이름 </div>
						<div class="col-xs-2 col-md-4"><input type="text" class="form-control" id="user_name" readonly="readonly"></div>
				</div>
				<div class="col-xs-4 col-md-4">
					<div class="col-xs-4 col-md-4">닉네임 </div>
					<div class="col-xs-8 col-md-8"><input type="text" class="form-control" id="user_nic" name="user_nic"></div>
				</div>
		</div>
		
		
		<div class="row col-xs-12 col-md-12" style="margin-top: 20px;"> 
		
			<div class="col-xs-8 col-md-8">
				<div class="col-xs-2 col-md-2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주소</div>
				<div class="col-xs-1 col-md-4"><input type="text" class="form-control" id="user_basic"  style="margin-left: 15px;" readonly="readonly"></div>
				<div class="col-xs-1 col-md-6"><input type="text" class="form-control" id="user_detail"  style="width: 310px;" readonly="readonly"></div>
			</div>
			
			<div class="col-xs-2 col-md-4" >
					<div class="col-xs-4 col-md-4">전화번호</div>
					<div class="col-xs-5 col-md-8"><input type="text" class="form-control" id="user_tel" style="margin-left: 15px;" readonly="readonly"></div>
				</div>
			
		</div>
		
		<div class="col-xs-12 col-md-12" style="margin-top: 20px;">
				<div class="col-xs-8 col-md-8">
						<div class="col-xs-2 col-md-2">이메일 </div>
						<div class="col-xs-4 col-md-4"><input type="text" class="form-control" id="user_mail" readonly="readonly"></div>
						<div class="row col-xs-2 col-md-2">생년월일 </div>
						<div class="col-xs-4 col-md-4"><input type="text" class="form-control" id="user_birth" readonly="readonly"></div>
				</div>
				<div class="col-xs-4 col-md-4">
					<div class="col-xs-4 col-md-4">제재상태</div>
					<div class="col-xs-8 col-md-8">
						<select class="form-control" name="select" id="select">
								<option value="">제재 없음</option>
								<option value="10">3일 정지</option>
								<option value="20">7일 정지</option>
								<option value="99">영구 정지</option>
						</select>
					</div>
				</div>
		</div>
		
		<div class="col-xs-12 col-md-12" style="margin-top: 20px;">
		<form action="/usermodify.do" method="post" >
				<div class="col-xs-7 col-md-7">
						<div class="col-xs-2 col-md-7"></div>
						<div class="row col-xs-3  col-md-2">계정상태 </div>
						<div class="col-xs-1 col-md-3">
							<input type="text" id="user_astate" class="form-control" readonly="readonly"style="margin-left: 10px;">
						</div>
				</div>
				<div class="col-xs-5 col-md-5">
					<div class="col-xs-4 col-md-5 text-right" >제재이전상태</div>
					<div class="col-xs-4 col-md-6 text-left">
						<input type="text" class="form-control" id="user_sstate" style="margin-left: 25px;" readonly="readonly">
					</div>
				</div>
		</div>
		<div class="row col-xs-12  col-md-12" style="margin-top: 20px;">
			<div class="col-xs-1 col-md-11"></div>
			<div class="col-xs-11 col-md-1"><button class="btn btn-default" type="submit">변경</button>
			</div>
		</div>
</div>		
</form>
</body>
</html>