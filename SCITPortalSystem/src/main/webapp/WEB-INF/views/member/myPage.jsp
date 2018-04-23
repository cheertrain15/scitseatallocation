<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />
		<title>[My Page]</title>
		<script type="text/javascript">
		function goHome() {
			location.href = "../home";
		}
		function goPersonal() {
			location.href = 'updateMypage';
		}
		function goCertificate() {
			location.href = 'updateCertificate';
		}
		
		</script>
	</head>
	
<body>

<%@ include file="../header.jsp" %>
<br><br><br><br><br>

	<div class="clearfix">     
      <button type="button" class="signupbtn" onclick='goPersonal()'>Personal</button>
      <button type="button" class="signupbtn" onclick='goCertificate()'>Certificate</button>
    </div>
    
<form action="#" style="border:1px solid #ccc" method="post">
  <br>
    <h1>Personal information</h1>  
    <hr>
    
    <table>
    	<tr>
    		<th>Profile</th>
    		<td><img width="160" height="160" src="downLoad?id=${searchOne.id }"></td>
    	</tr>    	
    	<tr>
    		<th>ID</th>
    		<td>${searchOne.id}</td>
    	</tr>
    	<tr>
    		<th>Name</th>
    		<td>${searchOne.name}</td>
    	</tr>
    	<tr>
    		<th>Phone</th>
    		<td>${searchOne.phone}</td>
    	</tr>
    	<tr>
    		<th>Email</th>
    		<td>${searchOne.email}</td>
    	</tr>
    	<tr>
    		<th>Address</th>
    		<td>${searchOne.address}</td>
    	</tr>      
    </table> 
</form>
<br>

<h1>Academic information</h1>
<hr>

<c:if test="${searchOne.memberClass == 'student'}">
 <table>
    	<tr>
    		<th>Student No.</th>
    		<td>${searchStudent.memberstudentNum}</td>
    	</tr>    	
    	<tr>
    		<th>기수</th>
    		<td>${searchStudent.alumni} 기</td>
    	</tr>
    	<tr>
    		<th>IT(유사전공 포함)</th>
    		<c:if test="${searchStudent.itMajor == 1}">    		
    		<td>전공자</td>
    		</c:if>
    		<c:if test="${searchStudent.itMajor == 0}">    		
    		<td>비전공자</td>
    		</c:if>
    	</tr>
    	<tr>
    		<th>일본어</th>
    		<c:if test="${searchStudent.jpMajor == 1}">    		
    		<td>전공자</td>
    		</c:if>
    		<c:if test="${searchStudent.jpMajor == 0}">    		
    		<td>비전공자</td>
    		</c:if>
    	</tr>
    	<tr>
    		<th>반(Class)</th>
    		<td>${searchStudent.classroom} 반</td>
    	</tr>
    	<tr>
    		<th>조(Group)</th>
    		<td>${searchStudent.groupNum} 조</td>
    	</tr>      
    	<tr>
    		<th>좌석(Seat)</th>
    		<td>${searchStudent.seat}</td>
    	</tr>
    	<tr>
    		<th>지각</th>
    		<td>${searchStudent.late} 회</td>
    	</tr>
    	<tr>
    		<th>조퇴</th>
    		<td>${searchStudent.early} 회</td>
    	</tr>     
    	<tr>
    		<th>결석</th>
    		<td>${searchStudent.absent} 회</td>
    	</tr>       
    </table> 
</c:if>
<br>

 <button type="button" class="cancelbtn" onclick='goHome()'>Cancel</button> 
 <br>
<%@ include file="../footer.jsp"%>
</body>
</html>