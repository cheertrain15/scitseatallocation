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
<h1>새 설문조사 작성</h1>
<div class="toolBar">

<div class="tools" id="text">텍스트툴</div>
<div class="tools" id="radiogroup">라디오그룹툴</div>
<div class="tools" id="checkbox">체크박스툴</div>


<!-- <ul>
<li class="tools" id="text">텍스트툴</li>
<li class="tools" id="radiogroup">라디오그룹툴</li>
<li class="tools" id="checkbox">체크박스툴</li>
</ul> -->

</div>

<div class="editPage">
<p>page 수정용</p>
</div>

<div class="surveyCanvas">
<p>여기에 tool 드랍하셈~</p>
<div class="questions" id="question">설문 조사 리스트 예시</div>
<!-- <ul id="surveyList">
<li id="question">설문조사 내용 예시 1</li>
</ul> -->

</div>

<div class="editSurvey">
<p>툴 내용 세부 수정</p>
</div>
</body>
</html>