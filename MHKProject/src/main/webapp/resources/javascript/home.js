/**
 * 
 */
$(function(){
	
	//Login Method
	$('#login').on('click',function(){
		var result = loginCheck();
		if(!result){
			alert('Fill the blanks.');
		} else {
			var loginId = document.getElementById('loginId').value;
			var loginPassword = document.getElementById('loginPassword').value;
			$.ajax({
				url : "member/login"
				, type : "POST"
				, contentType : "application/json; charset=utf-8"
				, data : JSON.stringify({
					memberId : loginId
					, memberPassword : loginPassword
				})
				, dataType : "text"
				, success : function(result){
					if(result == "true"){
						location.reload();
					} else if (result == "false"){
						alert('Login Failed.\nID or password might be incorrect.');
					}
				}
				, error : function(){
					alert('Login failed.\nID or password might be incorrect.');
				}
			});
		}
	});
	
	//Logout Method
	$('#logout').on('click', function(){
		$.ajax({
			url : "member/logout"
			, type : "get"
			, success : function(){
				location.reload();
			}
			, error : function() {
				alert('error during logout ajax');
			}
		});
	});
});


function loginCheck(){
	var loginId = document.getElementById('loginId').value;
	var loginPassword = document.getElementById('loginPassword').value;
	if(loginId.length == 0 || loginPassword.length == 0){
		return false;
	}
	return true;
}

