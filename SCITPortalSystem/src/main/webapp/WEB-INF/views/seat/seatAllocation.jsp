<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/seat/seatAllocation.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/seat/seatAllocation.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.min.css"/>">
	
<title>학생 배치</title>
</head>
<body>
<div class="thePageDiv">
	<h1>학생 배치</h1>
	
	<div class="showClassDiv">
		<div  class="showClassroom">
			<div class="showClassroomInfo">
				<h2>${seatPlacement.seatClassroom}반</h2>
				<br>
				<form id="seatPlan" action="seatModifySave" method="post">
					좌석 수 : <div class="numberOfSeat">${seatPlacement.seatCount}</div>석
					<br>
					<div class="seatInfo">
						${seatPlacement.seatContent}
					</div>
					<input type="hidden" id="seatPlacementNum" name="seatPlacementNum" value="${seatPlacement.seatPlacementNum}">
					<input type="hidden" id="classInput" name="seatClassroom" value="${seatPlacement.seatClassroom}">
					<input type="hidden" id="seatCount" name="seatCount" value="">
					<input type="hidden" id="seatContent" name="seatContent" value="">
				</form>
			</div>
			
			<br>
			<div class="resetButtonDiv">
				<form id="fixButton" action="seatModify" method="post">
					<input type="button" value="좌석 배치 수정하기 " onclick="fixSeatPlacement()">
					<input type="hidden" id="seatPlacementNum" name="seatPlacementNum" value="${seatPlacement.seatPlacementNum}">
				</form>
			</div>
			<div class="blankLowerDiv"></div>
			<div class="saveButtonDiv">
				<input type="button" id="saveButton" value="저장하기 " onclick="saveSeatConfig()">
			</div>
			<br><br><br>
		</div>
	</div>
	<!-- 반 배정을 기다리는 학생을 표시하는 DIV -->
	<div class="studentList">
		<h4>미배정 학생 목록</h4>
		<div id="minimize" onclick="minimize()">숨기기</div>
		<div id="appear" onclick="appear()">최대화</div>
		<hr>
		<div class="studentListScroll">
			<c:forEach items="${getStudents}" var="students" varStatus="status">
				<div id="${status.index}" class="cell">
					<div class="studentPhoto">
						${students.id}
					</div>
					<div class="studentName">
						${students.name}
					</div>
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>









