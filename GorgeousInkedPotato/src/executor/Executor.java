package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Executor {

	/**
	 * runs sclang and tries to write "s.boot;" on standard input of sclang
	 * @authors Joris
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		try {
			System.out.println("je lance le prog : sclang");
			String[] arg = { "/bin/sh", "-c", "sclang" };
			Process process = runtime.exec(arg);

			// recuperation de l'inputstream (sortie de sclang)
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			
			// recuperation de l'ouputstream (entree de sclang)
			OutputStream os = process.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			
			osw.write("abcd");
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			System.out.println("j'ai fini de lire");
			
			osw.close();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}