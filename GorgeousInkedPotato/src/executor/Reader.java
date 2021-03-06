package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import network.*;


/**
 * Thread for InputStream to read standard output of SClang
 * @author Joris
 */
public class Reader implements Runnable{
	
	private Process process;
	private InputStreamReader inputReader;
	private BufferedReader br;
	
	private Server_Socket ss;
	private Server_Socket_Windows ssw; // POUR WINDOWS
	
	/**
	 * Constructor that start the thread
	 * @param process get the process of the runtime to get the inputStream
	 */
	public Reader(Process process,Server_Socket ss)
	{
		this.process = process;
		this.ss = ss;
		this.inputReader = new InputStreamReader(this.process.getInputStream());
		this.br = new BufferedReader(this.inputReader);
	}
	
	public Reader(Process process,Server_Socket_Windows ssw) // CONSTRUCTEUR WINDOWS
	{
		this.process = process;
		this.ssw = ssw;
		this.inputReader = new InputStreamReader(this.process.getInputStream());
		this.br = new BufferedReader(this.inputReader);
	}
	
	/**
	 * implementation of method run from Runnable
	 */
	public void run()
	{
		while(true){	
			try {
				Thread.sleep(350);
				tryToRead(br);
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
			
			//String test = "<textarea>";
			//ssw.sendToAll(test);

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if(ss==null) // FOR LINUX OR WINDOWS USERS
				{
					ssw.sendToAll(line);
				} 
				else
				{
					ss.sendToAll(line);
				}
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
