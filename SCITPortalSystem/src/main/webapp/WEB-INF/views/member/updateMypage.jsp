<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[Update MyPage]</title>
	</head>
	
<body>

<%@ include file="../header.jsp" %>
<form action="update" style="border:1px solid #ccc" method="post">
  <div class="container">
  <br>
    <h1>Personal information</h1><br>
   
    <hr>
    
    <table>
    	<tr>
    		<th>Profile</th>
    		<td>
    		<img width="160" height="160" src="downLoad?id=${changeOne.id }">    	
    		</td> 
    	</tr>    	
    	<tr>
    		<th>ID</th>
    		<td>${changeOne.id }
    		<input type="hidden" name="id" id="id" value="${changeOne.id}">
    		</td>
    	</tr>
    	<tr>
    		<th>Name</th>
    		<td>${changeOne.name }</td>
    	</tr>
    	<tr>
    		<th>PassWord</th>
    		<td><input type="password" placeholder="Enter Password" name="password" id="pw"></td>
    	</tr>
    	<tr>
    		<th>Repeat Password</th>
    		<td><input type="password" placeholder="Repeat Password" id="pw2"></td>
    	</tr>
    	
    	<tr>
    		<th>Phone</th>
    		<td><input type="text" placeholder="Enter Phone" name="phone" value="${changeOne.phone }"></td>
    	</tr>
    	<tr>
    		<th>Email</th>
    		<td><input type="text" placeholder="Enter Email" name="email" value="${changeOne.email }"></td>
    	</tr>
    	<tr>
    		<th>Address</th>
    		<td><input type="text" placeholder="Enter Address" name="address" value="${changeOne.address }"></td>
    	</tr>      
    </table>    
  

    <div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Change</button>
    </div>
  </div>
</form>
<%@ include file="../footer.jsp"%>
</body>
</html>