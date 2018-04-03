<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 설문조사 작성</title>

	<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"/></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="./resources/js/survey/surveyCreate.js"/></script>
	<link rel="stylesheet" type="text/css" href="./resources/css/survey/surveyCreate.css"/>
	
</head>
<body>
<h1>Create Survey</h1>

<div id="target">
	<table>
		<tr>
		<td>대상:</td>
		<td>
			<select name="selectAlumni" id="selectAlumni">
			<option>기수 선택</option>
			<option value="${alumni}">${alumni}기</option>
			</select>
		</td>
		<td>
			<select name="selectClass" id="selectClass">
			<option>반 선택</option>
			<option value="all">전체</option>
			<c:forEach items="${classRoom}" var="cl">
			<option value="${cl}">${cl}</option>
			</c:forEach>
			</select>
		</td>
		<td>설문시작일:</td>
		<td>
		<input type="text" name="surveyStartDate" id="surveyStartDate">
		</td>
		<td></td>
		<td>설문마감일:</td>
		<td>
		<input type="text" name="surveyEndDate" id="surveyEndDate">
		</td>
		</tr>
	</table>
	<input type="button" value="설문조사 저장">
</div>

<div id="toolBar">
<p>Tool bar</p>
<div class="tools" id="singleinput">Single Input</div>
<div class="tools" id="radiogroup">Radiogroup</div>
<div class="tools" id="checkbox">Checkbox</div>
<div class="tools" id="dropdown">Dropdown</div>
<div class="tools" id="comment">Comment</div>
</div>

<div id="editPage">
<p>Edit page</p>

<select id="pages">
<option value="1">page1</option>
</select>

<input type="button" value="+" id="addPage" onclick="javascript:addPage()">
</div>

<div id="surveyCanvas">
<div class="canvases" id="canvas1" style="z-index:1;">
<p>page1</p>
</div>
</div>

<div id="editSurvey">
<p>Edit Survey Option</p>
</div>

</body>
</html>