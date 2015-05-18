package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ExecutorWindaube {


	
	/**
	 * 
	 * @authors dfg
	 * @param args name of the command and options we want to execute
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		Runtime runtime = Runtime.getRuntime();
		
		try {
			
			String[] cmd = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
			final Process process = runtime.exec(cmd);
			
			
			// Lancement du process sclang
			//Process process = runtime.exec(new String[] { "D:\\Applications\\SuperCollider-3.6.6\\sclang.exe"} );
			
			Reader r = new Reader(process);
			
			Writer w = new Writer (process);
			w.run();

			
			
		
			//Thread.sleep(2000);
			
			
		} catch (IOException e) {
			System.out.println("Ca a foiré !!!");			
			e.printStackTrace();
		}
		
		
		
	}

}