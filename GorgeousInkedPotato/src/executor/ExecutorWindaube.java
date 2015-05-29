package executor;



import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trash.ServerSocketReader;
import trash.ServerSocketWriter;
import network.*;

public class ExecutorWindaube {
	/**
	 * 
	 * @author daniel
	 * @param args name of the command and options we want to execute
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
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
		
		
		
		
		Runtime runtime = Runtime.getRuntime();
		try {
			String[] cmd = { "cmd.exe", "/C", "D: & cd Applications\\SuperCollider-3.6.6 & sclang.exe" };
			Process processSclang = runtime.exec(cmd);
			
			String command = "cmd /c start cmd.exe";
			Process processData = runtime.exec(command);
			
			Writer w = new Writer (processSclang);
			new Thread(w).start();
			
			Reader r = new Reader (processSclang);
			new Thread(r).start();
			
			
			Server_Socket ss = new Server_Socket();
			
			ServerSocketReader ssr = new ServerSocketReader();
			new Thread(ssr).start();
			ServerSocketWriter ssw = new ServerSocketWriter();
			new Thread(ssw).start();
			
			//w.setMsg(ss.getS());
			//w.send();
			
		} catch (IOException e) {
			System.out.println("Ca a foiré !!!");			
			e.printStackTrace();
		}
		

		
		
		
	}
}