 
var webSocket = new WebSocket("ws://localhost:8887");
var returnServer = document.getElementById("returnServer");
var chatMessage = document.getElementById("chatMessage");

webSocket.onopen = function(message) { processOpen(message);};
webSocket.onmessage = function(message) { processMessage(message);};
webSocket.onclose = function(message) { processClose(message);};
webSocket.onerror = function(message) { processError(message);};

function processOpen(message){
	returnServer.value += "Server Connect!"+"\n";
	webSocket.send("chat"+ firepadUserList.displayName_ + " has connected !");
}

function processMessage(message) {
	if (message.data.startsWith("chat"))
	{
		chat.value += message.data.replace("chat","") + "\n";
	}
	else
	{
		returnServer.value += message.data + "\n";
	}
}

function sendMessage(){
	webSocket.send("chat"+ firepadUserList.displayName_ + ": " + chatMessage.value);
	chatMessage.value="";
}

function sendLine(string) {
	webSocket.send(string);
}

function processClose(message) {
	webSocket.send("chat"+ firepadUserList.displayName_ + " has disconnected !"); // close avant le send ? meh o/
	returnServer.value += "Server Disconnect!"+"\n";
}

function processError(message) {
	returnServer.value += "error ...\n";
}


