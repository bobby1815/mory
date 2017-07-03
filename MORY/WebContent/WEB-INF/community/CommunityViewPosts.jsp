<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>





<script type="text/javascript">
	function myFunction(id) {
		var x = document.getElementById(id);
		if (x.className.indexOf("w3-show") == -1) {
			x.className += " w3-show";
		} else {
			x.className = x.className.replace(" w3-show", "");
		}
	}

	/* 모델  */
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModal").modal();
		});
	});

	/* 모델 1 */
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModal1").modal();
		});
	});

	/* 신고하기  */
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModalReport").modal();
		});
	});
	
	$(document).ready(function(){
		$("#reportBtn").click(function(){
			$("#myModalReport").modal('hide');
		});

	});
	
	
	/* 신고하기2  */
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModalReport").modal();
		});
		
	});
	
	
	$(document).ready(function(){
		$("#reportBtn1").click(function(){
			$("#myModalReport1").modal('hide');
		});

	});



	
	/* 신고하기2  */
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModalReport2").modal();
		});
	});
	
	$(document).ready(function(){
		
		$("#report_commit").click(function(){
			location.replace('CommunityMain.jsp');
		})
		
	});
	
	
	function previewImage(targetObj, divPeedPhoto) {

		var preview = document.getElementById(divPeedPhoto); //div id
		var ua = window.navigator.userAgent;

		//ie일때(IE8 이하에서만 작동)

		if (ua.indexOf("MSIE") > -1) {

			targetObj.select();

			try {

				var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)

				var ie_preview_error = document
						.getElementById("ie_preview_error_" + divPeedPhoto);

				if (ie_preview_error) {
					preview.removeChild(ie_preview_error); //error가 있으면 delete
				}

				var img = document.getElementById(divPeedPhoto); //이미지가 뿌려질 곳

				//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
				img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
						+ src + "', sizingMethod='scale')";

			} catch (e) {

				if (!document
						.getElementById("ie_preview_error_" + divPeedPhoto)) {

					var info = document.createElement("<p>");
					info.id = "ie_preview_error_" + divPeedPhoto;
					info.innerHTML = e.name;
					preview.insertBefore(info, null);
				}
			}
			//ie가 아닐때(크롬, 사파리, FF)
		} else {
			var files = targetObj.files;
			for (var i = 0; i < files.length; i++) {
				var file = files[i];
				var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
				if (!file.type.match(imageType))
					continue;
				var prevImg = document.getElementById("prev_" + divPeedPhoto); //이전에 미리보기가 있다면 삭제
				if (prevImg) {
					preview.removeChild(prevImg);
				}

				var img = document.createElement("img");
				img.id = "prev_" + divPeedPhoto;
				img.classList.add("obj");
				img.file = file;
				img.style.width = '30%';
				img.style.height = '30%';
				preview.appendChild(img);

				if (window.FileReader) { // FireFox, Chrome, Opera 확인.
					var reader = new FileReader();
					reader.onloadend = (function(aImg) {
						return function(e) {
							aImg.src = e.target.result;
						};
					})(img);

					reader.readAsDataURL(file);

				} else { // safari is not supported FileReader

					//alert('not supported FileReader');

					if (!document.getElementById("sfr_preview_error_"
							+ divPeedPhoto)) {

						var info = document.createElement("p");

						info.id = "sfr_preview_error_" + divPeedPhoto;

						info.innerHTML = "not supported FileReader";

						preview.insertBefore(info, null);

					}
				}
			}
		}
	}
</script>
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
					style="border: 1px solid; margin-top: 10px; height: 600px;">








					<div class="col-xs-12 col-md-12" style="height: 400px;">


						<div class="col-xs-4 col-md-4"
							style="margin-top: 20px; text-align: center; border: 1px solid;">
							육아 정보</div>
						<div class="col-xs-8 col-md-8"
							style="text-align: left; margin-top: 20px; border: 1px solid;">
							제목 :신생아 한테 좋은 음식</div>




						<div class="col-xs-12 col-md-12"
							style="height: 20px; border: 1px solid;">닉네임 : 용진아빠</div>


						<div class="col-xs-12 col-md-12"
							style="height: 20px; border: 2px solid; margin-top: 5px; height: 350px;">


						</div>

						<div class="col-xs-12 col-md-12"
							style="height: 20px; border: 2px solid; margin-top: 5px; height: 30px;">
							<div class="col-xs-2 col-md-2"
								style="text-align: left; margin-top: 4px;">

								<p>댓글 : 1명</p>



							</div>
							<div class="col-xs-2 col-md-2"
								style="text-align: left; margin-top: 4px;">
								<button type="button" value="사랑해요">
									<span class="glyphicon glyphicon-heart">사랑해요</span>
								</button>
							</div>


							<div class="col-xs-2 col-md-2"
								style="text-align: left; margin-top: 4px;">
								<button type="button" value="신고 하기" data-toggle="modal"
									data-target="#myModalReport">
									<span class="glyphicon glyphicon-bullhorn">신고하기</span>
								</button>
							</div>

							<div class="col-xs-6 col-md-6"
								style="text-align: left; margin-top: 4px;"></div>

						</div>



						<div class="col-xs-9 col-md-9"
							style="border: 1px solid; height: 80px; ">

							<div class="col-xs-3 col-md-3">닉네임:용진</div>

							<div class="col-xs-3 col-md-3">2017.06.19</div>
							
							<div class="col-xs-6 col-md-6"></div>
						</div>
						
						<div class="col-xs-3 col-md-3" style=" height: 80px; text-align: left;">
						
							<button type="button" value="댓글달기" style="height: 80px; width: 205px;">댓글달기</button>
						
						</div>
						
					</div>






















				</div>
				<div class="col-xs-12 col-md-12">
				
						
						<div class="col-xs-6 col-md-6" >
						<button type="button" class="glyphicon glyphicon-chevron-up" style="height: 50px;">다음글</button>
						<button type="button" class="glyphicon glyphicon-chevron-down" style="height: 50px;">이전글</button>
						</div>
						
						<div class="col-xs-6 col-md-6" style="text-align: right;">
						
								<button type="button" class="glyphicon glyphicon-align-justify" style="height: 50px;">목록보기</button>
						</div>
				
				</div>
				
				
			</div>
			<div class="col-xs-1 col-md-1" id="b3" style="margin-top: 500px;">
																		
																		
																		
																		
																		
																	<!-- Acordian Action -->
			<div class="w3-container">
		
				<a onclick="myFunction('Demo1')" style="width: 100px;"
					class="glyphicon glyphicon-plus-sign btn-lg"></a>
				<div id="Demo1" class="w3-container w3-hide">
					<button type="button" class="btn btn-primary " data-toggle="modal"data-target="#myModal">
						<span class="glyphicon glyphicon-user "></span>
					</button>
					<br />
					<button type="button" class="btn btn-primary " data-toggle="modal"
						data-target="#myModal1">
						<span class="glyphicon glyphicon-time"></span>
					</button>
					<br /> <a
						href="http://localhost:8090/Mory/community/CommunityInput.jsp"><span
						class="glyphicon glyphicon-pencil btn-lg"></span></a><br /> <a href=""><span
						class="glyphicon glyphicon-plus btn-lg"></span></a><br />
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





	





	<!--  내정보  -->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">




					<div id="divPeedPhoto"></div>
					<input type="file" name="profile_pt" id="profile_pt"
						onchange="previewImage(this,'divPeedPhoto')"
						style="text-align: center;">
					<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4> -->





				</div>
				<div class="modal-body" style="text-align: center;">
					이름 : 진드래곤 <br> 닉네임 : Jin
				</div>
				<div class="modal-footer ">

					<div class="col-xs-12 col-md-12">
						<div class="col-xs-4 col-md-4" style="text-align: left;">
							<button type="button" value="뉴스피드">뉴스피드</button>
						</div>
						<div class="col-xs-4 col-md-4" style="text-align: center;">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">돌아가기</button>
						</div>
						<div class="col-xs-4 col-md-4" style="text-align: right;">
							<button type="button" value="커뮤니티">커뮤니티</button>
						</div>
					</div>


					<div class="col-xs-12 col-md-12">
						<div class="col-xs-4 col-md-4" style="text-align: left;">
							<button type="button" value="다이어리">다이어리</button>
						</div>
						<div class="col-xs-4 col-md-4"></div>
						<div class="col-xs-4 col-md-4" style="text-align: right;">
							<button type="button" value="개인정보">개인정보</button>
						</div>

					</div>


				</div>
			</div>
		</div>
	</div>





	<!-- 알림 -->



	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">
					<h4>알림</h4>
				</div>
				<div class="modal-body" style="height: 600px;">
					<div class="col-xs-12 col-md-12"
						style="border: 1px solid; height: 50px;">
						<div class="col-xs-3 col-md-3" style="">
							<img src="img/user.PNG" alt=""
								style="height: 45px; margin-right: 800px;" />
						</div>

						<div class="col-xs-6 col-md-6">
							진드래곤<br> 2017
						</div>
						<div class="col-xs-3 col-md-3"
							style="text-align: right; margin-top: 10px;">
							<button type="button" value="수락">수락</button>
							<button type="button" value="거절">거절</button>
						</div>


					</div>

				</div>
				<div class="modal-footer "></div>
			</div>
		</div>
	</div>



























	<div class="modal fade" id="myModalDe" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">
					<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
					삭제 하시겠습니까?
				</div>
				<div class="modal-body" style="text-align: center;">

					<a href=""><button type="button" class="btn btn-default"
							data-dismiss="modal">삭제</button></a>
					<button type="button" class="btn btn-default" data-dismiss="modal">돌아가기</button>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>





	<div class="modal fade" id="myModalReport" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: left:;">
					<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
					신고하기

					<div>제목 : 신생아 에게 좋은 음식</div>

					<div>작성자 : 동언맘</div>
				</div>
				<div class="modal-body" style="height: 200px;">
					신고사유

					<div class="col-xs-12 col-md-12">


						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="영리목적/홍보성" /> 영리목적/홍보성
						</div>

						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="불법정보" /> 불법정보
						</div>

						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="욕설/인신공격" /> 욕설/인신공격
						</div>

					</div>



					<div class="col-xs-12 col-md-12">

						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="음란성/선정성" /> 영리목적/홍보성
						</div>

						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="부적절한콘텐츠" /> 부적절한콘텐츠
						</div>

						<div class="col-xs-4 col-md-4">
							<input type="checkbox" name="check" value="개인정보노출" /> 개인정보노출
						</div>

					</div>

					<div class="col-xs-12 col-md-12">

						<div class="col-xs-12 col-md-12">
							<input type="checkbox" name="check" value="같은내용반복" /> 같은내용반복
						</div>

						<div class="col-xs-12 col-md-12">
							<input type="checkbox" name="check" value="기타" /> 기타


						</div>

						<div class="col-xs-12 col-md-12"
							style="height: 60px; width: 200px;">

							<input type="text" style="height: 70px; width: 200px;" />
						</div>


					</div>


				</div>
				<div class="modal-footer">
					<button type="button" id="reportBtn" class="btn btn-default " value="신고완료" data-toggle="modal"
						data-target="#myModalReport1 ">신고 완료</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>





<!-- 신고 1 -->

<div class="modal fade" id="myModalReport1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">
					<h4>정말로 신고하시겠습니까?</h4>
				</div>
				<div class="modal-body"  style="text-align: center;" >
					
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="button" id="reportBtn1" class="btn btn-default " value="신고완료" data-toggle="modal"data-target="#myModalReport2 ">신고완료</button>
			

				</div>
				<div class="modal-footer "></div>
			</div>
		</div>
	</div>



<!-- 신고 2 -->

<div class="modal fade" id="myModalReport2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- <div class="modal-header" style="text-align: center;">
				
				</div> -->
				<div class="modal-body"  style="text-align: center;" >
					
						<button type="submit" id="report_commit" class="btn btn-default" data-dismiss="modal" data-toggle="modal"data-target="#myModalReport2">신고 완료되었습니다</button>
				</div>
				<!-- <div class="modal-footer "></div> -->
			</div>
		</div>
	</div>










</body>
</html>