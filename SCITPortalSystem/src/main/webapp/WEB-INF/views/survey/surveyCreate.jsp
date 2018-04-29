<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 생성</title>

	<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js' />"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/survey/surveyCreate.js' />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/survey/surveyCreate.css' />">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
</head>
<body>
 
<%@ include file="../header.jsp" %>

<div id="bodyWrap">

<div id="infoWrap">
	<table>
		<tr>
			<td>
				<select name="selectCategory">
					<option disabled value="">분류</option>
					<option value="0">만족도</option>
					<option value="1">반배치</option>
					<option value="2">자격증</option>
					<option value="3">기타</option>
				</select>
			</td>
			<td>
				<select id="selectAlumni">
					<option disabled value="">설문대상 기수</option>
					<option value="${alumni}">${alumni}기</option>
				</select>
			</td>
			<td>
				<select name="selectClass" id="selectClass">
					<option disabled value="">설문대상 반</option>
					<option value="ALL">전체</option>
					<c:forEach items="${classRoom}" var="cl">
					<option value="${cl}">${cl}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="text" id="surveyStartDate" placeholder="설문 시작일">
			</td>
			<td> ~ </td>
			<td>
				<input type="text" id="surveyEndDate" placeholder="설문 종료일">
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<input type="text" size="80" id="surveyTitle" placeholder="설문 제목을 입력하세요.">
			</td>
			<td>
				<input type="button" value="설문 생성" id="saveSurvey">
			</td>
		</tr>
	</table>
</div>

<div id="toolsWrap">

	<div class="tools" id="singleinput">Single Input</div>
	<div class="tools" id="radiogroup">Radiogroup</div>
	<div class="tools" id="checkbox">Checkbox</div>
	<div class="tools" id="dropdown">Dropdown</div>
	<div class="tools" id="comment">Comment</div>

</div> 
  
<div id="pagesWrap">

	<select id="pages">
		<option value="page1">페이지 1</option>
	</select>
	
	<input type="button" value="페이지 추가" onclick="javascript:addPage()">
	<input type="button" value="페이지 삭제" onclick="javascript:subPage()">

</div>

<div id="questionsWrap">
	
	<div id="page1" class="pages">
	<h1>페이지 1</h1>
	
	</div>
</div>

<div id="attributeWrap">
</div>

</div>

<%@ include file="../footer.jsp"%>
</body>
</html>