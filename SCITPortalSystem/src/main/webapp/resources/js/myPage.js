/**
 * 
 */

/**
 * 회원가입, 로그인, 개인정보 수정에 사용
 */

$(function() {
	$("#searchAddress").on('click', function(event) {
		new daum.Postcode({
			oncomplete: function(data) {
				
				 var fullRoadAddr = data.roadAddress;
		            var extraRoadAddr = '';
		           
		            if(data.bname !== ''){
		               extraRoadAddr += data.bname;
			}
		            
		    if(data.bulidingName !== '') {
		    	 extraRoadAddr += (extraRoadAddr !== '' ? ',' + data.buildingName : data.buildingName);	
		    }     
		    
		    if(extraRoadAddr !== ''){
            extraRoadAddr = ' (' + extraRoadAddr + ')';
		    }
		    
		    if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }	    
		   
		    
		    $("#postNum").val(data.zonecode);		    
		    $("#Address").val(fullRoadAddr);
		   
			}		            
		}).open();
	});	
});

function idCheckOpen() {
	window.open("idCheck", "newWindow", "top=200,left=400,height=300,width=400,resizable=no");	
	
}
function useId(searchId) {
	opener.document.getElementById('id').value = searchId;	
	this.close();
	
}
function formcheck() {
	var uSearchId = document.getElementById('searchId');
	
	if(uSearchId.value == '') {
		
		alert('Please enter a word');
		return false;
	}	
}

function goToHome() {
	
	location.href = "../home";	
}

function formCheck()
{	//submit 버튼 클릭시 실행 
	 var password1 = document.getElementById("password");
	 var password2 = document.getElementById("password2");
	 var id = document.getElementById("id");
	 var name = document.getElementById("name");
	 var email = document.getElementById("email");
	 var upload = document.getElementById("upload");
	 var passwordReg = /^[a-zA-Z0-9_]{8,10}$/;
	 
	 if(password1.value == '')
	 {
		 alert("Please enter your password.");
		 password1.focus();
		 return false;
	 }
	 else if(password1.value != password2.value)
	 {
		 alert("Please enter the same password.");
		 password2.focus();
		 return false;
	 } else if(id.value == '') {
		 alert("Please enter your ID.");
		 id.focus();
		 return false;
	 } else if(name.value == ''){
		 alert("Please enter your Name.");
		 name.focus();
		 return false;
	 } else if(email.value == ''){
		 alert("Please enter your Email.");
		 email.focus();
		 return false;
	 } else if(upload.value == ''){
		 alert("Please enter your Profile");
		 upload.focus();
		 return false;
	 }
	 
	 	 
	 return true;
}





