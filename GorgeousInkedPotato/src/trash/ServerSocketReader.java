package trash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import network.Server_Socket;

public class ServerSocketReader implements Runnable{
	
	private InputStreamReader inputReader; // De FailFish vers Executor
	private BufferedReader br;

	public ServerSocketReader() throws IOException
	{
		this.inputReader = new InputStreamReader(Server_Socket.server_socket1.getInputStream());
		this.br = new BufferedReader(inputReader); 
	}	
	
	/**
	 * implementation of method run from Runnable
	 */
	public void run()
	{
		while(true){	
			try {
				Thread.sleep(350);
				tryToRead(this.br);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Tries to read the inputStream and print it if it's not empty
	 * @param br BuferedReader to read from
	 */
	public void tryToRead(BufferedReader br)
	{		
		try {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedReader getBufferedReader()
	{
		return this.br;
	}
	
	public InputStreamReader getInputStreamReader()
	{
		return this.inputReader;
	}
	
	public void disconnect() throws IOException
	{
		this.br.close();
		this.inputReader.close();
	}

}
