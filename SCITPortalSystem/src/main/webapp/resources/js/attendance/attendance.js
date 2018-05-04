/**
 * 
 */

$(document).ready(function() {

	$('.comFirmBTN').click(function(){

		var registrationNum = $(this).attr('i');		

		

		$.ajax({

			url: 'AttendanceCheck',

			type: 'get',

			data:{

				registrationNum:registrationNum

			},

			success: function(){

				alert('성공');

				for(var i=0;i<$('.comFirmBTN').length;i++ ){					

					

					if($($('.comFirmBTN')[i]).attr('i') == registrationNum){

						console.log($($('.comFirmBTN')[i]).attr('i'));

						

						$('.comFirmBTN')[i].outerHTML='<b>complete</b>';	

					}

					

				}

				

			},

			error: function(){

				alert('실패');

			}

		

		})

	})	

	

})