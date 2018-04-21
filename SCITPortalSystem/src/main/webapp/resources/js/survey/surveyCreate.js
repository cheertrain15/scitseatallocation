$( document ).ready(function(){
	initialize();
	saveSurvey();
});  
  
// 설문 시작일과 마감일 설정
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
var checkbox = 1;
var radio = 1;

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
	        	    +'<input type="radio" name="radio'+radio+'" id="radio1">'
	        	    +'<label for="radio1" class="radio">옵션1</label>'
	        	    +'</fieldset>'
	        	    +'</div>';
        		
        		radio++;
				
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
	        	    +'<input type="checkbox" name="checkbox'+checkbox+'"  id="checkbox1">'
	        	    +'<label for="checkbox1">옵션1</label>'
	        	    +'</fieldset>'
	        	    +'</div>';
        		
        		checkbox++;
				
			}
        	
       if (draggableId == 'dropdown') {
	    	    str +='<div class="questions" id="question' + question + '" surveyType="dropdown">'
	    	   		+'<fieldset>'
	    	   		+'<legend>질문' + question + '. 내용 수정하쇼'
	    	   		+'<input type="button" value="수정" onclick="javascript:editQuestion('+question+')">'
	    			+'<input type="button" value="삭제" onclick="javascript:deleteSurvey('+question+')">'
	    			+'</legend>'
	    			+'<select v-model="select" name="select" id="select">'
	    			+'<option disabled value="" selected="selected">선택지</option>'
		    	    +'</select>'
		    	    +'<input type="button" value="해당 선택지 삭제" id="subSelectOption'+question+'">'
		    	    +'<br>'
		    	    +'<input type="text" id="selectOption'+question+'" placeholder="추가할 선택지 내용을 입력하세요" size="30">'
		    	    +'<input type="button" value="추가" id="addSelectOption'+question+'">'
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
         
        
        addSubOption(); // 라디오, 체크박스 설문지에 대한 선택지 추가/제거
        addSelectOption(question); // 셀렉트 설문지에 대한 선택지 추가
        subSelectOption(question); // 셀렉트 설문지에 대한 선택지 제거
        checkRequired(); // 각 설문항목 클릭시 필수 응답 항목 여부 체크 가능
        editOption();
        
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
					var name = $(this).parent().find('input[type=checkbox]').attr("name");
					console.log(name);
					
					var str = '';
					str += '<input type="checkbox" '
						+ 'name="'+name+'" id="checkbox'+checkOptionNum+'">'
						+'<label for="checkbox'+checkOptionNum+'">옵션'+checkOptionNum+'</label>'
						
						$(this).parent()
							.last()
							.append(str);
					
						editOption();
				}
				
				if (option =="radio") {
					
					radioOptionNum++;
					var name = $(this).parent().find('input[type=radio]').attr("name");
					console.log(name);
					
					var str = '';
					str += '<input type="radio" '
						+ 'name="'+name+'" id="radio'+radioOptionNum+'">'
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
	function addSelectOption(question){
		console.log('addselectoptioin called~~~~, ' + question);
		$("#addSelectOption"+question).click(function(){
			console.log("addselectoption button clicked");
			var val = $("#selectOption"+question).val();			
			console.log(val);			
			var str = '';
			str += '<option>'
				+ ''+val+''
				+ '</option>';
				
			$(this).parent()
				.find("select")
				.append(str);
			
			$(this).parent().find("option:disabled").remove();
			
			$("#selectOption" + question).val('');
			
		});
	};
	
	// select 질문 선택지 제거
	function subSelectOption(question){		
		$("#subSelectOption"+question).click(function(){
			
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
                   			+ ' 필수 응답항목 설정';                   			
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
			
			// 해당 설문조사 배열
			var surveyArray = new Array();
			var pageArray =  new Array();
			
			var surveyInfo = new Object();
			
			// 설문 분류, 대상, 기간, 제목 가져오기
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
			
			surveyInfo.surveyCategory = surveyCategory;
			surveyInfo.surveyTargetAlumni = surveyTargetAlumni;
			surveyInfo.surveyTargetClassroom = surveyTargetClassroom;
			surveyInfo.surveyStartDate = surveyStartDate;
			surveyInfo.surveyEndDate = surveyEndDate;
			surveyInfo.surveyTitle = surveyTitle;
			
			var surveyPage = new Array();
			
			// 각 페이지 아이디
			$(this).parents("body")
				.find(".canvases")
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
							pageInfo.surveyQuestionContent = questionContent;
							
							// 각 설문항목의 필수응답여부
							var required = $(this).attr("required");
							
							if (required == 'required') {
								pageInfo.surveyQuestionRequired = 1;
							} else {
								pageInfo.surveyQuestionRequired = 0;
							}
							 
							// 각 설문항목의 타입
							var surveyType = $(this).attr("surveyType");
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
				
				url : 'createNewSurvey',
				type : 'post',
				contentType : 'application/json;charset=utf-8',
				data : JSON.stringify(createSurvey),
				success : function(data) {
					alert(data);
//					$(location).attr('href', 'survey');
				},
				error : function(err) {
					console.log(err);
				}
				
			})
			
		});
	}; 