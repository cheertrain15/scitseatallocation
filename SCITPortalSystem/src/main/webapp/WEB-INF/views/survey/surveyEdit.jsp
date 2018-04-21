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
	
</head> 
<body>

<div id="bodyWrap">

<div id="infoWrap">
	*Survey Info*
	
	<table>
	<tr>
	<td>Target</td>
	<td>
		Alumni:
		<select>
		<option value="${survey.surveyTargetAlumni}" selected="selected">${survey.surveyTargetAlumni}</option>
		</select>
	</td>
	<td>
		Classroom:
		<select>
		<option value="ALL">ALL</option>
		<c:forEach items="${classRoom}" var="cr">
		<c:if test="${cr != survey.surveyTargetClassroom}">
		<option value="${cr}">${cr}</option>
		</c:if>
		<c:if test="${cr == survey.surveyTargetClassroom}">
		<option value="${cr}" selected="selected">${cr}</option>
		</c:if>
		</c:forEach>
		</select>
	</td>
	<td>StartDate:</td>
	<td><input type="text" id="surveyStartDate" value="${survey.surveyStartDate}"></td>
	<td>EndDate:</td>
	<td><input type="text" id="surveyEndDate" value="${survey.surveyEndDate}"></td>
	</tr>
	<tr>
	<td>Title:</td>
	<td colspan="7"> 
	<input type="text" size="120" value="${survey.surveyTitle}">
	</td>
	<td><input type="button" value="edit"></td>
	</tr>
	</table>
</div>

<div id="toolsWrap">
	*Survey Tools*
	
	<div class="tools" id="singleinput">singleinput</div>
	<div class="tools" id="radiogroup">radiogroup</div>
	<div class="tools" id="checkbox">checkbox</div>
	<div class="tools" id="dropdown">dropdown</div>
	<div class="tools" id="comment">comment</div>

</div>

<div id="pagesWrap">
	*Survey Pages Info*<br>
	<select>
		<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
		<option value="page${pgStatus.count}">page${pgStatus.count}</option>
		</c:forEach>
	</select>
	<input type="button" value="Add page" onclick="javascript:addPage(${pages.size()})">
	<input type="button" value="Sub page" onclick="javascript:subPage()">
</div>

<div id="questionsWrap">

	<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
	  	<div id="page${pgStatus.count}" class="pages">
	  		
	  		<h1>Page${pgStatus.count} ( ${pgStatus.count} / ${pages.size()} )</h1>
	  
		  	<c:forEach items="${questions}" var="qs">
		  	
		  	<c:if test="${pg.surveyPageNum == qs.surveyPageNum}">
		  	
		  		<div class="questions" id="question${qs.surveyQuestionNum}" surveyType="${qs.surveyQuestionType}">
		  			<input type="hidden" id="questionType" value="${qs.surveyQuestionType}">
				    	<fieldset>
				    	<legend>${qs.surveyQuestionContent}
				    	<c:if test="${qs.surveyQuestionRequired == 1}">
				    	<p id="required">(* 필수응답 항목입니다.)</p>
				    	</c:if>
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
		    	    			  		<input type="text" placeholder="추가할 선택지 내용을 입력하세요" size="30">
		    	  			  		<input type="button" value="추가" class="addSelectOption">
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

</body>
</html>