package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;


/**
 * Thread for InputStream to read standard output of sclang
 * @author joris
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
		new Thread(this).start();
	}
	
	/**
	 * implementation of method run from Runnable
	 */
	public void run()
	{
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		while(true){	
			try {
				Thread.sleep(350);
				tryToRead(isr, br);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tryToRead(InputStreamReader isr, BufferedReader br)
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
