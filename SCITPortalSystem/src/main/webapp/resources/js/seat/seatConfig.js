/**
 * 문희규 : 
 */

$(function(){
	
	/*
	 * '좌석 추가'를 누루면 좌석 칸을 추가하는 기능이다. 
	 */
	var seatCount = 1; //좌석 고유 번호를 부여하기 위한 변수
	var corridor = '<div class="corridor"> </div>'; // 복도를 표시하는 공백용 div
	var nextLine = '<br><br><br>'; // 좌석의 줄을 나누는 변수
	
	
		$('#seatAdd').on('click', function(){
			if(seatCount == 41){ //최대 생성 가능 좌석 수를 초과하면 경고메세지 출력
				alert('최대 좌석 수는 40석 입니다.');
			}
			//좌석을 최대수로 생성해주는 기능이다.
			for (seatCount; seatCount <= 40 ; seatCount++){
				var seatAdd = '<div id="seat'+seatCount+'" name="seat" class="seat" seatid="seatNum'+seatCount+'" hide="0" onclick="deleteShow('+seatCount+')"></div>';
				$('#seatPlacement').append(seatAdd);
				if(seatCount%8 == 3 ||seatCount%8 == 5 ){ 
					$('#seatPlacement').append(corridor);
				} else if(seatCount%8 == 0){
					$('#seatPlacement').append(nextLine);
				} 
			}
		});
});

/*
 * 좌석을 클릭하면 해당 좌석의 삭제 여부를 담당하는 기능이다.
 */
function deleteShow(seatCount){
	//좌석을 클릭하면 삭제 버튼을 보여준다.
	//삭제 버튼을 선택하면 좌석이 지워지고, div구역을 클릭하면 삭제버튼이 사라진다.
	if($('#seat'+seatCount).attr('hide') == 0 ){ //클릭했을떄
		$('#seat'+seatCount)
			.attr('hide',1)
			.css('opacity', '0.3')
			.html('<br><br><br><input type="button" value="삭제" onclick="deleteSeat('+seatCount+')">');
	} else if($('#seat'+seatCount).attr('hide') == 1 ){ //다시 클릭했을때
		$('#seat'+seatCount)
		.attr('hide',0)
		.css('opacity','1')
		.html('');
	}
}

function deleteSeat(seatCount){
	$('#seat'+seatCount).remove();
}
