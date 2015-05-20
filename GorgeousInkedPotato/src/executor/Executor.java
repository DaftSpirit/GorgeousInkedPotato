package executor;

import java.io.IOException;

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
				Writer writer = new Writer(process);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}