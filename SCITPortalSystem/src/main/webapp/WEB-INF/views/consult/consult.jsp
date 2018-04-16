<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/consult/consult.css" />
<title>[1:1 문의 게시판]</title>
<script type="text/javascript">
	function question(){
		location.href="insertQuestion"
	}
	function pagingFormSubmit(currentPage){
		var form = document.getElementById("pagingForm");
		var page = document.getElementById("page");
		page.value = currentPage;
		form.submit();
	}
	function input_Text(){
	    document.getElementById("test").value = '처리 완료';
	}
</script>

</head>

<body>
<%@ include file="../header.jsp" %>
<br><br><br><br><br>
	<table>		
		<tr>		
			<th></th>
			<th></th>
			<th></th>
			<th>
				<input type="button" value="1:1문의하기" onclick="question()">
			</th>			
		</tr>
		
			<tr>
				<th style="width: 100px">글 번호</th>
				<th style="width: 100px">이름</th>
				<th style="width: 400px">제목</th>
				<th style="width: 150px">작성일</th>
			</tr>
			<c:choose>
				<c:when test="${not empty askquestionList}">			
					<c:forEach var="askquestion" items="${askquestionList}">
						<tr>					
							<td class="tdconsult">${askquestion.askQuestionNum}</td>
							<td class="tdconsult">${askquestion.name}</td>					
							<td><a href="read?askQuestionNum=${askquestion.askQuestionNum}">${askquestion.askQuestionTitle}</a>
								[${askquestion.askQuestionReplies}]
							</td>
							<td class="tdconsult"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${askquestion.askQuestionDate}" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>			       	
			       		<th colspan="4">등록된 문의사항이 없습니다.</th>
			    </c:otherwise>
			</c:choose>
	</table>
	<div class="consultdiv">
			<a href="javascript:pagingFormSubmit(1)">◁◁</a>
			<a href="javascript:pagingFormSubmit(${navi.currentPage-1})">◀</a>
			<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
				<c:if test="${counter == navi.currentPage}">
					<b>					
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter})">${counter}</a>
				<c:if test="${counter == navi.currentPage}">
					</b>
				</c:if>										
			</c:forEach>
			<a href="javascript:pagingFormSubmit(${navi.currentPage+1})">▶</a>
			<a href="javascript:pagingFormSubmit(${navi.totalPageCount})">▷▷</a>			
		</div>		
		<div class="consultdiv">
		<form action="QnA" method="GET" id="pagingForm">
				<input type="hidden" name="page" id="page">
				<select name="searchSelect">
					<option value="AskQuestionTitle" <c:if test="${searchSelect == 'AskQuestionTitle'}"/>>제목</option>
					<option value="AskQuestionTitleContent" <c:if test="${searchSelect == 'AskQuestionTitleContent'}"/>>제목+내용</option>
					<option value="AskQuestionContent" <c:if test="${AskQuestionContent == 'askQuestionContent'}"/>>내용</option>
					<option value="id" <c:if test="${searchSelect == 'id'}"/>>작성자</option>
				</select>
				<input type="text" name="searchText" value="${searchText}"> 
				<input type="button" onclick="pagingFormSubmit(1)" value="검색">
		</form>
		</div>
<%@ include file="../footer.jsp"%>
</body>
</html>