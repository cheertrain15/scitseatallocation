<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 응답현황</title>
<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="./resources/js/survey/surveyAnswer.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/survey/surveyAnswer.css">
</head>
<body>
<%@ include file="../header.jsp" %>

	<div id="tableWrap">
	<table>
		<thead>
			<tr> 
				<th colspan="3">대상</th>
				<th colspan="${questionList.size()}">설문 내용</th>
			</tr>
			<tr>
				<th>이름</th>
				<th>기수</th>
				<th>반</th>
				<c:forEach items="${questionList}" var="q">
				<th><strong>${q.surveyQuestionContent}</strong></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${respondTargetStudentsList}" var="s" varStatus="vst">
				<tr>
					<td>${s.name}</td>
					<td>${s.alumni}기</td>
					<td>${s.classroom}반</td>
					<c:forEach items="${respondContentList}" var="c">
						<c:if test="${s.memberNum == c.memberNum}">
							<c:if test="${c.surveyOptionContent != null}">
							<td>${c.surveyOptionContent}</td>
							</c:if>
							<c:if test="${c.surveyRespondContent != null}">
							<td>${c.surveyRespondContent}</td>
							</c:if>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
<%@ include file="../footer.jsp"%>
</body>
</html>