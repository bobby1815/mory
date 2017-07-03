<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/acordian.css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="../css/acordian.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>




<style type="text/css">
#editor {
	height: 220px;
	width: 100%;
}

textarea {
	width: 100%;
}

input {
	width: 100%;
}
</style>


<script type="text/javascript">
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
	
	
	
	
	$(document).ready(function(){
	    $("#myBtn").click(function(){
	        $("#myModal3").modal();
	    });
	});

	
	
</script>

<link rel="stylesheet" href="../css/Mainmenu.css" />
<style type="text/css">

#editor {
	height: 220px;
	width: 100%;
}

textarea
{
	width: 100%;
}

input
{
	width: 100%;
}
 body {
        margin: 0px;
        padding: 0px;
      }
      .menu {
        text-align: center;
        padding: 10px 0px;
        width: 100%;
      }
      .menufix {
        position: fixed;
        top: 65%;
      }	
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script>
      $( document ).ready( function() {
        var moryOffset = $( '.menu' ).offset();
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > moryOffset.top ) {
            $( '.menu' ).addClass( 'menufix' );
          }
          else {
            $( '.menu' ).removeClass( 'menufix' );
          }
        });
      } );
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
</script>


<div class="col-xs-1 col-md-1" id="b3">
	<nav class="menu">
		<input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" /> <label class="menu-open-button" for="menu-open">
			<span class="hamburger hamburger-1"></span> 
			<span class="hamburger hamburger-2"></span> 
			<span class="hamburger hamburger-3"></span>
		</label> <a href="#" class="menu-item"> <i class="fa fa-cog"></i></a> 
  <a href="#" class="menu-item"> <i class="fa fa-cog"></i> </a>  
  <a href="#" class="menu-item" data-toggle="modal" data-target="#write"> <i class="fa fa-plus"></i> </a>
  <a href="#" class="menu-item"> <i class="fa fa-heart"></i> </a>
  <a href="#" class="menu-item" data-toggle="modal" data-target="#myModal1"> <i class="fa fa-envelope"></i> </a>
  <a href="#" class="menu-item" data-toggle="modal" data-target="#myModal1"> <i class="fa fa-envelope"></i> </a>
</nav>


	<!-- filters -->
<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
    <defs>
      <filter id="shadowed-goo">
          <feGaussianBlur in="SourceGraphic" result="blur"stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix"values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feGaussianBlur in="goo" stdDeviation="3" result="shadow" />
          <feColorMatrix in="shadow" mode="matrix"values="0 0 0 0 0  0 0 0 0 0  0 0 0 0 0  0 0 0 1 -0.2"result="shadow" />
          <feOffset in="shadow" dx="1" dy="1" result="shadow" />
          <feBlend in2="shadow" in="goo" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
      <filter id="goo">
          <feGaussianBlur in="SourceGraphic" result="blur"	stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix"values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
    </defs>
   </svg>
    
    
    	<!-- 알림 -->
    <!-- 작성 -->
    
    <div class="modal fade" id="write" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="text-align: center;">
							</div>
							<div class="modal-body" style="height: 600px;">
								<div class="col-xs-12 col-md-12"style="border: 1px solid; height: 50px;">
									<div class="col-xs-3 col-md-3" style="">
									<div class="col-xs-10 col-md-10" id="b2">
				
				<div id="divPeedPhoto" style='position: relative; width: 100%; height: 100%; color: black; border: 0px solid black; dispaly: inline;'>
				</div>
				<br><br>
		
				<div id="divPeedContent">
					<textarea rows="5" cols="" id="write_cont" name="write_cont" placeholder="피드 내용을 작성하세요">
					</textarea>
				</div>
				<div>
					<button type="button">작성완료</button>
				</div>
				<input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')">
			</div>
									</div>
								</div>

							</div>
							<div class="modal-footer "></div>
						</div>
					</div>
				</div>
</div>


<!-- 알림 -->
       <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header" style="text-align: center; color: black;">
                        <h4>알림</h4>
                     </div>
                        <jsp:include page="WEB-INF/Source/Common_AlarmList.jsp"></jsp:include>
                     <div class="modal-footer "></div>
                  </div>
               </div>
            </div>

<!-- 작성 -->

<div class="modal fade" id="write" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="text-align: center;">

			<div id="divPeedPhoto"></div>
			<input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')"style="text-align: center;">
			</div>
			<div class="modal-body" style="text-align: center;">
								<textarea rows="7" cols="" style="resize: none;"></textarea>
							</div>
							<div class="modal-footer " style="text-align: right;">
								<button value="작성완료" class="btn btn-primary"  data-toggle="modal" data-target="#myModal3" >작성완료</button>
								<button value="취소" class="btn btn-default"  data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body" style="height: 70px; text-align: center;">
						<button value="작성 완료 되었습니다" onclick="location.href='newsfeedlist.do'" style="height: auto; width: 100%;"
						class="btn btn-default" >작성완료 되었습니다.</button>
			</div>
			</div>
		</div>
    </div>
    
     
    
       <!-- 알림 -->
       <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header" style="text-align: center; color: black;">
                        <h4>알림</h4>
                     </div>
                        <jsp:include page="WEB-INF/Source/Common_AlarmList.jsp"></jsp:include>
                     <div class="modal-footer "></div>
                  </div>
               </div>
            </div>

    
