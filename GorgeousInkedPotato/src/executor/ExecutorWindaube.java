package executor;

import java.io.IOException;

public class ExecutorWindaube {
	/**
	 * 
	 * @authors dfg
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
			
			/*
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			*/
			
			//bw.write("f = {{SinOsc.ar(440,0,0.8)}.play};\n");
			//bw.write("s.waitForBoot(f);\n");
			
		} catch (IOException e) {
			System.out.println("Ca a foir� !!!");			
			e.printStackTrace();
		}
		
	}
}