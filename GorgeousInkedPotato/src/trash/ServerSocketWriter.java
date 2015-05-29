package trash;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import network.Server_Socket;

public class ServerSocketWriter implements Runnable{
	
	private OutputStreamWriter outputWriter;	// De l'Executor vers le FailFish
	private BufferedWriter bw;	
	
	private String msg;
	
	public ServerSocketWriter() throws IOException{
		this.outputWriter = new OutputStreamWriter(Server_Socket.server_socket1.getOutputStream());
		this.bw = new BufferedWriter(outputWriter);
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
		System.out.println("Thread terminé ..");
		System.exit(0);
	}
	
	private void msg() {
		this.setMsg("KAPPA 123");
	}

	public void send() throws IOException {
		bw.write(this.msg+"\n");
		bw.flush();
	} 			
	
	public void disconnect() throws IOException {
		this.bw.close();
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
