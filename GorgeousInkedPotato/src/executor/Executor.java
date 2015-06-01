package executor;

import java.io.IOException;

import network.*;

public class Executor {
	
	private Server_Socket ss;
	private Runtime runtime;
	private Process process;
	private Reader reader;
	private Writer writer;

	public Executor(Server_Socket server_Socket) {
		this.ss = server_Socket;
		this.runtime = Runtime.getRuntime();
	}

	/**
	 * instantiates a reader to get the output of SClang
	 * @author joris
	 */
	public void launchReader() {
		this.reader = new Reader(this.process, this.ss);
		new Thread(reader).start();
	}

	/**
	 * instantiates a writer to get the input of SClang
	 * @author joris
	 */
	public void launchWriter() {
		this.writer = new Writer(this.process, this.ss);
		new Thread(writer).start();
	}
	
	/**
	 * launches the shell in which SClang is executed
	 * @throws IOException
	 * @author joris
	 */
	public void launchSclang() throws IOException{
		System.out.println("je lance le prog : sclang");
		String[] arg = { "/bin/sh", "-c", "sclang" };
		
		this.process = this.runtime.exec(arg);
		
		launchWriter();
		launchReader();
	}

	public Writer getWriter() {
		return this.writer;
	}
}