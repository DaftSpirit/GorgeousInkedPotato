
var webSocket = new WebSocket("ws://localhost:8887");
var returnServer = document.getElementById("returnServer");
var chatMessage = document.getElementById("chatMessage");

webSocket.onopen = function(message) { processOpen(message);};
webSocket.onmessage = function(message) { processMessage(message);};
webSocket.onclose = function(message) { processClose(message);};
webSocket.onerror = function(message) { processError(message);};

function processOpen(message){
	returnServer.value += "Server Connect!"+"\n";
}

function processMessage(message) {
	if (message.data.startsWith("chat"))
	{
		chat.value += firepadUserList.displayName + ": " + message.data.replace("chat","") + "\n";
	}
	else
	{
		returnServer.value += message.data + "\n";
	}
}

function sendMessage(){
	webSocket.send("chat"+chatMessage.value);
	chatMessage.value="";
}

function sendLine(string) {
	webSocket.send(string);
}

function processClose(message) {
	webSocket.send("client disconnected!");
	returnServer.value += "Server Disconnect!"+"\n";
}

function processError(message) {
	returnServer.value += "error ...\n";
}


