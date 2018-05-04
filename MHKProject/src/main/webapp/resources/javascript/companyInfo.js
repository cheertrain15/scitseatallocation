/**
 * 
 */

$(function(){
	
	$('#updateCompany').on('click', function(){
		var num = document.getElementById('companyNum').value;
		location.href="updateCompany?companyNum="+num;		
	});
	
	$('#analyze').on('click', function(){
		var companyNum = document.getElementById('companyNum').value;
		location.href="analyze?companyNum="+companyNum;
	});
	
	$('#deleteCompany').on('click', function(){
		var num = document.getElementById('companyNum').value;
		var result = confirm('Are you sure about deleting this company?');
		if(result == true){
			location.href="companyDelete?companyNum="+num;
		}
	});
	
	
});


function companyReplySection(){
	var addCompanyReplyForm = '<form>';
	addCompanyReplyForm += '<input type="text" id="replyMessage" placeholder="Enter your comment" style="width: 300px;" required>';
	addCompanyReplyForm += '<input type="text" id="companyScore" placeholder="Score" style="width: 50px;" maxlength="3" required>*Scale from 0 ~ 5<br>';
	addCompanyReplyForm += '<input type="button" id="companyReplySave" value="Save">';
	addCompanyReplyForm += '<input type="button" id="companyReplyCancel" value="Cancel">';
	addCompanyReplyForm += '</form>';

	$('#companyReplySection').html(addCompanyReplyForm);
	$('#companyReplyCancel').on('click', function(){
		$('#companyReplySection').html('');	
	});
	
	$('#companyReplySave').on('click', function(){
		var replyMessage = document.getElementById('replyMessage').value;
		var writer = document.getElementById('loginId').value;
		var companyNum = document.getElementById('companyNum').value;
		var companyScore = document.getElementById('companyScore').value;
		var memberNum = document.getElementById('memberNum').value;
		
		$.ajax({
			url : "companyReplySave"
			, type : "POST"
			, contentType : "application/json; charset=utf-8"
			, data : JSON.stringify({
				writer : writer
				, memberNum : memberNum
				, companyNum : companyNum
				, replyMessage : replyMessage
				, companyScore : companyScore
			})
			, success : function(){
				location.href="companyInfo?companyNum="+companyNum;
			}
			, error : function(){
				alert('error during companyReplySave')
			}
		});
	});
	
	
}

function deleteCompanyReply(companyReplyNum){
	var replyDeletedBy = document.getElementById('loginId').value;
	var writer = document.getElementById('loginId').value;
	var companyNum = document.getElementById('companyNum').value;
	$.ajax({
		url : "deleteCompanyReply"
		, type : "POST"
		, contentType : "application/json; charset=utf-8"
		, data : JSON.stringify({
			replyDeletedBy : replyDeletedBy
			, writer : writer
			, companyReplyNum : companyReplyNum
			, companyNum : companyNum
		})
		, success : function (){
			location.href="companyInfo?companyNum="+companyNum;
		}
		, error : function(){
		alert('error during deleteCompanyReply')
		}
	});
}

function replyPaging(currentPage){
	var num = document.getElementById('companyNum').value;
	var page = document.getElementById('page');
	page.value = currentPage;
	location.href='companyInfo?companyNum='+num+'&page='+currentPage;
}




