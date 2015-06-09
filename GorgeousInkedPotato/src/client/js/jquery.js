$(document).ready(function(){
	
	$("#firepad-container").keydown(function(event){
		if (event.keyCode == 13 && event.shiftKey) {
			// Send the line
			var x = codeMirror.getLine(codeMirror.getCursor().line);
			sendLine("$"+(codeMirror.getCursor().line +1)+"$"+x);
			event.preventDefault();
		}
	});
	
	$("#firepad-container").keydown(function(event){
		if(event.keyCode == 13 && event.ctrlKey) {
			// Send the line
			var y = codeMirror.getSelection(" ");
			sendBloc("$"+(codeMirror.getCursor().line +1)+"$"+y);
			event.preventDefault();
		}
	});
});

