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
	<script type="text/javascript" src="<c:url value="/resources/js/seat/seatModify.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/seat/seatModify.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.min.css"/>">
	
<title>좌석 배치 수정하기</title>
</head>
<body>
<div class="thePageDiv">
	<h1>좌석 배치 	수정하기</h1>
	
	<div class="showClassDiv">
		<div  class="showClassroom">
			<div>
				<h2>${seatPlacement.seatClassroom}반</h2>
				<br>
				<form id="seatPlan" action="seatModifySave" method="post">
					좌석 수 : <div class="numberOfSeat" value="${seatPlacement.seatCount}">${seatPlacement.seatCount}</div>석
					<br>
					<div class="seatInfo">
						${seatPlacement.seatContent}
					</div>
					<input type="hidden" id="seatPlacementNum" name="seatPlacementNum" value="${seatPlacement.seatPlacementNum}">
					<input type="hidden" id="classInput" name="seatClassroom" value="${seatPlacement.seatClassroom}">
					<input type="hidden" id="seatCount" name="seatCount" value="">
					<input type="hidden" id="seatContent" name="seatContent" value="">
					<input type="hidden" id="deletedStudentNum" name="deletedStudentNum" value="">
				</form>
			</div>
			<br>
			<div class="cancelButtonDiv">
				<input type="button" value="취소하기 " onclick="back()">
			</div>
			<div class="blankLowerDiv"></div>
			<div class="resetButtonDiv">
				<input type="button" id="seatNew" value="초기화 ">
			</div>
			<div class="blankLowerDiv"></div>
			<div class="saveButtonDiv">
				<input type="button" id="saveButton" value="저장하기 " onclick="saveSeatConfig()">
			</div>
			<br><br><br>
		</div>
	</div>
</div>
</body>
</html>