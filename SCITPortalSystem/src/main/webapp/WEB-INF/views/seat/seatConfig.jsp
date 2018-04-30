<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자동 자리 배치 결과</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/seat/seatConfig.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/seat/seatConfig.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.min.css"/>">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<div class="w3-container">
	<%@ include file="../header.jsp" %>
</div>
	<!-- 문희규 : 좌석 배치도를 설정하는 페이지 -->
	<div class="thePageDiv">
	
	<div>
		<h1>자리 배치 설정</h1>
		<br>
		담당 기수 : ${loginedStaffInfo.inChargeAlumni}기
		<br><br>
	</div>	
		
		<!-- 강의실 좌석을 추가하는 버튼 -->
		<div>
			<input type="button" id="seatAdd" value="좌석 추가">
		</div>
		
		
		<div>
				<br>
				<div>
					<input type="text" id="classInput" class ="classInput" name="classInput" maxlength="1"> 반
				</div>
				<br>
				<div id="numberOfSeats"></div>
				<br>	
				<div id="seatTemplate">
					<!-- 강의실 책상배치를 표시하기 (강의실 당 최대 40좌석) -->
					<form id="seatPlan" action="saveSeatConfig" method="post">
						<!-- 강의실 교탁을 표시하기 -->
						<div id="seatPlacement" class="seatPlacement">
							<div>
								<p class="classroomFront">교탁</p>
							</div>
							<br>
						</div>
						<input type="hidden" id="seatInfo" name="seatInfo" value="">
						<input type="hidden" id="classInfo" name="classInfo" value="">
						<input type="hidden" id="seatCount" name="seatCount" value="">
					</form>
				</div>
				
				<br><br>
				<div class="cancelButtonDiv">
					<input type="button" id="cancel" value="뒤로가기" onclick="back()">
				</div>
				<div class="blankDiv"></div>
					<div class="restartDiv">
						<input type="button" value="다시하기" onclick="restart()">
				</div>
				<div class="blankDiv"></div>
					<div class="saveButtonDiv">
						<input type="button" id="save" value="저장하기" onclick="saveSeatConfig()">
				</div>
		</div>
	</div>
	
<div >
	<%@ include file="../footer.jsp"%>
</div>
</body>
</html>