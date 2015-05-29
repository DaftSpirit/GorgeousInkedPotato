package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import executor.Executor;


public class Server_Socket extends WebSocketServer {
	
	private Executor exe;
	
	public Server_Socket() throws UnknownHostException {
		super();
	}
	
	public Server_Socket(int port) throws UnknownHostException {
		super(new InetSocketAddress( port ));
	}
	
	public Server_Socket(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		
	}
	
	public void sendToAll(String text) {
		Collection<WebSocket> connections = connections();
		for(WebSocket w : connections){
			w.send(text);
		}
	}
	
	public void runExe() throws IOException{
		this.exe = new Executor(this);
		this.exe.launchSclang();
	}
	
	public static void main(String[] args){
		WebSocketImpl.DEBUG = true;
		int port = 8887;
		try {
			Server_Socket ss = new Server_Socket(port);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
}
