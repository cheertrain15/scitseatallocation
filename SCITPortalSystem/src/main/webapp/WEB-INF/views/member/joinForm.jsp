<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<form action="join" style="border:1px solid #ccc" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
  <div class="container">
  <br>
    <h1>Sign Up</h1><br>
    <p>Please fill in this form to create an account.</p>
    <hr>

	<b>ID	
	<input type="text" id="id" readonly="readonly" placeholder="Enter ID" name="id" id="id" value="${user.id }">
	<input type="button" value="ID Check" onclick='idCheckOpen()'>
	</b><br>
	    
    <b>Name</b>
    <input type="text" placeholder="Enter Name" name="name" value="${user.name }" id="name">   
	<br>
	
   	<b>Password</b>
    <input type="password" id="password" placeholder="Enter Password" name="password" value="${user.password}">
	<br>
	
    <b>Repeat Password</b>
    <input type="password" id="password2" placeholder="Repeat Password" name="passwordCheck">
	<br>
	
	<b>Profile</b>
	<img id="output" width="160" height="160"/>
	<input type="file" accept="image/*" name="upload" onchange="loadFile(event)" id="upload">
	<br>
	
	<b>Email</b>
    <input id="email" type="text" placeholder="Enter Email" name="email" value="${user.email }">
	<br>
	
	<b>Phone</b>
    <input id="phone" type="text" placeholder="Enter Phone" name="phone" value="${user.phone }">
    <br>
        
    <b>Address</b>
    <input type="text" placeholder="PostNumber" name="postNum" id="postNum" readonly="readonly">
    <input type="button" value="ZipCode" id="searchAddress"><br>
    <input style="width: 500px" type="text" placeholder="Enter Address" id ="Address" name="address" value="${user.address }">
    <br><br>
    

    <div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>
<%@ include file="../footer.jsp"%>

</body>
</html>