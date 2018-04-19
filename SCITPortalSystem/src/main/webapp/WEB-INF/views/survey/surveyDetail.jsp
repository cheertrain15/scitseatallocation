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
	  	
	  	<!-- 로그인 한 회원이 선생님일 경우 설문 수정 버튼 보이기 -->
	  	<h1>개별 설문 보기</h1>
	  	<c:if test="${memberClass == 'teacher'}">
	  	
	  	<div id="modifyBtn">
		<button id="editBtn">Edit</button>	  	
	  	</div>
	  	
	  	</c:if>
	  	
	  	<div id="surveyInfo">
	  	<form action="surveyEdit" method="get" id="surveyEditForm">
	  	<input type="hidden" id="surveyNum" name="surveyNum" value="${survey.surveyNum}">
	  	</form>
	  	<table>
	  	<tr>
	  	<td>제목: ${survey.surveyTitle}</td>
	  	<td>대상: ${survey.surveyTargetAlumni}기 ${survey.surveyTargetClassroom}</td>
	  	</tr>
	  	<tr>
	  	<td>설문 기간: ${survey.surveyStartDate} </td>
	  	<td>~ ${survey.surveyEndDate}</td>
	  	</tr>
	  	</table>
	  	</div> 
	  	
	  	<!-- 설문 참여 시작 -->

	  	<div id="canvase">
	  	
	  	<c:forEach items="${pages}" var="pg" varStatus="pgStatus">
	  	
	  	<div id="page${pgStatus.index}" class="pages" >
	  	
	  	 
	  	<div id="leftBtn">
	  	<br><br><br><br><br><br><br>
	  	<br><br><br><br><br><br>
	  	<button id="prevBtn" onclick="prevPage(${pgStatus.index})"><h1>◀</h1></button>
	  	</div>
	  		
	  		<div id="questionWrap">
	  		
	  		<h1>Page${pgStatus.count} ( ${pgStatus.count} / ${pages.size()} )</h1>
	  
		  	<c:forEach items="${questions}" var="qs">
		  	
		  	<c:if test="${pg.surveyPageNum == qs.surveyPageNum}">
		  	
		  		<div class="questions" id="question${qs.surveyQuestionNum}">
		  			<input type="hidden" id="questionType" value="${qs.surveyQuestionType}">
				    	<fieldset>
				    	<legend>${qs.surveyQuestionContent}
				    	<c:if test="${qs.surveyQuestionRequired == 1}">
				    	<p id="required">(* 필수응답 항목입니다.)</p>
				    	</c:if>
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
						  	</c:if>
				  	
				  	</fieldset>
				</div>
			  	
			</c:if>
			</c:forEach>
			
			</div>
		  	
		  	<div id="rightBtn">
		  	<br><br><br><br><br><br><br><br>
		  	<br><br><br><br><br><br>
		  	<button id="nextBtn" onclick="nextPage(${pgStatus.index})"><h1>▶</h1></button>
		  	</div>
		  	
		  	</div>

	  	</c:forEach>
	  	</div>
	  	
	  	<!-- 설문 참여 끝 -->
	  	
	  	<!-- 로그인 한 회원이 학생일 경우 설문 응답 제출 버튼 보이기 -->
	  	<c:if test="${memberClass == 'student'}">
	  	<div id="saveBtn">
	  	<button>제출</button>
	  	</div>
	  	</c:if>
	  	
</body>
</html>