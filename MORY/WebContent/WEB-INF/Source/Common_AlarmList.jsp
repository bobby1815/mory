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
	
	function alarmResult(requ_Seq, obj)
	{
		var value = obj.value;
		//alert(value);
		
		$.post("commonalarmresult.do",{requ_Seq : requ_Seq, result_yn : value}, function(data)
		{
			
		});
		
		return false;
	}

</script>
<body>
           <!--  <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header" style="text-align: center; color: black;">
                        <h4>알림</h4>
                     </div> -->
						<div class="modal-body" style="height: 600px;">
							<c:if test="${alarmList.size() == null}">
								<a>초대 내역이 존재하지 않습니다.</a>
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
							      <button type="submit" id="acceptBtn" value="Y" onclick="loation.href="commonalarmresult.do?requ_seq='${dto.requ_seq}&result_yn=y'">수락</button>
							      <button type="submit" id="rejectionBtn" value="N" onclick="alarmResult('${dto.requ_seq}',this)">거절</button>
							   </div>
							</div>
							</c:forEach>
						</div>
                    <!--  <div class="modal-footer "></div>
                  </div>
               </div>
            </div>
 -->

</body>
</html>