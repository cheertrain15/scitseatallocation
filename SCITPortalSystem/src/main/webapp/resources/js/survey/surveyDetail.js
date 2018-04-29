$( document ).ready(function(){   
	$('.pages').hide();
	$('.pages').eq(0).show();
	 
});

function prevPage(index){
	 
	if (index-1 >= 0) {
		$('#page'+index ).hide();
		$('#page'+(index-1)).show();
	} else {
		alert('첫 페이지입니다.')
	}
	
}  

function nextPage(index){
	
	if (index+1 < $('.pages').length) {
		$('#page'+index ).hide();
		$('#page'+(index+1)).show();
	}	else {
		alert('마지막 페이지입니다.')
	}
}

$(function(){
	
	// save data
	
	$('#saveBtn').find('button')
		.click(function(){
			
			// get surveyNum
			
			var surveyNum = $(this).parents('body')
								.find('#surveyInfo')
								.find('input').val();
			
			// get respondInfo
			
			var respondSurvey = new Object();
			var respondArray = new Array();
			
			$(this).parents('body')
				.find('.pages')
				.find('.questions')
				.each(function(index, item){
					
					var respondInfo = new Object();
					
					respondInfo.surveyNum = surveyNum;
					
					// get questionNum
					var questionId = $(this).attr('id');
					var surveyQuestionNum = questionId.replace(/[^0-9]/g,"");
					
					console.log(surveyQuestionNum);
					
					respondInfo.surveyQuestionNum = surveyQuestionNum;
					
					// get questionType
					var surveyQuestionType = $(this).find('#questionType').val();
					
					console.log(surveyQuestionType);
					
					respondInfo.surveyQuestionType = surveyQuestionType;
					
					// get optionNum
					
					$(this)
						.each(function(index, item){
							
							var optionId = new Object();
							var surveyRespondOptionNum = new Object();
							var surveyRespondContent = new Object();
							
							var surveyRespondOptionNumArray = new Array();
							
							// in the case of radio
							if (surveyQuestionType == 'radiogroup') {
								
								optionId = $(this).find('input[type=radio]:checked')
															.attr('id');
								console.log(optionId);
								surveyRespondOptionNum = optionId.replace(/[^0-9]/g,"");
								
								console.log('라디오옵션 아이디: '+surveyRespondOptionNum);
								
								respondInfo.surveyRespondOptionNum = surveyRespondOptionNum;
								
							} 
							
							// in the case of checkbox
							else if (surveyQuestionType == 'checkbox') {
								
								$(this)
									.find('input[type=checkbox]:checked')
									.each(function(index, item){
										
										optionId = $(this).attr('id');
										console.log(optionId);
										surveyRespondOptionNum = optionId.replace(/[^0-9]/g,"");
										
										surveyRespondOptionNumArray.push(surveyRespondOptionNum);
										
									});
								
								console.log('체크박스옵션 아이디: '+surveyRespondOptionNumArray);
								
								respondInfo.surveyRespondOptionNumArray = surveyRespondOptionNumArray;
							}
							
							// in the case of dropdown
							else if (surveyQuestionType == 'dropdown') {
								
								optionId = $(this).find('select')
											.find('option:selected').attr('id');
								console.log(optionId);
								surveyRespondOptionNum = optionId.replace(/[^0-9]/g,"");
								
								console.log('드롭다운옵션 아이디: ' + surveyRespondOptionNum);
								
								respondInfo.surveyRespondOptionNum = surveyRespondOptionNum;
								
							}
							
							else if (surveyQuestionType == 'singleinput'){
								
								surveyRespondContent = $(this).find('input[type=text]')
													.val();
								
								console.log('싱글인풋 내용: '+surveyRespondContent);
								
								respondInfo.surveyRespondContent = surveyRespondContent;
								
							}
							
							else {
								
								surveyRespondContent = $(this).find('textarea')
													.val();
								
								console.log('코멘트 내용: '+surveyRespondContent);
								
								respondInfo.surveyRespondContent = surveyRespondContent;
								
								
							}
							
						});
					
					respondArray.push(respondInfo);
					console.log(respondArray);
					
					
					});
			 
			
			respondSurvey.respondArray = respondArray;
			console.log(respondSurvey);
			
			$.ajax({
				
				url : 'survey/respondSurvey',
				type : 'post',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(respondSurvey),
				success : function(data) {
					alert(data);
					$(location).attr('href', 'survey/suveyList');
				},
				error : function(err) {
					console.log(err);
				}
				
			});
			
		});
});

$(function(){
	
	// 수정 버튼 눌렸을 경우
	$('#editBtn').click(function(){
		
		$('#surveyEditForm').submit();
			
		});
		
});


