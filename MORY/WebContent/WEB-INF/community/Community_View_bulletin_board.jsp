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


<style type="text/css">
/*   div{border:1px solid gray;}   */ 

#img
{
  
	height: 200px;
	background-image: url('img/�ǰ��ѾƱ�1.jpg'),url('img/���� ����.jpg'),url('img/��Ʈ.jpg');
	background-size: contain;
	
}
</style>



<script type="text/javascript">


function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}




/* ��  */
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});



/* �� 1 */
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal1").modal();
    });
});





function previewImage(targetObj, divPeedPhoto)
{

   var preview = document.getElementById(divPeedPhoto); //div id
   var ua = window.navigator.userAgent;

   //ie�϶�(IE8 ���Ͽ����� �۵�)

   if (ua.indexOf("MSIE") > -1) {

      targetObj.select();

      try {

         var src = document.selection.createRange().text; // get file full path(IE9, IE10���� ��� �Ұ�)

         var ie_preview_error = document.getElementById("ie_preview_error_" + divPeedPhoto);

         if (ie_preview_error) {
            preview.removeChild(ie_preview_error); //error�� ������ delete
         }

         var img = document.getElementById(divPeedPhoto); //�̹����� �ѷ��� ��

         //�̹��� �ε�, sizingMethod�� div�� ���缭 ����� �ڵ����� �ϴ� ����
         img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src + "', sizingMethod='scale')";

      } catch (e) {

         if (!document.getElementById("ie_preview_error_" + divPeedPhoto)) {

            var info = document.createElement("<p>");
            info.id = "ie_preview_error_" + divPeedPhoto;
            info.innerHTML = e.name;
            preview.insertBefore(info, null);
         }
      }
      //ie�� �ƴҶ�(ũ��, ���ĸ�, FF)
   } else {
      var files = targetObj.files;
      for (var i = 0; i < files.length; i++) {
         var file = files[i];
         var imageType = /image.*/; //�̹��� �����ϰ�츸.. �ѷ��ش�.
         if (!file.type.match(imageType))
            continue;
         var prevImg = document.getElementById("prev_" + divPeedPhoto); //������ �̸����Ⱑ �ִٸ� ����
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

         if (window.FileReader) { // FireFox, Chrome, Opera Ȯ��.
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
	<!-- ù��° row  -->
		<div class="row " id="all0">
		<div class="col-xs-1  col-md-1"  id="h1"></div>
		<div class="col-xs-10 col-md-10" id="h2" >
				<div class="col-xs-2 col-md-2">
					<button type="button" value="�����ǵ�" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" class="btn btn-primary" >�����ǵ�</button>
				</div>
				<div class="col-xs-2 col-md-2">	
					<button type="button" value="���̾" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" class="btn btn-primary">���̾</button>
				</div>
				<div class="col-xs-4 col-md-4"style="text-align: center;">	
					<a href="http://localhost:8090/Mory/new/NewSpead.jsp" style="margin:0px ; color:black;">
	                  <img src="img/logo.png" width="100"/>
	                    <span style="font-size:30px; text-align: center;"><b>MORY</b></span>
	                </a>
	            </div>
	            <div class="col-xs-2 col-md-2" style="">    
	                <button type="button" value="Ŀ�´�Ƽ" style="margin-top: 26px; margin-left:20px;  height: 40px; width: 100px;" class="btn btn-primary">Ŀ�´�Ƽ</button>
	            </div>  
	            <div class="col-xs-2 col-md-2">
					<button type="button" value="ȯ�漳��" style="margin-top: 26px; margin-left:20px; height: 40px; width: 100px;" class="btn btn-primary">ȯ�漳��</button>
				</div>
				
		</div>
				<div class="col-xs-1 col-md-1"  id="h3"></div>
		</div>		
		
		
	<!-- 	�ι�° row  --> 
	<div class="row " id="all1">
			<div class="col-xs-1 col-md-1"  id="b1">b1</div>
			<div class="col-xs-10 col-md-10"  id="b2">
				
				<div class="col-xs-12 col-md-12" style="height: 50px; border: 3px solid lightgray;">
					
					<div class="col-xs-6 col-md-6" style="margin-top: 15px;" >
								<div class="col-xs-6 col-md-6" >
								��������
								</div>
							 	<div class="col-xs-6 col-md-6" >
								��������
								</div>
					</div>
					<div class="col-xs-6 col-md-6"  style="margin-top: 15px;">
								<div class="col-xs-6 col-md-6" style="text-align: right;">
								�ʺ�����Q&A
								</div>
								<div class="col-xs-6 col-md-6" style="text-align: right;" >
								���ưǰ�
								</div>
								
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12" style="height: 1200px;border: 1px solid lightgray; margin-top: 7px; ">
				
								<div  class="col-xs-12 col-md-12">
								
									
									<div  class="col-xs-12 col-md-12 container " style=" height: 200px; margin-top: 10px;">
									
										
									
									
									<div id="myCarousel" class="carousel slide" data-ride="carousel">
								    <!-- Indicators -->
								    <ol class="carousel-indicators">
								      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								      <li data-target="#myCarousel" data-slide-to="1"></li>
								      <li data-target="#myCarousel" data-slide-to="2"></li>
								    </ol>
								
								    <!-- Wrapper for slides -->
								    <div class="carousel-inner">
								
								      <div class="item active">
								        <img src="img/�ǰ��ѾƱ�1.jpg" id="img" alt="Los Angeles" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>�ǰ��� �Ʊ�</h3>
								          <p>�ǰ� �ֱ�</p>
								        </div>
								      </div>
								
								      <div class="item">
								        <img src="img/���� ����.jpg" id="img" alt="Chicago" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>��������</h3>
								          <p>����</p>
								        </div>
								      </div>
								    
								      <div class="item">
								        <img src="img/��Ʈ.jpg" id="img" alt="New York" style="width:100%;">
								        <div class="carousel-caption">
								          <h3>��Ʈ</h3>
								          <p>����̴�.</p>
								        </div>
								      </div>
								  
								    </div>
								
								    <!-- Left and right controls -->
								    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
								      <span class="glyphicon glyphicon-chevron-left"></span>
								      <span class="sr-only">Previous</span>
								    </a>
								    <a class="right carousel-control" href="#myCarousel" data-slide="next">
								      <span class="glyphicon glyphicon-chevron-right"></span>
								      <span class="sr-only">Next</span>
								    </a>
								  </div>
								</div>								
						</div>		
					
								
								<div  class="col-xs-12 col-md-12" style="border: 1px solid lightgray; height: 30px; margin-top: 10px; text-align: center; " >
									���� ����
								</div >
					
					<div class="col-xs-12 col-md-12" style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px;"  >
						
						</div>
						
						<div class="col-xs-2 col-md-2" style="height: 100px;  ">
								
						</div>
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px; "  >
						
						</div>
						
					</div>
					
								
								
			<div class="col-xs-12 col-md-12" style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px;"  >
						
						</div>
						
						<div class="col-xs-2 col-md-2" style="height: 100px;  ">
								
						</div>
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px; "  >
						
						</div>
						
					</div>
			
				
				
				
			<div class="col-xs-12 col-md-12" style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px;"  >
						
						</div>
						
						<div class="col-xs-2 col-md-2" style="height: 100px;  ">
								
						</div>
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px; "  >
						
						</div>
						
			</div>
				
				
		    <div class="col-xs-12 col-md-12" style="height: 160px; border: 1px solid lightgray; margin-top: 10px;">
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px;"  >
						
						</div>
						
						<div class="col-xs-2 col-md-2" style="height: 100px;  ">
								
						</div>
						
						<div class="col-xs-5 col-md-5"  style="height: 100px; border: 1px solid lightgray; margin-top: 20px; "  >
						
						</div>
						
			</div>
				
				
				
				
				
				
			<div  class="col-xs-12 col-md-12" style="height: 40px; border: 1px solid lightgray; margin-top: 100px; " >
				 
				
					<div class="col-xs-3 col-md-3">				
				 	<select nama="name"  style="height: 30px; margin-top: 5px; margin-left:115px;  ">
				 		<option value="�г���" >�г���</option>
				 		<option value="����">����</option>
				 		<option value="����+����">����+����</option>
				 	</select>
				 	</div>
				 	<div class="col-xs-6 col-md-6" style="height: 30px; border: 1px solid lightgray;  margin-top: 5px;  ">
				 	
				 	</div>
			
					<div class="col-xs-3 col-md-3" style="  margin-top: 5px; text-align: left ">
						<button type="button" value="�˻�" style=" height: 30px;  width: 50px;  margin-right: 150px;">�˻�</button>
					</div>
				
				
			</div>
				
				
			</div>	
				
				
			</div>
				
				
				
				<div class="col-xs-1 col-md-1"  id="b3" style="margin-top: 450px;">
				
				
				
																												
	<!-- Acordian Action -->
           <div class="w3-container">
           
         <a onclick="myFunction('Demo1')" style="width: 100px; " class="glyphicon glyphicon-plus-sign btn-lg"></a>
         <div id="Demo1" class="w3-container w3-hide">
          <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user "></span></button><br />
          <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#myModal1" ><span class="glyphicon glyphicon-time"></span></button><br />
           <a href="http://localhost:8090/Mory/community/CommunityInput.jsp"><span  class="glyphicon glyphicon-pencil btn-lg"></span></a><br />
           
         </div>
         
         </div>



 

 <!--  ������  -->

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
        	�̸� : ���巡�� <br>
        	�г��� : Jin
      </div>
      <div class="modal-footer "  >
      	
      	<div class="col-xs-12 col-md-12">
      	<div class="col-xs-4 col-md-4" style="text-align: left;">
      	<button type="button" value="�����ǵ�">�����ǵ�</button>
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: center;">
      	<button type="button" class="btn btn-default" data-dismiss="modal" >���ư���</button>
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: right;">
      		<button type="button" value="Ŀ�´�Ƽ">Ŀ�´�Ƽ</button>
      	</div>
      	</div>
      	
      	
      	<div class="col-xs-12 col-md-12">
      	<div class="col-xs-4 col-md-4" style="text-align: left;">
      	<button type="button" value="���̾">���̾</button>
      	</div>
      	<div class="col-xs-4 col-md-4" >
      
      	</div>
      	<div class="col-xs-4 col-md-4" style="text-align: right;" >
      		<button type="button" value="��������">��������</button>
      	</div>
      	
      	</div>
      	
       
      </div>
    </div>
  </div>
</div>





<!-- �˸� -->



<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="text-align: center;">
      <h4>�˸�</h4>
      </div>
      <div class="modal-body" style="height: 600px;">
        	<div class="col-xs-12 col-md-12" style="border: 1px solid; height: 50px;">
        		<div class="col-xs-3 col-md-3" style="">
        				<img src="img/user.PNG" alt="" style="height: 45px; margin-right: 800px; "/>
        		</div>
        	
        		<div class="col-xs-6 col-md-6">
        		���巡��<br>
        		2017
        		</div>
        		<div class="col-xs-3 col-md-3" style="text-align: right; margin-top: 10px;">
        		<button type="button" value="����">����</button>
        		<button type="button" value="����">����</button>
        		</div>
        	
       
        	</div>
        	
      </div>
      <div class="modal-footer "></div>
    </div>
  </div>
</div>
											
				
				
				
				
				
				
				
				
				</div>
				
		</div>
		
 
		
		<!-- ����° row  -->
		<div class="row " id="all2">
				<div class="col-xs-1 col-md-1"  id="f1">f1</div>
				<div class="col-xs-10 col-md-10"  id="f2">f2</div>
				<div class="col-xs-1 col-md-1"  id="f3">f3</div>
		</div>		
 

	</div>	

</body>
</html>