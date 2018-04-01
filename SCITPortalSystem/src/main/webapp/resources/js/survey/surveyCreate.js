/**
 * 
 */

// drag

$( function() {
	
	$( "#surveyList" ).sortable({
	      revert: true
	    });
	
    $( "#text, #radiogroup, #checkbox").draggable(
    
    		{ scroll: true },
    		{ cursor: "move" },
    		{ 
    			connectToSortable: "#surveyList",
    		    helper: "clone",
    		    revert: "invalid"}
    		
    );

    $( "ul, li" ).disableSelection();
    
	var question = 1;
	var str = "";
    
    $( ".surveyCanvas" ).droppable({
        drop: function( event, ui ) {
        	
        	str += "<div class='questions' id='question" + question + "'>"
        		+ "질문" + question + "."
        		+ "<input type=text placeholder='질문내용을 입력하세요'>"
        		+"</div>";
        		
          $( this )
            .find( "p" )
              .html( "드랍되었음당" )
              
          $(event.target).html(str);
          
          question++;
        }
      });
   
} );