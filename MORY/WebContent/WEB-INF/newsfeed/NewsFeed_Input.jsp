<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/ckeditor/config.js"></script>
<link rel="stylesheet" href="css/sample.css" />
 -->

<link rel="stylesheet" href="../css/Mainmenu.css" />


<script>
var oEditors = [];
$(function(){
nhn.husky.EZCreator.createInIFrame({
oAppRef: oEditors,
elPlaceHolder: "textAreaContent",
sSkinURI: "se2/SmartEditor2Skin.html",
fCreator: "createSEditor2"
});
});
 
//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
 
    // 에디터의 내용에 대한 값 검증은 이곳에서
    // document.getElementById("textAreaContent").value를 이용해서 처리한다.
  
    try {
        elClickedObj.form.submit();
    } catch(e) {
     
    }
}
 
// textArea에 이미지 첨부
function pasteHTML(filepath){
    var sHTML = '<img src="<%=request.getContextPath()%>/path에서 설정했던 경로/'+filepath+'">';
    oEditors.getById["textAreaContent"].exec("PASTE_HTML", [sHTML]);
}

</script> 


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
	
	$(document).ready(function()
	{
		$("#saveBtn").click(function()
		{
			$("#form").submit();
		});
	});
	
</script>






</head>
<body>
	<div class="container" id="container">

		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../main/Mainmenu.jsp" />




		<!-- 	두번째 row  -->
		<form action="newsfeedinsert.do" method="post" enctype="multipart/form-data" id="form">
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1"></div>

			<div class="col-xs-10 col-md-10" id="b2">
				
				<div id="divPeedPhoto" style='position: relative; width: 100%; height: 100%; color: black; border: 0px solid black; dispaly: inline;'>
				</div>
				<br><br>
		
				<div id="divPeedContent">
					 <textarea name="textAreaContent" id="textAreaContent" rows="10" cols="100" style="width:766px; height:412px;"></textarea>
   					 <input type="button" id="savebutton" value="업로드" />

				</div>
	

				<div>
					<button type="button" id="saveBtn">작성완료</button>
				</div>
				<input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')">



			</div>

			<div class="col-xs-1 col-md-1" id="b3"></div>
		</div>
		</form>





		<!-- 세번째 row  -->
		<c:import url="../../Footer.jsp" />

	</div>
</body>
</html>