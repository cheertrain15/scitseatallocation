/**
 * 
 */

function loginCheck(){
	var loginId = document.getElementById('loginId').value;
	var loginPassword = document.getElementById('loginPassword').value;
	if(loginId.length == 0 || loginPassword.length == 0){
		return false;
	}
	return true;
}
