<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});



/* 모델 1 */
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal1").modal();
    });
});





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
</head>
<body>
	
	
<div class="container"  id="container">
	<!-- 첫번째 row  -->
		<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2">
				<div class="col-xs-2 col-md-2">
					<button type="button" value="뉴스피드" style="height: 40px; width: 100px;" class="btn btn-primary">뉴스피드</button>
				</div>
				<div class="col-xs-2 col-md-2">	
					<button type="button" value="다이어리" style="height: 40px; width: 100px;" class="btn btn-primary">다이어리</button>
				</div>
				<div class="col-xs-4 col-md-4"style="text-align: center;">	
					<a href="*" style="margin:0px 20px; color:black;">
	                    <!-- <img src="C:\MORY\Mory\WebContent\img\logo.png" width="100"/> -->
	                    <span style="font-size:30px; text-align: center;"><b>MORY</b></span>
	                </a>
	            </div>
	            <div class="col-xs-2 col-md-2" style="">    
	                <button type="button" value="커뮤니티" style="height: 40px; width: 100px;" class="btn btn-primary">커뮤니티</button>
	            </div>  
	            <div class="col-xs-2 col-md-2">
					<button type="button" value="환경설정" style="height: 40px; width: 100px;" class="btn btn-primary">환경설정</button>
				</div>
				
		</div>
				<div class="col-xs-1 col-md-1"  id="h3"></div>
		</div>		
		
	<!-- 	두번째 row  --> 
		<div class="row " id="all1">
				<div class="col-xs-1 col-md-1"  id="b1">b1</div>
				<div class="col-xs-10 col-md-10"  id="b2"> 
					<table>
				
				
					<div class="col-xs-12 col-md-12" style="border: 1px solid; margin-top: 10px; height:600px; ">
					
								
								<div class="col-xs-4 col-md-4" style="margin-top: 5px;">
									<div class="col-xs-6 col-md-6">
									<input type="checkbox" name="check" value="전체선택" style="margin-left: 17px;">
									전체 선택
									
									</div>
									<div class="col-xs-6 col-md-6" style="margin-top: 2px;">
									번호
									
									</div>
									
								</div>
								<div class="col-xs-4 col-md-4" style="text-align: center; margin-top: 6px;">
									제목
								</div>
								<div class="col-xs-4 col-md-4" style="text-align: center; margin-top: 6px;">
									작성일
								</div>
					
					
					
					
				<div class="col-xs-12 col-md-12" style="height: 30px; border: 1px solid;">
				
				
								<div class="col-xs-4 col-md-4" style="margin-top: 5px; ">
									<div class="col-xs-6 col-md-6">
									<input type="checkbox" name="check" value="" />
									
									
									</div>
									<div class="col-xs-6 col-md-6" >
										<tr>
											<td id="su" name="su"></td>
										</tr>
									
									</div>
									
								</div>
								<div class="col-xs-4 col-md-4" style="text-align: center; margin-top: 5px;">
									<tr>
										<td id="community_title" name="community_title"></td>
									</tr>
								</div>
								<div class="col-xs-4 col-md-4" style="text-align: center; margin-top: 5px; ">
										<tr>
											<td id="write_reg_dtm" name="write_reg_dtm"></td>
										</tr>
								</div>				
				
				
				
				
				</div>
								
								
								
					
					
					
					
					
					
					
					
				<div class="col-xs-12 col-md-12">
				<div class="col-xs-6 col-md-6"></div>
				<div class="col-xs-6 col-md-6" style="text-align: right;">
				
					<button type="button" value="수정">수정</button>
					<button type="button" value="삭제" data-toggle="modal" data-target="#myModalDe">삭제</button>
				</div>	
				</div>	
					
					
								<div  class="col-xs-12 col-md-12" style="height: 40px;  margin-top: 450px; " >
									 
									
										<div class="col-xs-3 col-md-3">				
									 	<select nama="community_title1" id="community_title1" style="height: 30px; margin-top: 5px; margin-left:133px;  ">
											<c:forEach var="community_title1" items="${community_title1 }">
									 		<option value="${community_title1.community_title }">${community_title1.community_title } </option>
									 		<option value="${community_title1.write_cont }">${community_title1.write_cont }</option>
									 		</c:forEach>
									 	</select>
									 	</div>
									 	<div class="col-xs-6 col-md-6" style="height: 30px;   margin-top: 5px;  ">
									 		<input type="text" class="col-xs-12 col-md-12" style="height: 30px; width: 440px;" />
									 	</div>
								
										<div class="col-xs-3 col-md-3" style="  margin-top: 5px; text-align: left ">
											<button type="button" value="검색" style=" height: 30px;  width: 50px;  margin-right: 200px;">검색</button>
										</div>
									
									
								</div>
					
					
					
					
					
					
					
					
					
					
			</div>
				
				
				
				
				
				
				
				
			
				
				</table>
				</div>
				<div class="col-xs-1 col-md-1"  id="b3"  style="margin-top: 500px;">





																								<!-- Acordian Action -->
           <div class="w3-container">
           
         <a onclick="myFunction('Demo1')" style="width: 100px; " class="glyphicon glyphicon-plus-sign btn-lg"></a>
         <div id="Demo1" class="w3-container w3-hide">
          <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user "></span></button><br />
          <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#myModal1" ><span class="glyphicon glyphicon-time"></span></button><br />
           <a href="http://localhost:8090/Mory/community/CommunityInput.jsp"><span  class="glyphicon glyphicon-pencil btn-lg"></span></a><br />
           <a href=""><span class="glyphicon glyphicon-plus btn-lg"></span></a><br />
         </div>
         
         </div>



 

 <!--  내정보  -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="text-align: center;">
      
      
      
      
      <div id="divPeedPhoto"></div>
      <input type="file" name="profile_pt" id="profile_pt"onchange="previewImage(this,'divPeedPhoto')" style="text-align: center;">
        <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4> -->
        
        
        
        
        
      </div>
      <div class="modal-body" style="text-align: center;">
        	이름 : 진드래곤 <br>
        	닉네임 : Jin
      </div>
      <div class="modal-footer "  >
      	
      	<div class="col-xs-12 col-md-12">
      	<div class="col-xs-4 col-md-4" style="text-align: left;">
      	<button type="button" value="뉴스피드">뉴스피드</button>
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: center;">
      	<button type="button" class="btn btn-default" data-dismiss="modal" >돌아가기</button>
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: right;">
      		<button type="button" value="커뮤니티">커뮤니티</button>
      	</div>
      	</div>
      	
      	
      	<div class="col-xs-12 col-md-12">
      	<div class="col-xs-4 col-md-4" style="text-align: left;">
      	<button type="button" value="다이어리">다이어리</button>
      	</div>
      	<div class="col-xs-4 col-md-4" >
      
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: right;" >
      		<button type="button" value="개인정보">개인정보</button>
      	</div>
      	
      	</div>
      	
       
      </div>
    </div>
  </div>
</div>





<!-- 알림 -->



<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="text-align: center;">
      <h4>알림</h4>
      </div>
      <div class="modal-body" style="height: 600px;">
        	<div class="col-xs-12 col-md-12" style="border: 1px solid; height: 50px;">
        		<div class="col-xs-3 col-md-3" style="">
        				<img src="img/user.PNG" alt="" style="height: 45px; margin-right: 800px; "/>
        		</div>
        	
        		<div class="col-xs-6 col-md-6">
        		진드래곤<br>
        		2017
        		</div>
        		<div class="col-xs-3 col-md-3" style="text-align: right; margin-top: 10px;">
        		<button type="button" value="수락">수락</button>
        		<button type="button" value="거절">거절</button>
        		</div>
        	
       
        	</div>
        	
      </div>
      <div class="modal-footer "></div>
    </div>
  </div>
</div>



















				</div>
		</div>	 
		
		<!-- 세번째 row  -->
		<div class="row " id="all2">
				<div class="col-xs-1 col-md-1"  id="f1">f1</div>
				<div class="col-xs-10 col-md-10"  id="f2">f2</div>
				<div class="col-xs-1 col-md-1"  id="f3">f3</div>
		</div>		
 
</div>







<div class="modal fade" id="myModalDe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
       <div class="modal-header"style="text-align: center;" >
       <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
       		삭제 하시겠습니까?
      </div> 
      <div class="modal-body"  style="text-align: center;">
     
      <a href=""><button type="button" class="btn btn-default" data-dismiss="modal">삭제</button></a>
       <button type="button" class="btn btn-default" data-dismiss="modal" >돌아가기</button>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>








</body>
</html>