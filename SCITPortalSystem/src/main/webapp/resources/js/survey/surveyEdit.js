$(document).ready(function() {
	$('.pages').hide();
	$('.pages').eq(0).show();
	
	initialize();
	editOption();
	addOption(); 
	subOption();
	addSelectOption();
	subSelectOption();
	checkRequired();
	editSurvey();

});
 
var question = 1;
var checkbox = 1;
var radio = 1;

//설문 시작일과 마감일 설정
$( function() {
	    $('#surveyStartDate').datepicker({
           dateFormat: "yy-mm-dd",            
           changeMonth: true,                  
           minDate: 0,                       
           onClose: function( selectedDate ) {    
               $("#surveyEndDate").datepicker( "option", "minDate", selectedDate );
           }                
       });

       $('#surveyEndDate').datepicker({
           dateFormat: "yy-mm-dd",
           changeMonth: true,
           minDate: 0,
           onClose: function( selectedDate ) {
               $("#surveyStartDate").datepicker( "option", "maxDate", selectedDate );
           }                
       });
	    
});


function initialize() {

	$(function() {
		// 각 툴 드래그 가능
		$(".tools").draggable({
			scroll : true,
			cursor : "move",
			helper : "clone",
			revert : "valid"
		});
	});

	$(function() {

		// 드롭하면 설문지 생성
		$("#questionsWrap div")
				.droppable(
						{
							greedy : true,
							drop : function(event, ui) {

								var draggableId = ui.draggable.attr("id");
								console.log(draggableId);

								var str = '';

								if (draggableId == 'singleinput') {

									str += '<div class="questions" id="question' + question + '">'
											+ '<input type="hidden" id="questionType" value="singleinput">'
											+ '<fieldset>'
											+ '<legend>질문 내용을 변경하세요'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="text" size="50" placeholder="유저 답변 입력 공간" readonly>'
											+ '</fieldset>' 
											+ '</div>';

								}

								if (draggableId == 'radiogroup') {

									str += '<div class="questions" id="question' + question + '">'
											+ '<input type="hidden" id="questionType" value="radiogroup">'
											+ '<fieldset>'
											+ '<legend>질문 내용을 변경하세요'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="button" value="+" class="addOption">'
											+ '<input type="button" value="-" class="subOption">'
											+ '<input type="radio" name="radio' + radio + '" id="radio1">'
											+ '<label for="radio1" class="radio">선택지 내용을 수정하세요</label>'
											+ '</fieldset>' 
											+ '</div>';

									radio++;

								}

								if (draggableId == 'checkbox') {

									str += '<div class="questions" id="question' + question + '">'
											+ '<input type="hidden" id="questionType" value="checkbox">'
											+ '<fieldset>'
											+ '<legend>질문 내용을 변경하세요'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="button" value="+" class="addOption">'
											+ '<input type="button" value="-" class="subOption">'
											+ '<input type="checkbox" name="checkbox' + checkbox + '"  id="checkbox1">'
											+ '<label for="checkbox1">선택지 내용을 수정하세요</label>'
											+ '</fieldset>' 
											+ '</div>';

									checkbox++;

								}

								if (draggableId == 'dropdown') {
									str += '<div class="questions" id="question' + question + '">'
											+ '<input type="hidden" id="questionType" value="dropdown">'
											+ '<fieldset>'
											+ '<legend>질문 내용을 변경하세요'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<select v-model="select" name="select" id="select">'
											+ '<option disabled value="" selected="selected">선택지를 추가하세요</option>'
											+ '</select>'
											+ '<input type="button" value="선택지 삭제" class="subSelectOption">'
											+ '<br>'
											+ '<input type="text" placeholder="추가할 내용 입력" size="30">'
											+ '<input type="button" value="선택지 추가" class="addSelectOption">'
											+ '</fieldset>'
											+ '</div>';
								}

								if (draggableId == 'comment') {

									str += '<div class="questions" id="question' + question + '">'
											+ '<input type="hidden" id="questionType" value="comment">'
											+ '<fieldset>'
											+ '<legend>질문 내용을 변경하세요'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<textarea rows="10" cols="50"></textarea>'
											+ '</fieldset>' 
											+ '</div>';

								}

								$(this).append(str);

								initialize();
								editOption();
								addOption();
								subOption();
								addSelectOption();
								subSelectOption();
								checkRequired();

								question++;
							}

						});

	});

};

//각 설문지의 삭제버튼이 눌렸을 때 삭제 처리
function deleteQuestion(questionNum){
	
	var questionSize = $('.questions').length;
	
	if (questionSize <= 1) {
		
		alert('더이상 삭제할 수 없습니다.');
		
	} else {
		
		$( "#question"+questionNum ).remove();
		
	}
	
};

//각 설문지의 수정버튼이 눌렸을 때 질문 내용을 변경
function editQuestion(questionNum){
	
//	var val = $(this).prev('legend').val();
	
	var str = '';
	
	str += '<input type="text" id="editQuestion'+questionNum+'">'
		+ '<input type="button" value="수정" onclick="javascript:completeEditQuestion('+questionNum+')">';
	
	$( "#question"+questionNum+" legend")
		.html(str);
};

//각 설문지의 질문 내용을 수정하고 변경 완료
function completeEditQuestion(questionNum){
	
	var val = $( "#editQuestion"+questionNum ).val();
	
	val += '<input type="button" value="수정" onclick="javascript:editQuestion('+questionNum+')">'
		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+questionNum+')">';
	
	$( "#question"+questionNum+" legend").html(val);
};

//라디오, 체크박스 옵션 내용 수정
function editOption(){
	
	$("label").dblclick(function(){
	 	
		$(this).each(function(index, item){
			
			var str = '';
			str += '<input type="text" id="editOption" value="">'
				+ '<input type="button" value="수정" class="CompleteEditOPtion">';
			
			$(this).html(str);
			completeEditOption();
			
		});
	});
	
}; 

//라디오, 체크박스 옵션 수정 완료
function completeEditOption(){
	
	$(".CompleteEditOPtion").off().click(function(){
		$(this).each(function(index, item){
			
			var editVal = $(this).prev('input').val();
			$(this).parent().html(editVal);
			
		});
	});
};

// 페이지 추가
function addPage(pageSize){
	
	var Num = pageSize+1;
	
	var pageOption = '';
	pageOption += '<option value="page'+Num+'" selected="selected">페이지 '+Num+'</option>';
	
	$( "#pagesWrap" ).find('select').append(pageOption);
	
	var 	page = '';
	page += '<div id="page'+Num+'" class="pages">'
		 + '<h1>페이지 '+Num+'</h1>';
	
	console.log($( "#pagesWrap" ).find('select'));
	$( "#questionsWrap" ).append(page);
	
	// 페이지를 추가하고 나면 해당 페이지만 보여주고 나머지는 숨김
	var target = $( "#pagesWrap" ).find('select').find('option:selected');
	console.log(target);
	var val = target.val();
	var num = val.replace(/[^0-9]/g,"");
	
	$( '.pages' ).hide();
	$( '#page'+num ).show();
	
	// 페이지를 추가하고 나면 해당 페이지에도 droppable 기능 추가
	initialize();
	
};

//페이지 삭제하기
function subPage(){
	
	var pageSize = $( "#pagesWrap" ).find('option').length;
	
	if (pageSize <= 1) {
		alert('더이상 삭제할 수 없습니다.');
	} else {
		
		var target = $( "#pagesWrap" ).find('option:selected');
		console.log(target);
		var val = target.val();
		var num = val.replace(/[^0-9]/g,"");
		
		target.remove();
		
		$( '#page'+num ).remove();
		
		target = $( "#pagesWrap" ).find('option:selected');
		console.log(target);
		val = target.val();
		num = val.replace(/[^0-9]/g,"");
		
		$( '#page'+num ).show();
		
	}
	
};

//select에서 페이지를 변경하면 해당 페이지를 보여주고 나머지 페이지는 숨김
$(function(){

	$( "#pagesWrap" ).find('select')
		.change(function() {
	    
		var target = $(this).find('option:selected');
		var val = target.val();
		var num = val.replace(/[^0-9]/g,"");
	    
	    	$( '.pages' ).hide();
	    $( '#page'+num ).show();
	    
	});

});

var checkOptionNum = 1;
var radioOptionNum = 1;

//radio와 checkbox설문 옵션 추가
function addOption(){
	
	$(".addOption")
		.off("click").on("click", function(){
		
		var option = $(this).parents('.questions')
						.find('input[type="hidden"]').val();
		console.log(option);

			if (option == 'checkbox') {
				
				checkOptionNum++;
				var name = $(this).parent().find('input[type=checkbox]').attr("name");
				console.log(name);
				
				var str = '';
				str += '<input type="checkbox" '
					+ 'name="'+name+'" id="checkbox'+checkOptionNum+'">'
					+'<label for="checkbox'+checkOptionNum+'">선택지 내용을 수정하세요</label>'
					
					console.log(str);
					
					$(this).parent()
						.last()
						.append(str);
				
					editOption();
			}
			
			if (option == 'radiogroup') {
				
				radioOptionNum++;
				var name = $(this).parent().find('input[type=radio]').attr("name");
				console.log(name);
				
				var str = '';
				str += '<input type="radio" '
					+ 'name="'+name+'" id="radio'+radioOptionNum+'">'
					+'<label for="radio'+radioOptionNum+'">선택지 내용을 수정하세요</label>'
					
					console.log(str);
					
					$(this).parent()
						.last()
						.append(str);
				
				editOption();
				
			}

	});
};

//radio와 checkbox설문 옵션 삭제
function subOption(){
	
	$(".subOption")
		.off("click").on("click", function(){
		
			var optionSize = $(this).parents('.questions').find('input').length;
			
			if (optionSize <= 1 ) {
				
				alert ('더이상 삭제할 수 없습니다.');
				
			} else {
			
			var option = $(this).parents('.questions')
							.find('input:checked');
			
			option.each(function(index, item){
				
				var optionId = $(this).attr('id');
				
				var optionLabel = $('label[for="'+optionId+'"]');
				
				option.remove();
				optionLabel.remove();
				
			});
				
			};
			
	});
	
};

//select 질문 선택지 추가
function addSelectOption(){
	
	$('.addSelectOption').click(function(){
		
		var val = $(this).prev('input[type="text"]').val();			
		console.log(val);
		
		var str = '';
			str += '<option>'+val+'</option>';
			
		$(this).parent().find("select").append(str);
		
		$(this).parent().find("option:disabled").remove();
		
		$(this).prev('input[type="text"]').val('');
		
	});
};

//select 질문 선택지 제거
function subSelectOption(){
	
	$(".subSelectOption").click(function(){
		
		var optionSize = $(this).parent().find('option').length;
		
		if (optionSize <= 1) {
			
			alert('더이상 삭제할 수 없습니다.');
			
		} else {
		
		$(this).parent()
			.find('option:selected')
			.remove();
		
		};
		
	}); 
		
};

//질문지 선택되면 필수 응답 질문인지 설정 가능하도록 체크박스 띄우기
function checkRequired(){
	
	$( ".questions" ).selectable({
        selected: function() {
        		$(this).each(function(index, item){
        			
        			var required = $(this).attr('required');
        			var val = $(this).find('legend').text();
        			console.log(val);
        			
        			var str = '';
        			
        			if (required == 'required') {
        				str += '<input type="checkbox" checked="checked" id="checkRequired" '
                   		+ 'associated="'+$( this ).attr('id')+'">'
                   		+ '<' + val + '> 필수 응답항목 설정';
					} else {
               		str += '<input type="checkbox" id="checkRequired" '
               			+ 'associated="'+$( this ).attr('id')+'">'
               			+ '<' + val + '> 필수 응답항목 설정';
					}
               		
                      $( "#attributeWrap" ).html(str); 
                      
               		reqiredQuestion(); // 필수 응답 항목 체크 시 각 설문항목에 속성 추가
        		});
        		
        }
     });
	
};

//필수 응답 체크박스에 체크될 경우 div에 required 속성 추가
function reqiredQuestion(){
	
	$("#checkRequired").change(function(){
		
		var id = $(this).attr('associated');
		console.log(id);
		
		if($("#checkRequired").is(":checked")){
			$('#'+id).attr('required', 'required');
		} else {
			$('#'+id).removeAttr('required');
		}

	});
	
};

function editSurvey(){
	
	$("#editSurvey").click(function(){
		
		// 해당 설문조사 배열
		var surveyArray = new Array();
		var pageArray =  new Array();
		
		var surveyInfo = new Object();
		
		// 설문 번호, 분류, 대상, 기간, 제목 가져오기
		var surveyNum =
			$(this).parents('body')
			.find('#getSurveyNum').val();
		
		var surveyCategory =
			$(this).parents('body')
			.find('#selectCategory option:selected').val();
		
		var surveyTargetAlumni = 
			$(this).parents('body')
			.find('#selectAlumni option:selected').val();
		
		var surveyTargetClassroom =
			$(this).parents('body')
			.find('#selectClass option:selected').val();
		
		var surveyStartDate =
			$(this).parents('body')
			.find('#surveyStartDate').val();
		
		var surveyEndDate =
			$(this).parents('body')
			.find('#surveyEndDate').val();
		
		var surveyTitle = 
			$(this).parents('body')
			.find('#surveyTitle').val();
		
		surveyInfo.surveyNum = surveyNum;
		surveyInfo.surveyCategory = surveyCategory;
		surveyInfo.surveyTargetAlumni = surveyTargetAlumni;
		surveyInfo.surveyTargetClassroom = surveyTargetClassroom;
		surveyInfo.surveyStartDate = surveyStartDate;
		surveyInfo.surveyEndDate = surveyEndDate;
		surveyInfo.surveyTitle = surveyTitle;
		
		var surveyPage = new Array();
		
		// 각 페이지 아이디
		$(this).parents("body")
			.find(".pages")
			.each(function(index, item){
				
				var pageId = new Object();
				var page = $(this).attr("id");
				
				pageId.surveyPageId = page;
				
				surveyPage.push(pageId); // surveyInfo - surveyPage(pageId배열)
				
				
				// 각 페이지 설문항목
				$(this).find('.questions')
					.each(function(index, item){
						
						var pageInfo = new Object();
						pageInfo.page = page; // pageInfo - 각 pageId
						
						
						// 각 설문항목의 질문내용
						var questionContent = $(this).find('legend').text();
						
						pageInfo.surveyQuestionContent = $.trim(questionContent);
						
						// 각 설문항목의 필수응답여부
						var required = $(this).attr("required");
						
						if (required == 'required') {
							pageInfo.surveyQuestionRequired = 1;
						} else {
							pageInfo.surveyQuestionRequired = 0;
						}
						 
						// 각 설문항목의 타입
						var surveyType = $(this).find('input[type="hidden"]').val();
						pageInfo.surveyQuestionType = surveyType;
						
						// 각 설문항목의 선택지
						var surveyOption = new Array();
						
						// 설문타입이 라디오/체크박스일 경우 선택지 저장
						if (surveyType == 'radiogroup' || 
								surveyType == 'checkbox') {
							
							$(this).find('label')
								.each(function(){
									
									var optionContent = new Object();
									optionContent.surveyOptionContent = $(this).text();
									surveyOption.push(optionContent);
									
								});
							
							pageInfo.surveyOption =  surveyOption;
							
						}
						
						if (surveyType == 'dropdown') {
							
							console.log($(this).find('option').val());
							
							$(this).find('option')
								.each(function(){
									
									var optionContent = new Object();
									optionContent.surveyOptionContent = $(this).val();
									surveyOption.push(optionContent);

									
								});
							
							pageInfo.surveyOption =  surveyOption;
							
							
						}
						
						// pageArray에 저장
						pageArray.push(pageInfo);
						
					}); // 각 페이지 설문항목 끝
				
			}); // 각 페이지 아이디 끝
		
		surveyInfo.surveyPage = surveyPage;
		surveyArray.push(surveyInfo);
		
		
		// 설문조사의 정보를 담을 객체
		var createSurvey = new Object();
		createSurvey.surveyArray = surveyArray;
		createSurvey.pageArray = pageArray;
		
		console.log(createSurvey);
		
		// 데이터 넘기기
		$.ajax({
			
			url : 'completeEditSurvey',
			type : 'post',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(createSurvey),
			success : function(data) {
				alert(data);
				$(location).attr('href', 'survey');
			},
			error : function(err) {
				console.log(err);
			}
			
		})
		
	});
}; 


