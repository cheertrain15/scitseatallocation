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

									str += '<div class="questions" id="question' + question + '" surveyType="singleinput">'
											+ '<input type="hidden" id="questionType" value="singleinput">'
											+ '<fieldset>'
											+ '<legend>질문' + question + '. 내용 수정하쇼'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="text" size="70" placeholder="유저 답변 입력 공간" readonly>'
											+ '</fieldset>' 
											+ '</div>';

								}

								if (draggableId == 'radiogroup') {

									str += '<div class="questions" id="question' + question + '" surveyType="radiogroup">'
											+ '<input type="hidden" id="questionType" value="radiogroup">'
											+ '<fieldset>'
											+ '<legend>질문' + question + '. 내용 수정하쇼'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="button" value="+" class="addOption">'
											+ '<input type="button" value="-" class="subOption">'
											+ '<input type="radio" name="radio' + radio + '" id="radio1">'
											+ '<label for="radio1" class="radio">옵션1</label>'
											+ '</fieldset>' 
											+ '</div>';

									radio++;

								}

								if (draggableId == 'checkbox') {

									str += '<div class="questions" id="question' + question + '" surveyType="checkbox">'
											+ '<input type="hidden" id="questionType" value="checkbox">'
											+ '<fieldset>'
											+ '<legend>질문' + question + '. 내용 수정하쇼'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<input type="button" value="+" class="addOption">'
											+ '<input type="button" value="-" class="subOption">'
											+ '<input type="checkbox" name="checkbox' + checkbox + '"  id="checkbox1">'
											+ '<label for="checkbox1">옵션1</label>'
											+ '</fieldset>' 
											+ '</div>';

									checkbox++;

								}

								if (draggableId == 'dropdown') {
									str += '<div class="questions" id="question' + question + '" surveyType="dropdown">'
											+ '<input type="hidden" id="questionType" value="dropdown">'
											+ '<fieldset>'
											+ '<legend>질문' + question + '. 내용 수정하쇼'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<select v-model="select" name="select" id="select">'
											+ '<option disabled value="" selected="selected">선택지</option>'
											+ '</select>'
											+ '<input type="button" value="해당 선택지 삭제" class="subSelectOption">'
											+ '<br>'
											+ '<input type="text" placeholder="추가할 선택지 내용을 입력하세요" size="30">'
											+ '<input type="button" value="추가" class="addSelectOption">'
											+ '</fieldset>'
											+ '</div>';
								}

								if (draggableId == 'comment') {

									str += '<div class="questions" id="question' + question + '" surveyType="comment">'
											+ '<input type="hidden" id="questionType" value="comment">'
											+ '<fieldset>'
											+ '<legend>질문' + question + '. 내용 수정하쇼'
											+ '<input type="button" value="수정" onclick="javascript:editQuestion(' + question + ')">'
											+ '<input type="button" value="삭제" onclick="javascript:deleteQuestion(' + question + ')">'
											+ '</legend>'
											+ '<textarea rows="10" cols="70"></textarea>'
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
	$( "#question"+questionNum ).remove();
};

//각 설문지의 수정버튼이 눌렸을 때 질문 내용을 변경
function editQuestion(questionNum){
	
	var val = $(this).prev('legend').val();
	
	var str = '';
	
	str += '<input type="text" id="editQuestion'+questionNum+'" value="'+val+'">'
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
			var val = $(this).text();
			console.log(val);
			
			var str = '';
			str += '<input type="text" id="editOption" value="'+val+'">'
				+ '<input type="button" value="수정" id="CompleteEditOPtion">';
			
			$(this).html(str);
			completeEditOption();
			
		});
	});
	
};

//라디오, 체크박스 옵션 수정 완료
function completeEditOption(){
	
	$("#CompleteEditOPtion").click(function(){
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
	pageOption += '<option value="page'+Num+'" selected="selected">page'+Num+'</option>';
	
	$( "#pagesWrap" ).find('select').append(pageOption);
	
	var 	page = '';
	page += '<div id="page'+Num+'" class="pages">'
		 + '<h1>Page'+Num+' ( '+Num+' / '+Num+' )</h1>';
	
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
					+'<label for="checkbox'+checkOptionNum+'">옵션'+checkOptionNum+'</label>'
					
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
					+'<label for="radio'+radioOptionNum+'">옵션'+radioOptionNum+'</label>'
					
					console.log(str);
					
					$(this).parent()
						.last()
						.append(str);
				
				editOption();
				
			}

	});
};

//radio와 checkbox설문 옵션 추가
function subOption(){
	
	$(".subOption")
		.off("click").on("click", function(){
		
			var option = $(this).parents('.questions')
							.find('input:checked');
			
			option.each(function(index, item){
				
				var optionId = $(this).attr('id');
				
				var optionLabel = $('label[for="'+optionId+'"]');
				
				option.remove();
				optionLabel.remove();
				
			});
			
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
		
		$(this).parent()
			.find('option:selected')
			.remove();
		
	});   
};

//질문지 선택되면 필수 응답 질문인지 설정 가능하도록 체크박스 띄우기
function checkRequired(){
	
	$( ".questions" ).selectable({
        selected: function() {
        		$(this).each(function(index, item){
        			
        			var required = $(this).attr('required');
        			
        			var str = '';
        			
        			if (required == 'required') {
        				str += '<input type="checkbox" checked="checked" id="checkRequired" '
                   		+ 'associated="'+$( this ).attr('id')+'">'
                   		+ ' 필수 응답항목 설정';
					} else {
               		str += '<input type="checkbox" id="checkRequired" '
               			+ 'associated="'+$( this ).attr('id')+'">'
               			+ ' 필수 응답항목 설정';
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


