package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client_Socket {
	
	public static void main(String[] args) {
		
		Socket socket;

		try {
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		     socket = new Socket(InetAddress.getLocalHost(),6969);	
		     
		     /** OUTPUT CLIENT SOCKET */
		     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		     bw.write("s.boot;");
		     // {SinOsc.ar(440,0,0.8)}.play
		     bw.flush();
		     
		     /** INPUT CLIENT SOCKET */
		     /*BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     try {
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		     
		     br.close();*/
		     
		     bw.close();
	         socket.close();

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}