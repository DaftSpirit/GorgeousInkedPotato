package executor;


import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer implements Runnable{
	
	private Process process;
	private String mess;
	
	private OutputStreamWriter osw;
	
	public Writer(Process p) throws IOException {
		this.process = p;
		osw = new OutputStreamWriter(process.getOutputStream());
		new Thread().start();
	}
	
	public void run() {
		
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
