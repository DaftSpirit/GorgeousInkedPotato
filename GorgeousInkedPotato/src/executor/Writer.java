package executor;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

import network.Server_Socket;
import network.Server_Socket_Windows;

public class Writer implements Runnable{
	
	private Process process;
	private String msg;
	
	private InputStreamReader inputReader; // vers System.in
	private BufferedReader br;
	
	private OutputStreamWriter outputWriter;	// vers Appli.in
	private BufferedWriter bw;	
	
	private Server_Socket ss;
	private Server_Socket_Windows ssw; // POUR WINDOWS
	
	public Writer(final Process p, Server_Socket_Windows ssw) {
		this.process = p;
		this.outputWriter = new OutputStreamWriter(process.getOutputStream());
		this.bw = new BufferedWriter(outputWriter);
		this.inputReader = new InputStreamReader(System.in);
		this.br = new BufferedReader(inputReader);
		this.ssw = ssw;
	}
	
	public Writer(final Process p, Server_Socket ss) {
		this.process = p;
		this.outputWriter = new OutputStreamWriter(process.getOutputStream());
		this.bw = new BufferedWriter(outputWriter);
		this.inputReader = new InputStreamReader(System.in);
		this.br = new BufferedReader(inputReader);
		this.ss = ss;
	}
	
	@Override
	public void run() {
		while(true) {
			msg();
			if(this.msg.equals("disconnect"))
				try {
					disconnect();
					break;
				} catch (IOException e1) {
					System.out.println("Failed to disconnect");
					e1.printStackTrace();
				}
			try {
				send();
			} catch (IOException e) {
				System.out.println("Failed to send");
				e.printStackTrace();
			}
		}
		System.out.println("Sclang terminated..");
		System.exit(0);
	}
	
	private void msg() { // ENVOI DE COMMANDES DEPUIS LA CONSOLE SERVEUR UNIQUEMENT
		try {
			this.setMsg(this.br.readLine());
		} catch (IOException e) {
			System.out.println("Commande non saisie");
			e.printStackTrace();
		}
	}
	
	public void receiveCommand(String command) throws IOException
	{
		
		Pattern p = Pattern.compile("\\$");
		String[] items = p.split(command);
		String user = items[0];
		String line = items[1];
		String cmd = items[2];
		if(ss==null) // FOR LINUX OR WINDOWS USERS
		{
			ssw.sendToAll("line" + line);
			ssw.sendToAll("<p id=\"user_text\">" + user + " à envoyé la ligne " + line + ".</p>");
		}
		else
		{
			ss.sendToAll("line" + line);
			ss.sendToAll("<p id=\"user_text\">" + user + " à envoyé la ligne " + line + ".</p>");
		}
		
		setMsg(cmd);
		send();
	}
	
	public void receiveBloc(String command) throws IOException
	{
		
		Pattern p = Pattern.compile("\\$");
		String[] items = p.split(command);
		String user = items[0];
		String line = items[1];
		String cmd = items[2];
		if(ss==null) // FOR LINUX OR WINDOWS USERS
		{
			ssw.sendToAll("bloc" + line);
			ssw.sendToAll("<p id=\"user_text\">" + user + " à envoyé le bloc ligne " + line + ".</p>");
		}
		else
		{
			ss.sendToAll("bloc" + line);
			ss.sendToAll("<p id=\"user_text\">" + user + " à envoyé le bloc ligne " + line + ".</p>");
		}
		
		setMsg(cmd);
		send();
	}
	
	public void receiveChat(String msg) {
		if(ss==null) // FOR LINUX OR WINDOWS USERS
		{
			ssw.sendToAll(msg);
		} 
		else
		{
			ss.sendToAll(msg);
		}
	}

	public void send() throws IOException {
		bw.write(this.msg+"\n"); // Pas forcément besoin du \n ? 
		bw.flush();
	} 			
	
	public void disconnect() throws IOException {
		this.br.close();
		this.bw.close();
		this.inputReader.close();
		this.outputWriter.close();
	}
	
	
	public void setMsg(String _s)
	{
		msg=_s;
	}
	
	public String getMsg()
	{
		return msg;
	}


}
