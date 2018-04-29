<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 참여/확인</title>
  
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.2.1.js' />"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/survey/surveyDetail.js' />"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/survey/surveyDetail.css' />">

</head>
<body> 

<%@ include file="../header.jsp" %>

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
	  	<td>분류:</td>
	  	<td>
	  	<c:if test="${survey.surveyCategory == 0}">만족도</c:if>
	  	<c:if test="${survey.surveyCategory == 1}">반배치</c:if>
	  	<c:if test="${survey.surveyCategory == 2}">자격증</c:if>
	  	<c:if test="${survey.surveyCategory == 3}">기타</c:if>
	  	</td>
	  	<td>대상:</td>
	  	<td>${survey.surveyTargetAlumni}기</td>
	  	<td>${survey.surveyTargetClassroom}</td>
	  	</tr>
	  	<tr>
	  	<td>제목:</td>
	  	<td colspan="5">${survey.surveyTitle}</td>
	  	</tr>
	  	<tr>
	  	<td>설문 기간:</td>
	  	<td colspan="5">${survey.surveyStartDate}~${survey.surveyEndDate}</td>
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
	  
		  	<c:forEach items="${questions}" var="qs">
		  	
		  	<c:if test="${pg.surveyPageNum == qs.surveyPageNum}">
		  	
		  		<div class="questions" id="question${qs.surveyQuestionNum}">
		  			<input type="hidden" id="questionType" value="${qs.surveyQuestionType}">
				    	<fieldset>
				    	<legend>${qs.surveyQuestionContent}
				    	<c:if test="${qs.surveyQuestionRequired == 1}">
				    	<span id="required">(* 필수응답 항목입니다.)</span>
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
				
				<div id="pageCount">
					(${pgStatus.count}/${pages.size()})
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
	  	
<%@ include file="../footer.jsp"%>
</body>
</html>