/**
 * 문희규 : seatAllocation.jsp용 (학생 배치)
 */
$(function(){
//	$('.studentList').draggable().css('z-index', 1);
	$('#appear').hide();//기본적으로 appear Div는 가려준다.
	
	//미배정 학생들을 Drag가능하게 만든다.
	$('.cell').draggable({ 
		appendTo: 'body'
		, zIndex: 1
		, containment: $('.showClassroomInfo')
		, helper: 'clone'
		});
		
	//좌석에 Drop이 가능하게 만든다.
	$('.seat').droppable({
	      drop: function( event, ui ) {
	          $( this )
	            .find( '.cell' );
	            $('.seat').html($('.cell').html());
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
function fixSeatPlacement(){
	var seatPlacementNum = $('#seatPlacementNum').val();
	location.href='seatModify?seatPlacementNum='+seatPlacementNum;
}


/*
 * '저장하기' 버튼 누루면, 좌석 배치도와 반 이름 저장하기.
 */
function saveSeatConfig(){
	var seatPlacementForm = document.getElementById('seatPlan'); //좌석 배치를 전송할 form이다.
	//seatPlacementForm.submit();
}

/*
 * 학생목록 창을 최소화하는 기능
 */
function minimize(){
	$('#minimize').hide();
	$('#appear').show();
	$('.cell').hide();
	$('.studentList')
		.css('height', '100px')
		.css('opacity', '0.3');
}


/*
 * 학생목록 창을 최대화하는 기능
 */
function appear(){
	$('#appear').hide();
	$('#minimize').show();
	$('.cell').show();
	$('.studentList')
		.css('height', '600px')
		.css('opacity', '1');
}










