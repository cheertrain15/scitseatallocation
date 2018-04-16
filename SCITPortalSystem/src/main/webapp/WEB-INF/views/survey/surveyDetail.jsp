<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 상세보기</title>
  
<script type="text/javascript" src="./resources/js/jquery-3.2.1.js"/></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="./resources/js/survey/surveyDetail.js"/></script>
<link rel="stylesheet" type="text/css" href="./resources/css/survey/surveyDetail.css"/>

</head>
<body>
<!--      
선생님 / 학생으로 구분

선생님 - 설문조사의 내용과 옵션 내용 확인하고 수정 가능
학생 - 참여 여부에 따라
		(참여했을 경우)설문 내용과 자신의 응답내용 확인
		(참여하지 않았을 경우)참여페이지
	  마감일 경과 여부에 따라
	  	(경과했을 경우)설문 내용만 확인 가능 -->
	  	<div id="modifyBtn">
		<button id="editBtn"><h1>Edit</h1></button>	  	
	  	</div>

	  	<div id="canvase">
	  	
	  	<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
	  	
	  	<div id="page${pgStatus.index}" class="pages">
	  	 
	  	<div id="leftBtn">
	  	<br><br><br><br><br><br><br>
	  	<br><br><br><br><br><br>
	  	<button id="prevBtn" onclick="prevPage(${pgStatus.index})"><h1>◀</h1></button>
	  	</div>
	  		
	  		<form action="surveyAnswer" method="post" onsubmit=""> 
	  		
	  		<div id="questionWrap">
	  
		  	<c:forEach items="${questions}" var="qs">
		  	
		  	<c:if test="${pg.surveyPageNum == qs.surveyPageNum}">
		  	
		  		<div class="questions" id="question${qs.surveyQuestionNum}">
				    	<fieldset>
				    	<legend>${qs.surveyQuestionContent}
				    </legend>
				    
				    <c:if test="${qs.surveyQuestionType == 'singleinput'}">
					  	<input type="text" id="option${op.surveyOptionNum}" placeholder="답변을 입력하세요." size="70">
					</c:if>
					<c:if test="${qs.surveyQuestionType == 'comment'}">
					  	<textarea rows="10" cols="70">답변을 입력하세요.</textarea>
					</c:if>
					
					<c:if test="${qs.surveyQuestionType == 'dropdown'}">
						  <select name="dropdown${qs.surveyQuestionNum}" id="dropdown${qs.surveyQuestionNum}">
					</c:if>
					
			  		<c:forEach items="${options}" var="op">
					  	<c:if test="${qs.surveyQuestionNum == op.surveyQuestionNum}">
					  	
						  	<c:if test="${qs.surveyQuestionType == 'radiogroup'}">
					        	    <input type="radio" name="option${op.surveyOptionNum}" id="radio${op.surveyOptionNum}">
					        	    <label for="radio${op.surveyOptionNum}" class="radio">${op.surveyOptionContent}</label>
						  	</c:if>
						  	
						  	<c:if test="${qs.surveyQuestionType == 'checkbox'}">
					        	    <input type="checkbox" name="option${op.surveyOptionNum}" id="checkbox${op.surveyOptionNum}">
					        	    <label for="checkbox${op.surveyOptionNum}" class="checkbox">${op.surveyOptionContent}</label>
						  	</c:if>
						  	
						  	<c:if test="${qs.surveyQuestionType == 'dropdown'}">
		    						<option>${op.surveyOptionContent}</option>
						  	</c:if>
					  	</c:if>
				  	
				  	</c:forEach>
				  	
				  			<c:if test="${qs.surveyQuestionType == 'dropdown'}">
			    				    </select>
						  	</c:if>
				  	
				  	</fieldset>
				</div>
			  	
			</c:if>
			</c:forEach>
			
			</div>
			  	
		  	</form>
		  	
		  	<div id="rightBtn">
		  	<br><br><br><br><br><br><br><br>
		  	<br><br><br><br><br><br>
		  	<button id="nextBtn" onclick="nextPage(${pgStatus.index})"><h1>▶</h1></button>
		  	</div>
		  	
		  	</div>

	  	</c:forEach>
	  	</div>
	  	
	  	<div id="saveBtn">
	  	<button><h1>설문 응답 제출</h1></button>
	  	</div>
	  	
</body>
</html>