package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Thread for InputStream to read standard output of SClang
 * @author Joris
 */
public class Reader implements Runnable{
	
	private Process process;
	
	/**
	 * Constructor that start the thread
	 * @param process get the process of the runtime to get the inputStream
	 */
	public Reader(Process process)
	{
		this.process = process;
	}
	
	/**
	 * implementation of method run from Runnable
	 */
	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
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
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
