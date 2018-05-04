<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_1.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/mypage/Mypage_2.css"/>" />
	<link href="<c:url value ="/resources/css/mainMenu.css"/>" rel="stylesheet" type="text/css" />	
	<script type="text/javascript" src="<c:url value ="/resources/js/mypage/Mypage.js"/>"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="<c:url value="../js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="../js/joinForm.js"/>"></script>
	<title>[Update MyPage]</title>
	<script type="text/javascript">
	function changeBtn() {		
		 document.updateSub.submit();
		 alert("Success");
	}
	
	/* function goHome() {
		location.href = "../";
	}
	 */

	function goReset() {
		location.href = "./";
		
	}
	
	 $(function(){
	   $('.hello').remove();
	 });
	 
	 
	 
	 </script>	
	</head>
	
<body>

<%@ include file="../header.jsp" %>
<form action="update" method="post" name="updateSub">
 <div class="container">
    <ul class="profile_box_update">
    	<li>
    		<div>
    			<h2 id="per_info_h2">Personal information</h2>
    			<img id="profile_img" width="160" height="180" src="downLoad?id=${changeOne.id }">
    		</div>
    	</li>
    	<li>
    		<ul>
    			<li class="profile_box_update_li_1">ID</li>
    			<li class="profile_box_update_li_2">${changeOne.id }<input type="hidden" name="id" id="id" value="${changeOne.id}"></li>
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">Name</li>
    			<li class="profile_box_update_li_2">${changeOne.name }</li>    			
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">PassWord</li>
    			<li><input type="password" placeholder="Enter Password" name="password" id="pw" class="profile_box_update_li_2"></li>
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">Repeat Password</li>
    			<li><input type="password" placeholder="Repeat Password" id="pw2" class="profile_box_update_li_2"></li>
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">Phone</li>
    			<li><input type="text" placeholder="Enter Phone" name="phone" value="${changeOne.phone }" class="profile_box_update_li_2"></li>
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">Email</li>
    			<li><input type="text" placeholder="Enter Email" name="email" value="${changeOne.email }" class="profile_box_update_li_2"></li>
    		</ul>
    		<ul>
    			<li class="profile_box_update_li_1">Address</li>
    			<li>
	    			<input type="text" placeholder="PostNumber" name="postNum" id="postNum" readonly="readonly" class="profile_box_update_li_2">	    			
	    			<input type="button" value="ZipCode" id="searchAddress" class="profile_box_update_li_2"><br>
	    			<input style="width: 432px; margin-top: 10px;" type="text" placeholder="Enter Address" id ="Address" name="address" value="${changeOne.address }" class="profile_box_update_li_2">
   				 </li>   			
    		</ul>
    		<ul>
    			<li class="update_btn_1">    			   	
    			 <label id="cancelBtn" onclick='goReset()'>HOME</label>  	    				
    			</li>
    			<li class="update_btn_1">
    			 <label id="cancelBtn" onclick='changeBtn()' >CHANGE</label>
    			</li>
    		</ul>    		
    	</li>
    </ul>    
  </div>
</form>
<%@ include file="../footer.jsp"%>
</body>
</html>