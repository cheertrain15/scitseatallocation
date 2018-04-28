<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 목록</title>
 
	<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="./resources/js/survey/survey.js"></script>
	<link rel="stylesheet" type="text/css" href="./resources/css/survey/survey.css">
		
</head>
<body> 

<%@ include file="../header.jsp" %>
<br><br><br><br><br><br>
	
	<c:if test="${memberClass == 'teacher'}">
	<a href="surveyCreate" class="surveyAtag"><input type="button" value="새설문작성"></a>
	<br><br>
	</c:if>

	<div> 
		<table>
			<tr>
				<td>글번호</td>
				<td>분류</td>
				<td>대상 기수</td>
				<td>대상 반</td>
				<td>제목</td>
				<td>작성자</td>
				<td>설문 작성일</td>
				<td>설문 시작일</td>
				<td>설문 마감일</td>
				<c:if test="${memberClass == 'teacher' }">
					<td>참여자 수</td>
				</c:if>
				<c:if test="${memberClass == 'student' }">
					<td>참여 여부</td>
				</c:if>
			</tr>
			<c:forEach items="${list}" var="v" varStatus="st">
			<tr>
				<td>${v.surveyNum}</td>
					<c:if test="${v.surveyCategory == 0}">
						<td>만족도</td>
					</c:if>
					<c:if test="${v.surveyCategory == 1}">
						<td>반배치</td>
					</c:if>
					<c:if test="${v.surveyCategory == 2}">
						<td>자격증</td>
					</c:if>
					<c:if test="${v.surveyCategory == 3}">
						<td>기타</td>
					</c:if>
				<td>${v.surveyTargetAlumni}기</td>
				<c:if test="${v.surveyTargetClassroom != 'ALL'}">
					<td>${v.surveyTargetClassroom}반</td>
				</c:if>
				<c:if test="${v.surveyTargetClassroom == 'ALL'}">
					<td>전체</td>
				</c:if>
				<td>
					<c:if test="${memberClass == 'teacher' }">
						<a href="surveyDetail?surveyNum=${v.surveyNum}" class="surveyAtag">${v.surveyTitle}</a>
					</c:if>
					<c:if test="${memberClass == 'student' }">
						<c:if test="${checkRespondList[st.index] == '미참여'}">
						<a href="surveyDetail?surveyNum=${v.surveyNum}" class="surveyAtag">${v.surveyTitle}</a>
						</c:if>
						<c:if test="${checkRespondList[st.index] == '참여'}">
						${v.surveyTitle}
						</c:if>
					</c:if>
				</td>
				<td>${v.name}</td>
				<td>${v.surveyWrittenDate}</td>
				<td>${v.surveyStartDate}</td>
				<td>${v.surveyEndDate}</td>
				<c:if test="${memberClass == 'teacher' }">
					<td>
						<a class="surveyAtag" href='checkSurveyRespondStatus?surveyNum=${v.surveyNum}&surveyTargetAlumni=${v.surveyTargetAlumni}&surveyTargetClassroom=${v.surveyTargetClassroom}'>${sizeList[st.index]}</a>
					</td>
				</c:if>
				<c:if test="${memberClass == 'student' }">
					<td>${checkRespondList[st.index]}</td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="pageGroup">
		<ul>
			<c:if test="${navi.currentPage > 1}">
				<li><a href="survey?page=1"><input class="button"
						type="button" value="맨앞"></a></li>
			</c:if>
			<c:if test="${navi.startPageGroup > 1 }">
				<li><a href="survey?page=${navi.startPageGroup-1}"><input
						class="button" type="button" value="이전"></a></li>
			</c:if>
			<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}"
				var="p">
				<c:if test="${navi.currentPage == p}">
					<li>${p}</li>
				</c:if>
				<c:if test="${navi.currentPage != p}">
					<li><a href="survey?page=${p}" class="pageNumber">${p}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${navi.endPageGroup < navi.totalPageCount }">
				<li><a href="survey?page=${navi.endPageGroup+1}"><input
						class="button" type="button" value="다음"></a></li>
			</c:if>
			<c:if test="${navi.currentPage != navi.totalPageCount}">
				<li><a href="survey?page=${navi.totalPageCount}"><input
						class="button" type="button" value="맨뒤"></a></li>
			</c:if>
		</ul>
	</div>
		
<%@ include file="../footer.jsp"%>

</body>
</html>