<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<script type="text/javascript">
	
	function alarmResult(requ_seq, obj)
	{
		var value = obj.value;
		//alert(value);
		/* 
		var url = "commonalarmresult.do?requ_seq="+requ_seq+"&result_yn="+value;
		$(location).attr("href",url);
		 */
		$.post("commonalarmresult.do",{requ_seq : requ_seq, result_yn : value}, function(data)
		{
			$("#listDiv").html(data).find("#listDiv");
		});
	}

</script>
<body>
           <!--  <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header" style="text-align: center; color: black;">
                        <h4>알림</h4>
                     </div> -->
                     <div class="modal-header" style="text-align: center; color: black;">
                        <h5>알림</h5>
                     </div>
						<div class="modal-body" style="height: 600px;" id="listDiv">
							<c:if test="${alarmList.size() == null}">
								<p>초대 내역이 존재하지 않습니다.</p>
							</c:if>
							<c:forEach var="dto" items="${alarmList}">
							<div class="col-xs-12 col-md-12" style="border: 1px solid; height: 50px;">
							<div class="col-xs-3 col-md-3" style="">
								<img src="img/user.PNG" alt="" style="height: 45px; margin-right: 800px;" />
							</div>
							<div class="col-xs-6 col-md-6" style="color: black;">
								<p>${dto.requ_user_nic}님께서 ${dto.share_diary_name} 로 초대하였습니다.</p>
							</div>
							<div class="col-xs-3 col-md-3" style="text-align: right; margin-top: 10px;">
								<%-- 
								<button type="button" id="acceptBtn" value="Y" onclick="alarmResult('${dto.requ_seq}',this)">수락</button>
							    <button type="button" id="rejectionBtn" value="N" onclick="alarmResult('${dto.requ_seq}',this)">거절</button>
								 --%>	
							      <button type="button" id="acceptBtn" value="Y" onclick="alarmResult('${dto.requ_seq}',this)">수락</button>
							      <button type="button" id="rejectionBtn" value="N" onclick="alarmResult('${dto.requ_seq}',this)">거절</button>
							      
							   </div>
							</div>
							</c:forEach>
						</div>
                    <!--  <div class="modal-footer "></div>
                  </div>
               </div>
            </div>
 -->


<!-- 깃은 왜잘 안되는걸까요 -->




</body>
</html>