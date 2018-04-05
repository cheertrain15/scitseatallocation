<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/joinForm.js"></script>
	<title>Insert title here</title>
	</head>
	
<body>
<h2>[ ID CHECK ]</h2>
		<form action="idSearch" method="post" onsubmit="return formcheck();">
			<input type="text" name="searchId" id="searchId" value="${searchId}">
			<input type="submit" value="Search">		
		</form>
		
		<!-- 검색 후에만 출력되는 부분 -->
		<c:if test="${search}">
			<!-- 검색 결과가 없는 경우 -->
				<c:if test="${searchResult == null}">
					<p>
						<b>
						${searchId} </b> :  [ Available ]				
					</p>
					<p>
						<input type="button" value="UseID" onclick="useId('${searchId}')"> 
					</p>
				
				</c:if>
			<!--  검색 결과가 있는 경우 -->
				<c:if test="${searchResult != null}">
					<p>
					
						<b>${searchId} </b> :  [ Already in use ]				
					</p>
				</c:if>
		</c:if>

</body>
</html>