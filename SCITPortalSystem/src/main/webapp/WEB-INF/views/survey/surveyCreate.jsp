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
		
		<select name="alumni" id="alumni">
		<option>기수 선택</option>
		<option>34기</option>
		<option>35기</option>
		</select>
		
		</td>
		<td></td>
		<td></td>
		</tr>
	</table>
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
</div>

<div id="surveyCanvas">
<p>Survey Canvas</p>
</div>

<div id="editSurvey">
<p>Edit Survey Option</p>
</div>

</body>
</html>