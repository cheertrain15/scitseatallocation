<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<table>		
		<tr>		
			<td>
				<%-- <c:if test="${sessionScope.loginId != null}"> --%>
					<input type="button" value="1:1문의하기" onclick="question()">
				<%-- </c:if> --%>
			</td>			
		</tr>
			<tr>
				<th>글 번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>작성일</th>
				<th></th>
			</tr>			
			<c:forEach var="askquestion" items="${askquestionList}">
				<tr>					
					<td>${askquestion.askQuestionNum}</td>
					<td>${askquestion.id}</td>					
					<td><a href="read?askQuestionNum=${askquestion.askQuestionNum}">${askquestion.askQuestionTitle}</a>
						[${askquestion.askQuestionReplies}]
					</td>
					<td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${askquestion.askQuestionDate}" /></td>
				</tr>
			</c:forEach>
	</table>
	<div class="centerdiv">
			<a href="javascript:pagingFormSubmit(1)">◁◁</a>
			<a href="javascript:pagingFormSubmit(${navi.currentPage-1})">◀</a>
			<c:forEach var="counter" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
				<c:if test="${counter == navi.currentPage}">
					<b>					
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter})">${counter}</a><!-- 숫자를 무엇을 눌렀느냐를 전달 -->
				<c:if test="${counter == navi.currentPage}">
					</b>
				</c:if>										
			</c:forEach>
			<a href="javascript:pagingFormSubmit(${navi.currentPage+1})">▶</a>
			<a href="javascript:pagingFormSubmit(${navi.totalPageCount})">▷▷</a>			
		</div>		
		<div class="centerdiv">
		<form action="QnA" method="GET" id="pagingForm">
				<input type="hidden" name="page" id="page">
				<select name="searchSelect">
					<option value="AskQuestionTitle" <c:if test="${searchSelect == 'AskQuestionTitle'}"/>>제목</option>
					<%-- <option value="tc" <c:if test="${searchSelect == 'tc'}"/>>제목+내용</option> --%>
					<option value="AskQuestionContent" <c:if test="${AskQuestionContent == 'askQuestionContent'}"/>>내용</option>
					<option value="id" <c:if test="${searchSelect == 'id'}"/>>작성자</option>
				</select>
				<input type="text" name="searchText" value="${searchText}"> 
				<input type="button" onclick="pagingFormSubmit(1)" value="검색">
		</form>
		</div>	
</body>
</html>