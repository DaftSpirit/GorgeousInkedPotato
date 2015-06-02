$(document).ready(function(){
	
	$("#firepad-container").keydown(function(event){
		if (event.keyCode == 13 && event.shiftKey) {

			var x = codeMirror.getLine(codeMirror.getCursor().line);
			sendLine("cmd"+x);
			event.preventDefault();
		}
	});
	
	$("#firepad-container").keydown(function(event){
		if(event.keyCode == 13 && event.ctrlKey) {
			var y = codeMirror.getSelection(" ");
			sendLine("cmd" + y);
			event.preventDefault();
		}
	});
	
});