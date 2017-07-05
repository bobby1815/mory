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
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />
<style type="text/css">
#all1
{
	margin-top: 5%;
}

#b3
{
	margin-top: 30%;
}
.uplo
{
	width: 100%;
	height: auto;
	background-size: contain;
} 
p
{
	text-align: left;
}
#user_id{font-family: 맑은 고딕; font-size: 20px; font-weight: bold;}
#newsfeed_content{border: 2px solid #fdfaf8; margin-top: 5%; background-color: #ffffe9; border-radius: 2%; }
#newsfeed_love{border: 2px solid #fdfaf8;}
#newsfeed_conmmet{border: 2px solid #fdfaf8;}

</style>
<script type="text/javascript">
	function loveclick(write_seq)
	{
		$.post("newsfeedloveclick.do",{write_seq : write_seq}, function(data)
		{
			//alert(data);
			$("#newsfeed_love"+write_seq).html(data).find("#newsfeed_love"+write_seq);
		});
	}
	
	function profile(user_id)
	{
		$.post('commonprofilesearch.do?cust='+user_id, {cust : user_id}, function(data)
		{
			$("#profile").html(data).find("#profile");
		});
	}

</script>

</head>
<body>
		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../main/Mainmenu.jsp" />

		<!-- 	두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1"></div>

			<div class="col-xs-8 col-md-" id="b2">
			<c:forEach var="dto" items="${list }">
				<div id="newsfeed_content" class="col-xs-12 col-md-12" style="text-align: center;">
					<%-- 
					<p id="user_id" onclick="location.href='commonprofilesearch.do?cust=${dto.write_user_id }'" data-toggle="modal" data-target="#myinfo"><img src="" />${dto.write_user_id } </p>
					 --%>
					<p id="user_id" onclick="profile('${dto.write_user_id }')" data-toggle="modal" data-target="#myinfo"><img src="" />${dto.write_user_id } </p>
					<img class="uplo"  src="/newsfeedupload/${dto.uplo_loca }" >
					<p id="newsfeed_love${dto.write_seq }" onclick="loveclick('${dto.write_seq}')"><img src="img/redheart.png" width="20px" />${dto.feed_love_cnt } LOVES</p>
					<p id="newsfeed_content">${dto.write_cont }</p>
					<p id="newsfeed_comment">Commnets</p>
				</div>
			</c:forEach>
			</div>
			
			
			<div class="modal fade" id="myinfo" tabindex="-1" role="dialog"   aria-labelledby="myModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header" style="text-align: center;">
							<div class="modal-body" style="text-align: center;" id="profile">
							
							<img src="/profileupload/${userDTO.profile_location }" style="width: 300px; height: 500px;" ><br>
								이름 : ${userDTO.user_name } <br> 닉네임 : ${userDTO.user_nic}<br>
								배우자 : ${userDTO.acce_user_nic }
							</div>
                   
                     </div>
                  </div>
               </div>
            </div>
			
<%-- 	<div class="modal fade" id="myinfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<c:import url="../Source/Common_Profile.jsp"/>
			</div>
		</div>
	</div>
 
			 --%>
			
			<div class="col-xs-3 col-md-3" id="b3">
			<c:import url="../../tooglebtn.jsp"/> 
			</div>
		
		<!-- 세번째 row  -->
		
		</div>
		
		<c:import url="../../Footer.jsp" />
</body>
</html>