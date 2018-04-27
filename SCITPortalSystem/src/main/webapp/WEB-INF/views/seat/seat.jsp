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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.structure.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.theme.min.css"/>">
	
</head>
<body>
<!-- 화면에 전체에 현재 div로 채워 넣기 -->
<!-- 이유 : 각 DOM 위치를 편하게 조정할 수 있게-->
<div class="thePageDiv">

	<h1>학생 반 배치</h1>
	
	<!-- 로그인한 선생님이 담당 하는 기수만 보여주기 -->
	<div>
		<div class="autoAllocation">
		담당 기수 : ${sessionScope.loginedAlumni}기
		</div>
	</div>
		
		<div id="seatJSP">
			<h1>자리 배치도</h1>
			<br>
			<!-- 선생님/관리자 전용 -->
			<!-- 자동으로 반배치하는 링크 -->
			<c:if test="${sessionScope.loginMemberClass == 'teacher' || sessionScope.loginMemberClass == 'admin'}">
				<div>
					<a href="seatConfig"><input type="button" value="새로 만들기"></a>
				</div>
			</c:if>
			<br>
			<div class="showClassDiv">
				
					<c:if test="${loginedStaffSeatPlacement != null}">
						<input type="hidden" id="seatPlacementSize" value="${loginedStaffSeatPlacement.size()}">
							<c:forEach items="${loginedStaffSeatPlacement}" var="classList" varStatus="status">
										<div id="showClassroom${status.index}" class="showClassroom" hide="0">
											<div id="previousClassroom" class="previousClassroom" onclick="previousClassroom('${status.index}')">
												◁
											</div>
											<div class="blankDiv"></div>
											<div id="nextClassroom" class="nextClassroom" onclick="nextClassroom('${status.index}')">
												▷
											</div>
												<h3>${classList.seatClassroom}반</h3>
												<br>
												좌석 수 : ${classList.seatCount}석
												${classList.seatContent}
											<br>
											<c:if test="${sessionScope.loginMemberClass == 'teacher' || sessionScope.loginMemberClass == 'admin'}">
												<div class="deleteButtonDiv">
													<input type="button" value="반 배치 삭제 " onclick="deleteSeatPlacement('${classList.seatPlacementNum}')">
												</div>
												<div class="blankLowerDiv"></div>
												<div class="fixButtonDiv">
												
														<input type="button" value="반 배치 수정" onclick="fixSeatPlacement('${classList.seatPlacementNum}')">
										
												</div>
												<div class="blankLowerDiv"></div>
												<div class="allocateButtonDiv">
												
														<input type="button" value="학생 배치 " onclick="allocateSeatPlacement('${classList.seatPlacementNum}')">
											
												</div>
											</c:if>
											<br><br><br>
										</div>
							</c:forEach>
					</c:if>
					
					<c:if test="${loginedStaffSeatPlacement == null
									|| loginedStaffSeatPlacement.isEmpty()
									|| loginedStaffSeatPlacement.size() == 0
									|| loginedStaffSeatPlacement == ''}">
						<h3>생성된 반 배치도가 없습니다.</h3>
						<br>
					</c:if>
			
			</div>
		</div>
		
		
</div>	
</body>
</html>