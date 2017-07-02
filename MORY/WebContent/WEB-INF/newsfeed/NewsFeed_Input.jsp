<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>
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

<link rel="stylesheet" href="../css/Mainmenu.css" />
<script type="text/javascript" src="<%=cp%>/resource/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<style type="text/css">
* 
{
	margin: 0;
	padding: 0;
}

body 
{
	font-size: 13px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
}

a 
{
	color: #000000;
	text-decoration: none;
	cursor: pointer;
}

a:active, a:hover 
{
	text-decoration: underline;
	color: tomato;
}

.title 
{
	font-weight: bold;
	font-size: 15px;
	margin-bottom: 10px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
}

.btn 
{
	color: #333;
	font-weight: 500;
	font-family: "Malgun Gothic", "맑은 고딕", NanumGothic, 나눔고딕, 돋움, sans-serif;
	border: 1px solid #cccccc;
	background-color: #fff;
	text-align: center;
	cursor: cursor;
	padding: 3px 10px 5px;
	border-radius: 4px;
}

.btn:active, .btn:focus, .btn:hover 
{
	background-color: #e6e6e6;
	border-color: #adadad;
	color: #333;
}

.boxTF 
{
	border: 1px solid #999999;
	padding: 3px 5px 5px;
	border-radius: 4px;
	background-color: #ffffff;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
}

.selectField 
{
	border: 1px solid #999999;
	padding: 2px 5px 4px;
	border-radius: 4px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
}
</style>
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
<script type="text/javascript">

// 좌우의 공백을 제거하는 함수
if (typeof String.prototype.trim !== 'function') 
{
	String.prototype.trim = function() 
	{
		var TRIM_PATTERN = /(^\s*)|(\s*$)/g;
		return this.replace(TRIM_PATTERN, "");
	};
}

function check() 
{
	var f = document.boardForm;
	
	var str = f.subject.value;
	if (!str) 
	{
		alert("제목을 입력하세요. ");
		f.subject.focus();
		return false;
	}
	
	str = f.name.value;
	if (!str) 
	{
		alert("이름을 입력하세요. ");
		f.name.focus();
		return false;
	}
	
	str = f.content.value;
	if (!str || str=="<p>&nbsp;</p>") 
	{
		alert("내용을 입력하세요. ");
		f.content.focus();
		return false;
	}
	
	str = f.pwd.value;
	if (!str) 
	{
		alert("패스워드를 입력하세요. ");
		f.pwd.focus();
		return false;
	}
	
	f.action = "<%=cp%>/bbs/${mode}";
	return true;
}
</script>
</head>
<body>
	<div class="container" id="container">
		<!-- 첫번째 row  -->
		<!-- 메인메뉴 -->
		<c:import url="../main/Mainmenu.jsp" />
<table style="width: 700px; margin: 30px auto 0px; border-spacing: 0px;">
	<tr height="45">
		<td align="left" class="title">
			<h3>
				<span>|</span>  뉴스피도
			</h3>
		</td>
	</tr>
</table>



		<!-- 	두번째 row  -->
		<form action="newsfeedinsert.do" method="post" enctype="multipart/form-data" id="form">
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1"></div>

			<div class="col-xs-10 col-md-10" id="b2">
				
				<!-- <div id="divPeedPhoto" style='position: relative; width: 100%; height: 100%; color: black; border: 0px solid black; dispaly: inline;'>
				</div>
				<br><br>
		
				<div id="divPeedContent">
					 <textarea name="textAreaContent" id="textAreaContent" rows="10" cols="100" style="width:766px; height:412px;"></textarea>
   					 <input type="button" id="savebutton" value="업로드" />

				</div>
	

				<div>
					<button type="button" id="saveBtn">작성완료</button>
				</div>
				<input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')"> -->
				<table style="width: 700px; margin: 20px auto 0px; border-spacing: 0px; border-collapse: collapse;">
		<%-- <tr align="left" height="40" style="border-top: 1px solid #cccccc; border-bottom: 1px solid #cccccc;">
			<td width="80" bgcolor="#eeeeee" style="text-align: center;">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
			<td style="padding-left: 10px;">
				<input type="text" name="subject" maxlength="100" class="boxTF" style="width: 95%;" value="${dto.subject}">
			</td>
		</tr>
		
		<tr align="left" height="40" style="border-bottom: 1px solid #cccccc;">
			<td width="80" bgcolor="#eeeeee" style="text-align: center;">작성자</td>
			<td style="padding-left: 10px;">
				<input type="text" name="name" size="35" maxlength="20" class="boxTF" value="${dto.name}">
			</td>
		</tr> --%>
		
		<tr align="left" style="border-bottom: 1px solid #cccccc;">
			<td width="80" bgcolor="#eeeeee" style="text-align: center; padding-top: 5px;" valign="top">
			<br><br><br><br><br><br><br><br><br>
			내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
			<td valign="top" style="padding: 5px 0px 5px 10px;">
				<textarea name="content" id="content" style="width: 95%; height: 270px;">${dto.content}</textarea>
			</td>
		</tr>
		
		<tr align="left" height="40" style="border-bottom: 1px solid #cccccc;">
			<td width="80" bgcolor="#eeeeee" style="text-align: center;">패스워드</td>
			<td style="padding-left: 10px;">
				<input type="password" name="pwd" size="35" maxlength="7" class="boxTF">&nbsp;(게시물 수정 및 삭제시 필요 !!!)
			</td>
		</tr>
	</table>
	
	<table style="width: 700px; margin: 0px auto; border-spacing: 0px;">
		<tr height="45">
			<td align="center">
				<button type="submit" class="btn">${mode=='update'?'수정완료':'등록하기'}</button>
				<button type="reset" class="btn">다시입력</button>
				<button type="button" class="btn" onclick="javascript:location.href='<%=cp%>/newsfeedlist.do';">${mode=='update'?'수정취소':'등록취소'}</button>
				<c:if test="${mode=='update'}">
					<input type="hidden" name="num" value="${dto.num}">
					<input type="hidden" name="page" value="${page}">
				</c:if>
			</td>
		</tr>
	</table>
	</div>
	
	<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame(
{
	oAppRef: oEditors,
	elPlaceHolder: "content",
	sSkinURI: "<%=cp%>/resource/se/SmartEditor2Skin.html",
	htParams :
	{
		bUseToolbar : true,
		fOnBeforeUnload : function()
		{
			//alert("아싸!");
		}
	}, // boolean
	fOnAppLoad : function()
	{
		// 예제 코드
		//oEditors.getById["content"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	},
	fCreator : "createSEditor2"
});

function pasteHTML()
{
	var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
	oEditors.getById["content"].exec("PASTE_HTML", [ sHTML ]);
}

function showHTML()
{
	var sHTML = oEditors.getById["content"].getIR();
	alert(sHTML);
}

function submitContents(elClickedObj)
{
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됩니다.
	// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("content").value를 이용해서 처리하면 됩니다.

	try
	{
		// elClickedObj.form.submit();
		return check();
	} 
	catch (e)
	{
	}
}

function setDefaultFont()
{
	var sDefaultFont = '돋움';
	var nFontSize = 24;
	oEditors.getById["content"].setDefaultFont(sDefaultFont, nFontSize);
}
</script>
	

			<div class="col-xs-1 col-md-1" id="b3"></div>
		</div>
		</form>





		<!-- 세번째 row  -->
		<c:import url="../../Footer.jsp" />

	</div>
</body>
</html>