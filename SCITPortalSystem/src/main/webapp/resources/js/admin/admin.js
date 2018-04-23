/**
 * 
 */


/*
$(document).on('click','#approval',function(){	
	alert('클릭');
	
	$.ajax({
		type: "get",
		url: "approvalComplete",
		success : function (data) {
			alert('성공');
		},
		error : function() {
			alert('실패');
			return false;
		}		
		
	});
	
	
});
*/


$(document).ready(function() {
	$('.btn_click').click(function(){
		var id = $(this).attr('i');			
		
		$.ajax({
			url: 'approvalComplete',
			type: 'get',
			data:{
				id:id
			},
			success: function(){
				alert('성공');
				for(var i=0;i<$('.btn_click').length;i++ ){
					
					
					if($($('.btn_click')[i]).attr('i') == id){
						console.log($($('.btn_click')[i]).attr('i'));
						
						$('.btn_click')[i].outerHTML='<b>complete</b>';	
					}
					
				}
				
			},
			error: function(){
				alert('실패');
			}
		
		})
	})
	
	
	
})


