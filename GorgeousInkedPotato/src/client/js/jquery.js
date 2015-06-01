$(document).ready(function(){
	
	$("#firepad-container").keydown(function(event){
		if (event.keyCode == 13 && event.shiftKey) {

			var x = codeMirror.getLine(codeMirror.getCursor().line);
			sendLine(x);
			event.preventDefault();
		} else if(event.keyCode == 13){
			$("#sendButton").click();
			event.preventDefault();
		}
	});
	
	$("#chatMessage").keydown(function(event){
		if(event.keyCode == 13){
			$("#sendMessage").click();
			event.preventDefault();
		}
	});
	
});