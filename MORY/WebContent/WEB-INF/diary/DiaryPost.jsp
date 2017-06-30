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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/new.css">
<style type="text/css">
	.ui-datepicker-week-end:first-child a{color: red;}
	.ui-datepicker-week-end:last-child a{color: blue;}
	table, th, td {
        border: 1px solid #bcbcbc;
      }
     textarea {
	min-width: 75%;
}
	
</style>
<link rel="stylesheet" href="css/jquery-ui.css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
		
		//2댓 답
			<%
        	ArrayList<DiaryDTO> comment = (ArrayList<DiaryDTO>)request.getAttribute("commentList");
			ArrayList<DiaryDTO> recomment = (ArrayList<DiaryDTO>)request.getAttribute("recommentList");
        	for(DiaryDTO comm : comment )
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
        	for(DiaryDTO comm : comment )
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
        	for(DiaryDTO comm : comment )
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
        	for(DiaryDTO comm : comment )
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
           
            for(DiaryDTO recomm : recomment )
            {
        		String recomentupdate = "#recomentupdate"+recomm.getReco_seq();
        		String recomentlistdiv = "#recomentlistdiv"+recomm.getReco_seq();
        		String recommentupdatediv = "#recommentupdatediv"+recomm.getReco_seq();
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
            
            for(DiaryDTO recomm : recomment )
            {
        		String reupcancel =  "#reupcancel"+recomm.getReco_seq();
        		String recomentlistdiv = "#recomentlistdiv"+recomm.getReco_seq();
        		String recommentupdatediv = "#recommentupdatediv"+recomm.getReco_seq();
            %>
        		$("#reupcancel<%=recomm.getReco_seq()%>").click(function()
        		{
        			$("<%=recomentlistdiv%>").css("display","block");
        			$("<%=recommentupdatediv %>").css("display","none");
        		});
        		
        		
            <%
            }
            %>
            
       
	});
</script>


</head>

<body>

	<div class="container" id="container">
		<!-- 첫번째 row  -->
		<div class="row " id="all0">
			<div class="col-xs-1 col-md-1" id="h1"></div>
			<div class="col-xs-10 col-md-10" id="h2"
				style="margin-bottom: 30px; ">
				<div class="col-xs-2 col-md-2">
					<button type="button" value="뉴스피드"
						style="height: 40px; width: 100px;" class="btn btn-primary">뉴스피드</button>
				</div>
				<div class="col-xs-2 col-md-2">
					<button type="button" value="다이어리"
						style="height: 40px; width: 100px;" class="btn btn-primary">다이어리</button>
				</div>
				<div class="col-xs-4 col-md-4" style="text-align: center;">
					<a href="*" style="margin: 0px 20px; color: black;"> <!-- <img src="C:\MORY\Mory\WebContent\img\logo.png" width="100"/> -->
						<span style="font-size: 30px; text-align: center;"><b>MORY</b></span>
					</a>
				</div>
				<div class="col-xs-2 col-md-2">
					<button type="button" value="커뮤니티"
						style="height: 40px; width: 100px;" class="btn btn-primary">커뮤니티</button>
				</div>
				<div class="col-xs-2 col-md-2">
					<button type="button" value="환경설정"
						style="height: 40px; width: 100px;" class="btn btn-primary">환경설정</button>
				</div>
			</div>
			<div class="col-xs-1 col-md-1" id="h3"></div>
		</div>
 
		<!-- 두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1">b1</div>
			<div class="col-xs-10 col-md-10" id="b2">
				<div>
					<input type="text" class="form-control" value="민준이의 다이어리"
						style="text-align: center"  readonly="readonly" >
				</div>
				<div>
					<input type="text" class="form-control" value="다이어리 작성"
						style="text-align: center" readonly="readonly" >
				</div>
				<div class="col-xs-12 col-md-12"  style="background-color: aqua;">
					<div class="col-xs-6 col-md-6" align="left">
						<label style="text-align: left; color: white;  ">제목 :</label>
						<input type="text" id="diary_post_title" name="diary_post_title" class="diary_post_title"
						 placeholder="제목을 입력하세요." style="width: 70%;" value="${diaryDTO.diary_post_title }" readonly="readonly" >
					</div>
					<div align="right" class="col-xs-6 col-md-6">
						<label style="text-align: right;  color: white; ">일시 :</label>
						<input type="text" id="write_reg_dtm" class="write_reg_dtm" name="write_reg_dtm" 
						style="text-align: right; width: 70%; color: black; "
						 placeholder="작성날짜를 선택해주세요." value="${diaryDTO.write_reg_dtm }" readonly="readonly" >
					</div>
				</div>
				<div>
					<div class="form-control" id="write_cont" class="write_cont"
						style="min-height: 450px; height:100%; background-color: white;  ">
						<button style="margin-left: 90%;">수정</button>
						<br /><button style="margin-left: 90%;">삭제</button>
						<br />
						${diaryDTO.write_cont }
					</div>
					<div  class="col-xs-12 col-md-12" style="align: right;" >
						
						 
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
									<textarea rows="3" name="commentupdatecont${comment.comment_seq }" id="commentupdatecont${comment.comment_seq }"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"><%=cont %></textarea>
									<!-- 댓글달기버튼 -->
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
										recont = cont.replaceAll("<br>", "\\\n");%>
							
									
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
													<div style="text-align:left; width: 100%; min-height:  40px; " ><pre><%=recont %></pre>
													</div>
													<!-- 수정버튼 -->
													<button id="recomentupdate${recoment.reco_seq }" name="recomentupdate${recoment.reco_seq }"  style="width: 50px; height: 40px; ">수정</button>
													<!-- 삭제버튼 -->
													<button id="recomentdelete${recoment.reco_seq }" name="recomentdelete${recoment.reco_seq }"  style="width: 50px; height: 40px;">삭제</button>
												</div>
											</div>
											<!-- 답글 수정폼 -->
											
											<div id="recommentupdatediv${recoment.reco_seq }" name="recommentupdatediv${recoment.reco_seq }" style="border: 1px solid; width: 89%; padding: 5px; margin-left: 6%;  display:none   ; ">
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
													<textarea rows="3" id="recommentupdatecont${recoment.reco_seq }" name="recommentupdatecont${recoment.reco_seq }"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"><%=recont %></textarea>
													<!-- 댓글달기버튼 -->
													<input type="button" name="recommentcontupdate${recoment.reco_seq }" id="recommentcontupdate${recoment.reco_seq }" value="댓글달기" style="width: 20%; min-height: 40px; vertical-align: middle;">
												</div>
											</div>
									</c:if>
								</c:forEach>
								
							
							
						</c:forEach>	
	
					<div onsubmit=""  id="commentinsert"  style="border: 1px solid; width: 92%; padding: 5px; margin-left: 3%;   ">
						<!-- 답글달기 (숨겨줌) -->
						<input type="hidden" name="recomment" value="답글">
						<div style="min-height: 40px;">
							<form action="commentinsert.do" method="post" onsubmit="">
								<!-- 댓글내용입력 -->
								<textarea rows="3" name="commentinsertcont" id="commentinsertcont"   maxlength="200" placeholder="댓글을 입력해주세요." style=" vertical-align: middle;"></textarea>
								<!-- 댓글달기버튼 -->
								<input type="submit" name="cancle" value="댓글달기" style="width: 100px; min-height: 40px; vertical-align: middle;">
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