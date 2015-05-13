package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Executor {

	/**
	 * 
	 * @authors Joris
	 * @param args name of the command and options we want to execute
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		try {
			//runtime.exec(new String[] {"sclang"});
			System.out.println("je lance le prog : sclang");
		    Process process = runtime.exec(new String[] {"sclang"});
		    InputStream is = process.getInputStream();
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
		    String line;

		    while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}