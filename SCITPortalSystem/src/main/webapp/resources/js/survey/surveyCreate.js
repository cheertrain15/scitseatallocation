$( document ).ready(function(){
	initialize();
	saveSurvey();
});

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
        	console.log(draggableId);
        	
        	var str = '';
        
        	if (draggableId == 'singleinput') {
        		
        		str +='<div class="questions" id="question' + question + '" surveyType="singleinput">'
	        		+'<fieldset>'
	        	    +'<legend>질문' + question + '. 내용 수정하쇼'
	        	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        		+'<input type="text" size="70" placeholder="유저 답변 입력 공간" readonly>'
	        		+'</fieldset>'
	        		+'</div>';
				
			}
        	
        	if (draggableId == 'radiogroup') {
        		
        		str += '<div class="questions" id="question' + question + '" surveyType="radiogroup">'
	    			+'<fieldset>'
	    			+'<legend>질문' + question + '. 내용 수정하쇼'
	    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        		+'<input type="button" value="+" class="addOption">'
	        	    +'<input type="button" value="-" class="subOption">'
	        	    +'<input type="radio" name="radio" id="radio1">'
	        	    +'<label for="radio1" class="radio">옵션1</label>'
	        	    +'</fieldset>'
	        	    +'</div>';
				
			}
        	
        	if (draggableId == 'checkbox') {
        		
        		str += '<div class="questions" id="question' + question + '" surveyType="checkbox">'
	    			+'<fieldset>'
	    			+'<legend>질문' + question + '. 내용 수정하쇼'
	    			+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	        		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	        		+'</legend>'
	        		+'<input type="button" value="+" class="addOption">'
	        	    +'<input type="button" value="-" class="subOption">'
	        	    +'<input type="checkbox" name="checkbox" id="checkbox1">'
	        	    +'<label for="checkbox1">옵션1</label>'
	        	    +'</fieldset>'
	        	    +'</div>';
				
			}
        	
       if (draggableId == 'dropdown') {
        	 
	    	    str +='<div class="questions" id="question' + question + '" surveyType="dropdown">'
	    	   		+'<fieldset>'
	    	   		+'<legend>질문' + question + '. 내용 수정하쇼'
				+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	    			+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	    			+'</legend>'
	    			+'<select name="select" id="select">'
	    			+'<option selected="selected">선택지</option>'
		    	    +'</select>'
		    	    +'<input type="button" value="해당 선택지 삭제" id="subSelectOption">'
		    	    +'<br>'
		    	    +'<input type="text" id="selectOption" placeholder="추가할 선택지 내용을 입력하세요" size="30">'
		    	    +'<input type="button" value="추가" id="addSelectOption">'
		    	    +'</fieldset>'
	        	    +'</div>';
	    	    
       }
       
      if (draggableId == 'comment') {
    	
	    	str +='<div class="questions" id="question' + question + '" surveyType="comment">'
	  		+'<fieldset>'
	  		+'<legend>질문' + question + '. 내용 수정하쇼'
	  	    +'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	  		+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	  		+'</legend>'
	  		+'<textarea rows="10" cols="70"></textarea>'
	  		+'</fieldset>'
	  		+'</div>';
    	  
	}
        
        	$(this).append(str);
         
        question++;
        
        addSubOption(); // 라디오, 체크박스 설문지에 대한 선택지 추가/제거
        addSelectOption(); // 셀렉트 설문지에 대한 선택지 추가
        subSelectOption(); // 셀렉트 설문지에 대한 선택지 제거
        checkRequired(); // 각 설문항목 클릭시 필수 응답 항목 여부 체크 가능
        editOption();
        
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
	
	// 라디오, 체크박스 옵션 내용 수정
	function editOption(){
		
		$("label").dblclick(function(){
			
			$(this).each(function(index, item){
				
				var val = $(this).text();
				
				var str = '';
				str += '<input type="text" id="editOption" value="'+val+'">'
					+ '<input type="button" value="수정" id="CompleteEditOPtion">';
				
				$(this).html(str);
				completeEditOption();
				
			});
			
		});
		
		
		
	};
	
	// 라디오, 체크박스 옵션 수정 완료
	
	function completeEditOption(){
		
		$("#CompleteEditOPtion").click(function(){
			
			$(this).each(function(index, item){
				
				var editVal = $(this).prev('input').val();
				$(this).parent().html(editVal);
				
			});
		});
	};
	
	// 페이지 추가
	
	var Num = 2;
	var zIndex = 1;
	 
	function addPage(){
//		
//		var obj = $("#surveyCanvas").offset();
//		console.log("left: " + obj.left + "px, top: " + obj.top + "px");

		var page = '';
		page += '<option value="page'+Num+'" selected>page'+Num+'</option>';
		
		zIndex++;
		var canvas = '';
		canvas += '<div class="canvases" id="canvas'+Num+'" style="z-index:'+zIndex+';">'
		+ '<p>page'+Num+'</p>'
		+ '</div>';
		
		$( "#pages" ).append(page);
		$( "#surveyCanvas" ).append(canvas);
		
		Num++;
		
		// 페이지를 추가하고 나면 해당 페이지만 보여주고 나머지는 숨김
		var target = $("#pages").find('option:selected');
		var val = target.val();
		var num = val.replace(/[^0-9]/g,"");
		
		$( '.canvases' ).hide();
		$( '#canvas'+num ).show();
		
		// 페이지를 추가하고 나면 해당 페이지에도 droppable 기능 추가
		initialize();
		
	};
	
	// 페이지 삭제하기
	function subPage(){
		
		var target = $("#pages").find('option:selected');
		var val = target.val();
		var num = val.replace(/[^0-9]/g,"");
		
		target.remove();
		
		$("#id"+num).remove();
		
	}
	
	// select에서 페이지를 변경하면 해당 페이지를 보여주고 나머지 페이지는 숨김
	$(function(){
	
		$('#pages').change(function() {
		    
			var target = $("#pages").find('option:selected');
			var val = target.val();
			var num = val.replace(/[^0-9]/g,"");
		    
		    	$( '.canvases' ).hide();
		    $( '#canvas'+num ).show();
		    
		});
	
	});
	
	var checkOptionNum = 1;
	var radioOptionNum = 1;
	
	// radio와 checkbox설문 옵션 추가/제거
	function addSubOption(){
		
		$(".addOption, .subOption").click(function(){
			
			var option = $(this).parent().find("input").eq(4).attr("type");
			
			if ($(this).attr("class") == "addOption ui-selectee") {
				
				if (option =="checkbox") {
					
					checkOptionNum++;
					
					var str = '';
					str += '<input type="checkbox" name="checkbox" id="checkbox'+checkOptionNum+'">'
						+'<label for="checkbox'+checkOptionNum+'">옵션'+checkOptionNum+'</label>'
						
						$(this).parent()
							.last()
							.append(str);
					
						editOption();
				}
				
				if (option =="radio") {
					
					radioOptionNum++;
					
					var str = '';
					str += '<input type="radio" name="radio" id="radio'+radioOptionNum+'">'
						+'<label for="radio'+radioOptionNum+'">옵션'+radioOptionNum+'</label>'
						
						$(this).parent()
							.last()
							.append(str);
					
					editOption();
					
				}
		
			}
			
			if ($(this).attr("class") == "subOption ui-selectee") {
				
				$(this).parent().children().last().remove();
				$(this).parent().children().last().remove();
				
			}
				
				
	
		});
	};
	
	// select 질문 선택지 추가
	function addSelectOption(){
		
		$("#addSelectOption").click(function(){
			
			alert('눌리긴 하는겐지?');
			
			var val = $("#selectOption").val();
			
			console.log(val);
			
			var str = '';
			str += '<option>'
				+ ''+val+''
				+ '</option>';
				
			$(this).parent()
				.find("select")
				.append(str);
			
			$("#selectOption").val('');
			$("#selectOption").empty();
			
		});
	};
	
	// select 질문 선택지 제거
	function subSelectOption(){
		
		$("#subSelectOption").click(function(){
			
			$(this).parent()
				.find('option:selected')
				.remove();

		});   
	}; 
	 
	// 질문지 선택되면 필수 응답 질문인지 설정 가능하도록 체크박스 띄우기
	function checkRequired(){
		
		$( ".questions" ).selectable({
            selected: function() {
            		$.each($(this), function(index, item){
            			
            			var str = '';
                   		str += '<input type="checkbox" name="checkRequired" id="checkRequired" '
                   			+ 'associated="'+$( this ).attr("id")+'">'
                   			+ $( this ).attr("id")+' 필수 응답항목 설정'
                   			
                          $( "#editSurvey" ).html(str);
                   		
                   		reqiredQuestion(); // 필수 응답 항목 체크 시 각 설문항목에 속성 추가
            		});
            		
            }
         });
		
	};
	
	// 필수 응답 체크박스에 체크될 경우 div에 required 속성 추가
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
	
	// 설문조사 저장 버튼 누름
	function saveSurvey(){
		
		$("#saveSurvey").click(function(){
			
			// 설문 대상, 기간, 제목 가져오기
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
			
			// 설문에 관련된 배열
			var survey = '{';
        	
			survey += ' surveyTargetAlumni : ' + surveyTargetAlumni
		        		+ ', surveyTargetClassroom: ' + surveyTargetClassroom
		        		+ ', surveyStartDate: ' + surveyStartDate
		        		+ ', surveyEndDate: ' + surveyEndDate
		        		+ ', surveyTitle: ' + surveyTitle
		        		+ ' , page : ';
			
			var surveyPage = '{';
			
			var surveyQuestion = '{';
			
			// 각 page의 id 배열에 저장
			$(this).parents("body")
				.find(".canvases").each(function(index, item){   
		         
		        	var pageId = $(this).attr("id");
		        
		        	survey += pageId + ', ';
		        surveyPage += ' page : ' + pageId
		        				+ ', questionId : ';
		       
		        	// 각 page의 설문 타입 확인 뒤 질문, 선택지 배열에 저장
		        	$(this).find(".questions")
		        		.each(function(index, item){
		        			
		        			// 각 질문의 id 배열에 저장
		        			var questionId = $(this).attr("id");
		        			surveyPage += questionId + ', ';
		        			surveyQuestion += ', questionId : ' + questionId
		        			
		        			var questionContent = $(this).find('legend').text();
		        			
		        			surveyQuestion += ', questionContent : ' + questionContent;
		        			
		        			var required = $(this).attr("required");
		        			
		        			// 각 질문이 필수 응답 항목인지 체크하여 배열에 저장
		        			if (required == "required") {
		        				
		        				surveyQuestion += ', required : required';
		        				
							};
		        			
						// 각 질문의 설문타입 가져오기
				        	var surveyType = $(this).attr("surveyType");
				        	
				        	surveyQuestion += ', surveyType : ' + surveyType
				        				+ ', surveyOption : ';
				        	
				        	// 설문타입이 라디오, 체크박스일 경우 옵션 선택지 가져오기
				        	if (surveyType == 'radiogroup' || surveyType == 'checkbox') {
				        		
				        		// 각 체크박스의 선택지 내용
				        		$(this).find('label')
				        			.each(function(index, item){
				        				surveyQuestion += $(this).text(); + ', '; 
				        			}) 
							};
				        	
				        	if (surveyType == 'dropdown') {
				        		
				        		// 각 셀렉트의 선택지 내용
				        		$(this).find('option')
				        			.each(function(index, item){
				        				surveyQuestion += $(this).val() + ', ';
				        			})
								
							}
		        		
		        	});
		         
		      });
        	
			surveyQuestion += '}';
			
			surveyPage += '}';
			
			survey += '}';
			
			console.log('survey: '+survey);
			console.log('page: '+surveyPage);
	        console.log('question: '+surveyQuestion);
	        

		});	
	};