<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="list" items="${userlist }">
	<tr>
	<td><img src="img/1497890377_female-silhouette-sunglasses.png"  width="30px"/></td>
		<td>${list.user_id }</td>
		<td style="color:gray;">${list.user_nic }</td>
		<td><img src="img/neighbor_non.png" width="30px" onclick="memberinvite('${list.user_id}')"/></td>
	</tr>
</c:forEach>