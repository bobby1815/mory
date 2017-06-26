<%@ page contentType="text/html; charset=UTF-8"%>

<!--  <div class="row " id="all0">
	<div class="col-xs-1  col-md-1" id="h1">h1</div>
		<div class="col-xs-10 col-md-10" id="mainMemu">
			<ul>
				<li><a href="#">뉴스피드</a></li>
				<li><a href="#">다이어리</a></li>
				<li><a href="#">MORY</a></li>
				<li><a href="#">커뮤니티</a></li>
				<li><a href="#">환경설정</a></li>
			</ul>
		</div>
	<div class="col-xs-1 col-md-1" id="h3">h3</div>
</div>  -->


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
                       <!-- <span style="font-size:30px; text-align: center;"><b>MORY</b></span> -->
                       <img src="img/Mainlogo.png" width="100" />
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
            
 