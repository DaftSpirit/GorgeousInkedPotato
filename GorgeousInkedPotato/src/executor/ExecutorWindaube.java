package executor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ExecutorWindaube {

	protected OutputStream os;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream ();
	private DataOutputStream output = new DataOutputStream (baos);
	
	
	/**
	 * 
	 * @authors Joris
	 * @param args name of the command and options we want to execute
	 */
	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(new String[] { "D:\\Applications\\SuperCollider-3.6.6\\sclang.exe"} );
			OutputStream os = process.getOutputStream();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write("s.boot;");
			
			
			
			String s;
			while((s=br.readLine())!=null)
				System.out.println(s);
			
		} catch (IOException e) {
			System.out.println("Ca a foiré !!");			
			e.printStackTrace();
		}
		
	
	}

}