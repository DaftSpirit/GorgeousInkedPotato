$(document).ready(function(){

	$("#chatMessage").keydown(function(event){
		if(event.keyCode == 13){
			$("#sendMessage").click();
			//event.preventDefault();
		}
	});
	
});