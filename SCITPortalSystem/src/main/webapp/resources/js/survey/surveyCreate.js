/**
 * 
 */

// drag

$( function() {
	
	// surveyCanvas 내의 항목들이 순서가 자유자재로 바뀔 수 있도록
	$( "#surveyCanvas" ).sortable({
	      revert: true
	    });
	
	// 각 툴들이 드래그 가능하도록
    $( "#singleinput, #radiogroup, #checkbox, #dropdown, #comment" ).draggable(
    
    		{ 
    			scroll: true,
    			cursor: "move",
    		    helper: "clone",
    		    	revert: "valid"
    		    	
    		}
    		
    );

    $( ".surveyCanvas" ).disableSelection();
    
	var question = 1;
	var str = '';
    
	// surveyCanvas에서 드래그된 것들을 받아서 그에 따른 설문지를 생성할 수 있도록
    $( "#surveyCanvas" ).droppable({
    		greedy: true,
        drop: function( event, ui ) {
        	
        	var draggableId = ui.draggable.attr("id");
        	console.log(draggableId);
        
        	if (draggableId == 'singleinput') {
        		
        		str +='<div class="questions" id="question' + question + '">'
        		+'<fieldset>'
        	    +'<legend>질문' + question + '. 텍스트 질문'
        	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
        		+'</legend>'
        		+'<input type="text" size="30" placeholder="유저 답변 입력 공간" readonly>'
        		+'</fieldset>'
        		+'</div>';
				
			}
        	
        	if (draggableId == 'radiogroup') {
        		
        		str += '<div class="questions" id="question' + question + '">'
    			+'<fieldset>'
    			+'<legend>질문' + question + '. 라디오 질문'
    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
        		+'</legend>'
        	    +'<input type="radio" name="radio-1" id="radio-1">'
        	    +'<label for="radio-1"><input type="text" placeholder="옵션1"></label>'
        	    +'<input type="radio" name="radio-1" id="radio-2">'
        	    +'<label for="radio-2"><input type="text" placeholder="옵션2"></label>'
        	    +'<input type="radio" name="radio-1" id="radio-3">'
        	    +'<label for="radio-3"><input type="text" placeholder="옵션3"></label>'
        	    +'</fieldset>'
        	    +'</div>';
				
			}
        	
        	if (draggableId == 'checkbox') {
        		
        		str += '<div class="questions" id="question' + question + '">'
    			+'<fieldset>'
    			+'<legend>질문' + question + '. 체크박스 질문'
    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
        		+'</legend>'
        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-1">'
        	    +'<label for="checkbox-1"><input type="text" placeholder="옵션1"></label>'
        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-2">'
        	    +'<label for="checkbox-2"><input type="text" placeholder="옵션2"></label>'
        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-3">'
        	    +'<label for="checkbox-3"><input type="text" placeholder="옵션3"></label>'
        	    +'</fieldset>'
        	    +'</div>';
				
			}
        	
       if (draggableId == 'dropdown') {
        	 
    	   str +='<div class="questions" id="question' + question + '">'
 			+'<fieldset>'
			+'<legend>질문' + question + '. 셀렉트 질문'
			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
    			+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
    			+'</legend>'
    			+'<select name="select" id="select">'
    			+'<option>옵션1</option>'
    			+'<option selected="selected">옵션2</option>'
    			+'<option>옵션3</option>'
    			+'<option>옵션4</option>'
	    	    +'</select>'
	    	    +'</fieldset>'
        	    +'</div>';
	    	    
       }
       
      if (draggableId == 'comment') {
    	
    	  str +='<div class="questions" id="question' + question + '">'
  		+'<fieldset>'
  	    +'<legend>질문' + question + '. 코멘트 질문'
  	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
  		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
  		+'</legend>'
  		+'<textarea rows="5" cols="30"></textarea>'
  		+'</fieldset>'
  		+'</div>';
    	  
	}
        
        	$(this).html(str);
          
          question++;
        }
      });
   
} );

// 각 설문지의 삭제버튼이 눌렸을 때 삭제 처리가 가능하도록
function deleteSurvey(questionNum){
	$( "#question"+questionNum ).remove();
}

// 각 설문지의 수정버튼이 눌렸을 때 질문 내용을 바꿀 수 있도록
function editQuestion(questionNum){
	var str = '';
	str += '<input type="text" id="editQuestion'+questionNum+'" value="질문'+questionNum+'. ">'
		+ '<input type="button" value="수정" onclick="javascript:completeEditQuestion('+questionNum+')">';
	
	$( "#question"+questionNum+" legend")
		.html(str);
}

// 각 설문지의 질문 내용을 수정하고 변경 완료할 수 있도록
function completeEditQuestion(questionNum){
	
	var val = $( "#editQuestion"+questionNum ).val();
	
	val += '<input type="button" value="수정" onclick="javascript:editQuestion('+questionNum+')">'
		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+questionNum+')">';
	
	$( "#question"+questionNum+" legend").html(val);
}
