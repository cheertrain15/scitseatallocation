<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!-- link -->
<meta name="viewport" content="width=device-width, initial-scale=1">		
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->



<!-- <Sidebar (hidden by default)> -->
<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:10%;min-width:300px; background-color: #eeeeeeb5;" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()"
  class="w3-bar-item w3-button">Close</a>
  
  <c:choose>
  	<c:when test="${sessionScope.loginID != null}">
  		<c:if test="${sessionScope.loginID eq 'admin'}">
  			<a href="<c:url value="/admin/management"/>" onclick="w3_close()" class="w3-bar-item w3-button">Management</a>
  		</c:if>    		
  		<c:if test="${sessionScope.loginID != 'admin'}">
  			<a href="<c:url value="/News/NewsMain"/>" onclick="w3_close()" class="w3-bar-item w3-button">News</a> 
		  	<a href="<c:url value="/additionalInfo/staffPage"/>" onclick="w3_close()" class="w3-bar-item w3-button">Work Information</a>
		  	<a href="<c:url value="survey"/>" onclick="w3_close()" class="w3-bar-item w3-button">Survey</a>
		  	<a href="<c:url value="/attendance/attendance"/>" onclick="w3_close()" class="w3-bar-item w3-button">Attendance</a>
		  	<a href="<c:url value="/seat/seatpage"/>" onclick="w3_close()" class="w3-bar-item w3-button">Seat Placement</a>
		  	<a href="<c:url value="/AskQuestion/QnA"/>" onclick="w3_close()" class="w3-bar-item w3-button">Consult</a>   		
  		</c:if>
  	</c:when>  	
  </c:choose>
    
</nav>
<!-- ☰s -->
<!-- Top menu -->
 <div class="w3-top">
  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
    <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">Menu</div>
        <div class="w3-right w3-padding-16"> 
        <c:if test="${sessionScope.loginID == null }">
            <span><a href="<c:url value="/member/loginForm"/>">Login</a></span>
      		<span><a href="<c:url value="/member/joinType"/>">Join</a></span>                                  
        </c:if>
        <c:if test="${sessionScope.loginID != null }">
        	<span><a href="<c:url value="/member/logoutForm"/>">Logout</a></span>
      		<span><a href="<c:url value="/member/myPage"/>">MyPage</a></span>          
        </c:if>
      
    </div>
    <div class="w3-center w3-padding-16">
    <a href="<c:url value="/"/>">
      <img src="<c:url value="/resources/img/logo.jpg"/>">
     </a>
    </div>
  </div>
</div>

<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}
</script>