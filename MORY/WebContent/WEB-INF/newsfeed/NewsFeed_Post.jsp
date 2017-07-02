<%@page import="com.kh.mory.newsfeed.Newsfeed_NewsfeedDTO"%>
<%@page import="com.kh.mory.DiaryDTO.DiaryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DiaryPost.jsp</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/new.css">
<link rel="stylesheet" href="css/jquery-ui.css" />

<!-- 확인해서 지울것 지울 것들 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
/* 
 수정버튼
 수정취소버튼
 
 답글버튼
 답글취소버튼
 
 수정폼에 빈곳있을시 경고창

 */
	$(document).ready(function()
	{
		//댓글 입력
		$("#commentinsersubBtn").click(function()
		{
			//데이터 검사(공란이 있는지 없는징 대한 여부)		
			if ( $("#commentinsertcont").val()=="")
			{
				alert("입력이 누락된 항목이 있습니다.");
				return;				
			}		
			//submit 액션 처리
			$("#commentisertform").submit();			
		});
			
		//2댓 답
		<%
       	ArrayList<Newsfeed_NewsfeedDTO> comment = (ArrayList<Newsfeed_NewsfeedDTO>)request.getAttribute("commentList");
		ArrayList<Newsfeed_NewsfeedDTO> recomment = (ArrayList<Newsfeed_NewsfeedDTO>)request.getAttribute("recommentList");
       	for(Newsfeed_NewsfeedDTO comm : comment )
        {
	   		String addrecomment = "#addrecomment"+comm.getComment_seq();
	   		String recommentinsertdiv = "#recommentinsertdiv"+comm.getComment_seq();
        	%>
       		$("<%=addrecomment%>").click(function()
       		{
       			$("<%=recommentinsertdiv%>").css("display","block");
       		});  
		<%
		}
		%>
		
		//3답 취소
		<%
		for(Newsfeed_NewsfeedDTO comm : comment )
		{
			String addcancel = "#addcancel"+comm.getComment_seq();
			String recommentinsertdiv = "#recommentinsertdiv"+comm.getComment_seq();
			%>
			$("<%=addcancel%>").click(function()
			{
				$("<%=recommentinsertdiv%>").css("display","none");
			});  
		<%
		}
		%>
            
		//2댓 수
		<%
		for(Newsfeed_NewsfeedDTO comm : comment )
		{
			String commentupdate = "#commentupdate"+comm.getComment_seq();
			String commentlistdiv = "#commentlistdiv"+comm.getComment_seq();
			String commentupdatediv = "#commentupdatediv"+comm.getComment_seq();
		    %>
			$("<%=commentupdate%>").click(function()
			{
				$("<%=commentupdatediv%>").css("display","block");
				$("<%=commentlistdiv%>").css("display","none");
			});
		<%
		}
		%>
          
		//2수 취소
		<%
		for(Newsfeed_NewsfeedDTO comm : comment )
		{
			String commentupdatecancel = "#commentupdatecancel"+comm.getComment_seq();
			String commentlistdiv = "#commentlistdiv"+comm.getComment_seq();
			String commentupdatediv = "#commentupdatediv"+comm.getComment_seq();
		   	%>
			$("<%=commentupdatecancel%>").click(function()
			{
				$("<%=commentupdatediv%>").css("display","none");
				$("<%=commentlistdiv%>").css("display","block");
			});
		<%
		}
		%>     
		
		//3댓 수정
		<%	 
		for(Newsfeed_NewsfeedDTO recomm : recomment )
		{
			String recomentupdate = "#recomentupdate"+recomm.getRecomment_cont();
			String recomentlistdiv = "#recomentlistdiv"+recomm.getRecomment_seq();
			String recommentupdatediv = "#recommentupdatediv"+recomm.getRecomment_seq();
			%>
			$("<%=recomentupdate%>").click(function()
			{
				$("<%=recommentupdatediv %>").css("display","block");
				$("<%=recomentlistdiv%>").css("display","none");
			});
		
	  	<%
		}
	   	%>
            
		//3수 취소
		<% 
		for(Newsfeed_NewsfeedDTO recomm : recomment )
		{
			String reupcancel =  "#reupcancel"+recomm.getRecomment_seq();
			String recomentlistdiv = "#recomentlistdiv"+recomm.getRecomment_seq();
			String recommentupdatediv = "#recommentupdatediv"+recomm.getRecomment_seq();
			%>
			$("#reupcancel<%=recomm.getRecomment_seq()%>").click(function()
			{
				$("<%=recomentlistdiv%>").css("display","block");
				$("<%=recommentupdatediv %>").css("display","none");
			});      		
		<%
		}
		%>
            
		// 댓글 삭제 유무 확인후 삭제
		<%  
		for(Newsfeed_NewsfeedDTO comm : comment)
		{
			String commentdelete = "#commentdelete"+comm.getComment_seq();
		 	%>
		
			$("<%=commentdelete%>").click(function()
			{
				if (confirm("댓글을 삭제하시겠습니까?"))
				{
					$(location).attr("href","commentdelete.do?comment_seq="+"<%=comm.getComment_seq()%>"+"&write_seq="+"${diaryDTO.write_seq}");
				}
			});
		         
		<%
		}
		%>
            
		// 댓글 수정 유무 확인후 수정            
		<%
		for(Newsfeed_NewsfeedDTO comm : comment )
		{
			String commentupdatebtn = "#commentupdatebtn"+comm.getComment_seq();
			String commentupdatecont = "commentupdatecont"+comm.getComment_seq();
		 	%>
			
			$("<%=commentupdatebtn%>").click(function()
			{
				if (confirm("수정 하시겠습니까?"))
				{
					<%-- var txtBox = $("<%=commentupdatecont%>").val();
					hiddenField1.setAttribute("value", document.getElementById("<%=commentupdatecont%>").value);
					document.getElementById("<%=commentupdatecont%>").innerHTML;
					alert(txtBox); --%>
			
				var str = document.getElementById("<%=commentupdatecont%>").value;
				str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
		
				alert(str);
		
				var form = document.createElement("form");					
				form.setAttribute("charset", "UTF-8");
				form.setAttribute("method", "Post"); // Get 또는 Post 입력
				form.setAttribute("action", "commentupdate.do");
				  
				var hiddenField1 = document.createElement("input");
				hiddenField1.setAttribute("type", "hidden");
				hiddenField1.setAttribute("name", "comment_cont");
				hiddenField1.setAttribute("value", str);
				form.appendChild(hiddenField1);
	 
				var hiddenField2 = document.createElement("input");
				hiddenField2.setAttribute("type", "hidden");
				hiddenField2.setAttribute("name", "comment_seq");
				hiddenField2.setAttribute("value", "<%=comm.getComment_seq()%>");
				form.appendChild(hiddenField2);
				
				var hiddenField3 = document.createElement("input");
				hiddenField3.setAttribute("type", "hidden");
				hiddenField3.setAttribute("name", "write_seq");
				hiddenField3.setAttribute("value", "${diaryDTO.write_seq}");
				form.appendChild(hiddenField3);
				document.body.appendChild(form);
				form.submit();
				}
			});      
		<%
		}
		%>           		
            
            // 답글 삭제 유무 확인후 삭제
   
		    <%
		    
		    for(Newsfeed_NewsfeedDTO comm : recomment )
		    {
				String recomentdelete = "#recomentdelete"+comm.getRecomment_seq();
		   	%>
	    
		    $("<%=recomentdelete%>").click(function()
			{
				if (confirm("답글을 삭제하시겠습니까?"))
				{
					$(location).attr("href","recommentdelete.do?reco_seq="+"<%=comm.getRecomment_seq()%>"+"&write_seq="+"${diaryDTO.write_seq}");
				}
			});
		    
		    <%
		    }
		    %>
        
            // 답글 수정 유무 확인후 수정
            
            <%           
            for(Newsfeed_NewsfeedDTO comm : recomment )
            {
        		String recommentcontupdate = "#recommentcontupdate"+comm.getRecomment_seq();
        		String recommentupdatecont = "recommentupdatecont"+comm.getRecomment_seq();	
           	%>

            $("<%=recommentcontupdate%>").click(function()
    		{
    			if (confirm("수정 하시겠습니까?"))
    			{
    				<%-- var txtBox = $("<%=commentupdatecont%>").val();
    				hiddenField1.setAttribute("value", document.getElementById("<%=commentupdatecont%>").value);
    				document.getElementById("<%=commentupdatecont%>").innerHTML;
    				alert(txtBox); --%>
  
    				var str = document.getElementById("<%=recommentupdatecont%>").value;
    				str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
		
					alert(str);
				
    				var form = document.createElement("form");
				
    				form.setAttribute("charset", "UTF-8");
    				form.setAttribute("method", "Post"); // Get 또는 Post 입력
    				form.setAttribute("action", "recommentupdate.do");
    				  
    				var hiddenField1 = document.createElement("input");
    				hiddenField1.setAttribute("type", "hidden");
    				hiddenField1.setAttribute("name", "reco_cont");
    				hiddenField1.setAttribute("value", str);
    				form.appendChild(hiddenField1);
			 
    				var hiddenField2 = document.createElement("input");
    				hiddenField2.setAttribute("type", "hidden");
    				hiddenField2.setAttribute("name", "reco_seq");
    				hiddenField2.setAttribute("value", "<%=comm.getRecomment_seq()%>");
    				form.appendChild(hiddenField2);
    				
    				var hiddenField3 = document.createElement("input");
    				hiddenField3.setAttribute("type", "hidden");
    				hiddenField3.setAttribute("name", "write_seq");
    				hiddenField3.setAttribute("value", "${diaryDTO.write_seq}");
    				form.appendChild(hiddenField3);
    				document.body.appendChild(form);
    				form.submit();
    			}
    		});
            
            <%
            }
            %>
            
		// 답글 입력            
		<%
		for(Newsfeed_NewsfeedDTO comm : recomment )
		{
			String addrecommentbtn = "#addrecommentbtn"+comm.getRecomment_seq();
			String addrecommentcont = "addrecommentcont"+comm.getRecomment_seq();
			%>
		           
			$("<%=addrecommentbtn%>").click(function()
			{
				if (confirm("답글 하시겠습니까?"))
				{				
					var str = document.getElementById("<%=addrecommentcont%>").value;
					str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
				
					alert(str);
			   				
					var form = document.createElement("form");   				
					form.setAttribute("charset", "UTF-8");
					form.setAttribute("method", "Post"); // Get 또는 Post 입력
					form.setAttribute("action", "recommentinsert.do");
					  
					var hiddenField1 = document.createElement("input");
					hiddenField1.setAttribute("type", "hidden");
					hiddenField1.setAttribute("name", "reco_cont");
					hiddenField1.setAttribute("value", str);
					form.appendChild(hiddenField1);  				 
					 
					var hiddenField2 = document.createElement("input");
					hiddenField2.setAttribute("type", "hidden");
					hiddenField2.setAttribute("name", "reco_seq");
					hiddenField2.setAttribute("value", "<%=comm.getRecomment_seq()%>");
					form.appendChild(hiddenField2);
				
					var hiddenField3 = document.createElement("input");
					hiddenField3.setAttribute("type", "hidden");
					hiddenField3.setAttribute("name", "write_seq");
					hiddenField3.setAttribute("value", "${diaryDTO.write_seq}");
					form.appendChild(hiddenField3);
					document.body.appendChild(form);
					form.submit();
			
					document.body.appendChild(form);
					form.submit();
			}
		});
		      
		<%
		}
		%>
       
	});
</script>

<style type="text/css">

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
</style>
</head>
<body>

	<div class="container" id="container">
		<!-- 첫번째 row  -->
		<c:import url="../main/Mainmenu.jsp" /> 
 
		<!-- 두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1">b1</div>
			<div class="col-xs-10 col-md-10" id="b2">
			<c:forEach var="dto" items="${list }">
				<div class="col-xs-12 col-md-12" style="text-align: center;">
					<p id="user_id">${dto.write_user_id } </p>
					<img class="uplo"  src="/newsfeedupload/${dto.uplo_loca }" >
					<p>${dto.write_cont }</p>
					<p>${dto.feed_love_cnt }</p>
					<p>댓글염</p>
				</div>
			</c:forEach>
				<div>
					<div class="col-xs-12 col-md-12" style="align: right;" >
						 
						 <bgsound class="col-xs-10 col-md-10">
						 
						<input type="button" value="목록" class="col-xs-2 col-md-2" >
					</div>
					
					<br /><br />
					
						<!-- 댓글 영역 -->
						<c:forEach var="comment" items="${commentList }" >
							<div id="commentlistdiv${comment.comment_seq }" name="commentlistdiv${comment.comment_seq }" style="border: 1px solid; width: 92%; padding: 5px; margin-left: 3%;   ">
									<!-- 댓글 번호 (숨겨줌) -->
									<input type="hidden" name="comment_seq"  value='<c:out value="${comment.comment_seq }"></c:out>'>
									<!-- 프로필 사진 -->
									<img src="" width="40" height="40" style="vertical-align: middle;">
									<!-- 닉네임 -->
									<input type="text" name="nickname" size="20" maxlength="20" value="${comment.user_nic}"  readonly="readonly" >
									<!-- 작성일자 -->
									<input type="text" name="date" size="20" maxlength="20" value="${comment.comment_reg_dtm}" readonly="readonly" >
									<!-- 답글달기 -->
									<input type="button" id="addrecomment${comment.comment_seq }" name="addrecomment${comment.comment_seq }"  value="답글">
									<div style="min-height: 40px; vertical-align: middle;">
										
										<!-- 댓글내용 --> 
										<div style="text-align:left; width: 100%; min-height:  40px; " ><pre>${comment.comment_cont}</pre>
										
									</div>
										<div style="">
											<!-- 수정버튼 -->
											<input type="button" id="commentupdate${comment.comment_seq }" name="commentupdate${comment.comment_seq }" value="수정" style="width: 50px; height: 40px;  ">
											<!-- 삭제버튼 -->
											<input type="button" id="commentdelete${comment.comment_seq }" name="commentdelete${comment.comment_seq }" value="삭제" style="width: 50px; height: 40px;">
										</div>
									</div>
									
							</div>
							<!-- 수정폼 -->
							
							<c:set var="a" value="${comment.comment_cont}"/>
							<% String cont = (String)pageContext.getAttribute("a"); 
							cont = cont.replaceAll("<br>", "\\\n");%>
							
							<div id="commentupdatediv${comment.comment_seq }" name="commentupdatediv${comment.comment_seq }" style="border: 1px solid; width: 92%; padding: 5px; margin-left: 3%; display:none   ; ">
								<!-- 댓글 번호 (숨겨줌) -->
								<input type="hidden" name="comment_seq"  value='<c:out value="${comment.comment_seq }"></c:out>'>
								<!-- 프로필 사진 -->
								<img src="" width="40" height="40" style="vertical-align: middle;">
								<!-- 닉네임 -->
								<input type="text" name="nickname" size="20" maxlength="20" value="${comment.user_nic}"  readonly="readonly" >
								<!-- 작성일자 -->
								<input type="text" name="comment_reg_dtm" id="comment_reg_dtm" size="20" maxlength="20" value="${comment.comment_reg_dtm}" readonly="readonly" >
								<!-- 수정취소 -->
								<a class="" id="commentupdatecancel${comment.comment_seq }" name="commentupdatecancel${comment.comment_seq }" style="margin-left: 38%; color: red; ">수정취소</a>
								<div style="min-height: 40px;">
									<!-- 댓글내용입력 -->
								<textarea rows="3" name="commentupdatecont${comment.comment_seq}" id="commentupdatecont${comment.comment_seq}"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"><%=cont %></textarea>
									<!-- 댓글수정버튼 -->
										<button id="commentupdatebtn${comment.comment_seq }"name="commentupdatebtn${comment.comment_seq }"  style="width: 20%; min-height: 40px; vertical-align: middle;">수정</button>
								</div>
							</div>
							
							
							<!-- 답글 달기 폼 -->
							<div id="recommentinsertdiv${comment.comment_seq }"  name="recommentinsertdiv${comment.comment_seq }"   style="border: 1px solid; width: 89%; padding: 5px; margin-left: 6%;  display:none   ; ">
								<!-- 답글취소 -->
								<a id="addcancel${comment.comment_seq }" name="addcancel${comment.comment_seq }"  style="margin-left: 88%; color: red; ">답글취소</a>
								<!-- 답글달기 (숨겨줌) -->
								<div style="min-height: 40px;">
									<!-- 댓글내용입력 -->
									<textarea rows="3" name="addrecommentcont${comment.comment_seq }" id="addrecommentcont${comment.comment_seq }"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"></textarea>
									<!-- 댓글달기버튼 -->
									<a href="">
										<button id="addrecommentbtn${comment.comment_seq }" name="addrecommentbtn${comment.comment_seq }" style="width: 20%; height: 40px; ">답글달기</button>
									</a>
								</div>
							</div>
							
							
							
									<c:forEach var="recoment" items="${recommentList }">
									<c:if test="${comment.comment_seq == recoment.comment_seq}">
									
										<c:set var="b" value="${recoment.reco_cont}"/>
										<% String recont = (String)pageContext.getAttribute("b"); 
										recont = recont.replaceAll("<br>", "\\\n");%>
							
									
										<!-- 답글 출력 -->
										<!-- commentupdatediv${comment.comment_seq } -->
										<div id="recomentlistdiv${recoment.reco_seq }" name="recomentlistdiv${recoment.reco_seq }" style="border: 1px solid; width: 89%; padding: 5px; margin-left: 6%;   ">
												<!-- 댓글 번호 (숨겨줌) -->
												<input type="hidden" name="recoment_seq"  value='<c:out value="${recoment.reco_seq }"></c:out>'>
												<!-- 프로필 사진 -->
												<img src="" width="40" height="40" style="vertical-align: middle;">
												<!-- 닉네임 -->
												<input type="text" name="nickname" size="20" maxlength="20" value="${recoment.user_nic}" readonly="readonly"  >
												<!-- 작성일자 -->
												<input type="text" name="date" size="20" maxlength="20" value="${recoment.reco_reg_dtm}"  readonly="readonly"  >
												<div style="min-height: 40px; vertical-align: middle;">
													<!-- 댓글내용 --> 
													<div style="text-align:left; width: 100%; min-height:  40px; " ><pre>${recoment.reco_cont }</pre>
													</div>
													<!-- 수정버튼 -->
													<button id="recomentupdate${recoment.reco_seq }" name="recomentupdate${recoment.reco_seq }"  style="width: 50px; height: 40px; ">수정</button>
													<!-- 삭제버튼 -->
													<button id="recomentdelete${recoment.reco_seq }" name="recomentdelete${recoment.reco_seq }"  style="width: 50px; height: 40px;">삭제</button>
												</div>
											</div>
											<!-- 답글 수정폼 -->
											
											<div id="recommentupdatediv${recoment.reco_seq}" name="recommentupdatediv${recoment.reco_seq }" style="border: 1px solid; width: 89%; padding: 5px; margin-left: 6%;  display:none   ; ">
												<!-- 댓글 번호 (숨겨줌) -->
												<input type="hidden" name="comment_seq"  value='<c:out value="${recoment.reco_seq }"></c:out>'>
												<!-- 프로필 사진 -->
												<img src="" width="40" height="40" style="vertical-align: middle;">
												<!-- 닉네임 -->
												<input type="text" name="nickname" size="20" maxlength="20" value="${recoment.user_nic}"  readonly="readonly" >
												<!-- 작성일자 -->
												<input type="text" name="date" size="20" maxlength="20" value="${recoment.reco_reg_dtm}" readonly="readonly" >
												<!-- 수정취소 -->
												<a class="" id="reupcancel${recoment.reco_seq}" name="reupcancel${recoment.reco_seq}" style="margin-left: 37%; color: red; ">수정취소</a>
												<div style="min-height: 40px;">
													<!-- 댓글내용입력 -->
													<textarea rows="3" id="recommentupdatecont${recoment.reco_seq }" name="recommentupdatecont${recoment.reco_seq }"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"><%=recont%></textarea>
													<!-- 댓글달기버튼 -->
													<input type="button" name="recommentcontupdate${recoment.reco_seq }" id="recommentcontupdate${recoment.reco_seq }" value="댓글달기" style="width: 20%; min-height: 40px; vertical-align: middle;">
												</div>
											</div>
									</c:if>
								</c:forEach>
								
							
							
						</c:forEach>	
	
					<div id="commentinsert"  style="border: 1px solid; width: 92%; padding: 5px; margin-left: 3%;   ">
						<!-- 답글달기 (숨겨줌) -->
						<input type="hidden" name="recomment" value="답글">
						<div style="min-height: 40px;">
							<form action="commentinsert.do" method="post"  id="commentisertform">
								<!-- 댓글내용입력 -->
								<textarea rows="3" name="commentinsertcont" id="commentinsertcont"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"></textarea>
								<!-- 댓글달기버튼 -->
								<input type="button" id="commentinsersubBtn" value="댓글달기" style="width: 100px; min-height: 40px; vertical-align: middle;">
								<input type="hidden" name="user" value=""  />
								<input type="hidden" name="write_seq" value="${diaryDTO.write_seq }"/>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xs-1 col-md-1" id="b3">b3</div>
			
			<!-- 댓글 출력 부분  -->
		</div>

		<!-- 세번째 row  -->
		<div class="row " id="all2">
			<div class="col-xs-1 col-md-1" id="f1">f1</div>
			<div class="col-xs-10 col-md-10" id="f2">f2</div>
			<div class="col-xs-1 col-md-1" id="f3">f3</div>
		</div>

	</div>
	



</body>
</html>