package executor;

import java.io.IOException;

public class Executor {

	/**
	 * runs sclang and lets the user write command lines to sclang
	 * @authors Joris
	 */
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("je lance le prog : sclang");
			
		String[] arg = { "/bin/sh", "-c", "sclang" };
			
		Process process;
		try {
			process = runtime.exec(arg);
			Reader reader = new Reader(process);
			new Thread(reader).start();
			Writer writer = new Writer(process);
			new Thread(writer).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}