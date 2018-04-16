/**
 * 문희규 : seat.jsp에 대한 JS
 */

$(function(){
	
	/*
	 * 각 반 배치도를  하나씩 조회 가능하게 해주는 기능
	 */
	var seatPlacementSize = $('#seatPlacementSize').val();
	for(var i = 0 ; i < seatPlacementSize ; i++){
		if(i>0){ // 첫 반 배치도를 제외한 나머지는 모두 hide 처리한다. 
		$('#showClassroom'+i)
			.attr('hide', 1)	
			.hide();
		}
	}
	
});

function previousClassroom(index){
	var currentDiv = index //현재 조회중인 반의 좌석 배치
	var seatPlacementSize = $('#seatPlacementSize').val(); //좌석 배치도의 갯수
	
	if(currentDiv == 0){
		$('#showClassroom'+currentDiv)
			.attr('hide',1)
			.hide('slow');
		currentDiv = seatPlacementSize-1;
		$('#showClassroom'+currentDiv)
			.attr('hide',0)
			.show('slow');
	} else if(currentDiv >= 1) {
		$('#showClassroom'+currentDiv)
		.attr('hide',1)
		.hide('slow');
		currentDiv--; //현재 조회 중인 반 배치 전에 있는 반을 조회한다.
	$('#showClassroom'+currentDiv)
		.attr('hide',0)
		.show('slow');
	}
}

function nextClassroom(index){
	var currentDiv = index //현재 조회중인 반의 좌석 배치
	var seatPlacementSize = $('#seatPlacementSize').val(); //좌석 배치도의 갯수
	
	if(currentDiv < seatPlacementSize-1 ) {
		$('#showClassroom'+currentDiv)
		.attr('hide',1)
		.hide('slow');
		currentDiv++; //현재 조회 중인 반 배치 다음에 있는 반을 조회한다.
	$('#showClassroom'+currentDiv)
		.attr('hide',0)
		.show('slow');
	} else if(currentDiv == seatPlacementSize-1){
		$('#showClassroom'+currentDiv)
			.attr('hide',1)
			.hide('slow');
		currentDiv = 0;
		$('#showClassroom'+currentDiv)
			.attr('hide',0)
			.show('slow');
	}
}

/*
 * 현재 조회 중인 반 배치도를 삭.제.한.다.
 */
function deleteSeatPlacement(seatPlacementNum){
	var deleteDecision = confirm('정말로 이 반 배치도를 지우시겠습니까?');
	if(deleteDecision){
		location.href="seatDelete?seatPlacementNum="+seatPlacementNum;
	} else {
		//취소 시 아무코토 안한다.
	} 
}

/*
 * 현재 조회 중인 반 배치도를 수.정.한.다.
 */
function fixSeatPlacement(seatPlacementNum){
	location.href="seatModify?seatPlacementNum="+seatPlacementNum;

}

/*
 * 현재 조회 중인 반에 학생들을 배.치.한.다
 */
function allocateSeatPlacement(seatPlacementNum){
	location.href="seatAllocation?seatPlacementNum="+seatPlacementNum;
}



/*
 * 좌석을 클릭하면 .
 */
function selectedDiv(seatCount){

//	if($('#seat'+seatCount).attr('hide') == 0 ){ //클릭했을떄
//		$('#seat'+seatCount)
//			.attr('hide',1)
//			.css('opacity', '0.3')
//			.html('<br><br><br><input type="button" value="삭제" onclick="deleteSeat('+seatCount+')">');
//	} 
}

/*
 * '삭제'버튼을 누루면  물리적으로 좌석을 삭제해주는 기능이다.
 */
function buttonShow(seatCount){
//	$('#seat'+seatCount).remove();
}