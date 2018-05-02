<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="../resources/css/joinType.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
		<title>[Join Type]</title>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<br><br>
<div class="mainJoin">
	<div class="introJoin" style="left: 27%;position: absolute;">
		<p style="border-radius: 6px;">
			<span>▶ Welcome To The SCIT PORTAL</span>
		</p>	
	</div>
	<br><br>
	<div class="joinTypeMain">
		<ul>
			<li class="joinStaff">
				<a href="joinStaff">
					<img src="../resources/img/staff.jpg" >
					<br><br>
					<p>STAFF</p>
				</a>
			</li>
			<li class="joinStudent">
				<a href="joinStudent">
					<img src="../resources/img/staff.jpg" >	
					<br><br>
					<p>STUDENT</p>
				</a>
			</li>
			<li class="joinTeacher">
				<a href="joinTeacher">
					<img src="../resources/img/staff.jpg"  >
					<br><br>
					<p>TEACHER</p>
				</a>
			</li>
		</ul>
	</div>
</div>


<br>

<%@ include file="../footer.jsp"%>
</body>
</html>