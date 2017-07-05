<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />

<title>프로필 수정</title>
<script type="text/javascript">
   function previewImage(targetObj, divPeedPhoto)
   {
   
      var preview = document.getElementById(divPeedPhoto); //div id
      var ua = window.navigator.userAgent;

      //ie일때(IE8 이하에서만 작동)

      if (ua.indexOf("MSIE") > -1) {

         targetObj.select();

         try {

            var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)

            var ie_preview_error = document.getElementById("ie_preview_error_" + divPeedPhoto);

            if (ie_preview_error) {
               preview.removeChild(ie_preview_error); //error가 있으면 delete
            }

            var img = document.getElementById(divPeedPhoto); //이미지가 뿌려질 곳

            //이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src + "', sizingMethod='scale')";

         } catch (e) {

            if (!document.getElementById("ie_preview_error_" + divPeedPhoto)) {

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
            img.style.width = '100%';
            img.style.height = '100%';
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

               if (!document.getElementById("sfr_preview_error_" + divPeedPhoto)) {

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
<script type="text/javascript">

	$(document).ready(function()
	{
		// 회원가입 버튼클릭
		$("#joinBtn").click(function() {
				$("#form").submit();
		});
	});

</script>

<script type="text/javascript">
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/jusopopup.do","pop","width=570,height=320, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
        roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
        detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
        buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {

	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
  document.form.roadFullAddr.value = roadFullAddr;
      document.form.basic_addr.value = roadAddrPart1;
      document.form.roadAddrPart2.value = roadAddrPart2;
      document.form.detail_addr.value = addrDetail;
      document.form.zipcode.value = zipNo;
      document.form.siNm.value = siNm;
      document.form.sggNm.value = sggNm;
      
	
}


function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

</script>
<style type="text/css">
#b3
{
	margin-top: 30%;
}

#setup_th
{
width: 200px;
	height: 80px;
	font-size: 25px;
	font-weight: bold;
	font-family: 맑은고딕; 
}

#setup_th:HOVER {
		color: lightpink;
	
}
</style>

</head>
<body>
<c:import url="../main/Mainmenu.jsp" /> 
<div class="container"  id="container">
      <!--Header  -->   
	   
 <!--Header End-->      
      
   <!--    Center --> 
      <div class="row " id="Center" style="margin-top: 20px;">
      
      <!-- Center_left  -->
            <div class="col-xs-1 col-md-1"  id="b1">
              <div class="col-md-3" id="b2_left" style="width: 25%; height: 700px; ">
        <table>
            <tr>
	           	<th id="setup_th"><p onclick="location.href='commonprofilesearch.do?type=modify'">PROFILE</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setcscenter.do'">COSTUMER CENTER</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setrhmanagement.do'">REALATION MANAGEMET</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setreportlist.do'">REPORT LIST</p></th>
	           </tr>
	           <tr>
	           	<th id="setup_th"><p onclick="location.href='setmenual.do'">MENUAL</p></th>
	           </tr>
           </table>
           </div> 
          
            </div>
            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">
            	
         <!--Cet  -->
		<form action="commonprofileset.do" id="form" name="form" method="post" enctype="multipart/form-data">

			<!-- 	두번째 row  -->
			<div class="row " id="callBackDiv">
				<div class="col-xs-1 col-md-1" id="b1">b1</div>
				<div class="col-xs-10 col-md-10 text-center" id="b2">
					<div class="row">
						<div id="divPeedPhoto" style="widows: 300px;"></div>
							<img src="/profileupload/${userDTO.profile_location }" style="width: 300px;" >
				        <input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')"style="text-align: center;">
				        </div>
			        </div>

					<!-- 아이디div  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right"><h5>아이디</h5></div>
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control" id="user_id" name="user_id" disabled="disabled" placeholder="아이디를 입력해주세요." value="${userDTO.user_id }"> 
								<span	class="input-group-btn">
									<button type="button" class="btn btn-info" id="idCheck" disabled="disabled">중복확인</button>
								</span>
								
							</div>
							<p id="idchk" style="display: inline;"></p>
						</div>
					</div>

					<!-- 닉네임div  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right"><h5>닉네임</h5></div>
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control" id="user_nic" name="user_nic" placeholder="닉네임을 입력해주세요." value="${userDTO.user_nic }"> 
								<span class="input-group-btn">
									<button type="button" class="btn btn-info" id="nicCheck">중복확인</button>
								</span>
							</div>
							<p id="nicchk" style="display: inline;"></p>
						</div>
					
					</div>
					<!-- 이름  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right"><h5>이름</h5></div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="text" class="form-control" id="user_name" name="user_name" placeholder="이름을 입력해주세요." value="${userDTO.user_name }">
						</div>
					</div>

					<!-- 비밀번호  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right"><h5>비밀번호</h5></div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="비밀번호를 입력해주세요.">
						</div>
						<p id="pwCheck1">
					</div>
					<!--비밀번호학인  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>비밀번호 확인</h5>
						</div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="password" class="form-control" id="user_pw2" name="user_pw2" placeholder="비밀번호를 재입력해주세요.">
						</div>
						<p id="pwCheck2">
					</div>
					
					
					<!--생년월일  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>생년월일</h5>
						</div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="date" class="form-control" id="user_birth" name="user_birth" value="${userDTO.user_birth }">
						</div>
					</div>
					
					<!--남녀 체크  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>성별</h5>
						</div>
						<div class="col-xs-7 col-md-7 text-center">
								
							<div class="col-xs-6 col-md-6" >
								<div class="col-md-5" style=" width: 60px;margin-top:10px;"><label for="gen_codeM">남성</label></div>
								<div class="col-md-1 "  style="  display: inline-block;">
									<c:choose>
										<c:when test="${userDTO.gen_code == 'M' }">
											<input type="radio" style="width: 15px; padding-left: 10px;" checked="checked" class="form-control" id="gen_codeM" name="gen_code" value="M">
									</c:when>
										<c:otherwise>
											<input type="radio" style="width: 15px; padding-left: 10px;"class="form-control" id="gen_codeM" name="gen_code" value="M">
										</c:otherwise>
									</c:choose>
								</div>
								
								<div class="col-md-5" style=" width: 60px;margin-top:10px;"><label for="gen_codeF">여성</label></div>
								<div class="col-md-1 "  style="  display: inline-block;">
									<c:choose>
										<c:when test="${userDTO.gen_code == 'F' }">
											<input type="radio" checked="checked" style="width: 15px; padding-left: 10px;" class="form-control" id="gen_codeF" name="gen_code" value="F">
										</c:when>
										<c:otherwise>
											<input type="radio" style="width: 15px; padding-left: 10px;" class="form-control" id="gen_codeF" name="gen_code" value="F">
										</c:otherwise>
									</c:choose>
								</div>
							
							</div>
						</div>
						<p id="genCheck"></p>
					</div>
							
					
					<!--e-mail  -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>e - mail</h5>
						</div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="text" class="form-control" id="user_email" name="user_email" placeholder="이메일을 입력해주세요." value="${userDTO.user_email }">
						</div>
					</div>

					<!--전화 번호-->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>전화 번호</h5>
						</div>
						<div class="col-xs-7 col-md-5 text-center">
							<input type="text" class="form-control" id="user_tel" name="user_tel" placeholder="'-'를 제외하고 입력해주세요." value="${userDTO.user_tel }">
						</div>
					</div>

					<!--우편 번호-->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>우편 번호</h5>
						</div>
						<div class="col-xs-3 col-md-2 text-right">
							<input type="text" class="form-control" id="zipcode" name="zipcode" readonly="readonly" value="${userDTO.zipcode }">
						</div>
						<div class="col-xs-3 col-md-3 ">
							<div class="col-xs-8 col-md-12  text-left">
								<button class="btn btn-info" type="button" style="width: 80px; margin-left: 35px;" onclick="goPopup();">검색</button>
							</div>
						</div>
					</div>

					<!-- 상세주소  -->
					<div class="row text-left ">
						<div class="col-xs-5 col-md-5"></div>
						<div class="col-xs-7 col-md-7 text-left">
							<input type="text" class="form-control" value="${userDTO.basic_addr} ${userDTO.detail_addr }" id="roadFullAddr" name="roadFullAddr" readonly="readonly" style="width: 100%;">
						</div>
						<input type="hidden" id="siNm" name="siNm" value="${userDTO.loca_name }">
						<input type="hidden" id="sggNm" name="sggNm" value="${userDTO.city_name }">
						<input type="hidden" id="basic_addr" name="basic_addr" value="${userDTO.basic_addr }">
						<input type="hidden" id="roadAddrPart2" name="roadAddrPart2">
						<input type="hidden" id="detail_addr" name="detail_addr" value="${userDTO.detail_addr }">
					</div>

					<!-- 비밀번호 찾기 -->
					<div class="row">
						<div class="col-xs-5 col-md-5 text-right">
							<h5>비밀번호 찾기 질문</h5>
						</div>
						<div class="col-xs-6 col-md-4 text-left">
							<select class="form-control "  id="pwqu_code" name="pwqu_code">
								<option selected="selected" ><h4>비밀번호 힌트</h4></option>
								<c:forEach var="list" items="${pwquLists }">
									<c:if test="${list.pwqu_code == userDTO.pwqu_code }">
										<option value="${list.pwqu_code }" selected="selected" >${list.pwqu_name }</option>
									</c:if>
										<option value="${list.pwqu_code }">${list.pwqu_name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-2"></div>
					</div>

					<div class=" col-xs-5 col-md-5"></div>
					<div class=" col-xs-7 col-md-7 text-left">
						<input type="text" id="pwqu_answ" name="pwqu_answ" placeholder="내용을 입력해주세요" class="form-control" value="${userDTO.pwqu_answ }">
					</div>
					
					<div class=" col-xs-6 col-md-6 text-center">
						<button type="button" class="btn btn-primary" id="homeBtn" onclick="location.href='main.do'"><h5>처음으로</h5></button>
					</div>
					<div class="col-xs-6 col-md-6 text-center">
						<button type="button" class="btn btn-primary" id="joinBtn"><h5>수정완료</h5></button>
					</div>
				
				</div>
				<div class="col-xs-11 col-md-1" id="b3">b3</div>
			</div>


		</form>         
           <!--center middle- right  -->
           <div class="col-md-3" style="width: 10%; height: 700px; ">           
           <!-- Acordian Action -->
            
           
           <!--b2_center right end  -->
           </div>
           


    
           </div>
       

<!--Center right  -->
            <div class="col-xs-2 col-md-2"  id="b3">
        <c:import url="../../tooglebtn.jsp"/> 
            </div>

<!-- Center_body End -->
      </div>    
      
      
      
      <!-- 세번째 row  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
 
</div>
</body>
</html>