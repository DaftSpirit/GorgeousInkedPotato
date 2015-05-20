package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_Socket {
	
	private static ServerSocket _SOCKET_;
	private Socket server_socket1;
	
	private String s;

	static {
		try {
			_SOCKET_ = new ServerSocket(6969);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Server_Socket(){
		try{
			server_socket1 = _SOCKET_.accept(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(server_socket1.getInputStream()));
			try {
				/** INPUT SERVER SOCKET */
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					s = line;
				}
				
				/** OUTPUT SERVER SOCKET */
				//BufferedWriter bw = null; 
				/*bw = new BufferedWriter(new OutputStreamWriter(server_socket1.getOutputStream()));
				bw.write(line);
				bw.flush();
				bw.close();*/
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			//System.out.println("Un client s'est connecté !"); 
		} catch (IOException e) {
			e.printStackTrace();
		}	
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
