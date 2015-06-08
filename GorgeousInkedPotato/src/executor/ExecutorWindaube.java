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
	
	
	private String[] cmdSclang = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
	private Process processSclang;
	
	private Runtime runtime;
	private Server_Socket_Windows ss;
	private Writer w;
	private Reader r;
	
	public ExecutorWindaube(Server_Socket_Windows _ss) throws IOException{
		this.ss = _ss;
		this.runtime = Runtime.getRuntime();
		this.processSclang = runtime.exec(cmdSclang);
		launchReader();
		launchWriter();
	}
	
	public void launchAPI() {
		
//		/** FRAME */
//		JFrame frame = new JFrame();
//		JPanel panel = new JPanel();
//		panel.setLayout(new FlowLayout());
//		JButton button = new JButton("Button Demo");
//		
//		panel.add(button);
//
//		
//		frame.add(panel);
//		frame.setSize(800, 600);
//		frame.setResizable(false);
//		frame.setLocation(100, 100);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	         
//	    
//		frame.setVisible(true);		
	}
	
	public void launchWriter(){
		this.w = new Writer (processSclang,ss);
		new Thread(w).start();
	}
	
	public void launchReader(){
		this.r = new Reader (processSclang,ss);
		new Thread(r).start();
	}
	
	public Writer getWriter() {
		return this.w;
	}
	
	public void truc(String[] args) throws InterruptedException {
		
		
//		try {
//			String[] cmd = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
//			Process processSclang = runtime.exec(cmd);
//			
//			String command = "cmd /c start cmd.exe";
//			Process processData = runtime.exec(command);
//			
//			Writer w = new Writer (processSclang);
//			new Thread(w).start();
//			
//			Reader r = new Reader (processSclang);
//			new Thread(r).start();
//			
//			
//			
//
//			
//		} catch (IOException e) {
//			System.out.println("Ca a foiré !!!");			
//			e.printStackTrace();
//		}
		

	}
	
	
}