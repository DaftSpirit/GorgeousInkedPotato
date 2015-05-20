package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {

	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		
		Socket socketduserveur1 =null;
		Socket socketduserveur2=null;
		Socket socketduserveur3=null;
		
		try {
		
			socketserver = new ServerSocket(2009,1);
			socketduserveur1 = socketserver.accept(); 
			System.out.println(socketduserveur1);
			System.out.println("Un zéro s'est connecté !");
		    
			socketduserveur2 = socketserver.accept();
			System.out.println(socketduserveur2);
			System.out.println("Un deuxieme s'est connecté !");
			
			socketduserveur3 = socketserver.accept();
			System.out.println(socketduserveur3);
			System.out.println("Un troisieme s'est connecté !");
			
		    socketduserveur1.close();
		    socketduserveur2.close();
		    socketduserveur3.close();
		    
		    socketserver.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
