<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../css/Mainmenu.css" />
<link rel="stylesheet" href="css/acordian.css" />
  
<title>ho</title>

<script type="text/javascript">



/* Toogle Button Function*/
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
   <!-- header -->
      
      
   <!--    Center  --> 
      <div class="row " id="Center">
      
      <!-- Center_left  -->
            <div class="col-xs-1 col-md-1"  id="b1"></div>

		<!--Center-middle   -->
            <div class="col-xs-10 col-md-10" id="b2" style="height: 800px;">
            
          <!--Center -middle left  -->  	
           <div class="col-md-3" id="b2_left" style="width: 20%; height: 700px; ; ">
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
          
          <!--Center middle-middle  -->
           <div class="col-md-6" id="b2_center" style="width: 45%; height: 700px; ">
           <div class="panel-group" id="accordion">
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">회원가입은 무료인가요?</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse collapse">
        <div class="panel-body">
		
		Mory 회원가입은 무료입니다.
		<br>
		> Mory 회원으로 가입을 원하실 경우,<br /> 메인홈페이지 로그인 입력 상단에서 "아직도 가족이 아니세요?"을 클릭하세요.  

			</div>
      </div>
    </div>
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">회원가입을 하고싶은데 나이제한이 있나요?</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        Mory 회원으로 가입하시기 위해서는 만 14세 이상이 되어야 합니다.<br><br />
		만 14세 미만은 보호자 동의가 있는 경우라도 MORY에 가입할 수 없습니다.<br><br />
		<br /><br />
		> Mory 회원으로 가입을 원하실 경우,<br /> 메인홈페이지 로그인 입력 상단에서 "아직도 가족이 아니세요?"을 클릭하세요. <br /><br /> 
        
        </div>
      </div>
    </div>
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">탈퇴하면 개인정보는 모두 삭제되나요?</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        회원탈퇴를 원하시면 고객센터로 아래 필요한 정보를 보내주시기 바랍니다.<br>

1. MORY 유저아이디<br />
				<br />
				<br />
■ 회원탈퇴 시, 유의 사항<br /><br />
 
 탈퇴를 신청하신 시점을 시작으로 14일간의 탈퇴결정 여부시간을 드립니다.<br />
 보유하고 계신 공유다이어리의 모든정보가 삭제됩니다. 탈퇴유예기간내에 미리 백업을 해주시기 바랍니다.<br />
  
고객센터 (070-xxxx-xxxx)<br />
이메일: bobby1815@naver.com<br />
카카오톡 플러스친구: @bobby1815 <br /></div>
      </div>
    </div>
  
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">서비스 운영시간은 어떻게 되나요?</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">
       	 고객센터(070-xxxx-xxxx)는 평일 09:30 ~ 18:30 시간동안 운영됩니다.

		(토요일과 일요일 그리고 국경일은 운영하지 않습니다.)</div>
      </div>
    </div>
    
    
      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">모바일 이용이 가능한가요?</a>
        </h4>
      </div>
      <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">
			● 현재 MORY 서비스는 Web 브라우저 만을 지원하고 있습니다.
			<br /><br />
			 - 모바일 서비스는 현재 개발단계에 있습니다. <br />
			 - 빠른 시일내에 모바일로 찾아뵙도록 하겠습니다.
			
			
		</div>
      </div>
    </div>
    
    
      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">제 계정이 해킹 당하였습니다</a>
        </h4>
      </div>
      <div id="collapse6" class="panel-collapse collapse">
        <div class="panel-body">
      회원탈퇴를 원하시면 고객센터로 아래 필요한 정보를 보내주시기 바랍니다.<br>

1. MORY 유저아이디<br />
2. 회욉가입에 기제한 정보 ex) 이메일 , 전화번호,아이디,생년월일<br />
				<br />
■ 개인정보 보호<br /><br />
 
 해킹에 대비하여 늘 최선을 다하고 있으며<br>
저희 고객센터르 문의하여 주시면 더 빠른 상담을 진행하실 수 있습니다.
    
고객센터 (070-xxxx-xxxx)<br />
이메일: bobby1815@naver.com<br />
카카오톡 플러스친구: @bobby1815 <br /></div>

		</div>
      </div>
    </div>
      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">동영상 및 사진이 업로드가 되지 않고있습니다.</a>
        </h4>
      </div>
      <div id="collapse7" class="panel-collapse collapse">
        <div class="panel-body">
        <h4>●아래와 같은 방법을 시행해 보시기 바랍니다.</h4>
        <hr />
	1.시작> 실행> services.msc 입력합니다<br>
"Error Reporting Service"들어가면<br>
일반 탭에서 시작 유형의 다운 메뉴를 클릭하고 시작 유형을 "사용안함"으로 변경
"중지" 버튼을 클릭<br>

2.제어판> 시스템> 고급 탭 밑에 "오류보고" 버튼을 클릭
오류 보고 창에서 "오류 보고 사용 안 함" 체크<br>

3.제어판> 시스템> 고급 탭 밑에 "시작 및 복구"의 설정버튼을 클릭
"시스템 오류" 항목에서 모든 항목의 체크해제<br>
 
제어판> 인터넷옵션><br>
1.일반 탭에서 <br>
-"임시인터넷 파일" 항목에서 "쿠키삭제"클릭<br> 
-"파일삭제"를 하면 "오프라인 항목을 모두삭제" 체크 하고 확인<br> 
-또 그옆에<br>"설정" 클릭해서 "저장된 페이지의 새 버전 확인:" 항목에서 "자동으로" 설정<br>
-그리고 "임시인터넷 파일폴더" 항목에서 사용할 디스크공간을 100 MB정도로 설정<br>
-밑에 "색"을 클릭<br>"Windows 색상표사용" 체크<br>
-"글꼴"클릭 →한국어<br>
-"언어"클릭 →한국어 [ko]<br>
-"사용자 서식"클릭 →모두체크해제 
(적용을 클릭해가며 탭을 이동하세요)<br>
2.개인정보 탭에서 <br>
-고급을 클릭해서 "자동쿠키처리 덮어쓰기" 체크 <br>
-"제1사쿠키" 적용, "제3사쿠키"적용 으로 설정<br>
-"항상 세션에 쿠키 허용"에 체크하고 확인<br>
3.내용 탭에서<br>
-"개인정보" 항목에서 "자동완성" 클릭<br>
-"자동완성 사용대상" 항목에서 모두체크<br>
-"자동완성 기록지우기" 항목에서 "폼지우기"클릭, "암호지우기"클릭<br>
4.연결 탭<br>
-LAN 설정 항목에서 "LAN 설정" 클릭하여 들어가서<br>모두 체크해제<br>
5.프로그램 탭<br>
-"시작할때 기본 브라우저확인" 체크<br>
6.고급 탭에서는<br>
-기본값복원 클릭<br>
-멀티미디어 항목에서 "이미지크기 자동 조정 가능"을 제외하고 모두 체크<br>
-"모든 스크립트 오류에 관련된 알림 표시" 체크해제<br>
-"스크립트 디버깅 사용안함" 둘다체크<br>
-"예약 시 동기화할 오프라인 항목 사용" 체크해제<br>
-"웹 페이지의 단추 및 컨트롤에 시각 스타일 사용" 체크해제<br>
-"타사 브라우저 확장명 사용(다시 시작해야 함)" 체크해제<br>
-"HTTP 오류 메시지 표시" 체크해제<br>
-"URL을 항상 UTF-8로 보냄(다시 시작해야 함)" 체크해제<br>
-"프록시 연결을 통해 HTTP 1.1사용" 체크 해제<br>
</div>
      </div>
    </div>
    

  </div> 
           
            <!--center-middle-middle end  -->
            </div>
           <!--b2 center middle right  -->
           <div class="col-md-3" style="width: 30%; height: 700px; background-color: ">
           
           
            <!--center-middle right end  -->
           </div>
           
      
           <!--center-middle end  -->
           </div>
           
           
           
           
			<!--Center right  -->
            <div class="col-xs-1 col-md-1"  id="b3">
            <!-- Acordian Action -->
           <div class="w3-container">
           
			<a onclick="myFunction('Demo1')" style="width: 100px; " class="glyphicon glyphicon-plus-sign btn-lg"></a>
			<c:import url="../../tooglebtn.jsp"/> 
            </div>
	 <!--Center End  -->
     </div>



      
      
      
      <!-- Footer  -->
      <div class="row " id="Footer">
            <div class="col-xs-1 col-md-1"  id="f1">f1</div>
            
            <div class="col-xs-10 col-md-10"  id="f2">f2</div>
            
            <div class="col-xs-1 col-md-1"  id="f3">f3</div>
      </div>      
 
</div>
</body>
</html>