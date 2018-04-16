$( document ).ready(function(){   
	$('.pages').hide();
	$('.pages').eq(0).show();
	 
});

function prevPage(index){
	if (index-1 >= 0) {
		$('#page'+index ).hide();
		$('#page'+(index-1)).show();
	} 
} 

function nextPage(index){
	if (index+1 < $('.pages').length) {
		$('#page'+index ).hide();
		$('#page'+(index+1)).show();
	}
}

