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
			System.out.println("je lance le prog : sclang");
			
			String[] arg = { "/bin/sh", "-c", "sclang" };
			
			Process process;
			try {
				process = runtime.exec(arg);
				Reader reader = new Reader(process);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}