<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 반 배치</title>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/seat/seat.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/seat/seat.css"/>">
	
</head>
<body>
<!-- 화면에 전체에 현재 div로 채워 넣기 -->
<!-- 이유 : 각 DOM 위치를 편하게 조정할 수 있게-->
<div>

	<h1>학생 반 배치</h1>
	
	<!-- 로그인한 선생님이 담당 하는 기수만 보여주기 -->
	<div>
		
		담당 기수 : ${loginedStaffInfo.inChargeAlumni}기
		
	</div>
	
		<!-- 테이블 모드, 배치도 모드 버튼 -->
		<div>
			<a href="seatpage">배치도로 보기</a>
		</div>
		
		<div id="seatJSP">
			<h1>테이블 모드</h1>
			
		</div>
		
		<!-- 반 배치를 수동으로 제작/수정하기 링크 -->
		<div>
			<a href="seatModify">수정하기</a>
		</div>
		
		<!-- 자동으로 반 배치하는 링크 -->
		<div>
			<a href="seatAuto">자동배치</a>
		</div>
	
</div>	
</body>
</html>