/**
 * 
 */

$(function(){
	$('#addCompanyButton').on('click', function(){
		addCompany();
	});
	
	$('#addCompanyButton').on('click', function(){
		addCompany();
	});
	
	

});

function addCompany(){
	location.href="addCompany";
}

function configCompany(){
	location.href="configCompany";
}

function pagingFormSubmit(currentPage){
	var form = document.getElementById('pagingForm');
	var page = document.getElementById('page');
	page.value = currentPage;
	form.submit();
}