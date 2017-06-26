<%@page import="com.mory.dao.DiaryDAO"%>
<%@page import="com.mory.diary.DiaryDTO"%>
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
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<style type="text/css">

	
</style>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/fullcalendar.min.css" media="print"/>
<script src="js/jquery.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/fullcalendar.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/ko.js"></script>
<script type="text/javascript">
	
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
                        %>
                        {
                        	title : "<%= diaryList.getDiary_post_title() %> "
                            , start : "<%= diaryList.getWrite_reg_dtm() %>"
                        },
                        <%
                        }
                        %>
                    	{
                              title : "All Day Event"
                            , start : "1000-01-01"
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
a {
	color: black;
}

.drop-menu {
	border: 1px solid grey;
}

.drop-menu-top {
	background: gray;
	color: white;
	border: gray;
}

th {
	background: lightgrey;
}

th, td {
	padding: 5px 0px;
	text-align: center;
	border-bottom: 1px solid grey;
	border-top: 1px solid grey;
}

a:hover {
	text-decoration: none;
}

footer a {
	color: grey;
	text-decoration: underline;
}

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>

<body>

<div class="container"  id="container">
      <div class="row " id="all0">
      <div class="col-xs-1  col-md-1"  id="h1"></div>
      <div class="col-xs-10 col-md-10" id="h2" >
            <div class="col-xs-2 col-md-2">
               <button type="button" value="뉴스피드" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" 
               class="btn btn-primary" onclick="location.href='loginmain.do'" >뉴스피드</button>
            </div>
            <div class="col-xs-2 col-md-2">   
               <button type="button" value="다이어리" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" 
               class="btn btn-primary"  onclick="location.href='diary.do'">다이어리</button>
            </div>
            <div class="col-xs-4 col-md-4"style="text-align: center;">   
               <a href="http://localhost:8090/Mory/new/NewSpead.jsp" style="margin:0px ; color:black;">
                     <img src="img/Mory_logo.png" width="100"/>
                       <span style="font-size:30px; text-align: center;"><b>MORY</b></span>
                   </a>
               </div>
               <div class="col-xs-2 col-md-2" style="">    
                   <button type="button" value="커뮤니티" style="margin-top: 26px; margin-left:20px;  height: 40px; width: 100px;"
                    class="btn btn-primary" onclick="location.href='communitymain.do'">커뮤니티</button>
               </div>  
               <div class="col-xs-2 col-md-2">
               <button type="button" value="환경설정" style="margin-top: 26px; margin-left:20px; height: 40px; width: 100px;"
                class="btn btn-primary" onclick="location.href='setmain.do'">환경설정</button>
            </div>
            
      </div>
            <div class="col-xs-1 col-md-1"  id="h3"></div>
</div>   
	<!-- 두번째 row  -->
	<div class="row " id="all1">
		<div class="col-xs-1 col-md-1"  id="b1">b1</div>
		
		<!-- 다이어리 구성 내용 -->
		<div class="col-xs-10 col-md-10"  id="b2">
			<div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">1</div>
				<div class="col-xs-1 col-md-1">
				<span class="glyphicon glyphicon-user" style="font-size: 30px; color: red;"></span>
				</div>
				<div class="col-xs-1 col-md-1">
				<span class="glyphicon glyphicon-user" style="font-size: 30px; color: blue;"></span>
				</div>
				<div class="col-xs-1 col-md-1">
				<span class="glyphicon glyphicon-user" style="font-size: 30px; color: yellow;"></span>
				</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">5</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">6</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">7</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">8</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">9</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">10</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">
				<span class="glyphicon glyphicon-menu-hamburger" style="font-size: 30px; color: black;"></span>
				</div>
				<div class="col-xs-1 col-md-1" style="font-size: 30px;">12</div>
			</div>
			
			<!-- 다이어리 제목 -->
			<div class="col-xs-3 col-md-3"></div>
			<div class="col-xs-6 col-md-6">
					<input type="text" class="form-control" value="민준이의 다이어리" style="text-align: center">
			</div>
			<div class="col-xs-3 col-md-3">
			</div>
			
			<!-- 달력 출력 -->
			<div class="col-xs-12 col-md-12" id='calendar'></div>
			<div id="datepicker"></div>
		
		</div>
		
		<div class="col-xs-1 col-md-1"  id="b3">b3</div>
	</div>	 
	
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
 
</div>








</body>
</html>