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
			
			var exit = false;
			
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
							
							var required = $(this).attr('required');
							var title = $(this).find('legend').find('#title').text();
							
							// in the case of radio
							if (surveyQuestionType == 'radiogroup') {
								
								var checked = $(this).find('input[type=radio]').is(':checked');
								
								// 필수 응답 항목일 경우
								if (required == 'required') {
									
									// 응답하지 않았을 경우
									if (checked == false) {
										alert('<'+$.trim(title)+'>는 필수 응답 항목입니다.');
										exit = true;
										return false;
										
									} else {
										
										optionId = $(this).find('input[type=radio]:checked')
										.attr('id');
										console.log(optionId);
										surveyRespondOptionNum = optionId.replace(/[^0-9]/g,"");
										
										console.log('라디오옵션 아이디: '+surveyRespondOptionNum);
										
										respondInfo.surveyRespondOptionNum = surveyRespondOptionNum;
										
									}
									
									if(exit){ return false;}
								
								// 필수 응답 항목이 아닐 경우
								} else {
									
									// 응답하지 않았을 경우
									if(checked == false) {
										
									} else {
										
										optionId = $(this).find('input[type=radio]:checked')
										.attr('id');
										console.log(optionId);
										surveyRespondOptionNum = optionId.replace(/[^0-9]/g,"");
										
										console.log('라디오옵션 아이디: '+surveyRespondOptionNum);
										
										respondInfo.surveyRespondOptionNum = surveyRespondOptionNum;
										
									}
									
								}
								
								if(exit){ return false;}
								
							} // radiogroup 끝 
							
							// in the case of checkbox
							else if (surveyQuestionType == 'checkbox') {
								
								var checked = $(this).find('input[type=checkbox]:checked').is(':checked');
								
								// 필수 응답 항목일 경우
								if (required == 'required') {
									
									// 응답하지 않았을 경우
									if (checked == false) {
										alert('<'+$.trim(title)+'>는 필수 응답 항목입니다.');
										exit = true;
										return false;
										
									} else {
										
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
									
									if(exit){ return false;}
									
								// 필수 응답 항목이 아닐 경우
								} else {
									
									// 응답하지 않았을 경우
									if(checked == false) {
										
									} else {
										
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
									
								}
								
								if(exit){ return false;}
								
							} // checkbox 끝
							
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
								
								var checked = $(this).find('input[type=text]').val();
								
								// 필수 응답 항목일 경우
								if (required == 'required') {
									
									// 응답하지 않았을 경우
									if (checked == null || checked == '') {
										alert('<'+$.trim(title)+'>는 필수 응답 항목입니다.');
										exit = true;
										return false;
										
									} else {
										surveyRespondContent = $(this).find('input[type=text]')
										.val();
					
										console.log('싱글인풋 내용: '+surveyRespondContent);
										
										respondInfo.surveyRespondContent = surveyRespondContent;
										
									}
									
									if(exit){ return false;}
								
								// 필수 응답 항목이 아닐 경우
								} else {
									
									// 응답하지 않았을 경우
									if(checked == null || checked == '') {
										
									} else {
										surveyRespondContent = $(this).find('input[type=text]')
										.val();
					
										console.log('싱글인풋 내용: '+surveyRespondContent);
										
										respondInfo.surveyRespondContent = surveyRespondContent;
										
									}
								}
								
								if(exit){ return false;}
								
							} // singleinput 끝
							
							else {
								
								var checked = $(this).find('textarea').val();
								
								// 필수 응답 항목일 경우
								if (required == 'required') {
									
									// 응답하지 않았을 경우
									if (checked == null || checked == '') {
										alert('<'+$.trim(title)+'>는 필수 응답 항목입니다.');
										exit = true;
										return false;
										
									} else {
										surveyRespondContent = $(this).find('textarea')
										.val();
					
										console.log('코멘트 내용: '+surveyRespondContent);
										
										respondInfo.surveyRespondContent = surveyRespondContent;
										
									}
									
									if(exit){ return false;}
									
								// 필수 응답 항목이 아닐 경우
								} else {
									
									// 응답하지 않았을 경우
									if(checked == 0) {
										
									} else {
										surveyRespondContent = $(this).find('textarea')
										.val();
					
										console.log('코멘트 내용: '+surveyRespondContent);
										
										respondInfo.surveyRespondContent = surveyRespondContent;
										
										
									}
								
								}
								
								if(exit){ return false;}
								
							} //comment 끝
							
						});
					
					if(exit){ return false;}
					
					respondArray.push(respondInfo);
					console.log(respondArray);
					
					
					});
			
			if(exit){ return false;}
			
			respondSurvey.respondArray = respondArray;
			console.log(respondSurvey);
			
			$.ajax({
				
				url : 'respondSurvey',
				type : 'post',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(respondSurvey),
				success : function(data) {
					alert(data);
					$(location).attr('href', 'surveyList');
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


