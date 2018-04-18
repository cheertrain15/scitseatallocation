<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="../js/myPage.js"/>"></script>
		<title>[Staff Page]</title>
		<script type="text/javascript">	
		<c:if test="${errorUP != null}">
		${errorMsg }
		</c:if>		
		</script>
	</head>
	
<body>
<%@ include file="../header.jsp" %>
<form action="addStaffInfo" style="border:1px solid #ccc" method="post" enctype="multipart/form-data">
<!-- <input type="hidden" name="teacherNum"> -->
  <div class="container">
  <br><br><br><br><br>
    <h1>Staff Information</h1><br>
    <p>Please fill in this form.</p>
    <hr>

	<b>ID</b>	
	<input type="text" id="id" readonly="readonly" name="id" id="id" value="${staff.id }">
	<br>
	
	<b>management</b>
    <input id="email" type="text" placeholder="Please Write" name="inChargeAlumni" value="${staff.inChargeAlumni}">
	<br>	
    
    <b>Subject</b>    
    <input type="radio" name="inChargeSubject" value="Administrator">administrator
    <input type="radio" name="inChargeSubject" value="Japanese">Japanese
    <input type="radio" name="inChargeSubject" value="IT">IT   
    <br>    

    <div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="registerbtn">Register</button>
    </div>
  </div>
</form>

<%@ include file="../footer.jsp"%>
</body>
</html>