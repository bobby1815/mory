<%@ page  contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <!-- jquery 다운받아서 경로잡고 지정해줘야함 -->
<!-- <script src="assets/jquery.js"></script> -->
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

	function detailSearch(num)
	{
		//alert(num);
		// 커뮤니티 코드 상세조회
		$.post("communitysearch.do",{community_type_code:num},function(data){
			var array = data.split(",");
			$("#community_code").attr("value",array[0]);
			$("#community_name").attr("value",array[1]);
		});
	}	
	
	$(document).ready(function()
	{
		// 신규버튼 클릭
		$("#newBtn").click(function()
		{
			var cnt = $("#communityTbl tr").length;
			var seq = 0;
			$.post("communityseqsearch.do",function(data){
				seq=Number(data)+1;
				$("#communityTbl > tbody:last").append('<tr style="cursor: pointer;"><td>'+cnt+'</td><td>'+seq+'</td><td id="comm_name"></td></tr>');
				$("#community_code").attr("value",seq);
			});
		});
		
		// 커뮤니티명 변경시 td 변경
		$("#community_name").keyup(function()
		{
			$("#comm_name").html($("#community_name").val());
		});
	});

</script>
</head>
<body>

<div class="container">
<!-- 헤더시작  -->
<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2" >
				<div class="col-xs-12col-md-12"style="text-align: center;">	
					<a href="http://localhost:8090/Mory/new/NewSpead.jsp" style="margin:0px ; color:black;">
	                  <img src="img/Mory_logo.png" width="100"/>
                       <!-- <span style="font-size:30px; text-align: center;"><b>MORY</b></span> -->
                       <img src="img/Mainlogo.png" width="100" />
	                </a>
	            </div>
		</div>
				<div class="col-xs-1 col-md-1"  id="h3"></div>
		</div>		



<!--사이드 시작  -->
<c:import url="/menu/Admin_side-menu.jsp"></c:import>
<!-- 본문시작  -->
<div class="col-xs-12 col-md-9">
<h1>커뮤니티 관리</h1>
		<div class="row" style="padding: 30px 0px;">
			<table class="col-xs-12 text-center" id="communityTbl">
				<tr>
					<th class="col-xs-2 col-md-2">No</th>
					<th class="col-xs-5 col-md-5">커뮤니티 코드</th>
					<th class="col-xs-5 col-md-5">커뮤니티 명</th>
				</tr>
			<c:if test="${!empty list}">
				 <c:forEach items="${list}" var="result">
					<tr style="cursor: pointer;" onclick="detailSearch('${result.community_type_code}')">
						<td>${result.num }</td>
						<td>${result.community_type_code}</td>
						<td id="tdid${result.community_type_code}">${result.community_type_name}</td>
					</tr>
				</c:forEach>
				<tbody></tbody>
			</c:if>
			
				
			</table>
		</div>
		
		<div class="col-xs-12 col-md-12">
				<div class="col-xs-6 col-md-6">
					<div class="col-xs-6 col-md-4">
						커뮤니티 코드
					</div>
					<div class="col-xs-4 col-md-3">
						<input type="text" class="form-control" style="width: 200px;" readonly="readonly" id="community_code">
					</div>
				
				</div>
				<div class="col-xs-6 col-md-6">
					<div class="col-xs-6 col-md-4">
						커뮤니티 명
					</div>
					<div class="col-xs-6 col-md-3">
						<input type="text" class="form-control" style="width: 200px; text-align: left;" id="community_name">
					</div>
				
				</div>
				
				
				<div class="col-md-12 text-right">
					<div class="col-md-6"></div>
					<div class="col-md-6" style="margin-top: 60px;">
						<div class="col-xs-3 col-md-3"></div>
						<div class="col-xs-3 col-md-3 text-right"><button class="btn btn-default" style="width: 70px;" id="newBtn" type="button">신규</button></div>
						<div class="col-xs-3 col-md-3 text-right"><button class="btn btn-default" style="width: 70px;">저장</button></div>
						<div class="col-xs-3 col-md-3 text-right"><button class="btn btn-default" style="width: 70px;">취소</button></div>
					</div>
				</div>
		</div>
	</div>
</div>


</body>
</html>