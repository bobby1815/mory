<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Common_Profile.jsp</title>
</head>
<body>

</body>
</html> -->
<!-- 
<div class="modal fade" id="myinfo" tabindex="-1" role="dialog"
               aria-labelledby="myModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                  <div class="modal-content">
                   -->
                     <div class="modal-header" style="text-align: center;">
                        <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4> -->
						
							<c:choose>
								<c:when test="${userDTO.acce_user_nic != null }">
									<div>${userDTO.user_nic }<img  src="img/redheart.png" width="30px" id="partner"> ${userDTO.acce_user_nic}</div>
								</c:when>
								<c:otherwise>
									<button type="button" onclick="location.href='memberinvite.do?mem_rel_code=10&nei_user_id=${userDTO.user_id}'">배우자 신청</button>								
								</c:otherwise>
							</c:choose>
							</div>
							
							<div class="modal-body" style="text-align: center;">
							<img src="/profileupload/${userDTO.profile_location }" style="width: 300px; height: 500px;" ><br>
								이름 : ${userDTO.user_name } <br> 닉네임 : ${userDTO.user_nic}
								
								배우자 : ${userDTO.acce_user_nic }
							</div>
							<div class="modal-footer ">
                   
                     <div class="modal-footer ">

                        <div class="col-xs-12 col-md-12">
                           <div class="col-xs-4 col-md-4" style="text-align: left;">
                              <button type="button" value="뉴스피드">뉴스피드</button>
                           </div>
                           <div class="col-xs-4 col-md-4" style="text-align: center;">
                              <button type="button" class="btn btn-default" data-dismiss="modal">돌아가기</button>
                           </div>
                           <div class="col-xs-4 col-md-4" style="text-align: right;">
                              <button type="button" value="커뮤니티">커뮤니티</button>
                           </div>
                        </div>


                        <div class="col-xs-12 col-md-12">
                           <div class="col-xs-4 col-md-4" style="text-align: left;">
                              <button type="button" value="다이어리">다이어리</button>
                           </div>
                           <div class="col-xs-4 col-md-4"></div>
                           <div class="col-xs-4 col-md-4" style="text-align: right;">
                              <button type="button" value="개인정보">개인정보</button>
                           </div>
                        </div>
                     </div>
                     <!-- 
                  </div>
               </div>
            </div>
 -->

