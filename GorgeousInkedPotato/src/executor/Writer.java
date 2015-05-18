package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Writer {
	
	private OutputStreamWriter osw;
	private String s;
	
	public Writer() throws IOException {
		new Thread() {

		}.start();
	}
	
	public void run(final Process process) {
		try {
			osw = new OutputStreamWriter(process.getOutputStream());
			try {
				write();
			} finally {
				osw.close();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void write() throws IOException {
		osw.write(s);				
	}
	
	public void setString(String _s)
	{
		s=_s;
	}
	
	public String getString()
	{
		return s;
	}
	
	

	
}
