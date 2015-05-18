package executor;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Writer implements Runnable{
	
	private Process process;
	private Scanner sc;
	private OutputStreamWriter osw;
	
	private String mess;
	
	
	public Writer(Process p) throws IOException {
		this.process = p;
		this.sc = new Scanner(System.in);
		this.osw = new OutputStreamWriter(process.getOutputStream());
		
		new Thread().start();
	}
	
	public void run() {
		while(true)
		{
			trytoWrite();
		}
	}
	
	private void trytoWrite() {
		
		System.out.println("Veuillez saisir un mot :");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi : " + str);
		this.setString(str);
		try {
			this.send();
		} catch (IOException e) {
			System.out.println("nul");
			e.printStackTrace();
		}
		
	}

	public void send() throws IOException {
		osw.write(mess);				
	}
	
	public void setString(String _s)
	{
		mess=_s;
	}
	
	public String getString()
	{
		return mess;
	}
	
	

	
}
