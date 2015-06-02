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

import executor.Executor;


public class Server_Socket extends WebSocketServer {
	
	private Executor exe;
	
	public Server_Socket() throws UnknownHostException {
		super();
	}
	/**
	 * constructs the server
	 * @param port : port number to listen to
	 * @throws UnknownHostException
	 */
	public Server_Socket(int port) throws UnknownHostException {
		super(new InetSocketAddress( port ));
	}
	
	public Server_Socket(InetSocketAddress address) {
		super(address);
	}

	/**
	 * Prints on the server out stream the address of the client who is connected
	 */
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " is connected !" );
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println(conn + " has closed connection ! reason : " + reason);
	}

	/**
	 * sends the message to the writer which can control SClang
	 * @author joris
	 */
	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("message received from : " + conn);
		try {
			if(message.startsWith("cmd"))
				this.exe.getWriter().receiveCommand(message.replaceFirst("cmd",""));	
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
	
	/**
	 * sends to all clients the text in parameter
	 * @param text : string to send
	 */
	public void sendToAll(String text) {
		Collection<WebSocket> connections = connections();
		for(WebSocket w : connections){
			w.send(text);
		}
	}
	
	/**
	 * Launches SClang and both reader and writer to discuss with SClang
	 * @throws IOException
	 */
	public void runExe() throws IOException{
		this.exe = new Executor(this);
		this.exe.launchSclang();
	}
	
	public static void main(String[] args){
		WebSocketImpl.DEBUG = true;
		int port = 8887;
		try {
			Server_Socket ss = new Server_Socket(port);
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
