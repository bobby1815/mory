<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>futter.jsp</title>
<!-- jquery 다운받아서 경로잡고 지정해줘야함 -->
<script src="assets/jquery.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
		function declaration(id) 
		{
			$.post("declarationuser.do",{id:id},function(data)
			{
				var array = data.split(",");
				$("#d_id").attr("value",array[0])
				$("#d_day").attr("value",array[1])
				$("#d_cont").attr("value",array[2])
				$("#d_reason").attr("value",array[3])
				
				
			});
			
			$("#lista").fadeToggle();
		}
</script>
</head>
<body>
<div class="container">
		<div class="col-md-12" style="margin-top: 20px;">
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">신고자</div>
					<div class="col-xs-2 col-md-3"><input type="text" class="form-control"  id="d_id" style="width: 170px; " readonly="readonly"></div>
						
				</div>
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">신고날짜</div>
					<div class="col-xs-2 col-md-3"><input type="text" class="form-control" id="d_day"style="width: 170px;" readonly="readonly"  ></div>
				</div>		
		</div>
		
		<div class="col-md-12" style="margin-top: 20px;">
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">내용</div>
					<div class="col-xs-2 col-md-3"><input type="text" id="d_cont" class="form-control" style="width: 300px; height: 50px;" readonly="readonly" >
					 </div>
				</div>
			
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">신고사유</div>
					<div class="col-xs-2 col-md-3">
						<input type="text" id="d_reason" class="form-control" style="width: 300px; height: 50px;" readonly="readonly">
					</div>
				</div>
		</div>
		
		<div class="col-md-12" style="margin-top: 20px;">
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">취소유형</div>
					<div class="col-xs-2 col-md-3">
							<select class="form-control" style="width: 150px;">
									<option>허유신고</option>
									<option>욕설,비방</option>
							</select>
					</div>
						
				</div>
				<div class="col-md-6">
					<div class="col-xs-1 col-md-3 text-center">취소사유</div>
					<div class="col-xs-2 col-md-3"><input type="text" class="form-control" id="declaration_" style="width: 170px; "></div>
				</div>		
		</div>
		<div class="col-md-12">
				<div class="col-md-10">
				
				</div>
				<div class="col-md-1">
					<button type="submit" class="btn btn-default" style="width: ">변경</button>
				</div>
		
		</div>
</div>
</body>
</html>