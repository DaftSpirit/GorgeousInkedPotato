package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import executor.ExecutorWindaube;


public class Server_Socket_Windows extends WebSocketServer {
	
	private ExecutorWindaube exe;
	
	public Server_Socket_Windows() throws UnknownHostException {
		super();
	}
	
	public Server_Socket_Windows(int port) throws UnknownHostException {
		super(new InetSocketAddress( port ));
	}
	
	public Server_Socket_Windows(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " is connected !" );
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println( conn + " has closed connection !" );
		this.sendToAll("chatSomeone left the room...");
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("message received from : " + conn);
		try {
			if(message.startsWith("cmd"))
				this.exe.getWriter().receiveCommand(message.replaceFirst("cmd",""));
			else if(message.startsWith("bloc"))
			{
				this.exe.getWriter().receiveBloc(message.replaceFirst("bloc",""));
			}
			else if(message.startsWith("chat"))
			{
				this.exe.getWriter().receiveChat(message);
				//message.replaceAll("(chat)(.*)","$2")
			}
			else{
				System.out.println("Non understood er general");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}
	
	public void sendToAll(String text) {
		Collection<WebSocket> connections = connections();
		for(WebSocket w : connections){
			w.send(text);
		}
	}
	
	public void runExe() throws IOException{
		this.exe = new ExecutorWindaube(this);
		//this.exe.launchSclang();
	}
	
	public static void main(String[] args){
		WebSocketImpl.DEBUG = true;
		int port = 8887;
		System.out.println("WINDOWS POWA");
		try {
			Server_Socket_Windows ss = new Server_Socket_Windows(port);
			ss.start();
			ss.runExe();
			System.out.println("Server started on port : " + port);
			
			BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
			while ( true ) {
				String in = sysin.readLine();
				ss.sendToAll( in );
				if( in.equals( "exit" ) ) {
					ss.stop();
					break;
				} else if( in.equals( "restart" ) ) {
					ss.stop();
					ss.start();
					break;
				}
			}	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
