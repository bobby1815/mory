<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/acordian.css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">



<div class="col-xs-1 col-md-1" id="b3">
<nav class="menu">
  <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open"/>
  <label class="menu-open-button" for="menu-open">
    <span class="hamburger hamburger-1"></span>
    <span class="hamburger hamburger-2"></span>
    <span class="hamburger hamburger-3"></span>
  </label>

  <a href="#" class="menu-item"> <i class="fa fa-cog"></i> </a>  
  <a href="newsfeedinsertform.do" class="menu-item"> <i class="fa fa-plus"></i> </a>
  <a href="#" class="menu-item"> <i class="fa fa-heart"></i> </a>
  <a href="commonalarmlist.do" class="menu-item" data-toggle="modal" data-target="#myModal1"> <i class="fa fa-envelope"></i> </a>

</nav>


<!-- filters -->
<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
    <defs>
      <filter id="shadowed-goo">
          
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feGaussianBlur in="goo" stdDeviation="3" result="shadow" />
          <feColorMatrix in="shadow" mode="matrix" values="0 0 0 0 0  0 0 0 0 0  0 0 0 0 0  0 0 0 1 -0.2" result="shadow" />
          <feOffset in="shadow" dx="1" dy="1" result="shadow" />
          <feBlend in2="shadow" in="goo" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
      <filter id="goo">
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feBlend in2="goo" in="SourceGraphic" result="mix" />
      </filter>
    </defs>
    </svg>
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
       
       <%-- 
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
             --%>

    