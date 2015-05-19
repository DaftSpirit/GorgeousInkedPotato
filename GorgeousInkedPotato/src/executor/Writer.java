package executor;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Writer implements Runnable{
	
	private Process process;
	private Scanner sc;
	private OutputStreamWriter osw;
	private BufferedWriter bw;
	
	private String mess;
	
	
	public Writer(final Process p) throws IOException {
		
		this.process = p;
		this.sc = new Scanner(System.in);
		//this.osw = new OutputStreamWriter(process.getOutputStream());
		//bw = new BufferedWriter(osw);
		//new Thread().start();
		
		// A REFAIRE AVEC UN SCANNER DANS LE RUN ET SYNCRO AVEC LES DEUX
		new Thread() {
			public void run() {
				try {
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
					try {
						String str = sc.nextLine();
						
						
						bw.write(str+"\n");
						//bw.write("f = {{SinOsc.ar(440,0,0.8)}.play};\n");
						//bw.write("s.waitForBoot(f);\n");
					} finally {
						bw.close();
					}
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}.start();
		
		
	}
	
	public void run() {
		//while(true)
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
		bw.write(mess);				
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
