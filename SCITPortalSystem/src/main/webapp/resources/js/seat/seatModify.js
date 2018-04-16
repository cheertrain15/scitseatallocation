/**
 * 문희규 : 
 */

var numberOfSeats = 0; //현재 존재하는 좌석의 수 

$(function(){
	
	/*
	 * 로딩된 반 배치도의 좌석 갯수 불러오기
	 */
	numberOfSeats =  $('.numberOfSeat').html();
	
	
	/*
	 * '초기화'를 누루면 기본 좌석 배치로 초기화된다. 
	 */
		$('#seatNew').on('click', function(){
			$('.seatInfo').html('');//
			var seatCount = 1; //좌석 고유 번호를 부여하기 위한 변수
			var corridor = '<div class="corridor"> </div>'; // 복도를 표시하는 공백용 div
			var nextLine = '<br><br><br>'; // 좌석의 줄을 나누는 변수
			
			if(seatCount == 41){ //최대 생성 가능 좌석 수를 초과하면 경고메세지 출력
				alert('최대 좌석 수는 40석 입니다.');
			}
			$('.seatInfo').append('<div><p class="classroomFront">교탁</p></div><br>');
			//좌석을 최대수로 생성해주는 기능이다.
			for (seatCount; seatCount <= 40 ; seatCount++){
				var seatAdd = '<div id="seat'+seatCount+'" name="seat" class="seat" seatid="seatNum'+seatCount+'" hide="0" onclick="selectedDiv('+seatCount+')"></div>';
				$('.seatInfo').append(seatAdd);
				if(seatCount%8 == 3 ||seatCount%8 == 5 ){ 
					$('.seatInfo').append(corridor);
				} else if(seatCount%8 == 0){
					$('.seatInfo').append(nextLine);
				}
				numberOfSeats = seatCount;
				$('.numberOfSeat').html(numberOfSeats);
			}
			
		});
});

/*
 * 좌석을 클릭하면 해당 좌석의 삭제 여부를 담당하는 기능이다.
 */
function selectedDiv(seatCount){
	//좌석을 클릭하면 삭제 버튼을 보여준다.
	//삭제 버튼을 선택하면 좌석이 지워지고, div구역을 클릭하면 삭제버튼이 사라진다.
	if($('#seat'+seatCount).attr('hide') == 0 ){ //클릭했을떄
		$('#seat'+seatCount)
			.attr('hide',1)
			.css('opacity', '0.3')
					//좌석 삭제 버튼 구현
			.html('<br><br><input type="button" value="좌석 삭제" onclick="buttonShow('+seatCount+')">'
					//좌석 추가 버튼 구현
					+'<br><br><input type="button" value="좌석 추가" onclick="addSeat('+seatCount+')">');
	} else if($('#seat'+seatCount).attr('hide') == 1 ){ //다시 클릭했을때
		$('#seat'+seatCount)
		.attr('hide',0)
		.css('opacity','1')
		.html('');
	}
}

/*
 * '좌석 추가'버튼을 누루면  물리적으로 좌석을 삭제해주는 기능이다.
 */
function buttonShow(seatCount){
	$('#seat'+seatCount).remove();
	numberOfSeats--;
	$('.numberOfSeat').html(numberOfSeats);
}


/*
 * '좌석 추가'버튼을 누루면  물리적으로 좌석을 추가해주는 기능이다.
 */
function addSeat(seatCount){
	//선택한 좌석의 양 옆에 좌석이 생성되어져 있는지 확인한다.
	if($('#seat'+(seatCount-1)).length == 0){ //선택한 좌석의 왼쪽이 비어져있으면 좌석을 추가한다
		seatCount--;
		var seatAdd = '<div id="seat'+seatCount+'" name="seat" class="seat" seatid="seatNum'+seatCount+'" hide="0" onclick="selectedDiv('+seatCount+')"></div>';
		$('#seat'+(seatCount+1)).before(seatAdd);
		numberOfSeats++;
		$('.numberOfSeat').html(numberOfSeats);
	} else if($('#seat'+(seatCount+1)).length == 0){ //선택한 좌석의 오른쪽이 비어져있으면 좌석을 추가한다
		seatCount++;
		var seatAdd = '<div id="seat'+seatCount+'" name="seat" class="seat" seatid="seatNum'+seatCount+'" hide="0" onclick="selectedDiv('+seatCount+')"></div>';
		$('#seat'+(seatCount-1)).after(seatAdd);
		numberOfSeats++;
		$('.numberOfSeat').html(numberOfSeats);
	}

}



/*
 * '뒤로가기' 버튼 클릭시 전 페이지로 돌아간다.
 */
function back(){
	location.href='seatpage';
}


/*
 * '다시하기' 버튼을 누루면 현재 페이지를 초기화 해준다.
 */
function restart(){
	location.reload();
}


/*
 * '저장하기' 버튼 누루면, 좌석 배치도와 반 이름 저장하기.
 */
function saveSeatConfig(){
	
	for(var i = 1; i <= 40 ; i++){ //반투명 처리 및 삭제 버튼이 표시된 DIV를 원상 복구 시킨다.
		if($('#seat'+i).attr('hide') == 1){
			$('#seat'+i)
			.attr('hide',0)
			.css('opacity','1')
			.html('');
		}		
	}
	
	var seatPlacement = $('.seatInfo').html(); //좌석 배치를 String으로 변환함.
	$('#seatContent').val(seatPlacement);//변환한 정보를 hidden DOM안에 넣는다.
	
	var seatCount = $('.numberOfSeat').html();
	$('#seatCount').val(numberOfSeats);
	
	var seatPlacementForm = document.getElementById('seatPlan'); //좌석 배치를 전송할 form이다.
	seatPlacementForm.submit();
}


