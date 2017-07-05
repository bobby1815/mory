<%@ page contentType="text/html; charset=UTF-8"%>


<style type="text/css">
#all0
{
	padding: 0;
	margin: 0 auto;
	width: 100%;
	background-color: lightyellow;
	
} 

      #menubtn {
        text-align: center;
        width: 100%;
      }
      #menubtnFixed {
        position: fixed;
        top: 0px;
      }


</style>
<script>
$( document ).ready( function() {
    var jbOffset = $( '#menubtn' ).offset();
    $( window ).scroll( function() {
      if ( $( document ).scrollTop() > jbOffset.top ) {
        $( '#menubtn' ).addClass( '#menubtnFixed' );
      }
      else {
        $( '#menubtn' ).removeClass( '#menubtnFixed' );
      }
    });
  } );

</script>
	
      <div class="row " id="all0">
       <div class="col-xs-1  col-md-1"  id="h1"> </div> 
      <div class="col-xs-12 col-md-12" id="h2" >
            <div  class="col-xs-2 col-md-2" style="margin-top: 26px;">
              <img src="img/newsfeed123.png" id="menubtn" height=40px; width=100px; align="middle" onclick="location.href='newsfeedlist.do'" />    
        <!--        <button type="button" value="뉴스피드" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" 
               class="btn btn-primary" onclick="location.href='newsfeedlist.do'" >뉴스피드</button> -->
            </div>
            <div class="col-xs-2 col-md-2" style="margin-top: 26px;">  
            <img src="img/diary.png" id="menubtn" height=40px; width=100px; align="middle" onclick="location.href='diary.do'" />    
               <!-- <button type="button" value="다이어리" style="margin-top: 26px; margin-right:20px; height: 40px; width: 100px;" 
               class="btn btn-primary"  onclick="location.href='diary.do'">다이어리</button> -->
            </div>
            <div class="col-xs-4 col-md-4"style="text-align: center;">   
               <a href="newsfeedlist.do" style="margin:0px ; color:black;">
                     <img src="img/Mory_logo.png" width="100"/>
                      <img src="img/Mainmory.png" width="100" />
                   </a>
               </div>
               <div class="col-xs-2 col-md-2" style="margin-top: 26px;"> 
               		<img src="img/community123.png" id="menubtn" height=40px; width=100px; align="middle" onclick="location.href='communitymain.do'" />   
          <!--          <button type="button" value="커뮤니티" style="margin-top: 26px; margin-left:20px;  height: 40px; width: 100px;"
                    class="btn btn-primary" onclick="location.href='communitymain.do'">커뮤니티</button> -->
               </div>  
               <div class="col-xs-2 col-md-2" style="margin-top: 26px;">
               <img src="img/setup.png"  id="menubtn" height=40px; width=100px; align="middle" onclick="location.href='setmain.do'" /> 
              <!--  <button type="button" value="환경설정" style="margin-top: 26px; margin-left:20px; height: 40px; width: 100px;"
                class="btn btn-primary" onclick="location.href='setmain.do'">환경설정</button> -->
            </div>
            
      </div>
             <div class="col-xs-1 col-md-1"  id="h3"> </div> 
</div>   
            
 