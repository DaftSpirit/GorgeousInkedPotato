 
var webSocket = new WebSocket("ws://localhost:8887");
var returnServer = document.getElementById("returnServer");
var chatMessage = document.getElementById("chatMessage");

webSocket.onopen = function(message) { processOpen(message);};
webSocket.onmessage = function(message) { processMessage(message);};
webSocket.onclose = function(message) { processClose(message);};
webSocket.onerror = function(message) { processError(message);};

function processOpen(message){
	returnServer.innerHTML += "Server Connect!"+"\n";
	webSocket.send("chat"+ firepadUserList.displayName_ + " has connected !");
}

function processMessage(message) {
	if (message.data.startsWith("chat"))
	{
		chat.value += message.data.replace("chat","") + "\n";
	}
	else if (message.data.startsWith("line"))
	{
		line = message.data.replace("line","");
		highlight(line-1);
	}
	else if (message.data.startsWith("bloc"))
	{
		var res = message.data.split("$");
		line = res[0].replace("bloc","");
		for (i = 0; i < parseInt(res[1])+1; i++) { 
			highlight(parseInt(line)-1-i);
			console.log(res[1]);
		}
		
	}
	else
	{
		returnServer.innerHTML += message.data + "\n";
	}
}

function sendMessage(){
	webSocket.send("chat"+ firepadUserList.displayName_ + ": " + chatMessage.value);
	chatMessage.value="";
}

function sendLine(string) {
	webSocket.send("cmd"+ firepadUserList.displayName_ + string);
}

function sendBloc(string) {
	webSocket.send("bloc"+ firepadUserList.displayName_ + string);
}

function processClose(message) {
	webSocket.send("chat"+ firepadUserList.displayName_ + " has disconnected !"); // close avant le send ? meh o/
	returnServer.value += "Server Disconnect!"+"\n";
}

function processError(message) {
	returnServer.value += "error ...\n";
}

function highlight(line){
	 var highlight = $(".CodeMirror-code pre").get(line);
	 var origincolor = $("pre").css("background-color");
	 $(highlight).css("background-color", "orange");
	 setTimeout(function(){
	 	$(highlight).css("background-color", origincolor);
	 }, 600);
}

