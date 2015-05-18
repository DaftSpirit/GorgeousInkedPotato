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
	 */
	public static void main(String[] args) {
		
		
		Runtime runtime = Runtime.getRuntime();
		try {
			
			String[] cmd = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
			final Process process = runtime.exec(cmd);
			
			
			// Lancement du process sclang
			//Process process = runtime.exec(new String[] { "D:\\Applications\\SuperCollider-3.6.6\\sclang.exe"} );
			
			// Récupération des streams Entrée / Sortie
			//OutputStream os = process.getOutputStream();
			InputStream is = process.getInputStream();
			
			// Lecture du InputStream
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			//osw.write("s.boot;");
			
			//Writer w = new Writer ();
			//w.setString("s.boot");
			//w.run(process);
			
			
			String s;
			while((s=br.readLine())!=null)
				System.out.println(s);
			
		} catch (IOException e) {
			System.out.println("Ca a foiré !!!");			
			e.printStackTrace();
		}
		
		
		
	}

}