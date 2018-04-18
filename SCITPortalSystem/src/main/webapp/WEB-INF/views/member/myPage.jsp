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
  <br><br><br><br>
    <h1>Personal information</h1><br>   
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
 <button type="button" class="cancelbtn" onclick='goHome()'>Cancel</button> 
 <br>
<%@ include file="../footer.jsp"%>
</body>
</html>