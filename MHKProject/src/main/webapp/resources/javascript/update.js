
/*
 * join.jsp
 */

function joinFormCheck(){
	var joinId = document.getElementById('joinId').value;
	var joinPw = document.getElementById('joinPw').value;
	var joinPwc = document.getElementById('joinPwc').value;
	var joinName = document.getElementById('joinName').value;
	var joinEmail = document.getElementById('joinEmail').value;
	var joinPhone = document.getElementById('joinPhone').value;
	var joinGender = document.getElementById('joinGender').value;
	var joinAddress = document.getElementById('joinAddress').value;
	var joinField = document.getElementById('joinField').value;
	var joinWT = document.getElementById('joinWT').value;
	var joinPayment = document.getElementById('joinPayment').value;
	var joinCD = document.getElementById('joinCD').value;
	var joinRN = document.getElementById('joinRN').value;

	if(joinId.length == 0 || joinPw.length == 0 ||
			joinPwc.length == 0 || joinName.length == 0 ||
			joinEmail.length == 0 || joinPhone.length == 0 ||
			joinGender.length == 0 || joinAddress.length == 0 ||
			joinField.length == 0 || joinWT.length == 0 ||
			joinPayment.length == 0 || joinCD.length == 0 ||
			joinRN.length == 0){
		alert('Fill the blanks.');
		return false;
	}
	
	if(joinPw != joinPwc){
		alert('Password is not identical.\nCheck the password.');
		return false;
	}
	
	if(isNaN(joinPhone)){
		alert('Enter only numbers.');
		document.getElementById('joinPhone').focus();
		return false;
	} else if(isNaN(joinWT)){
		alert('Enter only numbers.');
		document.getElementById('joinWT').focus();
		return false;
	} else if (isNaN(joinPayment)){
		alert('Enter only numbers.');
		document.getElementById('joinPayment').focus();
		return false;
	} else if (isNaN(joinCD)){
		alert('Enter only numbers.');
		document.getElementById('joinCD').focus();
		return false;
	} else if (joinGender == null) {
		alert('Select one in gender.');
		return false;
	} 
	

}

/*
 * joinComplete.jsp
 */

