<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value ="/resources/css/joinStaff.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
	<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/joinForm.js"/>"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<title>[Join Form]</title>	
	<meta charset="UTF-8">	
	<script>
	<c:if test="${errorMsg != null}">
	${errorMsg }
	</c:if>
	
	  var loadFile = function(event) {
	    var reader = new FileReader();
	   	 reader.onload = function(){
	      var output = document.getElementById('output');
	      output.src = reader.result;
	    };
	    reader.readAsDataURL(event.target.files[0]);
 	 };
</script>
	
</head>

<body>
<%@ include file="../header.jsp" %>

<div class="container" style="width: 800px">
  	<br>
    	<h1>회원가입</h1>
    	<p>[학생 가입화면]</p>
  	
	<form action="joinTheStudent" style="border:1px solid #ccc" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
		<input type="hidden" name="memberClass" value="staff">
		<table class="joinTable">
		  	<tr>
		  		<th class="joinInput-id">I D</th>
		  		<td>
						<input type="text" id="id" readonly="readonly" placeholder="ID입력" name="id" id="id" value="${user.id }">
						<input type="button" class="idcheckBtn" value="ID Check" onclick='idCheckOpen()'>
		  		</td>
		  	</tr>
			<tr>
				<th>Name</th>
				<td>
				    <input type="text" placeholder="이름 입력" name="name" value="${user.name }" id="name">   
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>
				    <input type="password" id="password" placeholder="비밀번호 입력" name="password" value="${user.password}">
				</td>
			</tr>		
			<tr>
				<th>Repeat Password</th>
				<td>
				    <input type="password" id="password2" placeholder="비밀번호 확인" name="passwordCheck">
				</td>
			</tr>
			<tr>
				<th>Profile</th>
				<td>
					<img id="output" width="160" height="160"/>
					<input type="file" accept="image/*" name="upload" onchange="loadFile(event)" id="upload">
				</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>
				    <input id="email" type="text" placeholder="Email 입력" name="email" value="${user.email }">
				</td>
			</tr>		
			<tr>
				<th>Phone</th>
				<td>
				    <input id="phone" type="text" placeholder="핸드폰 번호 입력" name="phone" value="${user.phone }">
				</td>
			</tr>		
			<tr>
				<th>Address</th>
				<td >
				    <input type="text" placeholder="주소 입력" name="postNum" id="postNum" readonly="readonly">
				    <input type="button" value="ZipCode" id="searchAddress"><br>
				</td>
			</tr>
			<tr>
				<th>&nbsp;
				</th>
				<td>
				    <input style="width: 300px" type="text" placeholder="Enter Address" id ="Address" name="address" value="${user.address }">
				</td>
			</tr>	        
	    </table>
	    <br>
	    <div class="btn_clear">
	      <button type="reset" class="cancelbtn">취소</button>&nbsp;&nbsp;
	      <button type="submit" class="signupbtn">등록</button>
	    </div>
	</form>
  </div>
  <br><br>
<%@ include file="../footer.jsp"%>

</body>
</html>