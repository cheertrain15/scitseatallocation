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
		$('#showClassroom'+i).hide();
		}
	}
	
});

function previousClassroom(){
	
}

function nextClassroom(){
	
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