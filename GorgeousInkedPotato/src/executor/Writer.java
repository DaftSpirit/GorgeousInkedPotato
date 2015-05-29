package executor;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Writer implements Runnable{
	
	private Process process;
	private String msg;
	
	private InputStreamReader inputReader; // vers System.in
	private BufferedReader br;
	
	private OutputStreamWriter outputWriter;	// vers Appli.in
	private BufferedWriter bw;	
	
	
	
	public Writer(final Process p) {
		this.process = p;
		this.outputWriter = new OutputStreamWriter(process.getOutputStream());
		this.bw = new BufferedWriter(outputWriter);
		this.inputReader = new InputStreamReader(System.in);
		this.br = new BufferedReader(inputReader);
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
		setMsg(command);
		send();
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
