<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="../js/admin/admin.js"/>"></script>
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />
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

	<form action="management" method="get" id="pagingForm">	
			<input type="hidden" name="page" id="page">	<!-- 현재 페이지 값을 갖고 컨트롤러로 전달해준다 -->
			
			<select id="selectTy" name="searchList">
			
			<!-- "selected" 생략해도 됨 -->
			<option value="id"
			<c:if test="${searchList == 'id' }">			
			selected = "selected" 
			</c:if>			
			>ID</option> 
			
			
			<option value="name"
			<c:if test="${searchList == 'name' }">
			selected = "selected"	
			</c:if> 
			>Name</option>
			
				
			<option value="content"
			<c:if test="${searchList == 'memberClass' }">
			selected = "selected"	
			</c:if> 
			>Type</option>
						
			</select>
			
			<input id="searchTextbx" type="text" name="searchText" value="${searchText }">
			<input id="searchbt" type="button" value="Search" onclick="pagingFormSubmit(1)" >	
			<!-- 검색한 뒤에는 항상 첫번째 페이지로 가기 때문에 -->	
		</form>
	<div class="pagaingbt">
			<a href="javascript:pagingFormSubmit(1)">◁◁</a>	<!-- 첫 번째 페이지로 이동 -->
			<a href="javascript:pagingFormSubmit(${navi.currentPage - 1})">◀</a>
			<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
				<c:if test="${counter == navi.currentPage }">					
					<b>	<!-- b태그는 진하게 if태그를 두 번 쓴 이유는 조건에 맞으면 b태그를 열고 닫는다 라는 뜻 -->
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter })">${counter}</a>
				<c:if test="${counter == navi.currentPage }">
					</b>	
				</c:if>
			</c:forEach>
				
			<a href="javascript:pagingFormSubmit(${navi.currentPage + 1 })">▶</a>
			<a href="javascript:pagingFormSubmit(${navi.totalPageCount})">▷▷</a>	<!-- 마지막 페이지로 이동 -->
		<br><br>
	</div>		
<%@ include file="../footer.jsp"%>
</body>
</html>