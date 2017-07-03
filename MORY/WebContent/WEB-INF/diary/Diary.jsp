<%@page import="com.kh.mory.DiaryDTO.DiaryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diary_1.jsp</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- + 버튼 테마 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/fullcalendar.min.css" media="print"/>
<script src="js/jquery.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/fullcalendar.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/ko.js"></script>
<script type="text/javascript">

	function myFunction(id) {
	    var x = document.getElementById(id);
	    if (x.className.indexOf("w3-show") == -1) {
	        x.className += " w3-show";
	    } else { 
	        x.className = x.className.replace(" w3-show", "");
	    }
	}
	
	/*// 모델 1
	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModal1").modal();
		});
	}); */
	
	$(document).ready(function() {	
	
		$('#calendar').fullCalendar({
			header: {
 				left: 'title',
				center: 'prev,today,next',
				right: 'month,listWeek,listMonth',
				titleFormat :{
				     month: "YYYY년 MMMM",
				     listWeek: "YYYY년 MMMM",
				     listMonth: "YYYY년 MMMM",
				   }
			},
			 
			viewRender: function(view, element) {
				//note: this is a hack, i don't know why the view title keep showing "undefined" text in it.
				//probably bugs in jquery fullcalendar
				$('.fc-left')[0].children[0].innerText = view.title.replace(new RegExp("undefined", 'g'), ""); 
				},

			views: {
				listWeek: { buttonText: '주 일정' },
				listMonth: { buttonText: '월 일정' }
			},
			
			eventSources : 
			[
                {
                    // 배경색이 빨간색인 이벤트
                    events : 
                    [
                    	<%
                    	ArrayList<DiaryDTO> list = (ArrayList<DiaryDTO>)request.getAttribute("diaryList");
                    	for(DiaryDTO diaryList : list )
                        {
                    		String urlw = "http://localhost:8090/diarypost.do?write_seq=" + diaryList.getWrite_seq();
                    		String dtm = diaryList.getWrite_reg_dtm();
                    		dtm = "20"+dtm.replaceAll("/", "-");
                    		System.out.println(dtm);
                    		
                        %>
                        {
                        	title :"<%=diaryList.getDiary_post_title()%> "
                            ,start :"<%=dtm%>"
                            ,url : "<%=urlw %>"
                        },
                        <%
                        }
                        %>
                    	{
                              title : "All Day Event"
                            , start : "2017-06-28"
                            ,url : "http://www.naver.com"
                        }
                        
                    ]
                    , color : "#FF0000"
                    , textColor : "#FFFF00"
                }
            ]

		});
			
	});	
	

	
</script>
<style type="text/css">
	a {color: black;}
	th {background: lightgrey;}
	th, td {padding: 5px 0px; text-align: center; border-bottom: 1px solid grey; border-top: 1px solid grey;}
	a:hover {text-decoration: none;}
	footer a {color: grey; text-decoration: underline;}
	body {	
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
		}
	#calendar {max-width: 900px; margin: 0 auto;}
	.drop-menu {border: 1px solid grey;}
	.drop-menu-top {background: gray; color: white;	border: gray;}
	.fc th {
		border-style: solid;
		border-color: #FFBB00;
		background: #9DCFFF;
		}
	.fc td{
		border-color: #FFEBFE;
		background: #C6FFFF0;
		}
	/* 확인해봐야할것 */
	.fc hr{
		border-color: #5F00FF;
		background: #5F00FF;
		}	
	.fc thead{
		border-color: #FF00DD;
		background: #E5FFFF;
		}
	.fc-row {
		border-color: #FFBB00;
		background: #B2EBF4;
		}

</style>
</head>

<body>

<div class="container"  id="container">
	<!-- 첫번째 row  -->
	<c:import url="../main/Mainmenu.jsp" />  		
	
	<!-- 두번째 row  -->
	<div class="row " id="all1">
		<div class="col-xs-1 col-md-1"  id="b1">b1</div>
		
		<!-- 다이어리 구성 내용 -->
		<div class="col-xs-10 col-md-10"  id="b2" >
			<div  style="height: 51px;">
				
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">
				<!-- <span class="glyphicon glyphicon-user" style="font-size: 30px; color: red;"></span> -->
				<a href="diary.do" >
				<img src="img/person_diary_image.png" style="width: 50px; height: 50px;">
				</a>
				</div>
				<div class="col-xs-1 col-md-1">
				<!-- <span class="glyphicon glyphicon-user" style="font-size: 30px; color: blue;"></span> -->
				<%-- 
				<a ${matecheck>0 ? "href='diary.do?requ_seq='"+couplediary.requ_seqd: '' } > <img src="img/couple_diary_image.jpg"   style="width: 50px; height: 50px;"></a>
				 --%>
				 <c:if test="${matecheck>0 }"><a href="diary.do?requ_seq=${matecheck }"><img src="img/couple_diary_image.jpg"   style="width: 50px; height: 50px;"></a></c:if>
				</div>
				<div class="col-xs-1 col-md-1">
				<!-- <span class="glyphicon glyphicon-user" style="font-size: 30px; color: yellow;"></span> -->
				<img src="img/other_diary_image.png" style="width: 50px; height: 50px;" data-toggle="modal" data-target="#myModal" >
				</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">
				</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;"></div>
			</div>
			
			<!-- 다이어리 제목 -->
			<div class="col-xs-3 col-md-3"></div>
			<div class="col-xs-6 col-md-6">
			<c:choose>
				<c:when test="${diary.diary_name eq null}">
					<input type="text" class="form-control" value="${couplediary.shar_diary_name }" style="text-align: center" readonly="readonly" >
				</c:when>
				<c:otherwise>
					<input type="text" class="form-control" value="${diary.diary_name }" style="text-align: center" readonly="readonly" >
				</c:otherwise>
			</c:choose>
			
				
			</div>
			<div class="col-xs-3 col-md-3">
				<img src="img/pen.jpg" style="width: 26px; height: 26px;" 
				data-toggle="modal" data-target="#myModal1"  >
			</div>
			<br />
			<br />
			<br />
			<br />
			
			<!-- 달력 출력 -->
			<div class="col-xs-12 col-md-12" id='calendar'></div>
			<div id="datepicker"></div>
		
		</div>
		
		<!-- +버튼 -->
		<div class="col-xs-1 col-md-1"  id="b3">
		    <div class="w3-container">        
				<a onclick="myFunction('Demo1')" style="width: 100px; " class="glyphicon glyphicon-plus-sign btn-lg"></a>
				<div id="Demo1" class="w3-container w3-hide">
				  <a href="" style="width: 100px;" class="glyphicon glyphicon-user btn-lg"></a><br />
				  <a href="" class="glyphicon glyphicon-time btn-lg"></a><br />
				  
				  <c:choose>
				<c:when test="${diary.diary_name eq null}">
					<a href="diaryinsertform.do?requ_seq=${matecheck}" class="glyphicon glyphicon-pencil btn-lg"></a><br />
				</c:when>
				<c:otherwise>
					<a href="diaryinsertform.do" class="glyphicon glyphicon-pencil btn-lg"></a><br />
				</c:otherwise>
			</c:choose>
				  
				  
				</div>
			</div>
		</div>	
		
		
		
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="text-align: center;">
							</div>
							
							<form action="diarynameupdate.do">
							<div class="modal-body" style="height: 300px;">
								<div class="col-xs-12 col-md-12"
									style="border: 1px solid; height: 50px;">
									<div class="col-xs-3 col-md-3" style="">
										다이어리 이름
									</div>
									<div class="col-xs-6 col-md-6">
										<c:choose>
											<c:when test="${diary.diary_name eq null}">
												<input type="text" id="diary_name" name="diary_name" value="${couplediary.shar_diary_name}" placeholder="다이어리 제목을 입력하세요"  >
												<input type="hidden" id="diary_seq" name="diary_seq"  />												
												<input type="hidden" id="diary_type"  name="diary_type"  />
											</c:when>
											<c:otherwise>
												<input type="text" id="diary_name" name="diary_name" value="${diary.diary_name}" placeholder="다이어리 제목을 입력하세요"  >
												<input type="hidden" id="diary_seq" name="diary_seq" />												
												<input type="hidden" id="diary_type" name="diary_type" />
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col-xs-3 col-md-3"
										style="text-align: right; margin-top: 10px;">
										<input type="submit" value="수정하기" >
									</div>
								</div>
							</div>
							</form>
							
							<div class="modal-footer "></div>
						</div>
					</div>
				</div>
				
				
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true" >
					<div class="modal-dialog" style="height: 500px;" >
						<div class="modal-content">
							<div class="modal-header" style="text-align: center;">
								<h2>공유받은 다이어리 목록</h2>
							</div>
							<div class="modal-body" style="min-height: 400px;" >
							<table>
							<c:if test="${memberdiarylist.isEmpty() }"> <span style="text-align: center;" ><h1>공유 받은 다이어리가 없습니다.</h1></span> </c:if>
							<c:forEach var="member" items="${memberdiarylist }">
							
								<tr onclick="location.href='diary.do?requ_seq=${member.requ_seq}'">
										<td class="col-xs-3 col-md-3">
											${member.user_nic } 
										</td>
	
										<td class="col-xs-6 col-md-6">
											<lanel id="diary_name" name="diary_name"  readonly="readonly"  >${member.shar_diary_name }</lanel>
										</td>
										<td class="col-xs-3 col-md-3">
											<input type="submit" value="구경가기">
										</td>
								</tr>
								
								
								</c:forEach>
								</table>
								</div>
							</div>
							<div class="modal-footer "></div>
						</div>
					</div>
				</div> 
			
		
		
	</div>	
	
	<br />
	<br />
	<br />
	<br /> 
	
	<!-- 세번째 row  -->
	<div class="row " id="all2">
		<div class="col-xs-1 col-md-1"  id="f1">f1</div>
		<div class="col-xs-10 col-md-10"  id="f2">
		
		<div class="row " id="foot">
				<div class="col-xs-1 col-md-1" id="h1">h1</div>
				<div class="col-xs-10 col-md-10" id="h2">
					<footer style="border-top:2px solid gainsboro"
						style="height:100px;  ">
					<ul class="list-inline">
						<li><a href="#">MORY 정보</a></li>
						<li><a href="#">지원</a></li>
						<li><a href="#">블로그</a></li>
						<li><a href="#">개인정보처리방침</a></li>
						<li><a href="#">홍보 센터</a></li>
						<li><a href="#">API</a></li>
						<li><a href="#">약관</a></li>
						<li><a href="#">채용정보</a></li>
					</ul>
					</footer>
				</div>
				<div class="col-xs-1 col-md-1" id="h3">h3</div>
			</div>
		</div>
		
		</div>
		<div class="col-xs-1 col-md-1"  id="f3">f3</div>
	</div>		
 







</body>
</html>