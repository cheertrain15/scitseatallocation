<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value ="../resources/css/idCheckForm.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/joinForm.js"></script>
	<title>ID CHECK</title>
	</head>
	
<body>
<div class="idCheckMain">
	<h2><a>&nbsp; [ ID CHECK ] &nbsp; </a></h2>
</div>
<br><br>
		<form action="idSearch" method="post" onsubmit="return formcheck();">
			<input type="text" name="searchId" id="searchId" value="${searchId}">
			<input type="submit" value="검색" class="idCheckBtn">		
		</form>
		
		<!-- 검색 후에만 출력되는 부분 -->
		<c:if test="${search}">
			<!-- 검색 결과가 없는 경우 -->
				<c:if test="${searchResult == null}">
					<p>
						<b>
						${searchId} </b> 는 사용가능한 아이디 입니다.				
					</p>
					<p>
						<input type="button" value="사용하기" onclick="useId('${searchId}')" class="useIdButton"> 
					</p>
				
				</c:if>
			<!--  검색 결과가 있는 경우 -->
				<c:if test="${searchResult != null}">
					<p>
					
						<b>${searchId} </b>은 이미 사용 중인 아이디 입니다.				
					</p>
				</c:if>
		</c:if>

</body>
</html>