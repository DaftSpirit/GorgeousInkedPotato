
var webSocket = new WebSocket("ws://localhost:8887"); //Change to your own server address
var returnServer = document.getElementById("returnServer");
var textMessage = document.getElementById("textMessage");

webSocket.onopen = function(message) { processOpen(message);};
webSocket.onmessage = function(message) { processMessage(message);};
webSocket.onclose = function(message) { processClose(message);};
webSocket.onerror = function(message) { processError(message);};

function processOpen(message){
	returnServer.value += "Server Connect!"+"\n";
}

function processMessage(message) {
	returnServer.value += message.data + "\n";
}

/*function sendMessage(){
	if(textMessage.value!="close"){
		webSocket.send(textMessage.value);
		returnServer.value += "Send to Server ==> " +textMessage.value+"\n";
		textMessage.value="";
	} else webSocket.close();
	
}*/

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


