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
		    var highlight = $(".CodeMirror-code pre").get(codeMirror.getCursor().line);
		    //console.log($(highlight).html()); //i.e.
		    var origincolor = $("pre").css("background-color");
		    $(highlight).css("background-color", "orange");
		    setTimeout(function(){
		    	$(highlight).css("background-color", origincolor);
		    }, 600);

			event.preventDefault();
		}
	});
	
	$("#firepad-container").keydown(function(event){
		if(event.keyCode == 13 && event.ctrlKey) {
			// Send the line
			var y = codeMirror.getSelection(" ");
			sendLine("cmd" + y);
			
			//Colorise the line
			var y = codeMirror.getSelection("$");
			//console.log(y);
		    var highlight = $(".CodeMirror-code pre").get(codeMirror.getSelection(" "));
		    //console.log($(highlight).html()); //i.e.
		    var origincolor = $("pre").css("background-color");
		    $(highlight).css("background-color", "orange");
		    setTimeout(function(){
		    	$(highlight).css("background-color", origincolor);
		    }, 600);
			
			event.preventDefault();
		}
	});
	
	
	
	$("#firepad-container").click(function(event){
		codeMirror.on("keydown",function(){
			alert("trololo");
		});
		//alert("j'ai cliqué madafaka");
		var start = $(".CodeMirror-code pre").get(codeMirror.getCursor().line);
		//console.log(start);
		$("#firepad-container").mouseup(function() {
			  //alert( "Handler for .mouseup() called." );
		});

	});
});

