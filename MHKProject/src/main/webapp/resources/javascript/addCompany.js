/**
 * 
 */
$(function(){
$('#duplicate').on('click', function(){
		
		var companyName = document.getElementById('companyName').value;
		
		$.ajax({
			url : "nameDuplication"
			, type : "POST"
			, data : companyName
			, contentType : "application/json; charset=utf-8"
			, dataType : "text"
			, success : function(result){
				var message = '';
				if (result == "true"){
					message = '<p id="result" style="color: blue;" value="true">This name can be used.</p>';	
				} else if (result == "false") {
					message = '<p id="result" style="color: red;" value="false">This name can not be used.</p>';
				}
				$('#nameResult').html(message);
			}
			, error : function(err){
				
			}
		});
	});
});

function addCompanyBlankCheck(){
	var companyName = document.getElementById('companyName').value;
	var companyCEO = document.getElementById('companyCEO').value;
	var companyEmail = document.getElementById('companyEmail').value;
	var companyPhone = document.getElementById('companyPhone').value;
	var companyAddress = document.getElementById('companyAddress').value;
	var companyField = document.getElementByName('companyField').value;
	var companyPayment = document.getElementById('companyPayment').value;
	var companyWorkingTime = document.getElementById('companyWorkingTime').value;
	var companyEmployee = document.getElementById('companyEmployee').value;
	var companyCapital = document.getElementById('companyCapital').value;
	var companyFoundation = document.getElementById('companyFoundation').value;
	var companyHomepage = document.getElementById('companyHomepage').value;
	
	if(companyName.length == 0 || companyCEO.length == 0 ||
		companyEmail.length == 0 || companyPhone.length == 0 ||
		companyAddress.length == 0 || companyField == null ||
		companyPayment.length == 0 || companyWorkingTime.length == 0 ||
		companyEmployee.length == 0 || companyCapital.length == 0 ||
		companyFoundation.length == 0 || companyHomepage.length == 0
		) {
		alert('Fill the blanks');
		return false;
	}
	
	
}