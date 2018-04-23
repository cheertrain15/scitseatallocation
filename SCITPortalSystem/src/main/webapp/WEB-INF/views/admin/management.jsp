<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="../js/admin/admin.js"/>"></script>
		<title>[Member Management]</title>		
	</head>
<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>

<div class="joinList">
	<div class="row">
		<div class="sub-row">
			<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>Name</th>
					<th>Type</th>
					<th>Phone</th>
					<th>Approval</th>				
				</tr>
			</thead>
			
		<c:forEach var ="MemberBasic" items="${memberList}">
			<tbody>		
			<c:if test="${MemberBasic.id != 'admin'}">	
			<tr>
				<td>${MemberBasic.memberNum}</td>			
				<td>${MemberBasic.id}</td>				
				<td>${MemberBasic.name}</td>
				<td>${MemberBasic.memberClass}</td>
				<td>${MemberBasic.phone}</td>
				<td>
				<c:if test="${MemberBasic.adminap == 0}">					
					<input type="button" i="${MemberBasic.id}" class="btn_click" value="확인"/>								
				</c:if>
				<c:if test="${MemberBasic.adminap == 1}">
					<b>complete</b>				
				</c:if>				
				</td>				
			</tr>	
			</c:if>		
			</tbody>	
		</c:forEach>		
			</table>
		
		
		
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>
</body>
</html>