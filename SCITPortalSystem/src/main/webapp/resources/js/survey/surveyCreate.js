$( document ).ready('initialize');
// 설문 시작일과 마감일 설정
$( function() {
	    var dateFormat = "yy-mm-dd",
	      from = $( "#surveyStartDate" ).datepicker({
	          defaultDate: "+1w", 
	          changeMonth: true
	        })
	        .on( "change", function() {
	          to.datepicker( "option", "dateFormat", dateFormat);
	        }),
	      to = $( "#surveyEndDate" ).datepicker({
	        defaultDate: "+1w",
	        changeMonth: true
	      })
	      .on( "change", function() {
	        from.datepicker( "option", "dateFormat", dateFormat);
	      });
	    
});


//$( function() {
//	// surveyCanvas 내의 항목 순서 변경
//	$( "#surveyCanvas" ).sortable({
//	      revert: true
//	    });
//});


//$( function() {
//    $( "#surveyCanvas" ).disableSelection();
//});

var question = 1;

function initialize(){
	
$( function() {
		// 각 툴 드래그 가능
	    $( ".tools" ).draggable(
	    	{ 
	    		scroll: true,
	    		cursor: "move",
//	    		connectToSortable: "#surveyCanvas",
	    		helper: "clone",
	    		revert: "valid"
	    	}
	   );
});

$( function() {
	
	// surveyCanvas에서 드롭받아 설문지 생성
    $( "#surveyCanvas div" ).droppable({
    		greedy: true,
        drop: function( event, ui ) {
        	
        	var draggableId = ui.draggable.attr("id");
        	
        	var str = '';
        
        	if (draggableId == 'singleinput') {
        		
        		str +='<div class="questions" id="question' + question + '">'
	        		+'<fieldset>'
	        	    +'<legend><p id="questionContent">질문' + question + '. 내용 수정하쇼</p>'
	        	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        		+'<input type="text" size="70" placeholder="유저 답변 입력 공간" readonly>'
	        		+'</fieldset>'
	        		+'</div>';
				
			}
        	
        	if (draggableId == 'radiogroup') {
        		
        		str += '<div class="questions" id="question' + question + '">'
	    			+'<fieldset>'
	    			+'<legend><p id="questionContent">질문' + question + '. 내용 수정하쇼</p>'
	    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        	    +'<input type="radio" name="radio-1" id="radio-1">'
	        	    +'<label for="radio-1"><p>옵션1</p></label>'
	        	    +'<input type="radio" name="radio-1" id="radio-2">'
	        	    +'<label for="radio-2"><p>옵션2</p></label>'
	        	    +'<input type="radio" name="radio-1" id="radio-3">'
	        	    +'<label for="radio-3"><p>옵션3</p></label>'
	        	    +'</fieldset>'
	        	    +'</div>';
				
			}
        	
        	if (draggableId == 'checkbox') {
        		
        		str += '<div class="questions" id="question' + question + '">'
	    			+'<fieldset>'
	    			+'<legend><p id="questionContent">질문' + question + '. 내용 수정하쇼</p>'
	    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-1">'
	        	    +'<label for="checkbox-1"><p>옵션1</p></label>'
	        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-2">'
	        	    +'<label for="checkbox-2"><p>옵션2</p></label>'
	        	    +'<input type="checkbox" name="checkbox-1" id="checkbox-3">'
	        	    +'<label for="checkbox-3"><p>옵션3</p></label>'
	        	    +'</fieldset>'
	        	    +'</div>';
				
			}
        	
       if (draggableId == 'dropdown') {
        	 
	    	    str +='<div class="questions" id="question' + question + '">'
	    	   		+'<fieldset>'
	 			+'<legend><p id="questionContent">질문' + question + '. 내용 수정하쇼</p>'
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
	  		+'<legend><p id="questionContent">질문' + question + '. 내용 수정하쇼</p>'
	  	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	  		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	  		+'</legend>'
	  		+'<textarea rows="10" cols="70"></textarea>'
	  		+'</fieldset>'
	  		+'</div>';
    	  
	}
        
        	$(this).append(str);
          
          question++;
        }
      });
   
});

};



	// 각 설문지의 삭제버튼이 눌렸을 때 삭제 처리
	function deleteSurvey(questionNum){
		$( "#question"+questionNum ).remove();
	};

	// 각 설문지의 수정버튼이 눌렸을 때 질문 내용을 변경
	function editQuestion(questionNum){
		var str = '';
		str += '<input type="text" id="editQuestion'+questionNum+'" value="질문'+questionNum+'. ">'
			+ '<input type="button" value="수정" onclick="javascript:completeEditQuestion('+questionNum+')">';
		
		$( "#question"+questionNum+" legend")
			.html(str);
	};
	
	// 각 설문지의 질문 내용을 수정하고 변경 완료
	function completeEditQuestion(questionNum){
		
		var val = $( "#editQuestion"+questionNum ).val();
		
		val += '<input type="button" value="수정" onclick="javascript:editQuestion('+questionNum+')">'
			+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+questionNum+')">';
		
		$( "#question"+questionNum+" legend").html(val);
	};
	
	// 페이지 추가
	
	var Num = 2;
	var zIndex = 1;
	
	function addPage(){
//		
//		var obj = $("#surveyCanvas").offset();
//		console.log("left: " + obj.left + "px, top: " + obj.top + "px");

		var page = '';
		page += '<option value="'+Num+'" selected>page'+Num+'</option>';
		
		zIndex++;
		var canvas = '';
		canvas += '<div class="canvases" id="canvas'+Num+'" style="z-index:'+zIndex+';">'
		+ '<p>page'+Num+'</p>'
		+ '</div>';
		
		$( "#pages" ).append(page);
		$( "#surveyCanvas" ).append(canvas);
		
		Num++;
		
		// 페이지를 추가하고 나면 해당 페이지에도 droppable 기능 추가
		initialize();
		
		// 페이지를 추가하고 나면 해당 페이지만 보여주고 나머지는 숨김
		var state = $('#pages option:selected').val();
		$( '.canvases' ).hide();
		$( '#canvas'+state ).show();
		
	};
	
	// select에서 페이지를 변경하면 해당 페이지를 보여주고 나머지 페이지는 숨김
	$(function(){
	
		$('#pages').change(function() {
		    
			var state = $('#pages option:selected').val();
		    
		    	$( '.canvases' ).hide();
		    $( '#canvas'+state ).show();
		    
		});
	
	});
	
	
	