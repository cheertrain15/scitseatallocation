<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 수정</title>

<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"/></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="./resources/js/survey/surveyEdit.js"/></script>
<link rel="stylesheet" type="text/css" href="./resources/css/survey/surveyEdit.css"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
</head>  
<body>

<%@ include file="../header.jsp" %>

<div id="bodyWrap">

<div id="infoWrap">

	<input type="hidden" value="${survey.surveyNum}" id="getSurveyNum">
	
	<table>
		<tr>
			<td>
				<select id ="selectCategory">
				<c:if test="${survey.surveyCategory == 0 }">
					<option disabled value="">분류</option>
					<option value="0" selected="selected">만족도</option>
					<option value="1">반배치</option>
					<option value="2">자격증</option>
					<option value="3">기타</option>
				</c:if>
				<c:if test="${survey.surveyCategory == 1 }">
					<option disabled value="">분류</option>
					<option value="0">만족도</option>
					<option value="1" selected="selected">반배치</option>
					<option value="2">자격증</option>
					<option value="3">기타</option>
				</c:if>
				<c:if test="${survey.surveyCategory == 2 }">
					<option disabled value="">분류</option>
					<option value="0">만족도</option>
					<option value="1">반배치</option>
					<option value="2" selected="selected">자격증</option>
					<option value="3">기타</option>
				</c:if>
				<c:if test="${survey.surveyCategory == 3 }">
					<option disabled value="">분류</option>
					<option value="0">만족도</option>
					<option value="1">반배치</option>
					<option value="2">자격증</option>
					<option value="3" selected="selected">기타</option>
				</c:if>
				</select>
			</td>
			<td>
				<select id="selectAlumni">
					<option disabled value="">설문대상 기수</option>
					<option value="${survey.surveyTargetAlumni}" selected="selected">${survey.surveyTargetAlumni}기</option>
				</select>
			</td>
			<td>
				<select id="selectClass">
				<c:forEach items="${classRoom}" var="cr">
				<option disabled value="">설문대상 반</option>
				<option value="ALL">전체</option>
				<c:if test="${cr != survey.surveyTargetClassroom}">
				<option value="${cr}">${cr}</option>
				</c:if>
				<c:if test="${cr == survey.surveyTargetClassroom}">
				<option value="${cr}" selected="selected">${cr}</option>
				</c:if>
				</c:forEach>
				</select>
			</td>
			<td><input type="text" id="surveyStartDate" value="${survey.surveyStartDate}"></td>
			<td><input type="text" id="surveyEndDate" value="${survey.surveyEndDate}"></td>
		</tr>
		<tr>
			<td colspan="7">
			<input type="text" size="120" id="surveyTitle" value="${survey.surveyTitle}" placeholder="설문 제목을 입력하세요.">
			</td>
			<td>
			<input type="button" value="edit" id="editSurvey">
			</td>
		</tr>
	</table>
	 
</div>

<div id="toolsWrap">

	<div class="tools" id="singleinput">singleinput</div>
	<div class="tools" id="radiogroup">radiogroup</div>
	<div class="tools" id="checkbox">checkbox</div>
	<div class="tools" id="dropdown">dropdown</div>
	<div class="tools" id="comment">comment</div>
 
</div>

<div id="pagesWrap">

	<select>
		<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
		<option value="page${pgStatus.count}">페이지 ${pgStatus.count}</option>
		</c:forEach>
	</select>
	<input type="button" value="페이지 추가" onclick="javascript:addPage(${pages.size()})">
	<input type="button" value="페이지 삭제" onclick="javascript:subPage()">

</div>

<div id="questionsWrap">

	<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
	  	<div id="page${pgStatus.count}" class="pages">
	  		
	  		<h1>페이지 ${pgStatus.count}</h1>
	  
		  	<c:forEach items="${questions}" var="qs">
		  	
		  	<c:if test="${pg.surveyPageNum == qs.surveyPageNum}">
		  	
			  	<c:if test="${qs.surveyQuestionRequired == 0}">
			  		<div class="questions" id="question${qs.surveyQuestionNum}">
			  	</c:if>
			  	<c:if test="${qs.surveyQuestionRequired == 1}">
			  		<div class="questions" id="question${qs.surveyQuestionNum}" required="required">
			  	</c:if>
		  			<input type="hidden" id="questionType" value="${qs.surveyQuestionType}">
				    	<fieldset>
				    	<legend>${qs.surveyQuestionContent}
				    	<input type="button" value="수정" onclick="javascript:editQuestion(${qs.surveyQuestionNum})">
		        		<input type="button" value="삭제" onclick="javascript:deleteQuestion(${qs.surveyQuestionNum})">
				    </legend>
				    
				    <c:if test="${qs.surveyQuestionType == 'singleinput'}">
					  	<input type="text" id="option${qs.surveyQuestionNum}" placeholder="답변을 입력하세요." size="70">
					</c:if>
					<c:if test="${qs.surveyQuestionType == 'comment'}">
					  	<textarea rows="10" cols="70" id="option${qs.surveyQuestionNum}">답변을 입력하세요.</textarea>
					</c:if>
					
					<c:if test="${qs.surveyQuestionType == 'dropdown'}">
						  <select name="dropdown${qs.surveyQuestionNum}" id="dropdown${qs.surveyQuestionNum}">
					</c:if>
					
					<c:if test="${qs.surveyQuestionType == 'radiogroup'}">
					<input type="button" value="+" class="addOption">
	        	    		<input type="button" value="-" class="subOption">
					</c:if>
					
					<c:if test="${qs.surveyQuestionType == 'checkbox'}">
					<input type="button" value="+" class="addOption">
	        	    		<input type="button" value="-" class="subOption">
					</c:if>
					
			  		<c:forEach items="${options}" var="op">
					  	<c:if test="${qs.surveyQuestionNum == op.surveyQuestionNum}">
					  	
						  	<c:if test="${qs.surveyQuestionType == 'radiogroup'}">
					        	    <input type="radio" name="option${qs.surveyQuestionNum}" id="radio${op.surveyOptionNum}">
					        	    <label for="radio${op.surveyOptionNum}" class="radio">${op.surveyOptionContent}</label>
					 	  	</c:if>
						  	
						  	<c:if test="${qs.surveyQuestionType == 'checkbox'}">
					        	    <input type="checkbox" name="option${qs.surveyQuestionNum}" id="checkbox${op.surveyOptionNum}">
					        	    <label for="checkbox${op.surveyOptionNum}" class="checkbox">${op.surveyOptionContent}</label>
						  	</c:if>
						  	
						  	<c:if test="${qs.surveyQuestionType == 'dropdown'}">
		    						<option id="dropdown${op.surveyOptionNum}">${op.surveyOptionContent}</option>
						  	</c:if>
					  	</c:if>
				  	
				  	</c:forEach>
				  	
				  			<c:if test="${qs.surveyQuestionType == 'dropdown'}">
			    				    </select>
			    				    <input type="button" value="해당 선택지 삭제" class="subSelectOption">
		    	   			  		<br>
		    	    			  		<input type="text" placeholder="추가할 내용 입력" size="15">
		    	  			  		<input type="button" value="선택지 추가" class="addSelectOption">
						  	</c:if>
				  	
				  	</fieldset>
				</div>
			  	 
			</c:if>
			</c:forEach>
			</div>
		</c:forEach>	
	</div>
	
<div id="attributeWrap">
</div>
</div>

<%@ include file="../footer.jsp"%>

</body>
</html>