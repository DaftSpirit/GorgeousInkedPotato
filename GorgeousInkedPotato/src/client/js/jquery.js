$(document).ready(function(){
	
	$("#firepad-container").keydown(function(event){
		if (event.keyCode == 13 && event.shiftKey) {

			var x = codeMirror.getLine(codeMirror.getCursor().line);
			sendLine("cmd"+x);
			codeMirror.colorize();
			highlightFor('test','red', 1);
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

function highlightFor(id,color,seconds){
    var element = document.getElementById(id)
    var origcolor = element.style.backgroundColor
    element.style.backgroundColor = color;
    var t = setTimeout(function(){
       element.style.backgroundColor = origcolor;
    },(seconds*1000));
}

//CodeMirror, copyright (c) by Marijn Haverbeke and others
//Distributed under an MIT license: http://codemirror.net/LICENSE

(function(mod) {
if (typeof exports == "object" && typeof module == "object") // CommonJS
 mod(require("../../lib/codemirror"), require("./runmode"));
else if (typeof define == "function" && define.amd) // AMD
 define(["../../lib/codemirror", "./runmode"], mod);
else // Plain browser env
 mod(CodeMirror);
})(function(CodeMirror) {
"use strict";

var isBlock = /^(p|li|div|h\\d|pre|blockquote|td)$/;

function textContent(node, out) {
 if (node.nodeType == 3) return out.push(node.nodeValue);
 for (var ch = node.firstChild; ch; ch = ch.nextSibling) {
   textContent(ch, out);
   if (isBlock.test(node.nodeType)) out.push("\n");
 }
}

codeMirror.colorize = function(collection, defaultMode) {
 if (!collection) collection = document.body.getElementsByTagName("span");

 for (var i = 0; i < collection.length; ++i) {
   var node = collection[i];
   //alert(i);
   var mode = node.getAttribute("data-lang") || defaultMode;
   if (!mode) continue;

   var text = [];
   textContent(node, text);
   node.innerHTML = "";
   CodeMirror.runMode(text.join(""), mode, node);

   node.className += " cm-s-default";
 }
};
});