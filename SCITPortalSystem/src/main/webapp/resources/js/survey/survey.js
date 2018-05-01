$( document ).ready(function(){
	
	deleteSurvey();
});  

// 학생이 아직 시작하지 않았거나 참여 기간이 만료 된 설문을 누를경우
function toRespond(today, start, end, surveyNum){
	
	var curDate = Date.parse(today);
	var startDate = Date.parse(start);
	var endDate = Date.parse(end);
	
	if (curDate < startDate) {
		alert('아직 참여할 수 없습니다.');
	} else if (curDate > endDate) {
		alert('기간이 만료된 설문입니다.');
	} else {
		
		$(location).attr('href', 'surveyDetail?surveyNum='+surveyNum);
		
	}
	
};

function deleteSurvey(){
	
	$('.deleteSurvey').dblclick(function(){
		
		$(this).each(function(index, item){
			
			console.log($(this));
			var surveyNum = $(this).text();
			console.log(surveyNum);
			
			
			var str = '';
			str += '<input type="button" value="삭제" onclick="javascript:completeDeleteSurvey('+surveyNum+')">';
			
			$(this).html(str);
			
		});
		
	});
	
};


function completeDeleteSurvey(surveyNum){

	$(location).attr('href', 'deleteSurvey?surveyNum='+surveyNum);
	
};