$(document).ready(function(){
	
	function highlightFor(tag,color,seconds){
	    var element = document.getElementsByTagName(tag)
	    var origcolor = element.style.backgroundColor
	    alert(origcolor.value);
	    element.style.backgroundColor = color;
	    var t = setTimeout(function(){
	       element.style.backgroundColor = origcolor;
	    },(seconds*1000));
	}
	
	
	
	$("#firepad-container").keydown(function(event){
		if (event.keyCode == 13 && event.shiftKey) {
			// Send the line
			var x = codeMirror.getLine(codeMirror.getCursor().line);
			sendLine("cmd"+x);
			
			// Colorise the line
		    var hightlight = $("pre").get(codeMirror.getCursor().line+1);
		    var origincolor = $("pre").css("background-color");
		    $(hightlight).css("background-color", "orange");
		    setTimeout(function(){
		    	$(hightlight).css("background-color", origincolor);
		    }, 600);

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

