package executor;

import java.io.IOException;
import network.*;

public class ExecutorWindaube {
	/**
	 * 
	 * @author daniel
	 * @param args name of the command and options we want to execute
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		try {
			String[] cmd = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
			Process process = runtime.exec(cmd);
			
			Writer w = new Writer (process);
			new Thread(w).start();
			
			Reader r = new Reader (process);
			new Thread(r).start();
			
			
			Server_Socket ss = new Server_Socket();
			
			ServerSocketReader ssr = new ServerSocketReader();
			new Thread(ssr).start();
			//ServerSocketWriter ssw = new ServerSocketWriter();
			//new Thread(ssw).start();
			
			//w.setMsg(ss.getS());
			//w.send();
			
		} catch (IOException e) {
			System.out.println("Ca a foiré !!!");			
			e.printStackTrace();
		}
		

		
		
		
	}
}