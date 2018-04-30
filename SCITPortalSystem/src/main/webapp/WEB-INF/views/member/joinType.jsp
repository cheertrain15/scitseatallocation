<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="../resources/css/joinType.css"/>" rel="stylesheet" type="text/css" />
		<title>[Join Type]</title>
	</head>
	
<body>
<%@ include file="../header.jsp" %>

<div class="mainJoin">
	<div class="introJoin">
		<br><br>
		<p>
			<span>▶ 해당하시는 회원종류를 선택해주세요</span>
		</p>
		<br>
	</div>
	<div class="joinTypeMain">
		<ul>
			<li class="joinStaff">
				<a href="joinStaff">
					<img src="../resources/img/staff.jpg" >
					<br><br>
					<p>직원</p>
				</a>
			</li>
			<li class="joinStudent">
				<a href="joinStudent">
					<img src="../resources/img/staff.jpg" >	
					<br><br>
					<p>연수생</p>
				</a>
			</li>
			<li class="joinTeacher">
				<a href="joinTeacher">
					<img src="../resources/img/staff.jpg"  >
					<br><br>
					<p>선생님</p>
				</a>
			</li>
		</ul>
	</div>

</div>

<br>

<%@ include file="../footer.jsp"%>
</body>
</html>