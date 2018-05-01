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
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
<title>학생 배치</title>
</head>
<body>
<div >
	<%@ include file="../header.jsp" %>
</div>
<br><br><br><br><br>
<div class="thePageDiv">
	<div id="seatAllocation">
	<h1>학생 배치</h1>
	</div>
	<div class="showClassDiv">
		<div  class="showClassroom">
			<div class="showClassroomInfo">
				<div id="classname">
					<h2>${seatPlacement.seatClassroom}반</h2>
				</div>
				<br>
					좌석 수 : <div class="numberOfSeat">${seatPlacement.seatCount}</div>석
					<br>
					
					<form id="seatPlan" action="seatAllocationSave" method="post">
						<div class="seatInfo">
							${seatPlacement.seatContent}
						</div>
						<input type="hidden" id="seatPlacementNum" name="seatPlacementNum" value="${seatPlacement.seatPlacementNum}">
						<input type="hidden" id="dispatchedSeatPlacement" name="dispatchedSeatPlacement" value="">
						<input type="hidden" id="studentNumOfStudentList" name="studentNumOfStudentList" value="">
					</form>				
					
					<!-- 반 배정을 기다리는 학생을 표시하는 DIV -->
				
					<div class="studentList">
						<div id="noAllocation">
							<h4>미배정 학생 목록</h4>
						</div>
						<!-- 
						<div id="minimize" onclick="minimize()">숨기기</div>
						<div id="appear" onclick="appear()">최대화</div>
						 -->
						<br>
						<!-- 자동 배치 버튼 -->
						<input type="button" id="autoAllocation" value="자동배치">
						<br><br>
						<div class="studentListScroll">
							<input type="hidden" id="evaluationCount" value="${evaluationCount}">
							<input type="hidden" id="conductedSurvey" value="${conductedSurvey}">
							<c:forEach items="${getStudents}" var="students" varStatus="status">
								<div id="cell${status.index+1}" class="cell">
									<div class="studentPhoto">
										<img id="photo" src="downLoad?id=${students.id}"/> 
										<!-- 
										${students.id}
										 -->
									</div>
									<div class="studentName" value="${students.name}">
										${students.name}
									</div>
									<input type="hidden" class="memberstudentNum" name="memberstudentNum" value="${students.memberstudentNum}">
									<input type="hidden" class="id" name="id"  value="${students.id}">					
									<input type="hidden" class="classroom" name="classroom"  value="${seatPlacement.seatClassroom}">
									<input type="hidden" class="seat" name="seat"  value="0">
									<input type="hidden" class="itMajor" value="${students.itMajor}">
									<input type="hidden" class="jpMajor" value="${students.jpMajor}">
									<input type="hidden" class="memberNum" value="${students.memberNum}">
									<input type="hidden" class="avoidPerson" value="${students.avoidPerson}">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			<br><br>
			<div class="saveButtonDiv">
				<input type="button" id="saveButton" value="저장하기 " onclick="saveSeatConfig()">
			</div>
			<br><br>
		</div>
	</div>
</div>
<br><br><br>
<div >
	<%@ include file="../footer.jsp"%>
</div>			
</body>
</html>









