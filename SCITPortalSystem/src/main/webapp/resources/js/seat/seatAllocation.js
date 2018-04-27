/**
 * 문희규 : seatAllocation.jsp용 (학생 배치)
 */
var temp ; //임시 활용을 위한 변수
var indexNum = 0;
var studentNumOfStudentList = []; // 초기화할 학생 번호
var cellMove = 0; //미배정 목록에 있는 학생수 

$(function(){
	
	cellMove = $('.cell').length; // 미배정 목록에 있는 학생수를 넣기
	$('#appear').hide();//기본적으로 appear Div는 가려준다.
	
	//미배정 학생DIV을 Drag가능하게 만든다.
	$('.studentList').draggable();
	
	
	//미배정 학생들을 Drag가능하게 만든다.
		$('.cell').draggable({ 
				cancel: "a.ui-icon"
				, appendTo: 'body .studentListScroll'
				,  revert: 'invalid'
				, zIndex: 20
				, containment: $('.showClassroomInfo')
				, helper: 'clone'	
				});

	//좌석에 Drop이 가능하게 만든다.
		$('.seatNum').droppable({
			accept: '.cell',
		      drop: function( event, ui ) {
		    	  if($(this).find('.cell').length==0){ //좌석에 이미 배정받은 사람이 있으면 갱신하지 않는다
		    		  $(this).html(ui.draggable);
		    		  var seat = jQuery(this).attr('seatid');
		    		  ui.draggable.find('.seat').val(seat); // 좌석 .seat의 좌석값을 입력하기
		    		  ui.draggable.find('.seat').attr('name','sendSeatStudentList['+indexNum+'].seat'); //좌석 이름 속성 변경하기 
		    		  ui.draggable.find('.memberstudentNum').attr('name','sendSeatStudentList['+indexNum+'].memberstudentNum'); //학생 번호 이름 속성 변경하기 
		    		  ui.draggable.find('.classroom').attr('name','sendSeatStudentList['+indexNum+'].classroom'); //학생 반 이름 속성 변경하기 
		    		  ui.draggable.find('.id').attr('name','sendSeatStudentList['+indexNum+'].id'); //아이디 이름 속성 변경하기
		    			  
		    		  indexNum++; //드랍되면 인덱스 값을 올린다.
		    	  }
		      }
		});
		
	//미배정 학생 목록에도 Drop이 가능하게 만든다.
	$('.studentListScroll').droppable({
		accept: '.cell',
	      drop: function( event, ui ) { 
	        $(this).append(ui.draggable);
	        var studentNumber = ui.draggable.find('.memberstudentNum').val();
	        studentNumOfStudentList.push(studentNumber);
	        ui.draggable.find('.seat').val(0); // 좌석 .seat의 좌석값을 입력하기
	        ui.draggable.find('.seat').attr('name','seat'); //좌석 이름 속성 변경하기
	        ui.draggable.find('.memberstudentNum').val(); // 좌석을 초기화할 학생의 번호를 찾는다.
	        ui.draggable.find('.memberstudentNum').attr('name','memberstudentNum'); //학생 번호 이름 속성 변경하기 
	        ui.draggable.find('.classroom').attr('name','classroom'); //학생 반 이름 속성 변경하기 
	        ui.draggable.find('.id').attr('name','id'); //아이디 이름 속성 변경하기
  		  	if(indexNum > 1) indexNum--; //드랍되면 인덱스 값 감소  		  	
  	
	      }
	});	
		 
	
	//자동으로 학생배치를 하는 기능이다
	$('#autoAllocation').on('click',function(){
//		$('#cell'+1).appendTo('#seat'+30);
		var cellCount = $('.cell').length; //미배정 목록에 있는 학생의 수 
		var cellIndex = 1;
		var evaluationCount = $('#evaluationCount').val();
		
		//역량평가나 설문조사를 시행한 적이 없을때
		if(evaluationCount == 0 /*TODO: && 반배치 설문조사 시행 횟수 == 0 */){
			for(var indicateSeat = 1 ; indicateSeat <= 40 ; indicateSeat++){ //전체 좌석의 수만큼 루프 돌기/ 이유: seat1, seat3 등 빠진 좌석들을 선택하기 위해서.
				
				var skipMemberCount = 0 ; //해당 회원이 짝이 되는 조건에 맞지 않으면 카운트
				var skipSeatCount = 0; //해당하는 좌석이 존재하지 않는 경우 카운트
				var previousITMajor = 0 ; //전의 배치 받은 학생의 IT전공의 유무
				var previousJPMajor = 0 ;  //전의 배치 받은 학생의 JP전공의 유무
				var previousJPCertificate = 0 ;  //전의 배치 학생의 JP자격증의 유무
				var thisITMajor = 0 ; //현재 좌석 배치를 받으려는 사람의 IT전공의 유무
				var thisJPMajor = 0 ; //현재 좌석 배치를 받으려는 사람의 JP전공의 유무
				var thisJPCertificate = 0 ; //현재 좌석 배치를 받으려는 사람의 JP자격증의 유무
				
				var seatExistence = $('#seat'+indicateSeat).length; //좌석의 존재확인
				if(seatExistence != 0 ){//좌석이 존재하는 경우
					if(indicateSeat == 1){//첫번째 좌석에는 아무학생이나 배치시킨다
							$('#cell'+cellIndex).appendTo('#seat'+indicateSeat);
							cellIndex++;
					} else if (indicateSeat > 1){
							var seatFound = 0;
							while(seatFound == 1){ //좌석이 있을때까지 찾아보기
								var seatIndex = indicateSeat-1;
								if($('#seat'+seatIndex).children('.cell').length != 0){ //배치받은 사람이 있다면 아래를 실행
									previousITMajor = $('#seat'+seatIndex).children('.cell').find('.itMajor').val();
									previousJPMajor = $('#seat'+seatIndex).children('.cell').find('.jpMajor').val();
									previousJPCertificate = $('#seat'+seatIndex).children('.cell').find('.jpCertificate').val();
									seatFound = 1;
								}
								seatIndex--; //그 전의 좌석을 조사해본다.
							}
							thisITMajor = $('#cell'+cellIndex).find('.itMajor').val();
							thisJPMajor = $('#cell'+cellIndex).find('.jpMajor').val();
							thisJPCertificate = $('#cell'+cellIndex).find('.jpCertificate').val();
							
							if(previousITMajor != thisITMajor || previousJPMajor != thisJPMajor || previousJPCertificate != thisJPCertificate){
								$('#cell'+cellIndex).appendTo('#seat'+indicateSeat); 
							} else {
								//조건에 안맞는 학생은 맨 뒤의 순서로 미룬다.
								$('#cell'+cellIndex).attr('id', 'cell'+cellMove+1);
								cellMove++;
							}
						cellIndex++;					
					}
				}	
			}
		} else {
			//TODO : 설문조사 및 역량평가 1회인 이상 경우 알고리즘 구성
			
			
			
		}
		
	});
	

});


/*
 * 좌석을 클릭하면 해당 좌석의 
 */
function selectedDiv(seatCount){
	
}


/*
 * 현재 조회 중인 반 배치도를 수.정.한.다.
 */
//function fixSeatPlacement(){
//	var seatPlacementNum = $('#seatPlacementNum').val();
//	location.href='seatModify?seatPlacementNum='+seatPlacementNum;
//}


/*
 * '저장하기' 버튼 누루면, 좌석 배치도와 반 이름 저장하기.
 */
function saveSeatConfig(){
	var seatPlanForm = document.getElementById('seatPlan');
	var dispatchedSeatPlacement = $('.seatInfo').html(); //새 자리의 폼 
	$('#dispatchedSeatPlacement').val(dispatchedSeatPlacement);//갱신된 반 배치를 저장
	$('#studentNumOfStudentList').val(studentNumOfStudentList);//미배정 목록으로 옴겨진 학생들의 학번호
	studentNumOfStudentList = [];
	seatPlanForm.submit();
}	
	
	
	// 드래그 해서 끌어온 객체가 책상위에 자리할때
	// 그 객체를 컨트롤러로 보내 전역으로 만들어진 Arraylist에 삽입
	// 저장하기 버튼을 누르면 현재까지 저장된 Arraylist 데이터베이스 전송









