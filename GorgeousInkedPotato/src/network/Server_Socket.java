package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_Socket{
	
	static ServerSocket _SOCKET_;
	static Socket server_socket1;
	

	
	private String s = null;

	static {
		try {
			_SOCKET_ = new ServerSocket(6969);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Server_Socket() throws IOException{
		server_socket1 = _SOCKET_.accept();
	}
	
	public void disconnect() {
		try {
			server_socket1.close();
			_SOCKET_.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}
