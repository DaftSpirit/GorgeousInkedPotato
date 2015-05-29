package executor;

import java.io.IOException;

import network.*;

public class Executor {
	
	private Server_Socket ss;
	private Runtime runtime;
	private Process process;

	public Executor(Server_Socket server_Socket) {
		this.ss = server_Socket;
		this.runtime = Runtime.getRuntime();
	}

	public void launchReader() {
		// TODO Auto-generated method stub
		
	}

	public void launchWriter() {
		// TODO Auto-generated method stub
		
	}
	
	public void launchSclang() throws IOException{
		System.out.println("je lance le prog : sclang");
		String[] arg = { "/bin/sh", "-c", "sclang" };
		
		this.process = this.runtime.exec(arg);
	}

	
	
//	public static void main(String[] args) {
//		Runtime runtime = Runtime.getRuntime();
//		System.out.println("je lance le prog : sclang");
//			
//		String[] arg = { "/bin/sh", "-c", "sclang" };
//			
//		Process process;
//		try {
//			process = runtime.exec(arg);
//			
//			Reader reader = new Reader(process);
//			new Thread(reader).start();
//			
//			Writer writer = new Writer(process);
//			new Thread(writer).start();
//			
//			Server_Socket ss = new Server_Socket();
//			//writer.setMsg(ss.getS());
//			//writer.send();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}