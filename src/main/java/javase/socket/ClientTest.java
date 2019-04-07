package javase.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args) {
		BufferedReader br=null;
		PrintWriter pw=null;
		Socket socket=null;
		try {
			socket=new Socket("localhost",2000);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw=new PrintWriter(socket.getOutputStream(),true);
			
			pw.println("hello world!");
			String s=null;
			while(true){
				s=br.readLine();
				if(s!=null)
					break;
			}
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				pw.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
